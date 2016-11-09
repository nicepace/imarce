<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="easyui-panel" data-options="fit:true">
   	<input name="positionid" value="${position.positionId}" type="hidden"/>
   <table class="table_info" width="100%">
		<tr>
			<td width="40%" align="left">用户:</td>
			<td width="60%">
				<input id="name" class="easyui-textbox" name="name" type="text" data-options="required:true" value="${user.userName}"/>
			</td>
		</tr>
		<tr>
			<td width="40%" align="left">权限:</td>
			<td width="60%">
				<select id="role" class="easyui-combobox" name="role" type="text" data-options="required:true" value="${user.roleName}">
				  <option value="1">管理员</option>
                <option value="2">1</option>
                <option value="3">2</option>
                <option value="4">3</option>
                </selec>
			</td>
		</tr>
				
	</table>

            <p style="text-align:center">
           
              <a id="basic_btn" href="javascript:;"  onclick="editPosition()"  class="easyui-linkbutton" 
              data-options="iconCls:'icon-save'">保存信息</a>
            </p>
            <p id="basic_tip" style="text-align:center"></p>
        </div>
</div>
  
  <script>
    function editPosition(){
    	 if(document.getElementById("name").value==""){
    		 $("#basic_tip").html("<font color='red' >名字不能为空!</font>");
 	    }
 	 else{
    	 $.ajax({
    	     url:"../editUser",
    		 type:"post",
    		 dataType:"json",
    		 data:{ 
    			       "userName":$("input[name='name']").val(),
    		           "roleId":$("input[name='role']").val()
    			  },
    	     success:function(da){
    	          $("#basic_tip").html("<font color='red'>"+da.msg+"</font>");
    	          $("#win").window("close");
    	          $.messager.alert("提示","修改成功！");
    	          $("#refresh").datagrid("reload"); 
    	          if(da.code=="10002"){
    	        	  $('#basic_btn').linkbutton('enable');
    	          }
    	     },
    	     beforeSend:function(){
    	    	 $("#basic_tip").html("<font color='red' >保存中...</font>");
    	    	 $('#basic_btn').linkbutton('disable');
    	     },
    	     error:function(){
    	    	 $("#basic_tip").html("<font color='red' >服务器忙...</font>") 
    	     }
    	});
 	 }
    	
    }
  
  </script>