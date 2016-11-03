<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="easyui-tabs" id="basic_form_tab" data-options="fit:true">
	<div title="基本信息" style="padding: 10px">
		<form action="../update_stu" method="post" id="form_update">
			<input type="hidden" value="${student.studentId}" name="studentId" id="stuId"></input>
			<table width="100%" class="table_info">
	            <tr>      
	              	<td width="22%" rowspan="7">&nbsp;</td>
	                <td width="16%">姓名</td>
	                <td width="23%">
	                  <input class="easyui-textbox" type="text" name="studentName" data-options="required:true" 
	                  value="${student.studentName}" style="width:120px"></input>
	                </td>
	                <td width="16%">出生日期</td>
	                <td width="23%">
	                   <input class="easyui-datebox"  name="birthday" value="${student.birthdayStr}" style="width:120px"></input>
	                </td>
	            </tr>
	            <tr>
	                <td>工作年限</td>
	                <td>
	                  <input class="easyui-numberbox" type="text" name="workTime" value="${student.workTime}" style="width:120px"></input>
	                </td>
	                <td>所在地</td>
	                <td>
	                  <input class="easyui-textbox" type="text" name="area" value="${student.area}" style="width:120px"></input>
	                </td>
	            </tr>	              
	            <tr>
	                <td>薪资</td>
	                <td>
	                  <input class="easyui-textbox" type="text" name="salary" value="${student.salary}" style="width:120px"></input>
	                </td>
	                <td>入职公司</td>
	                <td>
	                   <input class="easyui-textbox" name="employed" value="${student.employed}" style="width:120px"></input>
	                </td>
	            </tr>
	            <tr>
	                <td>入职时间</td>
	                <td>
	                  <input class="easyui-datebox" name="workDate" value="${student.workDateStr}" style="width:120px"></input>
	                </td>
	                <td>是否入职</td>
	                <td>
	                   <select class="easyui-combobox" style="width:120px"  name="workState" 
	                   		data-options="valueField:'id',textField:'text',value:${student.workState}" id="ws">
	                   		<option value="0">否</option>
	                   		<option value="1">是</option>
	                   </select>
	                </td>
	            </tr>
	            <tr>
					<td>岗位类型</td>
	                <td>
	                   
	                   <select class="easyui-combobox" style="width:120px" id="position_list" name="position.positionId" 
	                   		data-options="url:'../position_for_select',valueField:'id',textField:'text',
	                   		value:${student.position.positionId==null?'':student.position.positionId},
	                   		onSelect:changeKnowledgeList">
	                   </select>
	                </td>
	                <td>级别</td>
	                <td>
						<select class="easyui-combobox" style="width:120px" name="level.levelId" 
	                   		data-options="url:'../level_for_select',valueField:'levelId',textField:'levelName',
	                   		value:${student.level.levelId==null?'':student.level.levelId}">
	                   </select>
					</td>
	            </tr>
				<tr rowspan="2">
					<td>技能特长</td>
					<td colspan="3">
							<div>
								<input id="knowledge" class="easyui-combotree"
									data-options="url:'../query_skillmodule_and_knowledge?pid='+$('#position_list').combotree('getValue')+'&stuId='+$('#stuId').val(),
									multiple:true,lines:true,required:true,
									onBeforeExpand:showChildrenList" 
									style="width: 350px">
								</input>
							</div>
					</td>
				</tr>
			</table>
			<table width="80%" height="100px" class="table_info">
              <tr>
                <td width="16%">自我评价</td>
                <td colspan="4">
                	<input class="easyui-textbox" type="text" name="studentIntroduce" data-options="multiline:true"
                	value="${student.studentIntroduce}" style="width:100%;height:100%"></input>
                </td>
              </tr>
            </table>
		</form>
		<p style="text-align: center">

			<a id="update_btn" href="javascript:;" onclick="updateStu()"
				class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改信息</a>
		</p>
		<p id="update_tip" style="text-align: center"></p>
	</div>
</div>

<script>
 
 function showChildrenList(node){
	 var mark_pid =  parseInt('2'+$("input[name='position.positionId']").val());
 	 if(node.id!=mark_pid){
		 var node_id = node.id+"";
		 var real_id = parseInt(node_id.substring(1));
		 $('#knowledge').combotree("tree").tree("options").url= "../query_knowledge_list?sid=" + real_id;
	 } 
 }
 
 function changeKnowledgeList(record){
 	$.ajax({
		url:"../query_skillmodule_list",
		dataType:"json",
		data:"pid="+record.id,
		success:function(data){
			$('#knowledge').combotree('clear'); 
			$('#knowledge').combotree('loadData',data);
		}	
	});	 
 }
 
</script>