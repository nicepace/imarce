<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学员详细信息</title>
</head>

<body>
	<div class="easyui-tabs" id="basic_form_tab" data-options="fit:true">
        <div title="基本信息" style="padding:10px">
         <form action="../update_stu" method="post" id="form_update">
           <input type="hidden" value="${student.studentId}" name="studentId" id="stuId"></input>
           <table width="100%" class="table_info">
              <tr>      
              	<td width="22%" rowspan="7" onclick="showAvatarUploader()"	id="avatar_td"><img src="../${student.headPicture}" width="100%" id="edit_headPicture"><input hidden='true' id='headPicture' name='headPicture' value='${student.headPicture}'></td>
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
               <td>是否入职</td>
                <td>
                   <select class="easyui-combobox" style="width:120px"  name="workState" id="ws"
                   		data-options="valueField:'id',textField:'text',value:${student.workState}" id="ws">
                   		<option value="0">否</option>
                   		<option value="1">是</option>                   		
                   </select>
                </td>
                <td>薪资</td>
                <td>
                  <input  class="easyui-textbox" type="text" name="salary" id="salary" value="${student.salary}" style="width:120px" ></input>
                </td>
                
              </tr>
              <tr>
                <td>入职时间</td>
                <td>
                  <input  class="easyui-datebox" name="workDate" id="workDate" value="${student.workDateStr}" style="width:120px"></input>
                </td>
               <td>入职公司</td>
                <td>
                   <input  class="easyui-textbox" name="employed" id="employed" value="${student.employed}" style="width:120px"></input>
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
                	<input id="knowledge" class="easyui-combotree"
							data-options="url:'../query_skillmodule_and_knowledge?pid='+$('#position_list').combotree('getValue')+'&stuId='+$('#stuId').val(),
							multiple:true,lines:true,required:true,onlyLeafCheck:true,
							onBeforeExpand:showChildrenList,onCheck:filterSkillNode" 
							style="width: 350px">               		
                	</input>
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
            <p style="text-align:center">
           
              <a id="update_btn" href="javascript:;"  onclick="updateStu()"  class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改信息</a>
            </p>
            <p id="update_tip" style="text-align:center"></p>
        </div>

		<div title="工作经历" id="work_exp" style="padding: 10px"></div>


		<div title="项目经历" id="proj_exp" style="padding: 10px"></div>

  </div>
  
  <div id="avatar" class="easyui-panel" title="上传头像"
	style="padding: 10px; background: #fafafa; text-align: center"
	data-options="fit:true,tools:'#tool'">
	<center>
		<p>请选择jpg,png,gif格式，大小在1MB以内的文件</p>
		<input id="chooseFileBtn" name="avatar" type="file">
	</center>
</div>

<div id="tool">
	<button href="javascript:void(0)" onclick="closeCoodi()">取消</button>
</div>

<div id="avatar_cutter" class="easyui-panel" title="头像编辑"
	style="padding: 10px; background: #fafafa; text-align: center"
	data-options="fit:true,tools:'#cutter_tool'"></div>
<div id="cutter_tool">
	<button href="javascript:void(0)" onclick="saveCoodi()" alt="保存">保存</button>
	<button href="javascript:void(0)" onclick="closeCoodi()">取消</button>
