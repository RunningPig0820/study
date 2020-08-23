package pattern.proxy.dbrource.db;

/**
 * @author 淘沙
 * @date 2020/08/23 2:22 下午
 */
public class DynamicDataSourceEntity {
    private final static String DEFAULE_SOURCE = null;
    private final static ThreadLocal<String> local = new ThreadLocal<String>();

    private DynamicDataSourceEntity() {
    }

    //DB_2018
    //DB_2019
    private static  void set(String source) {
        local.set(source);
    }

    //DB_2018
    //DB_2019
    public static void set(int year) {
        local.set("DB_" + year);
    }

    private static String get() {
        return local.get();
    }

    public static void restore() {
        local.set(DEFAULE_SOURCE);

    }
}
