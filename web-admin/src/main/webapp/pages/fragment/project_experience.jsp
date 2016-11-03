<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="add_proj_exp_div" style="display:none;">
	<form id="form_proj_exp" name="form_proj_exp" action="" method="post">
	   <table width="100%" class="table_info">
	      <tr>
		        <td>项目名称</td>
		        <td colspan="3">
		          	<input class="easyui-textbox" style="width:400px"  type="text" name="projName" data-options="required:true"></input>
		        </td>
	      </tr>
	      <tr>
		        <td width="15%">开始时间</td>
		        <td width="25%">
		          	<input class="easyui-datebox" id="projStartDate" name="projStartDate" data-options="required:true,formatter:myformatter,parser:myparser" style="width:120px">
		        </td>
		        <td width="15%">结束时间</td>
		        <td width="25%">
			    	<input class="easyui-datebox" id="projEndDate" name="projEndDate" data-options="required:true,formatter:myformatter,parser:myparser" style="width:120px">
		        </td>
	      </tr>
	      <tr>
		        <td>项目介绍</td>
		        <td colspan="3">
		        	<input class="easyui-textbox" style="width:400px;height:100px"  type="text" name="projIntro" data-options="required:true,multiline:true"></input>
		        </td>
	      </tr>
	    </table>
	</form>
	<p style="text-align:center">
		<a id="save_proj_exp_btn" href="javascript:;"  onclick="saveProExp()"  class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
	</p>
	<p id="save_proj_exp_tip" style="text-align:center"></p>
</div>
<p style="text-align:right">
	<a href="javascript:;" id="add_proj_exp_btn" class="easyui-linkbutton" data-options="text:'添加项目经验'"onclick="addProExp()" style="padding:5px;margin-bottom:10px;"></a>
</p>

<div id="proj_exp_panel">
	<c:forEach  items="${projectExperiences }" var="pe">			
	<div id="edit_proj_exp_div${pe.projectExperienceId }" class="edit_proj_exp_div" style="display:none;">
	<form id="form_proj_exp" name="form_proj_exp" action="" method="post">
	   <table width="100%" class="table_info">
	      <tr>
		        <td>项目名称</td>
		        <td colspan="3">
		          	<input class="easyui-textbox" style="width:400px"  type="text" name="projName" id="pName${pe.projectExperienceId }" data-options="required:true" value="${pe.projectName }"/>
		        </td>
	      </tr>
	      <tr>
		        <td width="15%">开始时间</td>
		        <td width="25%">
		          	<input class="easyui-datebox" id="projStartDate${pe.projectExperienceId }" name="projStartDate" data-options="required:true,formatter:myformatter,parser:myparser" style="width:120px" value="${pe.projectStartStr }"/>
		        </td>
		        <td width="15%">结束时间</td>
		        <td width="25%">
			    	<input class="easyui-datebox" id="projEndDate${pe.projectExperienceId }" name="projEndDate" data-options="required:true,formatter:myformatter,parser:myparser" style="width:120px" value=" ${pe.projectEndStr }"/>
		        </td>
	      </tr>
	      <tr>
		        <td>项目介绍</td>
		        <td colspan="3">
		        	<input class="easyui-textbox" style="width:400px;height:100px"  type="text" name="projIntro" id="pI${pe.projectExperienceId }" data-options="required:true,multiline:true" value="${pe.projectIntroduce }"/>
		        </td>
	      </tr>
	    </table>
	</form>
	<p style="text-align:center">
		<a id="edit_proj_exp_btn" href="javascript:;"  onclick="updateProExp(${pe.projectExperienceId },${pe.studentId })"  class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a>
		<a id="edit_proj_exp_btn" href="javascript:;"  onclick="noEditWorkExp(${pe.projectExperienceId })"  class="easyui-linkbutton" data-options="iconCls:'icon-clear'">取消</a>
	</p>
	<p id="edit_proj_exp_tip" style="text-align:center"></p>
