package models;

import java.util.ArrayList;

public class UserListRootResponse {

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private ArrayList<UserResponse> data;
    private Support support;

    public UserListRootResponse(int page, int per_page, int total, int total_pages, ArrayList<UserResponse> data, Support support) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public ArrayList<UserResponse> getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(ArrayList<UserResponse> data) {
        this.data = data;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
