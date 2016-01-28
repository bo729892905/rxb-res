package com.rxb.res.entity;

/**
 * 权限
 * Created by rxb on 2016/1/28.
 */
public class Permission extends BaseEntity {
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限地址
     */
    private String url;
    /**
     * 权限类型
     */
    private Integer preType;
    /**
     * 上级权限id
     */
    private String parentId;
    /**
     * 是否可见
     */
    private Boolean visible;
    /**
     * 描述
     */
    private Boolean remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPreType() {
        return preType;
    }

    public void setPreType(Integer preType) {
        this.preType = preType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getRemark() {
        return remark;
    }

    public void setRemark(Boolean remark) {
        this.remark = remark;
    }
}
