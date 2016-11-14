x<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>简历推荐</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
	<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
	<c:set value="${Math.random()}" var="num"/>
    <link rel="stylesheet" href="${path}/wechat-assets/css/light7.min2.css?v=${num}">
    <link rel="stylesheet" href="${path}/wechat-assets/css/light7-swiper.min.css?v=${num}">

<style>

</style>

  </head>
  <body>
   <div class="page" style="min-height:469px;height:100%">
 <div class="mask"></div>
 <div id="msg_box" >
 </div>
  <nav class="bar bar-tab" style="background-color:#0a91ea">
    <a class="tab-item" href="#" style="color:#fff" >
      <span class="tab-label">提交候选人信息</span>
    </a>
  </nav>
 
  <div class="content">
  <form id="fm_rec">
       <div class="card">
            <p>候选人信息</p>
            <input type="text" placeholder="姓名" id="candidateName" name="candidateName" onblur="isCandidateName()">
            <input type="hidden" id="candidatePosition" name="candidatePosition" >
			    <a href="#"  class="open-popup open-about button" data-popup=".popup-about" id="checkPosition">选择岗位 </a>
			<input type="text" placeholder="联系方式" id="candidatePhone" name="candidatePhone" onblur="isCandidatePhone()">
	
	  </div>
	  
	   <div class="recommand">
	        <p>推荐人</p>
	        <input type="text" placeholder="姓名" id="recommendName" name="recommendName" onblur="isRecommendName()">
	        <input type="text" placeholder="联系方式" id="recommendPhone" name="recommendPhone" onblur="isRecommendPhone()">
		
		</div>
	</form>
  </div>
</div>
 
 
<!-- About Popup -->
<div class="popup popup-about">

    <div class="content-block" >
   
	 <div class="list-block media-list">
      <ul class="clist"  id="position_list">


      </ul>
    </div>

  </div>
</div>
    <script type='text/javascript' src='${path}/assets/js/jquery-2.1.4.js?v=${num}' charset='utf-8'></script>
    <script type='text/javascript' src='${path}/assets/js/jquery.form.js?v=${num}' charset='utf-8'></script>
    <script type='text/javascript' src='${path}/wechat-assets/js/light7.js?v=${num}' charset='utf-8'></script>
    <script type='text/javascript' src='${path}/wechat-assets/js/light7-swiper.min.js?v=${num}' charset='utf-8'></script>
    <script type="text/javascript" src="${path}/wechat-assets/js/light7-city-picker.js?v=${num}" charset="utf-8"></script>
  </body>
</html>

<script>
   /* $(document).on('click','.bar-tab a', function () {
   		var url = "${path}/reg_rec/insert_rec";
   		$.post(url,{candidateName:$("#candidateName").val(),candidatePosition:$("#candidatePosition").val(),candidatePhone:$("#candidatePhone").val(),
   			recommendName:$("#recommendName").val(),recommendPhone:$("#recommendPhone").val()},function () {
   				$.alert("123");
			if(data.message=='success')
				alertMsg('您已成功推荐了候选人，十分感谢您对i码士的支持', '推荐成功!');
			else
				alert("失败");
		});
   		$.alert("")
   }); */
   var message="";
   
   $(document).on('click','.open-about', function () {
	   $.ajax({
		    url:"${path}/reg_rec/select_position",
		    success: function(data){
		    	$("#position_list").html(data);
			},
			error: function(data){
				$.alert("服务器繁忙,请稍后再试","提示");
			}
		   
	   });
	   $.popup('.popup-about');
	 });
   
  
   
   $(document).on('click','.bar-tab a', function () {
	   if(checkAll()){
		   var url = "${path}/reg_rec/insert_rec";
		   $("#fm_rec").ajaxSubmit({
			   type: "POST",
			   url:url,
			   dataType: "json",
			   before:function (data) {
				   $.showPreloader('数据提交中...')
			   },
			   success: function (data) {
				   $.hidePreloader();
	  				if(data.code == 1){
	  					titletxt = "推荐成功";
	  					message = data.msg;
	  					$("#fm_rec").clearForm();
	  					$("#checkPosition").text("选择岗位");
	  					showTextBox();
	  				}
	  				else
	  					$.alert(data.msg,"提示");
	  			},
	  			error: function (data) {
	  				$.hidePreloader();
	  				$.alert("服务器繁忙,请稍后再试","提示");
	  			}
		   });
	   }
	   
   });
   
   function checkAll(){
	   if(!isCandidateName()){
		   return false;
	   }else if(!isCandidatePhone()){
		   return false;
	   }else if(!isRecommendName()){
		   return false;
	   }else if(!isRecommendPhone()){
		   return false;
	   }else if($("#candidateName").val() == $("#recommendName").val()){
		   $.toast("候选人姓名与推荐人不能相同", 1500);
		   return false;
	   }else if($("#candidatePhone").val() == $("#recommendPhone").val()){
		   $.toast("候选人手机与推荐人不能相同", 1500);
		   return false;
	   }else{
		   return true;
	   }
   }
   
   function isCandidateName(){
	   var Validation = new RegExp("^[\u4e00-\u9fa5][\u4e00-\u9fa5]{1,7}$");
	   if($("#candidateName").val()!=""){
		   if(Validation.test($("#candidateName").val())){
			   return true;
		   }
		   else{
			   $.toast("候选人姓名必须为2~8位汉字", 1500);
			   return false;
		   }  
	   }
	   else
		{
		   $.toast("候选人姓名不能为空", 1500);
		   return false;
		}
   }
   
   function isCandidatePhone(){
	   var Validation = new RegExp("^[1][358][0-9]{9}$");
	   var Telephone = new RegExp("(^(\\d{2,4}[-_－—])?\\d{7,8}$)|(^0?1[358]\\d{9}$)");
	   if($("#candidatePhone").val()!=""){
		   if(Validation.test($("#candidatePhone").val()) || Telephone.test($("#candidatePhone").val())){
			   return true;
		   }
		   else{
			   $.toast("候选人手机或电话号码格式不正确", 1500);
			   return false;
		   }  
	   }
	   else
		{
		   $.toast("候选人联系方式不能为空", 1500);
		   return false;
		}
   }
   
   function isRecommendName(){
	   var Validation = new RegExp("[\u4e00-\u9fa5]{2,8}");
	   if($("#recommendName").val()!=""){
		   if(Validation.test($("#recommendName").val())){
			   return true;
		   }
		   else{
			   $.toast("推荐人姓名必须为2~8位汉字", 1500);
			   return false;
		   }  
	   }
	   else
		{
		   $.toast("推荐人姓名不能为空", 1500);
		   return false;
		}
   }
   
   function isRecommendPhone(){
	   var Validation = new RegExp("^[1][358][0-9]{9}$");
	   var Telephone = new RegExp("(^(\\d{2,4}[-_－—])?\\d{7,8}$)|(^0?1[358]\\d{9}$)");
	   if($("#recommendPhone").val()!=""){
		   if(Validation.test($("#recommendPhone").val()) || Telephone.test($("#recommendPhone").val())){ 
			   return true;
		   }
		   else{
			   $.toast("推荐人手机或电话号码格式不正确", 1500);
			   return false;
		   }  
	   }
	   else
		{
		   $.toast("推荐人联系方式不能为空", 1500);
		   return false;
		}
   }
   

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

   $("input").focus(function(){
	   
	 
	   var win_h=$(window).height();
	   $("body").height(win_h);
   });
   
 
</script>