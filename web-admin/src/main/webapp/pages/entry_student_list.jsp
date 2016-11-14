<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>求贤若渴</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
	<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
	<c:set value="${Math.random()}" var="num"/>
    <link rel="stylesheet" href="${path}/wechat-assets/css/light7.min.css?v=${num}">
    <link rel="stylesheet" href="${path}/wechat-assets/css/light7-swiper.min.css?v=${num}">

<style >
body{
    margin:0;
    padding:0;
    background-color:#F6F4F5;
}
</style>

  </head>
  <body>
 
   <div class="page">
  <div class="mask"></div>
 <div id="reg_div" >
 </div>
  <nav class="bar bar-tab" style="background-color:#0a91ea">
    <a class="tab-item" href="#" style="color:#fff" >
      <span class="tab-label">一键注册，成为i码士</span>
    </a>
  </nav>
 
  <div class="content qxrklist">
    <div class="list-block media-list inset">
      <ul id="stu_list" style="margin-bottom:20px">
      	<div style="width: 100%;text-align: center">
      		 内容加载中...
		</div>
      </ul>

      <a href="#" class="button" id="loadingmore" sytle="height:50px">点击加载更多</a>
   </div>
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
	/*
		最后一条索引
	*/
	var lastIndex = null;
	/*
	 	当前页码
	*/
	var currentPage = 1;
	/*
		 总共的条数
	*/
	var maxItems = null;
	/*
		 一次加载的条数
	*/
	var itemsPerLoad = 5;
	/*
		返回消息
	*/
	var message="";
	
	var titletxt = "";

	$(function(){
		loadingStudent();
		countStudent();
	});
	
	function loadingStudent(){
		$.ajax({
			url:"${path}/reg_rec/select_beststu",
			data:{currentPage:currentPage},
			success: function(data){
				$("#stu_list").html(data);
			},
			error: function(data){
				$.alert("服务器繁忙,请稍后再试","提示");
			}
		})
	};
	
	function countStudent(){
		$.ajax({
			url:"${path}/reg_rec/select_countstu",
			success: function(data){
				maxItems = data;
			}
		})
	};

  $(document).on('click','.bar-tab a', function () {
	  $("div.mask").fadeIn();
	  $("div.login").fadeIn();
	  $.ajax({
			 url:"../base/jump?page=Regform",
			 success:function(data){
				 $("#reg_div").html(data);
			 }
	  })
  });

  function addItems() {
	  $.ajax({
			url:"${path}/reg_rec/select_beststu",
			data:{currentPage:currentPage},
			success: function(data){
				$("#stu_list").append(data);
			},
			error: function(data){
				$.alert("服务器繁忙,请稍后再试","提示");
			}
		})
      };


  $(document).on('click', "#loadingmore",function() {

         lastIndex = $("#stu_list li").length;
          if (lastIndex >= maxItems) {
        	  $("#loadingmore").addClass("disabled");
        	  $.toast("已没有更多");
              $("#loadingmore").html("已没有更多");
              return;
          }
          $.showPreloader('正在努力加载中...');
          currentPage++;
          addItems();
          $.hidePreloader();
  });
  

      /* $(window).scroll(function() {
          //$(document).scrollTop() 获取垂直滚动的距离
          //$(document).scrollLeft() 这是获取水平滚动条的距离
          if ($(document).scrollTop() <= 0) {
        	  
              	lastIndex = $("#stu_list li").length;
                if (lastIndex >= maxItems) {
              	  $("#loadingmore").addClass("disabled");
              		$.toast("已没有更多",1000);
                    $("#loadingmore").html("已没有更多");
                    return;
                }
                $.showPreloader('正在努力加载中...');
                currentPage++;
                addItems();
                $.hidePreloader();
          }
      }); */

</script>