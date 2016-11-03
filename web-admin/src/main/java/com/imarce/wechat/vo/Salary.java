package com.imarce.wechat.vo;
/**
* @version
* @author xsc 
* @time 2016年6月16日下午10:20:52
* 薪资类
*/
public class Salary {

    /**
     * 最低薪资
     */
    private Double salaryMin;
    /**
     * 最高薪资
     */
    private Double salaryMax;
    
    public Salary(){
    	
    }

	public Salary(Double salaryMin, Double salaryMax) {
		super();
		this.salaryMin = salaryMin;
		this.salaryMax = salaryMax;
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
	
}
