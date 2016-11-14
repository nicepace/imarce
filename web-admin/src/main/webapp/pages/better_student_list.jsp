<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>优秀码士</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
	<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
	<c:set value="${Math.random()}" var="num"/>
    <link rel="stylesheet" href="${path}/wechat-assets/css/light7.min.css?v=${num}">
    <link rel="stylesheet" href="${path}/wechat-assets/css/light7-swiper.min.css?v=${num}">
    <link rel="stylesheet" href="${path}/wechat-assets/css/betterStu.css">

<style>

</style>

  </head>
  <body>
   <div class="page" style="background: #ffffff;">
 
 
<header class="bar bar-nav" style="padding:0px;margin:0px;background-color: #fff;border-bottom: 1px solid #fff;">
	<div class="row">
	<button id="btn" >所有岗位<img src="../wechat-assets/images/arrow-1.png" width="14.5" height="7" style="margin-right: 5% ; position:absolute; top:38%;right:2%" id="arrow-left"/></button> 
	<button id="btn2">所有等级</button> <img src="../wechat-assets/images/arrow-1.png" width="14.5" height="7" style="margin-right: 8% ; position:absolute; top:38%;right:2%" id="arrow-right"/>
    </div>
</header> 




  <div class="content">  
  
    
    <div class="list-block media-list inset" style="margin-right: 0rem;  margin-left: 0rem; margin-top:0rem; ">
      <ul id="studentlist" style="border-radius: 0rem; ">

      
      </ul>
      <a class="button" href="javascript:;" onclick="addStudent()" id="addStudent" style="margin-top:20px; height:35px;text-align:center;vertical-align:middle;line-height:35px;">加载更多</a>
    </div> 
  </div>
</div>
 
</div>
    

 <div class="popup pop"  style="margin-top: 45px;height:inherit;">
  <div class="content-block" style="margin-left: -20%; margin-top: -10%;margin-bottom: 0">
   
	 <div class="list-block media-list" style="margin-bottom: 0">
      <ul class="clist" id="positionlist" >

	
      </ul>
    </div>
  </div>
</div>


<div class="popup popr" style="margin-top: 45px;height:inherit; margin-bottom: 0">
  <div class="content-block" style="margin-left: -20%; margin-top: -10%;">
   
	 <div class="list-block media-list" style="margin-bottom: 0">
      <ul class="clist" id="levellist">


      </ul>
    </div>
  </div>
</div> 
    <script type='text/javascript' src='${path}/assets/js/jquery-2.1.4.js?v=${num}' charset='utf-8'></script>
    <script type='text/javascript' src='${path}/wechat-assets/js/light7.js?v=${num}' charset='utf-8'></script>
  </body>
</html>

<script>
/*
 * 全局变量,currentPage当前页码,pageNum每页显示的条数,总共的页码total
 */
 var currentPage=1;
 var levelId = "";
 var positionId = "";
 var pageNum=5;
 var total=0;
//初始化数据
 initTotal();
 var flag = false;//判断是否初始化好
 
 $(function(){
	if(total==0){
		$.showPreloader("正在努力加载！");
		setTimeout(function(){
			getStudent('',"");
			},500);
	}else{
		getStudent('',"");
	}
	
}) 
	function initTotal(){
		var url ="${path}/better_student/getStudentTotal";
		$.post(url,{"positionId":positionId,"levelId":levelId},function(data){
				if(data.code==1){
					if(parseInt(data.objResult/5)<parseFloat(data.objResult/5)){
						total = parseInt(data.objResult/5)+1;
					}else{
						total = parseInt(data.objResult/5);
					}
					currentPage=1;
					if(total <=1){
						$("#addStudent").html("没有更多的数据");
						$("#addStudent").addClass("disabled");
					}else if(total>1){
						$("#addStudent").html("加载更多");
						$("#addStudent").removeClass("disabled");
					}
					flag=true;
				
				}
			})
	};
	function addStudent(){
		currentPage++;
		/*
		判断当前页数是不是最大
		*/
		if(parseInt(currentPage)>total||total==0){
			currentPage = total;
			$("#addStudent").text("没有更多的数据");
			$("#addStudent").addClass("disabled");
			$.hidePreloader();
		}else {
			$.ajax({
				url:"${path}/better_student/go_students",
				type:"post",
				data:{"positionId":positionId,"levelId":levelId,"currentPage":currentPage},
				success:function(da){
						$("#studentlist").append(da);
				},error:function(){
					$.alert("服务器忙！");
				}
			})
		}
	}


//加载student对象
 function getStudent(positionId,levelId){
	var url = "${path}/better_student/go_students";
	$.ajax({
		url:url,
		type:"post",
		data:{"positionId":positionId,"levelId":levelId,"currentPage":currentPage},
		success:function(da){
				$("#studentlist").html(da);
				$.hidePreloader();
		},error:function(){
			$.alert("服务器忙！");
		}
	})
}

 
   $(document).on('click','#btn', function () {
	  var url = "${path}/better_student/go_positions";
	  $("#arrow-left").attr("src","../wechat-assets/images/arrow-2.png");	
	  $.ajax({
			url:url,
			type:"post",
			data:{"get_positions":"get_positions"},
			success:function(data){							
				$("#positionlist").html(data);				
				//$("#studentlist").empty();
			}
	  	});
	 	 	
	 $.popup('.pop');
	 
  }); 

   $(document).on('click','#btn2', function () {
	   var url = "${path}/better_student/go_levels";
	   $("#arrow-right").attr("src","../wechat-assets/images/arrow-2.png");	 
	   $.ajax({
			url:url,
			type:"post",
			success:function(data){				
				$("#levellist").html(data);
				//$("#studentlist").empty();
			}
	  	});
	 $.popup('.popr');
  });
   
  
    function goPage(url){
    	
    	window.location.href=url;
    }
 
</script>