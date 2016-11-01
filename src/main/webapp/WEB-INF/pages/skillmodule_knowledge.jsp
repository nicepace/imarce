<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>请选择岗位</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
	<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
	<c:set value="${Math.random()}" var="num"/>
    <link rel="stylesheet" href="${path}/css/light7.min.css?v=${num}">
    <link rel="stylesheet" href="${path}/css/light7-swiper.min.css?v=${num}">

  </head>
  <body>
   <div class="page">
   <div class="mask"></div>
 <div id="skillModule_div" >
 </div>
    <nav class="bar bar-tab" style="background-color:#0a91ea">
    <a class="tab-item" href="#" style="color:#fff" >
      <span class="tab-label" id="btn_commit">确认选择</span>
    </a>
  </nav>
   
	  <div class="content">
	  		<c:forEach items="${skillmoduleList }" var="skillmodule">
	  			<div class="card">
                <div class="card-header skill_head">${skillmodule.skillmoduleName } </div>
                <div class="card-content">     
                    <ol class="ol_skill_list">
                		<c:forEach items="${skillmodule.knowledgeList }" var="knowledge">
                          	<li  
							  <c:forEach items="${sessionScope.knowledgeList }" var="choose_knowledge">
								<c:if test="${knowledge.knowledgeName == choose_knowledge}">
									class="li_curr"
								</c:if>
								</c:forEach>
							>${knowledge.knowledgeName }</li>
               			</c:forEach>
                        <div style="clear:both"></div>
                    </ol>
                </div>
              </div>
	  		</c:forEach>			  
               <div class="card">
                <div class="card-header skill_head">其他</div>
                <div class="card-content">     
                    <ol class="ol_skill_list">
                    	  <li id="positionName" names="${positionName}" style="display:none"></li>
                    	  <c:forEach items="${sessionScope.customKnowledgeNameList }" var="custom_knowledge">
                          	<li  
							  <c:forEach items="${sessionScope.knowledgeList }" var="choose_knowledge">
								<c:if test="${custom_knowledge == choose_knowledge}">
									class="li_curr"
								</c:if>
								</c:forEach>
							>${custom_knowledge }</li>
               			</c:forEach>
                          <li id="add_knowledge" onclick="addTag()">+</li>
                          <div style="clear:both"></div>
                    </ol>
                </div>
              </div>
	  </div>
   </div>
    <script type='text/javascript' src='${path}/assets/js/jquery-2.1.4.js?v=${num}' charset='utf-8'></script>
    <script type='text/javascript' src='${path}/js/light7.js?v=${num}' charset='utf-8'></script>
  </body>
  <script>
		  $(function(){
				choose();
			})
				  
		  $(document).ready(function(){
		  		$("#btn_commit").click(function(){
		  			var positionName = $("#positionName").attr("names");
				  	var str = "";
					$(".li_curr").each(function(){
						str += this.innerHTML + ","
					});
					$.ajax({
						url:"../release_requirement/add_knowledge",
						type:"post",
						data:{"str":str,"positionName":positionName},
						success:function(data){
							if(data=="success"){
								location.href="../release_requirement/to"
							}
						},
						error:function(){
							$.alert("服务器繁忙...")
						}
					})
		  		});
		  })
		  
			function choose(){
				$(".ol_skill_list li").unbind("click");
				$(".ol_skill_list li").click(function(){
					if($(this).attr("id") != "add_knowledge"){
						if($(this).hasClass("li_curr")){
							$(this).removeClass("li_curr");
						}else{
							$(this).addClass("li_curr");
						}
					}	
				});
			}
		  	
		  $(document).on('click', ".txtbox .btn",function(){
			  $.ajax({
          		url:"../release_requirement/add_customknowledge",
          		type:"post",
          		data:{"customknowledgename":$("#tagName").val()},
          		success:function(data){
          			if(data!="false"){
	            			$("#add_knowledge").before("<li class='li_curr'>"+data+"</li>");
	            			$(function(){
	        					choose();
	        				});
	        				$("div.mask").fadeOut();
	            		    $("div.txtbox").fadeOut();
          			}
          			if(data=="false"){
          				$.alert("输入不得超过6个字符");
          			}
          		},
          		error:function(){
          			$.alert("服务器繁忙...");
          		}
          	})
		  });
			
			function addTag(){
			$("div.mask").fadeIn();
			$("div.txtbox").fadeIn();
			  $.ajax({
				 url:"../base/jump?page=form5",
				type:"post",
				 success:function(data){
					 $("#skillModule_div").html(data);
				 }  
			  })
			}	
				
</script>
</html>