<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<li>
	<label class="label-checkbox item-content">
		<input class="left-position" type="radio" name="my-radio" value="">
		<div class="item-media"  pid=""><i class="icon icon-form-checkbox"></i></div>
		<div class="item-inner">
		<div class="item-subtitle"  style="padding-left: 10%;">所有岗位</div>
		</div>
	</label>
</li>
<c:forEach items="${positions }" var="position" varStatus="statu">

	<li >
	<label class="label-checkbox item-content">
		<input class="left-position" type="radio" name="my-radio" value="${position.positionId }">
		<div class="item-media"  pid="${position.positionId }"><i class="icon icon-form-checkbox"></i></div>
		<div class="item-inner">
		<div class="item-subtitle"  style="padding-left: 10%;">${position.positionName }</div>
		</div>
	</label>
	</li>

</c:forEach>
<script>
leftclose();
function leftclose(){
	   $(".left-position").unbind("click").bind("click",function () { 
		   $("#arrow-left").attr("src","../images/arrow-1.png");	
		   positionId = $(this).parent().find(".item-media").attr("pid");
		  
		   //初始化数据,页码数
		   initTotal();
		   currentPage=1;
		   
		   getStudent(positionId,levelId,currentPage);
		   $.closeModal(".pop");
		   $("#btn").html($(this).parent().find(".item-subtitle").html()+"<img src='../images/arrow-1.png' width='14.5' height='7' style='margin-right: 5% ; position:absolute; top:38%;right:2%' id='arrow-left'/>");

		});
}
</script> 