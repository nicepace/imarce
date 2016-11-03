<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="add_work_exp_div" style="display: none;">
	<form id="form_work_exp" name="form_work_exp" action="#" method="post">
		<table width="100%" class="table_info">
			<tr>
				<td>工作公司</td>
				<td colspan="3"><input id="workCompany" class="easyui-textbox"
					style="width: 400px" type="text" name="workCompany"
					data-options="required:true"></input></td>
			</tr>
			<tr>
				<td width="15%">开始时间</td>
				<td width="25%"><input class="easyui-datebox"
					id="workStartDate" name="workStartDate"
					data-options="required:true,formatter:myformatter,parser:myparser"
					style="width: 120px"></td>
				<td width="15%">结束时间</td>
				<td width="25%"><input class="easyui-datebox" id="workEndDate"
					name="workEndDate"
					data-options="required:true,formatter:myformatter,parser:myparser"
					style="width: 120px"></td>
			</tr>
			<tr>
				<td>工作介绍</td>
				<td colspan="3"><input id="workIntro" class="easyui-textbox"
					style="width: 400px; height: 100px" type="text" name="workIntro"
					data-options="required:true,multiline:true"></input></td>
			</tr>
		</table>
	</form>
	<p style="text-align: center">
		<a id="save_work_exp" href="javascript:;" onclick="saveWorkExp()"
			class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存信息</a>
	</p>
	<p id="save_work_exp_tip" style="text-align: center"></p>
</div>



<p style="text-align: right" id="p_add">
	<a href="javascript:;" id="add_work_exp" class="easyui-linkbutton"
		onclick="addWorkExp()" style="padding: 2px; margin-bottom: 10px;">添加工作经历</a>
</p>

<div id="work_exp_refresh">
	<c:forEach items="${workExperience}" var="we">		
		<p hidden="true" id="stuid">${we.studentId }</p>
		
	<div id="edit_work_exp_div${we.workExperienceId }" class="edit_work_exp_div" style="display: none;">
	<form id="edit_form_work_exp" name="form_work_exp" action="#" method="post">
		<table width="100%" class="table_info">
			<tr>
				<td>工作公司</td>
				<td colspan="3"><input id="edit_workCompany${we.workExperienceId }" class="easyui-textbox"
					style="width: 400px" type="text" name="workCompany"
					data-options="required:true" value="${we.workCompany }" /></td>
			</tr>
			<tr>
				<td width="15%">开始时间</td>
				<td width="25%"><input class="easyui-datebox"
					id="edit_workStartDate${we.workExperienceId }" name="editworkStartDate"
					data-options="required:true,formatter:myformatter,parser:myparser"
					style="width: 120px"  value="${we.workStartStr }" /></td>
				<td width="15%">结束时间</td>
				<td width="25%"><input class="easyui-datebox" id="edit_workEndDate${we.workExperienceId }"
					name="editworkEndDate"
					data-options="required:true,formatter:myformatter,parser:myparser"
					style="width: 120px"  value="${we.workEndStr }" /></td>
			</tr>
			<tr>
				<td>工作介绍</td>
				<td colspan="3"><input id="edit_workIntro${we.workExperienceId }" class="easyui-textbox"
					style="width: 400px; height: 100px" type="text" name="workIntro"
					data-options="required:true,multiline:true"  value="${we.workIntroduce }"/></td>
			</tr>
		</table>
	</form>
	<p style="text-align: center">
	    <a id="edit_work_exp" href="javascript:;" onclick="updateWorkExp(${we.workExperienceId },${we.studentId })"
			class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a>	  
			<a id="edit_work_exp" href="javascript:;" onclick="noEditWorkExp(${we.workExperienceId })"
			class="easyui-linkbutton" data-options="iconCls:'icon-clear'">取消</a>	      
			
	</p>
	<p id="edit_work_exp_tip" style="text-align: center"></p>
</div>

		<div class="easyui-panel" id="p${we.workExperienceId }"
			title="${we.workStartStr }到 ${we.workEndStr } [${we.workCompany }]"
			data-options="tools:[
			{iconCls:'icon-edit',handler:function(){editExp(${we.workExperienceId })}},
			{iconCls:'icon-clear',handler:function(){deleteExp(${we.workExperienceId })}}
			]"
			style="padding: 10px; margin-bottom: 10px; width: 100%">
			<p>${we.workIntroduce }</p>
		</div>		
	</c:forEach>
