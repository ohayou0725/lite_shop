package com.ohayou.liteshop.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author liyan
 * @date 2020/7/13 下午9:51
 */
public class PageQuery<T> {

    /*
    当前页码
     */
    public static final String PAGE = "page";

    /*
    每页记录数
     */
    public static final String LIMIT = "size";

    /*
    排序字段
     */
    public static final String ORDER_FIELD = "order";

    /*
    排序方式
     */
    public static final String ORDER = "order";

    /*
    升序
     */
    public static final String ASC = "acs";

    public IPage<T> getPage(Map<String, Object> params) {
        return this.getPage(params, null, false);
    }

    public IPage<T> getPage(Map<String, Object> params, String defaultOrderField, boolean isAsc) {
        //分页参数
        long curPage = 1;
        long limit = 10;

        if(params.get(PAGE) != null){
            curPage = Long.parseLong((String)params.get(PAGE));
        }
        if(params.get(LIMIT) != null){
            limit = Long.parseLong((String)params.get(LIMIT));
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //分页参数
        params.put(PAGE, page);

        //排序字段
        String orderField = String.valueOf(params.get(ORDER_FIELD));
        String order = (String)params.get(ORDER);


        //前端字段排序
        if(StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)){
            if(ASC.equalsIgnoreCase(order)) {
                return page.addOrder(OrderItem.asc(orderField));
            }else {
                return page.addOrder(OrderItem.desc(orderField));
            }
        }

        //没有排序字段，则不排序
        if(StringUtils.isBlank(defaultOrderField)){
            return page;
        }

        //默认排序
        if(isAsc) {
            page.addOrder(OrderItem.asc(defaultOrderField));
        }else {
            page.addOrder(OrderItem.desc(defaultOrderField));
        }

        return page;
    }
}
