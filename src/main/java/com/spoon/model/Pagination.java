package com.spoon.model;

import java.util.List;

/**
 * 分页类
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月9日 下午7:57:50
 */
public class Pagination {
	/** 查询结果 **/
	private List<?> result;
	/** 查询结果的总数 **/
	private long totalCount = 0;
	/** 每页条数 **/
	private int rowSize = 10;
	/** 当前页码 **/
	private int pageNum = 1;
	/** 页面起始序号 **/
	private int startNum;
	/** 总页数 **/
	private int pageSize;

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartNum() {
		return startNum;
	}

	public int getPageSize() {
		return pageSize;
	}
}
