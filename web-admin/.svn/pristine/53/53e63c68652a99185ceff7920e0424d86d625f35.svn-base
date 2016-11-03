<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div style="padding: 10px;">
	<form action="#" method="post" id="skillModuleForm" >
		<table class="table_info">
			<tr>
				<td width="30%">技能名称</td>
				<td width="70%"><input class="easyui-textbox" type="text" name="skillModuleName" data-options="required:true"></input></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input class="easyui-textbox" type="text" name="skillModuleNote" data-options="multiline:true" style="width:200px;height:100px"></input>
				</td>
			</tr>
		</table>
	</form>
	<p style="text-align: center">

		<a id="add_btn" href="javascript:;" onclick="saveSkillModule()"
			class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存添加</a>
	</p>
	<p id="add_tip" style="text-align: center"></p>
</div>
<script>
	function saveSkillModule(){
		if($("input[name='skillModuleName']").val()!=""){
			var pid = ${param.positionId};
			$.ajax({
		   	     url:"../add_skillmodule",
		   		 type:"post",
		   		 dataType:"json",
		   		 data:{ 
		   		          "skillModuleName":$("input[name='skillModuleName']").val(),
		   		          "skillModuleNote":$("input[name='skillModuleNote']").val(),
		   		          "pid":pid
		   			  },
		   	     success:function(data){
		   	    	 $("#add_tip").html("<font color='red'>"+data.msg+"</font>");
		   	    	 if(data.code=="10001"){
		   	   	          $("#win").window("close");
		   	   	          $.messager.alert("提示","添加成功！");
		   	   	          $("#skillmodule").datalist("reload");
		   	   	           
	   	   	       	  }else if(data.code=="10002"){
	   	   	        	  $('#add_btn').linkbutton('enable');
		   	    	 }     
		   	     },
		   	     beforeSend:function(){
		   	    	 $("#add_tip").html("<font color='red' >保存中...</font>");
		   	    	 $('#add_btn').linkbutton('disable');
		   	     },
		   	     error:function(){
		   	    	 $("#add_tip").html("<font color='red' >服务器忙...</font>") 
		   	     }
		   	});
		} else {
			$("#add_tip").html("<font color='red' >技能名称不能为空！</font>");
			return;
		}
	}
</script>