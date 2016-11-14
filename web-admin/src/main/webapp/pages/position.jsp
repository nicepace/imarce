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
    <link rel="stylesheet" href="${path}/wechat-assets/css/light7.min.css?v=${num}">
    <link rel="stylesheet" href="${path}/wechat-assets/css/light7-swiper.min.css?v=${num}">

  </head>
  <body>
   <div class="page">
     
	  <div class="content">
             <div class="list-block" style="padding-top:0px;margin-top:0px">
              <ul>
              <c:forEach items="${positionList }" var="position">
                <li>
						<a href="javascript:;" onclick="getKnowledge('${position.positionName}','${sessionScope.positionName}')" class="item-link item-content">
							<div class="item-inner">
							<input type="hidden" value="${position.positionName}"/>
					   			<div class="item-title">${position.positionName}</div>
					 		</div>
						</a>
                </li>   
              </c:forEach>
                <input type="hidden" id="sessionPositionName" value="${sessionScope.positionName}" />

			</ul>
           </div>
	  </div>


   	</div>		
 		<script type='text/javascript' src='${path}/assets/js/jquery-2.1.4.js?v=${num}' charset='utf-8'></script>
		<script type='text/javascript' src='${path}/wechat-assets/js/light7.js?v=${num}' charset='utf-8'></script>
</body>
</html>
<script>

function getKnowledge(positionName,sessionPositionName){
	var checkedPositionName = positionName;
    var sessionPositionName = sessionPositionName;
    if(sessionPositionName!=""&&checkedPositionName!=sessionPositionName){
    	position(checkedPositionName);
    }else{
    	window.location.href="${path}/release_requirement/show_skillmodule?positionName="+checkedPositionName;
    }
}

function position(positionName){
		 $.modal({
	      text: "更换岗位将会把你之前选择的其他岗位所选择的知识标签覆盖，是否继续？",
	      title: "提示",
	      buttons: [
	        {
	          text: '确定',
	          onClick: function(){
	        	  window.location.href="../release_requirement/show_skillmodule?positionName="+positionName+"&delete=yes";
	          }
	        },{
	        	text: '取消',
	        	onClick: function() {
		            
		          }
	        }
	      ]
	    });
	}

</script>