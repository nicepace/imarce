<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div style="padding: 10px;">
	<form action="#" method="post" id="skillModuleForm" >
		<table class="table_info" >
			<tr>
				<td width="30%">技能名称</td>
				<td width="70%"><input class="easyui-textbox" type="text" name="skillModuleName" data-options="required:true" value="${skillModule.skillModuleName }"></input></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input class="easyui-textbox" type="text" name="skillModuleNote" data-options="multiline:true" style="width:200px;height:100px" value="${skillModule.skillModuleNote }"></input>
				</td>
			</tr>
		</table>
	</form>
	<p style="text-align: center">

		<a id="update_btn" href="javascript:;" onclick="saveUpdateSkillModule()"
			class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存修改</a>
	</p>
	<p id="update_tip" style="text-align: center"></p>
</div>
<script>
	function saveUpdateSkillModule(){
		if($("input[name='skillModuleName']").val()!=""){
			var sid = ${skillModule.skillModuleId};
			$.ajax({
		   	     url:"../update_skillmodule",
		   		 type:"post",
		   		 dataType:"json",
		   		 data:{ 
		   				  "skillModuleId":sid,
		   		          "skillModuleName":$("input[name='skillModuleName']").val(),
		   		          "skillModuleNote":$("input[name='skillModuleNote']").val()
		   			  },
		   	     success:function(data){
		   	    		 $("#update_tip").html("<font color='red'>"+data.msg+"</font>");
			   	    	 if(data.code=="10001"){
			   	   	          $("#win").window("close");
			   	   	          $.messager.alert("提示","修改成功！");
			   	   	          $("#skillmodule").datalist("reload");
			   	   	          
		  	   	       	  }else if(data.code=="10002"){
		  	   	        	  $('#update_btn').linkbutton('enable');
		  	   	          }     
		   	     },
		   	     beforeSend:function(){
		   	    	 $("#update_tip").html("<font color='red' >保存中...</font>");
		   	    	 $('#update_btn').linkbutton('disable');
		   	     },
		   	     error:function(){
		   	    	 $("#update_tip").html("<font color='red' >服务器忙...</font>") 
		   	     }
		   	});
		} else {
			 $("#update_tip").html("<font color='red' >技能名称不能为空！</font>");
			return;
		}
	}
</script>