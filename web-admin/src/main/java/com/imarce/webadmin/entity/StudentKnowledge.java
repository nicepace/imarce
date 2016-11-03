package com.imarce.webadmin.entity;
/**
 * 2016年7月14日 下午7:11:11
 * @author shadow
 * 说明：技能知识实体类
 *
 */
public class StudentKnowledge {
	private int studentKnowledgeId;
	private int studentId;
	private int knowledgeId;
	
	
	public int getStudentKnowledgeId() {
		return studentKnowledgeId;
	}
	public void setStudentKnowledgeId(int studentKnowledgeId) {
		this.studentKnowledgeId = studentKnowledgeId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getKnowledgeId() {
		return knowledgeId;
	}
	public void setKnowledgeId(int knowledgeId) {
		this.knowledgeId = knowledgeId;
	}
	
	
}
