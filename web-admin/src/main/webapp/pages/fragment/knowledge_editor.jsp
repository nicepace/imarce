<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div style="padding: 10px;">
	<form action="#" method="post" id="skillModuleForm" >
		<table class="table_info" >
			<tr>
				<td width="30%">知识名称</td>
				<td width="70%"><input class="easyui-textbox" type="text" name="knowledgeName" data-options="required:true" value="${knowledge.knowledgeName }"></input></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input class="easyui-textbox" type="text" name="knowledgeNote" data-options="multiline:true" style="width:200px;height:100px" value="${knowledge.knowledgeNote }"></input>
				</td>
			</tr>
		</table>
	</form>
	<p style="text-align: center">

		<a id="update_btn" href="javascript:;" onclick="saveUpdateKnowledge()"
			class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存修改</a>
	</p>
	<p id="update_tip" style="text-align: center"></p>
</div>
<script>
	function saveUpdateKnowledge(){
		if($("input[name='knowledgeName']").val()!=""){
			var kid = ${knowledge.knowledgeId};
			$.ajax({
		   	     url:"../update_knowledge",
		   		 type:"post",
		   		 dataType:"json",
		   		 data:{ 
		   				  "knowledgeId":kid,
		   		          "knowledgeName":$("input[name='knowledgeName']").val(),
		   		          "knowledgeNote":$("input[name='knowledgeNote']").val()
		   			  },
		   	     success:function(data){
		   	    		 $("#update_tip").html("<font color='red'>"+data.msg+"</font>");
			   	    	 if(data.code=="10001"){
			   	   	          $("#win").window("close");
			   	   	          $.messager.alert("提示","修改成功！");
			   	   	          $("#knowledge").datalist("reload");
			   	   	         
		  	   	       	  }else if(data.code=="10002"){
		  	   	        	  //$("#update_tip").html("<font color='red'>"+data.msg+"</font>");
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
			 $("#update_tip").html("<font color='red' >知识名称不能为空！</font>");
				return;
		}
	}
</script>