package com.imarce.webadmin.entity.vo;

import java.util.List;

/**
 * 2016年7月15日 上午11:00:21
 * @author shadow
 * 说明：ComboTree叶子节点类
 *
 */
public class ComboTreeLeafVO {
	private Integer id;
	private String text;
	private boolean checked = false;
	private List attributes;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public List getAttributes() {
		return attributes;
	}
	public void setAttributes(List attributes) {
		this.attributes = attributes;
	}

}
