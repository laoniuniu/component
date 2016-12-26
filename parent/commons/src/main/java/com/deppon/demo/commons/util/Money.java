package com.deppon.demo.commons.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Ǯ�������塣��Ӧ�Ŀɱ��壺{@link MoneyBuilder}��Ĭ�ϵĻ�������������ҡ�
 * <b>ע�⣺</b>Ǯ��������������
 * <p/>
 * <p>���಻������в�ͬ����֮���ת������Ϊ������漰ʵʱ�Ļ��ʻ�ȡ��
 * �����漰���� {@code Money} ʵ��ķ�������������Ƿ��뵱ǰʵ����ͬһ�ֻ��ҡ�
 * <p/>
 * <p>Ϊʲô�������һ��Ǯ��1����Ϊ���ŵ� {@code Money} ���ǿɱ��塣�����������Ϊ����������ƣ�
 * ��������Ϊ������������ơ�2����û�п���������ҵ���������ʵ���ʱ��ʹ�õ�
 * {@link java.util.Currency} �� SDR �Ļ�����ô�еķ����ᱨ NPE���еķ������صĽ�����Ǵ���ġ�
 * 3������ʹ���� {@code Currency}�������ʵ����Ȼ��֧�ֳ������֮��Ļ��ҡ�
 *
 * @author fanshen
 */
public class Money implements Comparable<Money>, Serializable {
    private static final long serialVersionUID = 2158419477655294341L;

    Money(long cent, Currency currency) {
        this.currency = checkNotNull(currency);
        this.cent = cent;
    }

    Money(long cent) {
        this(cent, Currency.getInstance(DEFAULT_CURRENCY_CODE));
    }

    private final Currency currency;
    private final long cent;

    public static final String DEFAULT_CURRENCY_CODE = "CNY";

    public BigDecimal getAmount() {
        int fractionDigits = Math.max(0, currency.getDefaultFractionDigits());
        return BigDecimal.valueOf(cent, fractionDigits);
    }

    public long getCent() {
        return cent;
    }

    public Money add(Money other) {
        checkArgument(other.currency.equals(currency));
        return new Money(cent + other.cent, currency);
    }

    public Money subtract(Money other) {
        checkArgument(other.currency.equals(currency));
        return new Money(cent - other.cent, currency);
    }

    public Money multiply(long val) {
        return new Money(cent * val, currency);
    }

    public Money multiply(double val) {
        return new Money(Math.round(cent * val), currency);
    }

    public Money divide(double val) {
        checkArgument(val != 0);
        return new Money(Math.round(cent / val), currency);
    }

    public String format() {
        return currency.getSymbol() + getAmount();
    }

    private String format(String format) {
        return String.format(format, getAmount());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Money other = (Money) obj;
        return this.cent == other.cent && this.currency.equals(other.currency);
    }

    @Override
    public int hashCode() {
        int h = 4;
        h = h * 31 + currency.hashCode();
        h = h * 31 + (int) (cent ^ (cent >>> 32));
        return h;
    }

    @Override
    public String toString() {
        // Obscure the string so that clients won't try to rely on this implementation.
        return "######## " + format();
    }

    public int compareTo(Money o) {
        if (o == null) return 1;

        if (!o.currency.equals(currency)) {
            throw new IllegalArgumentException("can't compare money of different currencies");
        }

        return (int) Math.signum(cent - o.cent);
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public static String formatCNY(Money money) {
        checkNotNull(money);
        checkArgument(money.currency.getCurrencyCode().equals("CNY"));

        return money.format("%sԪ");
    }

    public static Money fromMiniUnit(long cent) {
        return new Money(cent);
    }

    public static Money fromMiniUnit(long cent, Currency currency) {
        return new Money(cent, currency);
    }

    public static Money fromCommonUnit(double yuan) {
        Currency defaultCurrency = Currency.getInstance(DEFAULT_CURRENCY_CODE);
        return fromCommonUnit(yuan, defaultCurrency);
    }

    public static Money fromCommonUnit(double yuan, Currency currency) {
        int fractionDigits = Math.max(0, currency.getDefaultFractionDigits());
        long cent = Math.round(yuan * Math.pow(10, fractionDigits));
        return new Money(cent);
    }

    public Money negative() {
    	return new Money(- cent);
    }
    
    private static <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    private static void checkArgument(boolean expr) {
        if (!expr) {
            throw new IllegalArgumentException();
        }
    }

    public static final Money ZERO_CNY = new Money(0);
}
