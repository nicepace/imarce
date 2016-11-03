<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="easyui-panel" data-options="fit:true">
	<input name="levelid" value="${level.levelId}" type="hidden"/>
	<table class="table_info" width="100%">
		<tr>
			<td width="40%">等级:</td>
			<td width="60%">
				<input class="easyui-textbox" name="levelname" type="text" data-options="required:true" value="${level.levelName}"/>
			</td>
		</tr>
		<tr>
			<td>描述:</td>
			<td>
				<input name="description" class="easyui-textbox" data-options="multiline:true" style="width:300px;height:100px" value="${level.levelDesc}"/>
			</td>
		</tr>
				
	</table>
	<p style="text-align:center">
			<a id="level_update" href="javascript:;" onclick="updateLevel()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">更新</a>
	</p>
	 <p id="basic_level" style="text-align:center"></p>
</div>
<script>
function updateLevel(){
	 $.ajax({
	     url:"../view_level_update",
		 type:"post",
		 
		 dataType:"json",
		 data:{ 
		           "levelId":$("input[name='levelid']").val(),
		           "levelName":$("input[name='levelname']").val(),
		           "levelDesc":$("input[name='description']").val(),
		           "levelPicture":$("input[name='picture']").val(),
		          
			  },
	     success:function(da){
	          $("#basic_level").html("<font color='red'>"+da.msg+"</font>");
	          $("#win").window("close");
	          $.messager.alert("提示","修改成功！");
	          $("#flush").datagrid("reload");    
	          if(da.code=="10002"){
	        	  $('#level_update').linkbutton('enable');
	          }
	     },
	     beforeSend:function(){
	    	 $("#basic_level").html("<font color='red' >更新中...</font>");
	    	 $('#level_update').linkbutton('disable');
	     },
	     error:function(){
	    	 $("#basic_level").html("<font color='red' >服务器忙...</font>") 
	     }
	     
	});			
}
</script>