</div>
<script type="text/javascript">
  
   
	function editExp(expId) {
		$("#add_work_exp").linkbutton('disable');		
		$('#edit_work_exp_div'+expId).slideDown();
		$('#p'+expId).panel('close'); 
		$('#p'+expId).panel('disable'); 
		 
	}
	
	function noEditWorkExp(expId) {
		$("#add_work_exp").linkbutton('enable');		
		$(".edit_work_exp_div").slideUp();
		$(".easyui-panel").panel('open');
	}

	function deleteExp(expId) {
		var stuId = $('#stuid').text();
		if (expId != null && expId > 0) {
			$.messager.confirm('Confirm', '确认删除?', function(r) {
				if (r) {
					$.ajax({
						url : "../delete_work_experience",
						type : "post",
						dataType : "json",
						data : {
							"workExperienceId" : expId
						},
						success : function(da) {
							if (da.code == "10001") {
								alert(da.msg)
								$('#work_exp').panel(
										'refresh',
										'../query_work_experience?studentId='
												+ stuId);
							} else {
								alert(da.msg)
							}
						},
						error : function() {
							alert("删除失败")
						}
					});
				}
			});
		}
	}
	
	function updateWorkExp(expId,stuId) {
		var start = $("#edit_workStartDate"+expId).datebox("getValue");
		var end = $("#edit_workEndDate"+expId).datebox("getValue");			
		var workItroduce=$("#edit_workIntro"+expId).val();
		var workcompany=$("#edit_workCompany"+expId).val();		
		if (start != "" && end != "") {
			start = start.split('-');
			end = end.split('-');
			var startTime = new Date(start[0], start[1] - 1, start[2]);
			var endTime = new Date(end[0], end[1] - 1, end[2]);
			if (startTime.getTime() >= endTime.getTime()) {
				alert("开始时间不能大于或等于结束时间");
				return;
			}
		}

		if (start==""||end==""||workItroduce==""||workcompany=="") {
			$("#edit_work_exp_tip").html("<font color='red' >必填项不能为空！</font>")
			
		} else {
			
			$.ajax({
				url : "../update_work_experience",
				type : "post",
				dataType : "json",
				data : {
					"studentId" :stuId,
					"workCompany" : workcompany,
					"workStart" :start[0]+"-"+start[1]+"-"+start[2],
					"workEnd" :  end[0]+"-"+end[1]+"-"+end[2],
					"workIntroduce" : workItroduce,					
					"workExperienceId":expId
					},
				success : function(da) {
					
							$("#edit_work_exp_tip").html(
									"<font color='red'>" + da.msg + "</font>");

							if (da.code == "10002") {
								$('#edit_work_exp').linkbutton('enable');
								if ($("input[name='workCompany']").val().length > 25) {
									alert("标题字数过长,请控制在25字内.");
								} else if ($("input[name='workIntro']").val().length > 250) {
									alert("介绍字数过长,请控制在250字内");
								}
							} else if (da.code == "10001") {
								$('#work_exp').panel(
										'refresh',
										'../query_work_experience?studentId='
												+ stuId);
							}
						},
				beforeSend : function() {					
							$("#edit_work_exp_tip").html(
									"<font color='red' >保存中...</font>");
							$('#edit_work_exp').linkbutton('disable');
						},
				error : function() {
							$("#save_work_exp_tip").html(
									"<font color='red' >服务器忙...</font>")
						}
					});
		}

	}

	function saveWorkExp() {
		var start = $("#workStartDate").datebox("getValue");
		var end = $("#workEndDate").datebox("getValue");
		if (start != "" && end != "") {
			start = start.split('-');
			end = end.split('-');
			var startTime = new Date(start[0], start[1] - 1, start[2]);
			var endTime = new Date(end[0], end[1] - 1, end[2]);
			if (startTime.getTime() >= endTime.getTime()) {
				alert("开始时间不能大于或等于结束时间");
				return;
			}
		}

		if ($("input[name='workCompany']").val() == ""
				|| $("input[name='workStartDate']").val() == ""
				|| $("input[name='workEndDate']").val() == ""
				|| $("input[name='workIntro']").val() == "") {
			$("#save_work_exp_tip").html("<font color='red' >必填项不能为空！</font>")
		} else {
			$
					.ajax({

						url : "../save_work_experience",
						type : "post",
						dataType : "json",
						data : {

							"workCompany" : $("input[name='workCompany']")
									.val(),
							"workStart" : $("input[name='workStartDate']")
									.val(),
							"workEnd" : $("input[name='workEndDate']").val(),
							"workIntroduce" : $("input[name='workIntro']")
									.val(),
							"studentId" : $("input[name=studentId]").val()
						},
						success : function(da) {
							$("#save_work_exp_tip").html(
									"<font color='red'>" + da.msg + "</font>");

							if (da.code == "10002") {
								$('#save_work_exp').linkbutton('enable');
								if ($("input[name='workCompany']").val().length > 25) {
									alert("标题字数过长,请控制在25字内.");
								} else if ($("input[name='workIntro']").val().length > 250) {
									alert("介绍字数过长,请控制在250字内");
								}
							} else if (da.code == "10001") {
								$('#work_exp').panel(
										'refresh',
										'../query_work_experience?studentId='
												+ da.data.studentId);
							}
						},
						beforeSend : function() {
							$("#save_work_exp_tip").html(
									"<font color='red' >保存中...</font>");
							$('#save_work_exp').linkbutton('disable');
						},
						error : function() {
							$("#save_work_exp_tip").html(
									"<font color='red' >服务器忙...</font>")
						}
					});
		}

	}

	function addWorkExp() {
		var workExp = document.getElementById("add_work_exp");
		if (workExp.innerText == "添加工作经历") {
			workExp.innerText = "返回";
			$("#add_work_exp_div").slideDown();
		} else {
			workExp.innerText = "添加工作经历";
			$("#add_work_exp_div").slideUp();			
		}
	}

	function myformatter(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d);
	}
	function myparser(s) {
		if (!s)
			return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0], 10);
		var m = parseInt(ss[1], 10);
		var d = parseInt(ss[2], 10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
			return new Date(y, m - 1, d);
		} else {
			return new Date();
		}
	}
</script>