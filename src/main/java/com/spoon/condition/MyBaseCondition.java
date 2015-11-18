package com.spoon.condition;

import com.spoon.service.MyOrder;
import org.apache.commons.lang.StringUtils;

/**
 * 查询条件基类
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月9日 下午8:52:41
 */
public class MyBaseCondition {
	/** 当前页 **/
	private int pageNum = 1;
	/** 每页显示条数 **/
	private int rowSize = 10;
	/** 是否是点击页码的查询 **/
	private boolean pageFlag = false;
	/** 排序方法 **/
	private String orderSql;
	/** 接收前台传入的排序字符串 **/
	private String order;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public boolean isPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(boolean pageFlag) {
		this.pageFlag = pageFlag;
	}

	public String getOrderSql() {
		return orderSql;
	}

	public void setOrderSql(String orderSql) {
		this.orderSql = orderSql;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 判断是否存在排序
	 * @param field
	 * @return
	 */
	public boolean containOrder(String field) {
		if (StringUtils.isEmpty(orderSql))
			return false;
		return orderSql.substring(10).contains(field);
	}

	/**
	 * 添加排序
	 * @param order
	 * @param importan
	 *            条件优先级
	 */
	public void addOrder(MyOrder order, boolean important) {
		if (order==null)
			return;
		String sql = (order.isChinese() ? "convertgbk("+order.getField()+")" : order.getField())
				+(order.isAsc() ? " asc" : " desc");
		if (StringUtils.isEmpty(orderSql)) {
			orderSql = " order by "+sql;
		} else if (containOrder(order.getField())) {
			removeOrder(order.getField());
			addOrder(order, important);
		} else if (important) {
			orderSql = " order by "+sql+","+orderSql.substring(10);
		} else {
			orderSql += sql;
		}
	}

	/**
	 * 移除某字段的排序
	 * @param field
	 */
	public void removeOrder(String field) {
		if (orderSql==null)
			return;
		String fields = orderSql.substring(10);
		if (!fields.contains(field))
			return;
		String[] temps = fields.split(",");
		orderSql = "";
		if (temps.length==1)
			return;
		for (String temp : temps) {
			if (temp.contains(field))
				continue;
			orderSql += ","+temp;
		}
		orderSql = " order by "+orderSql.substring(1);
	}

	/**
	 * 当前排序个数
	 * @return
	 */
	public int orderSize() {
		if (StringUtils.isEmpty(orderSql))
			return 0;
		return orderSql.split(",").length;
	}

	/**
	 * 优先级最低的排序
	 */
	public String peekOrder() {
		if (StringUtils.isEmpty(orderSql)||orderSize()==1)
			return "";
		return orderSql.substring(0, orderSql.lastIndexOf(","));
	}
}
