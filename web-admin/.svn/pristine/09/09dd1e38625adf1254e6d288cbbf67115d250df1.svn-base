<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="easyui-tabs" id="basic_form_tab" >
	<div id="div_info" title="" style="padding: 10px">
	<table width="100%" class="table_info" style="border:0">
		<tr>
		<td width="15%">公司名称：</td>
		<td width="35%"><input class="easyui-textbox" type="text" value="" id="companyName" name="companyName" style="width:120px"></input></td>
		<td width="15%">岗位需求：</td>
		<td width="35%"><input class="easyui-textbox" type="text" value="" id="position" name="position" style="width:120px"></input></td>
		</tr>
		<tr>
		<td>联 系 人：</td>
		<td><input class="easyui-textbox" type="text" value="" id="contacts" name="contacts" style="width:120px"></input></td>
		<td>联系号码：</td>
		<td><input class="easyui-textbox" type="text" value="" id="phoneNumber" name="phoneNumber" style="width:120px"></input></td>
		</tr>
		<tr>
		<td>最低薪资：</td>
		<td><input class="easyui-textbox" type="text" value="" id="salaryMin" name="salaryMin" style="width:120px"></input></td>
		<td>最高薪资：</td>
		<td><input class="easyui-textbox" type="text" value="" id="salaryMax" name="salaryMax" style="width:120px"></input></td>
		</tr>
		</table>
		<table width="100%" class="table_info" style="border:0">
		<tr>
		<td width="14.7%">需求简介：</td>
		<td width="85.3%"><input class="easyui-textbox" type="text" value="" id="requirementIntroduce" name="requirementIntroduce" data-options="multiline:true" style="width:90%;height: 70px"></input></td>
		</tr>
		<tr>
		<td>发布时间：</td>
		<td><input class="easyui-textbox" type="text" value="" id="releaseTimeStr" name="releaseTimeStr" style="width:120px"></input></td>
		</tr>
		<tr>
		<td>知 识 点：</td>
		<td><c:forEach items="${knowledge}" var="knowledge" varStatus="vs">
		<input class="easyui-textbox" type="text" value="${knowledge.knowledgeName}" name="knowledge" style="width:100px"></input>
		</c:forEach></td>
		</tr>
		<tr>
		<td>技   能 ：</td>
		<td><c:forEach items="${skill}" var="skill" varStatus="vs">
		<input class="easyui-textbox" type="text" value="${skill.skillName}" name="skill" style="width:100px"></input>
		</c:forEach></td>
		</tr>
		</table>
	</div>
</div>

<script>


$(function(){
	loading();
});
 
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
 
 function loading(){
	 $("#div_info").attr('title',companyName);
	 $("#companyName").val(companyName);
	 $("#position").val(position);
	 $("#contacts").val(contacts);
	 $("#phoneNumber").val(phoneNumber);
	 $("#salaryMin").val(salaryMin);
	 $("#salaryMax").val(salaryMax);
	 $("#requirementIntroduce").val(requirementIntroduce);
	 $("#releaseTimeStr").val(releaseTimeStr);
	 //$("input").Attr({disabled:"disabled"});
	 var aInput = document.getElementsByTagName('input');
	 for(var j = 0; j < aInput.length; j++){
	   aInput[j].readOnly = true;
	 }
 }
 
</script>