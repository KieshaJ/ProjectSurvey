package com.kj.dashboardapi.utils.filters;

import com.kj.dashboardapi.utils.enums.SurveyStatus;

public class SurveyFilter {
    private String name;
    private SurveyStatus status;
    private Integer page;
    private Integer pageSize;

    public SurveyFilter(String name, SurveyStatus status, Integer page, Integer pageSize) {
        this.name = name;
        this.status = status;
        this.page = page;
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SurveyStatus getStatus() {
        return status;
    }

    public void setStatus(SurveyStatus status) {
        this.status = status;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
