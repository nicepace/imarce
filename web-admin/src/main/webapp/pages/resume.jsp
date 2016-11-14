<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,java.io.*"  pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
  String path = "";
  
 Properties pro = new Properties();  
 String realpath = request.getRealPath("/WEB-INF");  
 try{  
 //读取配置文件
 FileInputStream in = new FileInputStream(realpath+"/headPicUrl.properties");  
 pro.load(in);  
 }  
 catch(FileNotFoundException e){  
     out.println(e);  
 }  
 catch(IOException e){out.println(e);} 

//通过key获取配置文件
 path = pro.getProperty("headPicUrl"); 
 
 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>个人简历</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
	<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
	<c:set value="${Math.random()}" var="num"/>
    <link rel="stylesheet" href="${path}/wechat-assets/css/light7.min.css?v=${num}">
    <link rel="stylesheet" href="${path}/wechat-assets/css/light7-swiper.min.css?v=${num}">
	<style>
        div.zoomMask{
            width:100%;
            height:100%;
            position:fixed;
            top:0%;
            left:0%;
            background-color:#fff;
            opacity:0.8;
            display:none;
            z-index:4;
        }
        p.zoomIn{
            width:90%;
            height:48%;
            position:absolute;
            top:20%;
            left:5%;
            z-index:10;
            display:none;
        }
        p.zoomIn img{
            width:100%;
        }
    </style>
  </head>
  <body>
   <div class="page">
   <div class="mask"></div>
 <div id="rec_div" >
 </div>
       <nav class="bar bar-tab" style="background-color:rgb(101,153,255)">
        <a class="tab-item" href="#" style="color:#fff" >
          <span class="tab-label">招募</span>
        </a>
      </nav>
   
	  <div class="content">
	  
	      <div class="div_block grjl">
                 <div class="user_icon" style="position:absolute;top:20%;left:8%">
                    <img src="<%=path%>/${betterStu.student.headPicture}" width="80" height="80" 
                    style="border-radius:50%;border:rgb(184,201,253) solid 3px" id="m"/>
                 </div>
                 <div class="zoomMask"></div>
    				<p class="zoomIn">
       					<img src="" class="img-responsive">
    			 	</p>
                 <div class="mid" id="studentId" stuid="${betterStu.student.studentId }" style="top:30%;left:40%">
                      <span style="font-size:18px" id="stuName">${betterStu.student.studentName }</span><br/>
                      <span style="font-size:11px">${betterStu.student.position }</span>
                 </div>
                 <div class="user_level"  style="position:absolute;top:31%;right:8%">
                     <img src="${path}/wechat-assets/images/${betterStu.student.levelId }.png" width="40" height="44"/>
                 </div>
          </div>
          
          <div class="skilllist" style="overflow:hidden;background-color:rgb(255,102,102);padding-top:10px;padding-right:25px;padding-bottom:10px;padding-left:25px;" >
                 <ol class="skill_label"  >
                 <c:forEach items="${betterStu.student.knowledge }" var="kle" varStatus="statu">
                 	<li style="color:#FFF;margin-bottom:5px;line-height:1;padding: 0.18rem .75rem;;font-size: 15px;">${ kle.knowledgeName}</li>
                 </c:forEach>
                 </ol>
                 <div style="clear:both"></div>
          </div>
          
          <div class="div_block white_bg">
               <ol style="height: 45px">
                  <li style="padding-right:22%;border-right: #a1a0a1 solid 1px"><img src="${path}/wechat-assets/images/iconfont-zs-rank.png" width="19" height="19" style="position:absolute;top:25%;left:5%"/><span style="position:absolute;top:15%;left:13%">i码士-P${betterStu.student.level }</span></li>
                 
                  <li style="padding-left:8%;padding-right:8%"><img src="${path}/wechat-assets/images/iconfont-shijian-3.png" width="19" height="19" style="position:absolute;top:25%;left:43%"/><span style="position:absolute;top:15%;left:50%">${betterStu.student.workTime }&nbsp;年</span></li>
                 
                  <li style="padding-left: 20%;border-left: #a1a0a1 solid 1px"><img src="${path}/wechat-assets/images/iconfont-didian-2.png" width="14.5" height="19" style="position:absolute;top:25%;left:73%"/><span style="position:absolute;top:15%;left:80%">${betterStu.student.area }</span></li>
               </ol>
          <div style="clear:both"></div>
          </div>
          
           <div class="card">
			<div class="card-header" style="color:rgb(122,174,255)">工作经历<img src="${path}/wechat-assets/images/iconfont-icon.png" width="17" height="17"/> </div>
			<div class="card-content" style="color:rgb(100,100,100)">
			<c:forEach items="${betterStu.workexperience }" var="worke" varStatus="statue">
		      <div class="row">
                <div class="col-50" style="padding-left:.8rem;padding-top:.4rem;padding-bottom:.4rem;font-weight:bold;font-size:18px"> ${worke.workCompany }</div>
                <div class="col-50" style="padding-right:.8rem;padding-top:.4rem;padding-bottom:.4rem;text-align:right"> ${worke.start }-${worke.end }</div>
              </div>
    		<div class="row" id="workexperience">
              <c:if test="${fn:length(worke.workIntroduce)>20 }">
              	<div class="col-100 brief div_block_show" >
                     	${worke.workIntroduce }<div onclick="showWorkDetail($(this))" style="padding-right:.3rem;text-align:right;color:rgb(117,171,255);">[详细介绍]</div>
                 </div>
              </c:if>
               <c:if test="${fn:length(worke.workIntroduce)<=20 }">
              	<div class="col-100 brief">
                     	${worke.workIntroduce }
                 </div>
              </c:if>
              </div>
              
              <c:if test="${statue.count!=fn:length(betterStu.workexperience) }">
              	<hr  size="0" style=" border:none; border-bottom:1px dashed #ccc;"/>
              </c:if>	
              </c:forEach>		    
            </div>
          </div>
          
          
           <div class="card">
			<div class="card-header" style="color:rgb(122,174,255)">项目经历<img src="${path}/wechat-assets/images/iconfont-wenjianjia.png" width="17" height="17"/> </div>
			<div class="card-content">
			<c:forEach items="${betterStu.projectexperience }" var="projecte" varStatus="statue">
		      <div class="row">
                <div class="col-50" style="padding-left:.8rem;padding-top:.4rem;padding-bottom:.4rem;font-weight:bold;font-size:18px">${projecte.projectName }</div>
                <div class="col-50" style="padding-right:.8rem;padding-top:.4rem;padding-bottom:.4rem;text-align:right">${projecte.start }-${projecte.end }</div>
              </div>
              <div class="row" id="projectexperience">
	              <c:if test="${fn:length(projecte.projectIntroduce)>20}">
	              		<div class="col-100 brief div_block_show" style="color:rgb(100,100,100)">
	                    	${projecte.projectIntroduce }<div onclick="showProjectDetail($(this))" style="padding-right:.3rem;text-align:right;color:rgb(117,171,255);">[详细介绍]</div>
	                 </div>
	              </c:if>
	              <c:if test="${fn:length(projecte.projectIntroduce)<=20}">
	                 <div class="col-100 brief"  style="color:rgb(100,100,100)">
	                    	${projecte.projectIntroduce }
	                 </div>
	              </c:if>
	           </div>
	              
	              <c:if test="${statue.count!=fn:length(betterStu.projectexperience) }">
	              	<hr  size="0" style=" border:none; border-bottom:1px dashed #ccc;"/>
	              </c:if>			
             </c:forEach>	
            </div>
          </div>
          
           <div class="card" >
			<div class="card-header" style="color:rgb(122,174,255)">自我评价<img src="${path}/wechat-assets/images/iconfont-wodepingjia.png" width="17" height="17"/> </div>
			<div class="card-content">
              <div class="row">
                <div class="col-100 brief card-brief" style="padding-left:0%;padding-right:0%;margin-left:1%;color:rgb(100,100,100)">
                <div class="col-100 brief"> 
                  <div class="row" id="studentIntroduce">
	              <c:if test="${fn:length(betterStu.student.studentIntroduce)>20}">
	              		<div class="col-100 brief div_block_show" style="padding-left:0%;padding-right:0%">
	                    	${betterStu.student.studentIntroduce }<div onclick="showStudentIntroduce($(this))" style="padding-right:0rem;text-align:right;color:rgb(117,171,255);">[详细介绍]</div>
	                 </div>
	              </c:if>
	              <c:if test="${fn:length(betterStu.student.studentIntroduce)<=20}">
	                 <div class="col-100 brief" style="padding-left:0%;padding-right:0%">
	                    	${betterStu.student.studentIntroduce }
	                 </div>
	              </c:if>
	              </div>
	              
              </div>		    
            </div>
          </div>
          
          
	  </div>
