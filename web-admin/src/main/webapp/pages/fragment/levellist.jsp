<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      	<li >
          <label class="label-checkbox item-content">
            <input class="right-level" type="radio" name="my-radio" value="">
            <div class="item-media " pid=""><i class="icon icon-form-checkbox"></i></div>
            <div class="item-inner" >
              <div class="item-subtitle"  style="padding-left: 10%;">所有等级</div>
            </div>
          </label>
        </li>
<c:forEach items="${ levels}" var="level" varStatus="statu">
      	<li >
          <label class="label-checkbox item-content">
            <input class="right-level" type="radio" name="my-radio" value="${level.levelId }">
            <div class="item-media" pid="${level.levelId }"><i class="icon icon-form-checkbox"></i></div>
            <div class="item-inner" >
              <div class="item-subtitle" style="padding-left: 10%;">i码士-L${level.levelName }</div>
            </div>
          </label>
        </li>
</c:forEach>
<script>
rightclose();
function rightclose(){
    $(".right-level").unbind("click").bind("click",function () { 
 	   $("#arrow-right").attr("src","../images/arrow-1.png");
    	levelId = $(this).parent().find(".item-media").attr("pid");
    	//初始化数据页面数
		 initTotal();
		 currentPage=1;
		 
		 getStudent(positionId,levelId,currentPage);
 	   	$("#btn2").html($(this).parent().find(".item-subtitle").html());
    	$.closeModal('.popr');
	});
}  
</script>