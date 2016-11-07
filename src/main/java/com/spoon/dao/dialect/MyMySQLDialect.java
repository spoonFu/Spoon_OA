package com.spoon.dao.dialect;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

/**
 * 为hql方言添加convert方法
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月16日 上午1:40:38
 */
public class MyMySQLDialect extends MySQLDialect {
    public static final String CONVERT_GBK = "convertgbk";
    @SuppressWarnings("deprecation")
    public MyMySQLDialect() {
        super();
        registerFunction(CONVERT_GBK, new SQLFunctionTemplate(StandardBasicTypes.STRING, "convert(?1 using gbk)"));
    }
}