</div>
 
 

</div>
    <script type='text/javascript' src='${path}/assets/js/jquery-2.1.4.js' charset='utf-8'></script>
    <script type='text/javascript' src='${path}/wechat-assets/js/light7.js' charset='utf-8'></script>
    <script  type="text/javascript">
    var message = null;
    var titletxt = "";
  	//放大区域的图片路径是获取小图片的路径
    //除了fade动画可以使用其他的动画函数
    $("#m").click(function(){
        $("div.zoomMask").fadeIn();
        $("p.zoomIn").fadeIn();
        var srcc=$("#m").attr("src");
        $("p.zoomIn img").attr("src",srcc);
    });

    $("p.zoomIn").click(function(){
        $(this).fadeOut();
        $("div.zoomMask").fadeOut();
    });
    //点击放大的图片以外的区域实现隐藏 添加此事件
    $("div.zoomMask").click(
            function(){
                $(this).fadeOut();
                $("p.zoomIn").fadeOut();
            }
    )

  $(document).on('click','.bar-tab a',function(){
	  $("div.mask").fadeIn();
	  $("div.login").fadeIn();
	  $.ajax({
			 url:"../base/jump?page=form2",
			 success:function(da){
			   	  $("#rec_div").html(da);
			 }  
		  });
  });
  
