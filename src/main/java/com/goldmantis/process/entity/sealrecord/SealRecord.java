package com.goldmantis.process.entity.sealrecord;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="user对象",description="用户对象user")
public class SealRecord implements Serializable {
    /** 主键 */
	@ApiModelProperty(hidden=true)
    private String id;

    /** 领用人姓名 */
    @ApiModelProperty(value="领用人姓名",name="employeeName",example="金螳螂")
    private String employeeName;

    /** 工号 */
    @ApiModelProperty(value="工号",name="jobnumber",example="工号",required=true)
    private String jobnumber;

    /** 印章类型 */
    @ApiModelProperty(value="印章类型",name="sealType",example="根据需求来",required=true)
    private String sealType;

    /** 部门ID */
    @ApiModelProperty(value="部门ID",name="departmentId",example="部门的ID",required=true)
    private String departmentId;

    /** 用印类型 */
    @ApiModelProperty(value="用印类型",name="usingType",example="根据需求来",required=true)
    private String usingType;

    /** 文件类型 */
    @ApiModelProperty(value="文件类型",name="fileType",example="根据需求来",required=true)
    private String fileType;

    /** 文件数量 */
    @ApiModelProperty(value="文件数量",name="fileCount",example="1",required=true)
    private Integer fileCount;

    /** 文件用途 */
    @ApiModelProperty(value="文件用途",name="fileInstruction",example="根据需求来",required=true)
    private String fileInstruction;

    /** 领用日期 */
    @ApiModelProperty(value="领用日期",name="usingDate",example="2017-11-11 11:11:11",required=true)
    private Date usingDate;

    /** 公司ID */
    @ApiModelProperty(value="公司ID",name="companyId",example="公司的ID",required=true)
    private String companyId;

    /** 关联号 */
    @ApiModelProperty(value="关联号",name="referId",example="审批的单号",required=true)
    private String referId;

    /** 备注 */
    @ApiModelProperty(value="备注",name="remark",example="备注内容")
    private String remark;

    /** 创建时间 */
    @ApiModelProperty(hidden=true)
    private Date createTime;

    /** 创建人id */
    @ApiModelProperty(hidden=true)
    private String createUserId;

    /** 修改时间 */
    @ApiModelProperty(hidden=true)
    private Date modifyTime;

    /** 修改人id */
    @ApiModelProperty(hidden=true)
    private String modifyUserId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber == null ? null : jobnumber.trim();
    }

    public String getSealType() {
        return sealType;
    }

    public void setSealType(String sealType) {
        this.sealType = sealType == null ? null : sealType.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getUsingType() {
        return usingType;
    }

    public void setUsingType(String usingType) {
        this.usingType = usingType == null ? null : usingType.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public Integer getFileCount() {
        return fileCount;
    }

    public void setFileCount(Integer fileCount) {
        this.fileCount = fileCount;
    }

    public String getFileInstruction() {
        return fileInstruction;
    }

    public void setFileInstruction(String fileInstruction) {
        this.fileInstruction = fileInstruction == null ? null : fileInstruction.trim();
    }

    public Date getUsingDate() {
        return usingDate;
    }

    public void setUsingDate(Date usingDate) {
        this.usingDate = usingDate;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getReferId() {
        return referId;
    }

    public void setReferId(String referId) {
        this.referId = referId == null ? null : referId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
    }
}