</div>
		<div id="p${pe.projectExperienceId }" class="easyui-panel" title="${pe.projectStartStr } 到  ${pe.projectEndStr }" style="width:100%;padding:10px;margin-bottom:10px;" data-options="tools:[
		    {iconCls:'icon-edit',handler:function(){editExp(${pe.projectExperienceId })}},
			{iconCls:'icon-clear',handler:function(){deleteExp(${pe.projectExperienceId })}}
			]" >
		     <p hidden="true" id="stuid">${pe.studentId }</p>
		                 项目名称：<p>&nbsp;&nbsp;${pe.projectName }</p>
		                 项目介绍：<p>&nbsp;&nbsp;${pe.projectIntroduce }</p>
		</div>
	</c:forEach>
	 
</div>
<script>

    function editExp(expId){
    	$("#add_proj_exp_btn").linkbutton('disable');		
		$('#edit_proj_exp_div'+expId).slideDown();
		$('#p'+expId).panel('close'); 
		$('#p'+expId).panel('disable'); 
    }
    
    function noEditWorkExp(expId) {
		$("#add_proj_exp_btn").linkbutton('enable');		
		$(".edit_proj_exp_div").slideUp();
		$(".easyui-panel").panel('open');
	}
    
    function deleteExp(expId){
    	var stuId=$('#stuid').text();
    	if(expId!=null&&expId>0){
    			$.messager.confirm('Confirm', '确认删除?', function(r){
    			if (r){
    				 $.ajax({
    				     url:"../delete_project_experience",
    					 type:"post",
    					 dataType:"json",
    					 data:{ 
    					           "projectExperienceId":expId								          
    						  },
    				     success:function(da){	
    				    	 if(da.code=="10001"){
    				    	     alert(da.msg)
    				    	     $('#proj_exp').panel('refresh','../query_project_experience?studentId='+stuId);	
    				    	 }else{
    				    		 alert(da.msg)
    				    	 }							    	 
    				     },
    					 error:function(){
    						 alert("删除失败")
    					 }  
    				});			
    			}
    		});
    		}
    }

	function saveProExp(){
		var pname = $("input[name=projName]").val();
		var psd = $("input[name=projStartDate]").val();
		var ped = $("input[name=projEndDate]").val();
		var pi = $("input[name=projIntro]").val();
		
		var start=$("#projStartDate").datebox("getValue");
		var end=$("#projEndDate").datebox("getValue");
		if(start!=""&&end!=""){
			start=start.split('-');
			end=end.split('-');
			var startTime=new Date(start[0],start[1]-1,start[2]);
			var endTime=new Date(end[0],end[1]-1,end[2]);
			if(startTime.getTime()>=endTime.getTime()){
				alert("开始时间不能大于或等于结束时间");
				return;
			}
		}
		
		if(pname!="" && psd!="" && ped!="" && pi!=""){
			$.ajax({
		   	     url:"../save_project_experience",
		   		 type:"post",
		   		 dataType:"json",
		   		 data:{ 
		   				  "studentId":$("input[name=studentId]").val(),
		   		          "projectName":pname,
		   		       	  "projectStart":psd,
		   		    	  "projectEnd":ped,
		   		          "projectIntroduce":pi
		   			  },
		   	     success:function(data){
		   	    		 $("#save_proj_exp_tip").html("<font color='red'>"+data.msg+"</font>");
		   	    		 if(data.code=="10001"){
		   					 $('#proj_exp').panel('refresh','../query_project_experience?studentId='+data.data.studentId);	
		   	    		 } else if(data.code=="10002"){
		   	    			  if(pname.length>25){
		   	    				  alert("标题字数过长,请控制在25字内.");
		   	    			  }else if(pi.length>250){
		   	    				  alert("介绍字数过长,请控制在250字内");
		   	    			  }
		  	   	        	  $('#save_proj_exp_btn').linkbutton('enable');
		  	   	         }     
		   	     },
		   	     beforeSend:function(){
		   	    	 $("#save_proj_exp_tip").html("<font color='red' >保存中...</font>");
		   	    	 $('#save_proj_exp_btn').linkbutton('disable');
		   	     },
		   	     error:function(){
		   	    	 $("#save_proj_exp_tip").html("<font color='red' >服务器忙...</font>") 
		   	     }
		   	});
		}else{
			$("#save_proj_exp_tip").html("<font color='red' >不能有空项！</font>");
			return;
		}
	}
	
	function updateProExp(expId,stuId){
		var pname = $("#pName"+expId).val();	
		var pi = $("#pI"+expId).val();	
		var timestart=$("#projStartDate"+expId).val();		
		var timeend=$("#projEndDate"+expId).val();
		var start=$("#projStartDate"+expId).datebox("getValue");		
		var end=$("#projEndDate"+expId).datebox("getValue");		
		if(start!=""&&end!=""){
			start=start.split('-');
			end=end.split('-');
			var startTime=new Date(start[0],start[1]-1,start[2]);
			var endTime=new Date(end[0],end[1]-1,end[2]);
			if(startTime.getTime()>=endTime.getTime()){
				alert("开始时间不能大于或等于结束时间");
				return;
			}
		}
		
		if(pname!="" && pi!=""&&timestart!=""&&timeend!="" ){
			$.ajax({
		   	     url:"../update_project_experience",
		   		 type:"post",
		   		 dataType:"json",
		   		 data:{ 
		   			      "projectExperienceId":expId,
		   				  "studentId":stuId,
		   		          "projectName":pname,
		   		       	  "projectStart":start[0]+"-"+start[1]+"-"+start[2],
		   		    	  "projectEnd":end[0]+"-"+end[1]+"-"+end[2],
		   		          "projectIntroduce":pi
		   			  },
		   	     success:function(data){
		   	    		 $("#edit_proj_exp_tip").html("<font color='red'>"+data.msg+"</font>");
		   	    		 if(data.code=="10001"){
		   					 $('#proj_exp').panel('refresh','../query_project_experience?studentId='+stuId);	
		   	    		 } else if(data.code=="10002"){
		   	    			  if(pname.length>25){
		   	    				  alert("标题字数过长,请控制在25字内.");
		   	    			  }else if(pi.length>250){
		   	    				  alert("介绍字数过长,请控制在250字内");
		   	    			  }
		  	   	        	  $('#edit_proj_exp_btn').linkbutton('enable');
		  	   	         }     
		   	     },
		   	     beforeSend:function(){
		   	    	 $("#edit_proj_exp_tip").html("<font color='red' >保存中...</font>");
		   	    	 $('#edit_proj_exp_btn').linkbutton('disable');
		   	     },
		   	     error:function(){
		   	    	 $("#edit_proj_exp_tip").html("<font color='red' >服务器忙...</font>") 
		   	     }
		   	});
		}else{
			$("#edit_proj_exp_tip").html("<font color='red' >不能有空项！</font>");
			return;
		}
	}
	
	//显示添加项目经历表格
	function addProExp(){
		var projExpBtn = document.getElementById("add_proj_exp_btn");
		if(projExpBtn.innerText=="添加项目经验"){
			projExpBtn.innerText = "返回";
	    	$("#add_proj_exp_div").slideDown();
		}else{
			projExpBtn.innerText = "添加项目经验";
			$("#add_proj_exp_div").slideUp();
		}
	}
	
  	/* //选择开始时间后，限制结束时间不小于开始时间
    function onSelectStart(date){
		if(date!="" && $('#projEndDate').datebox('getValue')==""){
	   		$('#projEndDate').datebox().datebox('calendar').calendar({
	   			validator: function(startDate){
	   		        var sDate = new Date(date.getFullYear(), date.getMonth(), date.getDate());
	   				return startDate>=sDate;
	   			}
	   		});
		} else if(date=="" ){
			$('#projEndDate').datebox().datebox('calendar').calendar({
	   			validator: function(startDate){
	   				return startDate;
	   			}
	   		});
		}
    } 
    //选择结束时间后，限制开始时间不大于结束时间
    function onSelectEnd(date){
    	if(date!="" && $('#projStartDate').datebox('getValue')==""){
	   		$('#projStartDate').datebox().datebox('calendar').calendar({
	   			validator: function(EndDate){
	   				var eDate = new Date(date.getFullYear(), date.getMonth(), date.getDate());
	   				return EndDate<=eDate;
	   			}
	   		});
    	} else if(date=="" ){
			$('#projStartDate').datebox().datebox('calendar').calendar({
	   			validator: function(EndDate){
	   				return EndDate;
	   			}
	   		});
		}
    } */
 
	function myformatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
    }
    function myparser(s){
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0],10);
        var m = parseInt(ss[1],10);
        var d = parseInt(ss[2],10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
            return new Date(y,m-1,d);
        } else {
            return new Date();
        }
    }
</script>
