package com.dayanghome.dayangerp.form;

public class CustomerQuery {
    private String chineseName;
    private String mobile;

    private Integer pageNum = 0;
    private Integer pageSize = 30;

    private Integer offset;

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        if (pageNum == 0) {
            return 0;
        } else {
            return (pageNum - 1) * pageSize;
        }
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "CustomerQuery{" +
                "chineseName='" + chineseName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                '}';
    }
}
