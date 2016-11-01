<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>意见反馈</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
	<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
	<c:set value="${Math.random()}" var="num"/>
    <link rel="stylesheet" href="${path}/css/light7.min2.css?v=${num}">

  </head>
  <body>
   <div class="page">
   <div class="mask"></div>
 <div id="msg_box" >
 </div>
    <nav class="bar bar-tab" style="background-color:#0a91ea">
    <a class="tab-item" href="#" style="color:#fff" >
      <span class="tab-label">提交意见</span>
    </a>
  </nav>
   
	  <div class="content">
             <textarea class="area"  id="opinion"  placeholder="请提出您的宝贵意见" onpropertychange="this.style.height='0px';this.style.height=this.scrollHeight+'px'" oninput="this.style.height='0px';this.style.height=this.scrollHeight+'px'"></textarea>        
	  </div>
   </div>
    <script type='text/javascript' src='${path}/assets/js/jquery-2.1.4.js?v=${num}' charset='utf-8'></script>
    <script type='text/javascript' src='${path}/js/light7.js?v=${num}' charset='utf-8'></script>
  </body>
</html>

<script>

   var message ="";
   var titletxt = "";
   $(document).on('click','.bar-tab a', function () {
	   var Validation = new RegExp("^.{5}");
	   var url = "${path}/opinion/insert_opinion";
	   if(Validation.test($("#opinion").val())){
		   $.ajax({
			    type: "POST",
			    url:url,
			    dataType: "json",
			    data:{opinion:$("#opinion").val()},
			    	before : function (data) {
			    		$.showPreloader('数据提交中...')
			    	},
		   			success: function (data) {
		   				$.hidePreloader();
		   				if(data.code == 1){
		   					message = data.msg;
		   					titletxt = "提交成功";
		   					$("#opinion").val("");
		   					showTextBox();
		   			   	}
		   				else
		   					$.alert(data.msg,"提示");
		   				
		   			},
		   			error: function (data) {
		   				$.hidePreloader();
		  				$.alert("服务器繁忙,请稍后再试","提示");
		   			}
			   
		   })
	   }
	   else
		   $.alert("建议内容不能少于5个字符","提示")
   });
   
   function showTextBox(){
	   $.ajax({
		   type:"GET",
		   url:"../base/jump?page=textBoxSuccess",
		   success: function (data) {
			   $("#msg_box").html(data);
		   },
	   	   error: function (data) {
				$.alert("服务器繁忙,请稍后再试","提示");
		   }
	   
	   });
   }
</script>