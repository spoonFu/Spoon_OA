package com.spoon.service;

import com.spoon.dao.dialect.MyMySQLDialect;

/**
 * 排序类
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月12日 下午8:07:33
 */
public class MyOrder {
	/** 需要排序的字段名 **/
	private String field;
	/** 升序/降序 **/
	private boolean asc = true;
	/** 是否汉字 **/
	private boolean chinese = false;

	public MyOrder() {
	}

	public MyOrder(String field, boolean asc, boolean chinese) {
		this.field = field;
		this.asc = asc;
		this.chinese = chinese;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public boolean isChinese() {
		return chinese;
	}

	public void setChinese(boolean chinese) {
		this.chinese = chinese;
	}

	/**
	 * 生成sql语句，如“ name asc”、“ age desc”
	 * @return
	 */
	public String getSql(){
		final StringBuffer sql = new StringBuffer(" ");
		if(chinese){
			sql.append(MyMySQLDialect.CONVERT_GBK).append("(").append(field).append(")");
		}else{
			sql.append(field);
		}
		sql.append(asc ? " asc" : " desc");
		return sql.toString();
	}
}
