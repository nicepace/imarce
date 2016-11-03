<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
	<c:forEach items="${Positions}" var="position" varStatus="vs"> 
        <li >
		<label class="label-checkbox item-content ">
		<input  class="close-popup" type="radio" name="my-radio" value="${position.positionId }">
		<div class="item-media left-position"  pid="${position.positionId }"><i class="icon icon-form-checkbox"></i></div>
		<div class="item-inner">
		<div class="item-subtitle">${position.positionName }</div>
		</div>
	</label>
	</li>
      </c:forEach>
      <script>
       $(".close-popup").unbind("click").bind("click",function(){
           var checkedPositionName = $(this).parent().find(".item-subtitle").html();
		   $("#checkPosition").text(checkedPositionName);
		   $("#candidatePosition").val(checkedPositionName.trim());
		   
		   $.closeModal('.popup-about');
    	   
    	   
       });
      
     
	  </script>