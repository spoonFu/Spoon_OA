package com.spoon.condition;

import com.spoon.service.MyOrder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 查询条件基类
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月9日 下午8:52:41
 */
public class MyBaseCondition {
    /**
     * 当前页
     **/
    private int pageNum = 1;
    /**
     * 每页显示条数
     **/
    private int rowSize = 10;
    /**
     * 是否是点击页码的查询
     **/
    private boolean pageFlag = false;
    /**
     * 前台点击要排序的字段，分为三部分（字段名,升序降序,中文/其他），如“name,asc,chinese”、“age,desc,else”
     */
    private String order;
    /**
     * 当前处于排序状态的字段
     **/
    private List<MyOrder> orderList = new ArrayList<MyOrder>();

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

    /**
     * 生成排序的sql，如“ order by name asc,age desc”
     *
     * @return
     */
    public String getOrderSql() {
        if(CollectionUtils.isEmpty(orderList)){
            return "";
        }
        final StringBuffer orderSql = new StringBuffer(" order by ");
        for (MyOrder order : orderList) {
            orderSql.append(order.getSql()).append(",");
        }
        return orderSql.substring(0, orderSql.length() - 1);
    }

    public List<MyOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<MyOrder> orderList) {
        this.orderList = orderList;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * 判断字段是否已存在排序中
     *
     * @param field
     * @return
     */
    public boolean containOrder(String field) {
        Assert.notNull(field);
        for (MyOrder order : orderList) {
            if (field.equals(order.getField())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 添加排序
     *
     * @param order
     * @param important 为true时，将排序字段放在第一位
     */
    public void addOrder(MyOrder order, boolean important) {
        if (order == null)
            return;
        // 先删除此字段
        removeOrder(order.getField());
        // 如果是重要的则排在第一位，否则最后一位
        if (important) {
            orderList.add(0, order);
        } else {
            orderList.add(order);
        }
    }

    /**
     * 移除某字段的排序
     *
     * @param field
     */
    public void removeOrder(String field) {
        // 遍历，对比field
        final Iterator<MyOrder> iterator = orderList.iterator();
        while (iterator.hasNext()) {
            final MyOrder next = iterator.next();
            if (next.getField().equals(field)) {
                iterator.remove();
            }
        }
    }

    /**
     * 当前排序个数
     *
     * @return
     */
    public int orderSize() {
        return orderList.size();
    }

    /**
     * 删除优先级最低的排序
     */
    public void peekOrder() {
        if(CollectionUtils.isEmpty(orderList)){
            return;
        }
        orderList.remove(orderList.size()-1);
    }
}
