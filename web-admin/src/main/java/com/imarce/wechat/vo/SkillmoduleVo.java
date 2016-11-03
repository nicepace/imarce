package com.imarce.wechat.vo;

import java.util.List;

import com.imarce.wechat.entity.Knowledge;

/**
* @version
* @author xsc 
* @time 2016年6月16日下午9:22:04
* 技能模块Vo类
*/
public class SkillmoduleVo {

    /**
     * 技能模块名称
     */
    private String skillmoduleName;
    
    /**
     * 技能对象集合
     */
    private List<Knowledge> knowledgeList;
    
    public SkillmoduleVo(){
    	
    }

	public SkillmoduleVo(String skillmoduleName, List<Knowledge> knowledgeList) {
		super();
		this.skillmoduleName = skillmoduleName;
		this.knowledgeList = knowledgeList;
	}

	public String getSkillmoduleName() {
		return skillmoduleName;
	}

	public void setSkillmoduleName(String skillmoduleName) {
		this.skillmoduleName = skillmoduleName;
	}

	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

    
}
