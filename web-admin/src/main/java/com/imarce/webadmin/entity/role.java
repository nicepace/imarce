package com.imarce.webadmin.entity;

public class role {

	@Override
	public String toString() {
		return "role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	private int roleId;
	private String roleName;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
}