</div>
  
  <script>

  
  $(document).ready(function() {
		$("#ws").combobox({
			onChange : function(newVal, oldVal) {
				if(newVal=="1"){
					$('#workDate').textbox('readonly',false);
			    	$('#salary').textbox('readonly',false);
			    	$('#employed').textbox('readonly',false);
			    	$('#workDate').textbox({required:true});
			    	$('#salary').textbox({required:true});
			    	$('#employed').textbox({required:true});
				}else if(newVal="0"){
					$('#workDate').textbox('readonly',true)
			    	$('#salary').textbox('readonly',true);
			    	$('#employed').textbox('readonly',true);			    	
			    	$('#workDate').textbox({required:false});
				    $('#salary').textbox({required:false});
			    	$('#employed').textbox({required:false});
			    	$('#workDate').textbox({value:''});
			    	$('#salary').textbox({value:''});
			    	$('#employed').textbox({value:''});
			    }
			}
		});
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
  	
	 function filterSkillNode(node,checked){
		 var checked_id = node.id+"";
		 var mark = parseInt(checked_id.substring(0,1));
		 if(mark!=4){
			 var arr = $('#knowledge').combo('getValues');
			 for (i=0;i<arr.length;i++) {
				mark = parseInt((arr[i]+"").substring(0,1));
			}
		 }
		 
	 }
	 $("#basic_form_tab").tabs({
	      onSelect: function(title,index){
	    	  var stuId = ${student.studentId};
	    	  var selectedTab = $('#basic_form_tab').tabs('getSelected');  // get selected panel
	    	  var url="";
	    	  if(index==1){
	    		  url="../query_work_experience?studentId="+stuId;
	    	  } else if (index==2){
	    		  url="../query_project_experience?studentId="+stuId;
	    	  }else if (index==0){
	    		  var ws = $("input[name='workState']").val();
	    		  if(ws=="0"){	   	    			 
	    			  $('#salary').textbox({
	    				  readonly:'true'
	    			  });
	    			  $('#workDate').datebox({
	    				  readonly:'true'
	    			  });
	    			  $('#employed').textbox({
	    				  readonly:'true'
	    			  });
	    		  }else if(ws=="1"){	    			  
	    		  }
	    	  }
	    		  
	    	  $('#basic_form_tab').tabs('update', {
	    	  	tab: selectedTab,
	    	  	options: {
	    	  		href:url  // the new content URL
	    	  	}
	    	  });	    	  
		  }
	});
	  
	function updateStu() {
		var hp = $("#headPicture").val();		
	    var sn = $("input[name='studentName']").val();
	    var b = $("input[name='birthday']").val();
	    var wt = $("input[name='workTime']").val();
	    var a = $("input[name='area']").val();
	    var pi = $("input[name='position']").val();
	    var li = $("input[name='level']").val();
	    var s = $("input[name='salary']").val();
	    var e = $("input[name='employed']").val();
	    var wd = $("input[name='workDate']").val();
	    var ws = $("input[name='workState']").val();
	 
	    if(ws == "1"){
	    
	    if(hp!=""&&sn!=""&&b!=""&&wt!=""&&a!=""&&pi!=""
	    		&&li!=""&&s!=""&&e!=""&&wd!=""&&ws!=""){
	    	$("#form_update").ajaxSubmit({
				dataType:"json",
				data:{					
					"knowledgeStr":JSON.stringify($('#knowledge').combo('getValues'))
				},
	   		    success:function(da){
	  	            $("#update_tip").html("<font color='red'>"+da.msg+"</font>");	  	          
	  	            if(da.code=="10002"){
	  	        	    $('#update_btn').linkbutton('enable');
	  	            }else{
		  	            $("#win").window("close");
		  	            $("#flusher").datagrid("reload");
	  	            }
		   	    },
				beforeSend : function() {
					$("#update_tip").html("<font color='red' >修改中...</font>");
					$('#update_btn').linkbutton('disable');
				},
				error : function() {
					$("#update_tip").html("<font color='red' >服务器忙...</font>");
				}
	    	});
	    }else {
			$("#basic_tip").html("<font color='red' >必填项不能为空!</font>");
		}
	   }else{
		   if(hp!=""&&sn!=""&&b!=""&&wt!=""&&a!=""&&pi!=""
	    		&&li!=""&&ws!=""){
	    	$("#form_update").ajaxSubmit({
				dataType:"json",
				data:{
					"knowledgeStr":JSON.stringify($('#knowledge').combo('getValues'))
				},
	   		    success:function(da){
	  	            $("#update_tip").html("<font color='red'>"+da.msg+"</font>");	  	          
	  	            if(da.code=="10002"){
	  	        	    $('#update_btn').linkbutton('enable');
	  	            }else{
		  	            $("#win").window("close");
		  	            $("#flusher").datagrid("reload");
	  	            }
		   	    },
				beforeSend : function() {
					$("#update_tip").html("<font color='red' >修改中...</font>");
					$('#update_btn').linkbutton('disable');
				},
				error : function() {
					$("#update_tip").html("<font color='red' >服务器忙...</font>");
				}
	    	});
	    }else {
			$("#basic_tip").html("<font color='red' >必填项不能为空!</font>");
		}
	   }
	}

	
	function showAvatarUploader() {
		$("#basic_form_tab").slideUp();
		$("#avatar").panel("open");
	}
       
	function closeCoodi() {
		$("#avatar_cutter").panel("close");
		$("#basic_form_tab").slideDown();				
	}
	
	$('#chooseFileBtn').uploadify({
		'buttonClass' : 'fileChoose',
		'multi' : false,
		'allowResize' : false,
		'height' : 150,
		'fileTypeExts' : '*.gif; *.jpg; *.png',
		'fileSizeLimit' : '1MB',
		'width' : 150,
		'buttonImage' : '../plugin/uploadify/filechoose.png',
		'swf' : '../plugin/uploadify/uploadify.swf',
		'uploader' : '../avatar_upload',
		'onUploadSuccess' : function(file, data, response) {
			//$("#avatar_td").html("<img src='../"+data+"' width='120' />");
			//$("#basic_tab").slideDown();
			$("#avatar").panel("close");
			$("#avatar_cutter").panel("open");
			initJcrop(data);
		}
	});
	var coodnate = {
		"x" : 0,
		"y" : 0,
		"x1" : 200,
		"y2" : 200,
		"w" : 200,
		"h" : 200,
		"filePath" : ""
	};
	var jcrop_api;
	function initJcrop(pic) {

		coodnate.filePath = pic;
		//alert(coodnate.filePath);
		$("#avatar_cutter").html("<img id='target' src='../"+pic+"'/>");
		$('#target').Jcrop({
			onChange : showCoords,
			onSelect : showCoords,
			aspectRatio : 1,
			bgFade : true,
			bgOpacity : .2,
			setSelect : [ 0, 0, 200, 200 ]
		}, function() {
			jcrop_api = this;
		});
	}

	function showCoords(c) {
		$.extend(coodnate, c);
	}

	function saveCoodi() {
		$.ajax({
			url : "../save_student_headicon",
			type : "post",
			data : coodnate,
			success : function(da) {				
				$("input[name='headPicture']").val(da);
				$("#avatar_td").html(
						"<img src='../"+da+"' width='100' height='100'  /><input hidden='true' id='headPicture' name='headPicture' value='"+da+"'>");
				$("#avatar_cutter").panel("close");
				$("#basic_form_tab").slideDown();
			}
		});
	}
	
	</script>

</body>
</html>