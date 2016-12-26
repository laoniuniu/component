package com.deppon.schedule.common;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @author mitsui.
 */
public abstract class MEnum<T extends MEnum> implements Comparable, Serializable {
    private static Logger logger = LoggerFactory.getLogger(MEnum.class);

    private static final long serialVersionUID = -3452282958188035040L;

    private static final Map<String,MEnum> EMPTY_MAP = Collections.unmodifiableMap(new HashMap<String, MEnum>(0));

    /**
     * <code>Map</code>, key of class name, value of <code>Entry</code>.
     */
    private static Map<Class<MEnum>,Entry> cEnumClasses = new WeakHashMap<Class<MEnum>,Entry>();


    private  String name; //英文CODE CASH
    private  String cname; //中文名称  現金
    private  Number value; //值    100100
    private  String desc;  //描述  現金科目
    //private int ordinal;

    protected transient String iToString = null;


    private static class Entry {

        final Map<String,MEnum> map = new HashMap<String,MEnum>();

        final Map<String,MEnum> unmodifiableMap = Collections.unmodifiableMap(map);

        final List<MEnum> list = new ArrayList<MEnum>(25);

        final List<MEnum> unmodifiableList = Collections.unmodifiableList(list);

        protected Entry() {
            super();
        }

        @SuppressWarnings("unchecked")
        private final void populateNames(Class enumClass){
            synchronized (enumClass) {
                Field[] fields = enumClass.getFields();
                for(Field field:fields){
                    int modifier = field.getModifiers();
                    if(Modifier.isPublic(modifier) && Modifier.isFinal(modifier) && Modifier.isStatic(modifier)){
                        try{
                            Object value = field.get(null);
                            String fname = field.getName();
                            for(MEnum enumObject:unmodifiableList){
                                if(value == enumObject && (enumObject.name == null) && !unmodifiableMap.containsKey(fname)){
                                    enumObject.name = fname;
                                    map.put(fname, enumObject);
                                    break;
                                }
                            }

                        }catch(Exception e){
                            logger.error(e.getMessage());
                        }
                    }
                }
            }
        }

    }

    public static MEnum create() {
        return create(null,null,null,null);
    }

    public static MEnum create(String name) {
        return create(name,null,null,null);
    }

    public static MEnum create(String name,Number value) {
        return create(name,value,null,null);
    }

    public static MEnum create(Number value,String cname) {
        return create(null,value,cname,null);
    }

    public static MEnum create(String name,Number value,String cname) {
        return create(name,value,cname,null);
    }

    @SuppressWarnings("unchecked")
    public static MEnum create(String name,Number value,String cname,String desc) {
        MEnum menum = init(name);
        if(StringUtils.isNotEmpty(name)){
            menum.name = name;
        }
        menum.cname = cname;
        menum.value = value;
        menum.desc = desc;
        return menum;
    }



