package com.lijinlin.project.controller.monitor;

import java.util.List;
import java.util.Map;

/**
 * @author lijinlin
 * @date2021年05月14日 17:39
 */
public class HikPage {
    private Integer pageNo;
    private Integer pageSize;
    private Integer total;
    private Integer totalPage;
    private Boolean hasNextPage;
    private Boolean hasPreviousPage;
    private Boolean isfirstPage;
    private Boolean islastPage;
    private List<Map> rows;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public Boolean getHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(Boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public Boolean getIsfirstPage() {
        return isfirstPage;
    }

    public void setIsfirstPage(Boolean isfirstPage) {
        this.isfirstPage = isfirstPage;
    }

    public Boolean getIslastPage() {
        return islastPage;
    }

    public void setIslastPage(Boolean islastPage) {
        this.islastPage = islastPage;
    }

    public List<Map> getRows() {
        return rows;
    }

    public void setRows(List<Map> rows) {
        this.rows = rows;
    }
}
