package com.shyb.masterslave.datasource;

/**
 * @author wzh
 * @date 2019/6/13 - 15:19
 */
public class CustomerContextHolder {
    private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<DbType>();

    public static void setCustomerType(DbType dbType){
        contextHolder.set(dbType);
    }

    public static DbType getCustomerType(){
        return contextHolder.get();
    }

    public static void clearCustomerType(){
        contextHolder.remove();
    }
}
