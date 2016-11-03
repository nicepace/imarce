<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="easyui-panel" data-options="fit:true">
   	<input name="positionid" value="${position.positionId}" type="hidden"/>
   <table class="table_info" width="100%">
		<tr>
			<td width="40%" align="left">岗位:</td>
			<td width="60%">
				<input id="name" class="easyui-textbox" name="positionName" type="text" data-options="required:true" value="${position.positionName}"/>
			</td>
		</tr>
		<tr>
			<td align="left">岗位描述:</td>
			<td>
				<input class="easyui-textbox" name="positionDesc" data-options="multiline:true" style="width:295px;height:100px" value="${position.positionDesc}"/>
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
    		 $("#basic_tip").html("<font color='red' >岗位不能为空!</font>");
 	    }
 	 else{
    	 $.ajax({
    	     url:"../edit_position_basic",
    		 type:"post",
    		 dataType:"json",
    		 data:{ 
    			       "positionId":$("input[name='positionid']").val(),
    		           "positionName":$("input[name='positionName']").val(),
    		           "positionDesc":$("input[name='positionDesc']").val()
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