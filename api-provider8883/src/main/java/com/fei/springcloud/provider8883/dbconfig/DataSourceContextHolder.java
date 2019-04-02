package com.fei.springcloud.provider8883.dbconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 本地线程，数据源上下文
 * @author Jfei
 *
 */
public class DataSourceContextHolder {

	private static Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);
	
	//线程本地环境
	private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 读库
     */
    public static void setRead() {
        local.set(DataSourceType.read.getType());
    }

    /**
     * 写库
     */
    public static void setWrite() {
        local.set(DataSourceType.write.getType());
    }

    public static String getReadOrWrite() {
        return local.get();
    }
    
    public static void clear(){
    	local.remove();
    }
}
