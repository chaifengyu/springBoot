package com.goldmantis.process.entity.common;

import java.io.Serializable;

public class CommonRegion implements Serializable {
    /** common_region.id */
    private String id;

    /** common_region.name */
    private String name;

    /** common_region.level */
    private Integer level;

    /** common_region.govcode */
    private String govcode;

    /** common_region.areacode */
    private String areacode;

    /** common_region.typename */
    private String typename;

    /** common_region.parent_id */
    private String parentId;

    /** erp地区编号 */
    private String erpCode;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getGovcode() {
        return govcode;
    }

    public void setGovcode(String govcode) {
        this.govcode = govcode == null ? null : govcode.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode == null ? null : erpCode.trim();
    }
}