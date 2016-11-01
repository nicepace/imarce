<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${skillList }" var="skill">
	<li  
	  <c:forEach items="${sessionScope.skillList }" var="choose_skill">
		<c:if test="${skill.skillName == choose_skill}">
			class="li_curr"
		</c:if>
		</c:forEach>
	>${skill.skillName }</li>
</c:forEach>
<c:forEach items="${sessionScope.customSkillNameList }" var="custom_skill">
	<li 
		<c:forEach items="${sessionScope.skillList }" var="choose_skill">
			<c:if test="${custom_skill == choose_skill}">
				class="li_curr"
			</c:if>
		</c:forEach>
	>${custom_skill }</li>
</c:forEach>
<li id="add_skill" onclick="addTag()">+</li>
<div style="clear: both"></div>
