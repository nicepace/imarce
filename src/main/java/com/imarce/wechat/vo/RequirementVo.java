package com.imarce.wechat.vo;


/**
* @version
* @author xsc 
* @time 2016年6月16日下午8:31:40
* 需求Vo类
*/
public class RequirementVo {

    /**
     * 需求ID
     */
	private Integer requirementId;
	/**
     * 公司名称
     */
    private String companyName;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 联系电话
     */
    private String phoneNumber;
    /**
     * 需求内容，即工作内容介绍
     */
    private String requirementIntroduce;
    /**
     * 最低薪资
     */
    private Double salaryMin;
    /**
     * 最高薪资
     */
    private Double salaryMax;
    /**
     * 所选择的岗位的id
     */
    private Integer positionId;
    
    public RequirementVo(){}

	public RequirementVo(Integer requirementId, String companyName, String contacts, String phoneNumber,
			String requirementIntroduce, Double salaryMin, Double salaryMax, Integer positionId) {
		super();
		this.requirementId = requirementId;
		this.companyName = companyName;
		this.contacts = contacts;
		this.phoneNumber = phoneNumber;
		this.requirementIntroduce = requirementIntroduce;
		this.salaryMin = salaryMin;
		this.salaryMax = salaryMax;
		this.positionId = positionId;
	}

	public Integer getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRequirementIntroduce() {
		return requirementIntroduce;
	}

	public void setRequirementIntroduce(String requirementIntroduce) {
		this.requirementIntroduce = requirementIntroduce;
	}

	public Double getSalaryMin() {
		return salaryMin;
	}

	public void setSalaryMin(Double salaryMin) {
		this.salaryMin = salaryMin;
	}

	public Double getSalaryMax() {
		return salaryMax;
	}

	public void setSalaryMax(Double salaryMax) {
		this.salaryMax = salaryMax;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}


}