function  showWorkDetail(obj){
		//obj.parent().hide();
		//alert(obj.parent().html());
		if(obj.parent().hasClass("div_block_show")){
			obj.html("[收起]");
			obj.parent().removeClass("div_block_show");
			
		}else{
			obj.html("[详细介绍]");
			obj.parent().addClass("div_block_show");
		}
		
	}
	
function  showProjectDetail(obj){
	if(obj.parent().hasClass("div_block_show")){
		obj.html("[收起]");
		obj.parent().removeClass("div_block_show");
		
	}else{
		obj.html("[详细介绍]");
		obj.parent().addClass("div_block_show");
	}
	
}

function  showStudentIntroduce(obj){
	if(obj.parent().hasClass("div_block_show")){
		obj.html("[收起]");
		obj.parent().removeClass("div_block_show");
		
	}else{
		obj.html("[详细介绍]");
		obj.parent().addClass("div_block_show");
	}
	
}
  
  
  
  
  function checkRecruit(){
	  if(RegCompany()&&RegName()&&RegQQ()&&RegPhone()){
		  return true;
	  }else{
		  //$.alert("信息输入有误！");
		  $.toast("信息输入有误！",1500);
		  return false;
	  }
	  
  }
  
  function RegCompany(){
	  var reg = new RegExp("^([\u4E00-\u9FA5]||\\w)*$");
	  var company = $("#RegCompany").val();
	  if(!reg.test(company)){
		  //$("#RegCompany").parent().addClass("input_error");
		  //$("#error").html("公司不包含特殊字符！");
		  $.toast("公司不包含特殊字符！",1500);
		  return false;
	  }else if($.trim(company)==""){
		  //$("#RegCompany").parent().addClass("input_error");
		  //$("#error").html("请输入公司名称");
		  $.toast("请输入公司名称",1500);
		  return false;
	  }else{
		 // $("#RegCompany").parent().removeClass("input_error");
		  //$("#error").html('');
		  return true;
	  }
	  
  }
  
  function RegName(){
	  var reg = new RegExp("^([\u4E00-\u9FA5]||\\w)*$");
	  var name = $("#RegName").val();
	  if(!reg.test(name)){
		  //$("#RegName").parent().addClass("input_error");
		  //$("#error").html("姓名不包含特殊字符！");
		   $.toast("姓名不包含特殊字符！",1500);
		  return false;
	  }else if($.trim(name)==""){
		 // $("#RegName").parent().addClass("input_error");
		  //$("#error").html("请输入姓名");
		  $.toast("姓名不包含特殊字符！",1500);
		  return false;
	  }else{
		  //$("#RegName").parent().removeClass("input_error");
		  //$("#error").html('');
		  return true;
	  }
  }
  function  RegQQ(){
	  var reg = new RegExp("^[1-9][0-9]{4,9}$");
	  var qq = $("#RegQQ").val();
	  if(!reg.test(qq)){
		  //$("#RegQQ").parent().addClass("input_error");
		  //$("#error").html("qq位数不对！");
		  $.toast("qq位数不对！",1500);
		  return false;
	  }else{
		  $("#RegQQ").parent().removeClass("input_error");
		  $("#error").html('');
		  return true;
	  }
  }
  function RegPhone(){
	  var reg = new RegExp("(^(\\d{2,4}[-_－—])?\\d{7,8}$)|(^0?1[358]\\d{9}$)");
	  var phone = $("#RegPhone").val();
	  if(!reg.test(phone)){
		  //$("#RegPhone").parent().addClass("input_error");
		  //$("#error").html("请输入正确的手机号或座机！");
		  $.toast("请输入正确的手机号或座机！",1500);
		  return false;
	  }else{
		 // $("#RegPhone").parent().removeClass("input_error");
		  //$("#error").html('');
		  return true;
	  }
  }

</script>
  </body>
</html>

