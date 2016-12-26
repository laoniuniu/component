package com.deppon.demo.commons.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

/**
 * {@link Money} �Ĺ������������ڴ�ʹ���Ż����������Ҫ����߾���ʱʹ�á�
 *
 * @author fanshen
 */
public class MoneyBuilder {

    private MoneyBuilder(long cent, Currency currency) {
        this.cent = BigDecimal.valueOf(cent);
        this.currency = checkNotNull(currency);
    }

    public MoneyBuilder(long cent) {
        this(cent, Currency.getInstance(Money.DEFAULT_CURRENCY_CODE));
    }

    public MoneyBuilder() {
        this(0, Currency.getInstance(Money.DEFAULT_CURRENCY_CODE));
    }

    private final Currency currency;
    private BigDecimal cent;

    public MoneyBuilder(Money money) {
        this.currency = money.getCurrency();
        this.cent = BigDecimal.valueOf(money.getCent());
    }

    public MoneyBuilder add(long cent) {
        this.cent = this.cent.add(BigDecimal.valueOf(cent));
        return this;
    }

    public MoneyBuilder subtract(long cent) {
        this.cent = this.cent.subtract(BigDecimal.valueOf(cent));
        return this;
    }

    public MoneyBuilder add(Money money) {
        return add(money.getCent());
    }

    public MoneyBuilder subtract(Money money) {
        return subtract(money.getCent());
    }

    public MoneyBuilder multiply(double val) {
        this.cent = cent.multiply(BigDecimal.valueOf(val));
        return this;
    }

    public MoneyBuilder multiply(BigDecimal val) {
        this.cent = cent.multiply(val, MathContext.UNLIMITED);
        return this;
    }

    public MoneyBuilder divide(double val) {
        checkArgument(val != 0);
        this.cent = cent.divide(BigDecimal.valueOf(val), MathContext.UNLIMITED);
        return this;
    }

    private <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    private void checkArgument(boolean expr) {
        if (!expr) {
            throw new IllegalArgumentException();
        }
    }

    public Money build() {
        return Money.fromMiniUnit(cent.longValue(), currency);
    }

}