    @SuppressWarnings("unchecked")
    private static MEnum init(String name) {
        Class<MEnum> enumClass;
        try {
            enumClass = ClassUtils.getClass(Thread.currentThread().getContextClassLoader(), getCallerClassName());
            if (enumClass == null) {
                throw new IllegalArgumentException("EnumClass must not be null");
            }

            Entry entry;
            synchronized( MEnum.class ) {
                entry = (Entry) cEnumClasses.get(enumClass);
                if (entry == null) {
                    entry = createEntry(enumClass);
                    Map myMap = new WeakHashMap( ); // we avoid the (Map) constructor to achieve JDK 1.2 support
                    myMap.putAll( cEnumClasses );
                    myMap.put(enumClass, entry);
                    cEnumClasses = myMap;
                }
            }

            MEnum enumObject = (MEnum)enumClass.newInstance();

            if( StringUtils.isNotEmpty(name)){
                if(!entry.map.containsKey(name)){
                    enumObject.name = name;
                    entry.map.put(name, enumObject);

                }else{
                    throw new IllegalArgumentException("The Enum name must be unique, '" + name + "' has already been added");
                }
            }
            //NAME为空的对象在MAP中没有，在对象实例化后，VALUE取LIST中的值，KEY取当前CLASS的FIELD PUT进去
            entry.list.add(enumObject);

            return enumObject;
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    private static String getCallerClassName(){
        StackTraceElement[] callers = new Throwable().getStackTrace();
        String enumClass = MEnum.class.getName();
        for(StackTraceElement caller:callers){
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            if(!enumClass.equals(className) && "<clinit>".equals(methodName)) {
                return className;
            }
        }

        throw new IllegalArgumentException("");
    }

    protected Object readResolve() {
        Entry entry = (Entry) cEnumClasses.get(getEnumClass());
        if (entry == null) {
            return null;
        }
        return entry.map.get(name());
    }

    private Class getEnumClass() {
        Class enumClass = getClass();
        synchronized(enumClass){
            return enumClass;
        }
    }

    //-----------------------------------------------------------------------

    private static <T> Entry getEntry(Class<T> enumClass) {
        if (enumClass == null) {
            throw new IllegalArgumentException("The Enum Class must not be null");
        }
        if (MEnum.class.isAssignableFrom(enumClass) == false) {
            throw new IllegalArgumentException("The Class must be a subclass of Enum");
        }
        Entry entry = (Entry) cEnumClasses.get(enumClass);

        if (entry == null) {
            try {
                Class.forName(enumClass.getName(), true, enumClass.getClassLoader());
                entry = (Entry) cEnumClasses.get(enumClass);
            } catch (Exception e) {
                // Ignore
            }
        }

        return entry;
    }


    private static Entry createEntry(Class enumClass) {
        Entry entry = new Entry();
        Class cls = enumClass.getSuperclass();
        while (cls != null && cls != MEnum.class) {
            Entry loopEntry = (Entry) cEnumClasses.get(cls);
            if (loopEntry != null) {
                entry.list.addAll(loopEntry.list);
                entry.map.putAll(loopEntry.map);
                break;
            }
            cls = cls.getSuperclass();
        }
        return entry;
    }

    //--------------------------------------------------------------------------------


    public static <T> MEnum getEnum(Class<T> enumClass, String name) {
        Entry entry = getEntry(enumClass);
        if (entry == null) {
            return null;
        }
        return  entry.map.get(name);
    }

    public static <T> MEnum getEnum(Class<T> enumClass, Number value) {
        if (enumClass == null) {
            throw new IllegalArgumentException("The Enum Class must not be null");
        }
        @SuppressWarnings("unchecked")
        List<MEnum> list = MEnum.getEnumList(enumClass);
        for (Iterator<MEnum> it = list.iterator(); it.hasNext();) {
            MEnum enumeration = (MEnum) it.next();
            if (enumeration.value() == value.intValue()) {
                return enumeration;
            }
        }
        return null;
    }


    public static <T> Map<String,MEnum> getEnumMap(Class<T> enumClass) {
        Entry entry = getEntry(enumClass);
        if (entry == null) {
            return EMPTY_MAP;
        }
        return entry.unmodifiableMap;
    }


    public static <T> List getEnumList(Class<T> enumClass) {
        Entry entry = getEntry(enumClass);
        if (entry == null) {
            return Collections.EMPTY_LIST;
        }
        return entry.unmodifiableList;
    }


    @SuppressWarnings("unchecked")
    protected static Iterator<MEnum> iterator(Class<MEnum> enumClass) {
        return MEnum.getEnumList(enumClass).iterator();
    }


    public final boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other.getClass() == this.getClass()) {
            // Ok to do a class cast to Enum here since the test above
            // guarantee both
            // classes are in the same class loader.
            return this.name.equals(((MEnum) other).name);
        } else {
            // This and other are in different class loaders, we must check indirectly
            if (other.getClass().getName().equals(this.getClass().getName()) == false) {
                return false;
            }
            return true;
        }
    }


    public int compareTo(Object other) {
        if (other == this) {
            return 0;
        }
        if (other.getClass() != this.getClass()) {
            throw new ClassCastException(
                    "Different enum class '" + ClassUtils.getShortClassName(other.getClass()) + "'");
        }
        return this.name.compareTo(((MEnum) other).name);
    }


    public String toString() {
        if (iToString == null) {
            String shortName = ClassUtils.getShortClassName(getEnumClass());
            iToString = shortName + "[" + name() + "]";
        }
        return iToString;
    }

    public final int hashCode() {
        return getClass().hashCode()^value.hashCode();
    }

    //-----------------------------------------------------------------------
    public final int value() {
        return this.value.intValue();
    }

    public final byte byteValue() {
        return this.value.byteValue();
    }

    public final short shortValue() {
        return this.value.shortValue();
    }

    public final long longValue() {
        return this.value.longValue();
    }

    public final String name(){
        if(name== null){
            Class enumClass = getEnumClass();
            Entry entry = (Entry) cEnumClasses.get(getEnumClass());
            entry.populateNames(enumClass);
        }
        return this.name;
    }

    public String getCname() {
        return cname;
    }

    public String getDesc() {
        return desc;
    }


}
