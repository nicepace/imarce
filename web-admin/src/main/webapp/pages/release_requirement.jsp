<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>发布需求</title>
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
   <div class="mask"></div>
 <div id="sal_div" ></div>
 <div id="introduce_div" ></div>
 <div id="msgbox_div" ></div>
       <nav class="bar bar-tab" style="background-color:#0a91ea">
        <a class="tab-item" href="#" style="color:#fff" >
          <span class="tab-label" id="btn_commit">提交需求</span>
        </a>
      </nav>
	  <div class="content">
        <div class="list-block" style="padding-top:0px;margin-top:0px">
              <ul>
                <li>
                  <a href="#" class=" item-content">
                    <div class="item-inner">
                       <input type="text" placeholder="公司名称" id="company_name" value=${sessionScope.companyName }>
                    </div>
                  </a>
                </li>
                <li>
                  <a href="#" class="item-content">
                    <div class="item-inner">
                       <input type="text" placeholder="联系人" id="contacts" value=${sessionScope.contacts }>
                    </div>
                  </a>
                </li>
                <li>
                  <a href="#" class="item-content">
                    <div class="item-inner">
                      <input type="text" placeholder="手机号码" id="phone_number" value=${sessionScope.phoneNumber }>
                    </div>
                  </a>
                </li>   
              </ul>
           </div>
             <div class="list-block" style="padding-top:0px;margin-top:0px">
              <ul>
                <li>
                  <a href="${path}/release_requirement/show_position" class="item-link item-content">
                    <div class="item-inner">
                      <div class="item-title">岗位类型
                        <input id="judge_knowledgeList" type="hidden" value="${sessionScope.positionName }">
                      	<pp class="ol_skill_list" style="color:#a99a8a;">${sessionScope.positionName }</pp>
                        <c:forEach items="${sessionScope.knowledgeList }" var="know">
							<pp class="ol_skill_list" style="color:#a99a8a;">${know }</pp>
					  	</c:forEach>
                      </div>
                   </div>
                  </a>
                </li>
                <li>
                  <a href="${path}/base/jump?page=skill" class="item-link item-content">
                    <div class="item-inner">
                      <div class="item-title">技能要求
                      <input id="judge_skillList" type="hidden" value="${sessionScope.skillList }">
                      <c:forEach items="${sessionScope.skillList }" var="choose_skill">
						<pp class="ol_skill_list" style="color:#a99a8a;">${choose_skill }</pp>
					  </c:forEach>
				
                      </div>
                    </div>
                  </a>
                </li>
                <li>
                  <a href="#" class="item-link item-content" id="tr_sal_choose">
                    <div class="item-inner">
                      <div class="item-title">薪资范围
                      <input id="judge_salvalue" type="hidden" value="${sessionScope.minsal }">
						<pp class="ol_skill_list" style="color:#a99a8a;" id="salvalue">
						<c:if test="${! empty sessionScope.minsal }">${sessionScope.minsal }--${sessionScope.maxsal }</c:if>
						</pp>
                      </div>
                    </div>
                  </a>
                </li> 
                 <li>
                  <a href="#" class="item-link item-content" id="tr_pos_desc">
                    <div class="item-inner">
                      <div class="item-title">职位描述
                      <input id="judge_introducevalue" type="hidden" value="${sessionScope.introduce }">
                      <pp class="ol_skill_list" style="color:#a99a8a;" id="introducevalue">${sessionScope.introduce }</pp>
                      </div>
                    </div>
                  </a>
                </li>   
              </ul>
              <h4 id="info" style="color:red;text-align:center"></h4>
           </div>
	  </div>
   </div>
    <script type='text/javascript' src='${path}/assets/js/jquery-2.1.4.js?v=${num}' charset='utf-8'></script>
    <script type='text/javascript' src='${path}/wechat-assets/js/light7.js?v=${num}' charset='utf-8'></script>
    
  </body>
</html>

<script>
var titletxt = "";
function getKnowledge(positionName,sessionPositionName){
	var checkedPositionName = positionName;
    var sessionPositionName = sessionPositionName;
    if(sessionPositionName!=""&&checkedPositionName!=sessionPositionName){
    	positionChoose(checkedPositionName);
    }else{
    	window.location.href="${path}/release_requirement/show_skillmodule?positionName="+checkedPositionName;
    }
} 

function positionChoose(Name){
	 $.modal({
     text: "更换岗位将会把你之前选择的其他岗位所选择的知识标签覆盖，是否继续？",
     title: "提示",
     buttons: [
       {
         text: '确定',
         onClick: function(){
       	  window.location.href="../release_requirement/show_skillmodule?positionName="+Name+"&delete=yes";
         }
       },{
       	text: '取消',
       	onClick: function() {
	            
	          }
       }
     ]
   });
}

var sal = "";
var introduce = "";
var position = "";
var message="";
$(document).ready(function(){
	if($("#judge_knowledgeList").val()==""){
		$("#judge_knowledgeList").siblings($("pp")).hide();
	}else{
		position = "yes";
		$("#judge_knowledgeList").siblings($("pp")).show();
	}
	if($("#judge_skillList").val()==""){
		$("#judge_skillList").siblings($("pp")).hide();
	}else{
		$("#judge_skillList").siblings($("pp")).show();
	}
	if($("#judge_salvalue").val()==""){
		$("#salvalue").hide();
	}else{
		$("#salvalue").show();
		sal = "yes";
	}
	if($("#judge_introducevalue").val()==""){
		$("#introducevalue").hide();
	}else{
		$("#introducevalue").show();
		introduce = "yes";
	}
})

$("#btn_commit").click(function(){
	if(provingCompanyName()&&provingContacts()&&provingPhoneNumber()&&position!=""&&sal!=""&&introduce!=""){
		$.ajax({
			url:"../release_requirement/save_requirement",
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.code=="1"){
					$(".item-title pp").html("");
					$(".item-inner input").val("");
					$("#judge_knowledgeList").siblings($("pp")).hide();
					$("#judge_skillList").siblings($("pp")).hide();
					$("#salvalue").hide();
					$("#introducevalue").hide();
					titletxt = "发布需求成功";
					message = data.msg;
  					showTextBox();
				}
			},
			error:function(){
				
			}
		})	
	}else if(position==""){
		$.toast("岗位类型不能不选！", 1500);
	}else if(sal==""){
		$.toast("请输入正确的薪资范围！", 1500);
	}else if(introduce==""){
		$.toast("请输入正确的职位描述！", 1500);
	}
})

function provingCompanyName(){
	var reg = new RegExp("^([\u4e00-\u9fa5]{2,50}|[a-zA-Z0-9]{2,50})$");
	var companyName = $("#company_name").val().trim();
	if(!reg.test(companyName)){
		$.toast("公司名称不符合规范！", 1500);
		return false;
	}
	return true;
}
$("#company_name").blur(function(){
	if(provingCompanyName()){
		$.ajax({
			url:"${path}/release_requirement/add_company_name",
			type:"post",
			data:{"companyName":$("#company_name").val().trim()},
		})
	}	
})

function provingContacts(){
	var reg = new RegExp("^([\u4e00-\u9fa5]{2,4}|[a-zA-Z\.\s]{2,20})$");
	var contacts = $("#contacts").val().trim();
	if(!reg.test(contacts)){
		$.toast("姓名不符合规范！", 1500);
		return false;
	}
	return true;
}

$("#contacts").blur(function(){
	if(provingContacts()){
		$.ajax({
			url:"${path}/release_requirement/add_contacts",
			type:"post",
			data:{"contacts":$("#contacts").val().trim()},
		})
	}	
})

function provingPhoneNumber(){
	var reg = new RegExp("(^(\\d{2,4}[-_－—])?\\d{7,8}$)|(^0?1[358]\\d{9}$)");
	var phoneNumber = $("#phone_number").val().trim();
	if(!reg.test(phoneNumber)){
		$.toast("联系号码不符合规范！", 1500);
		return false;
	}
	return true;
}

$("#phone_number").blur(function(){
	if(provingPhoneNumber()){
		$.ajax({
			url:"${path}/release_requirement/add_phone_number",
			type:"post",
			data:{"phoneNumber":$("#phone_number").val().trim()},
		})
	}	
})

function provingMinSal(){
	var reg = new RegExp("^[0-9]+(\.[0-9]{1})?$");
	var minsal = $("#minsal").val().trim();
	var maxsal = $("#maxsal").val().trim();
	if(!reg.test(minsal)){
		if(minsal!=""){
			$.toast("薪资不规范！", 1500);
			return false;
		}
		return false;
	}
	if(maxsal!=null||maxsal!=""){
		if(parseFloat(minsal)>parseFloat(maxsal)){
			$.toast("最高工资要高于最低工资！", 1500);
			return false;
		}
	}
	return true;
}

function provingMaxSal(){
	var reg = new RegExp("^[0-9]+(\.[0-9]{1})?$");
	var minsal = $("#minsal").val().trim();
	var maxsal = $("#maxsal").val().trim();
	if(!reg.test(maxsal)){
		if(maxsal!=""){
			$.toast("薪资不规范！", 1500);
			return false;
		}
		return false;
	}
	if(minsal!=null||minsal!=""){
		if(parseFloat(minsal)>parseFloat(maxsal)){
			$.toast("最高工资要高于最低工资！", 1500);
			return false;
		}
	}
	return true;
}

function provingSal(){
	if(provingMaxSal()&&provingMinSal()){
		return true;
	}
	return false;
}



function provingIntroduce(){
	if($("#introduce").val().length>250){
		$.toast("描述太长！", 1500);
		return false;
	}
	return true;
}

  $(document).on('click','#tr_sal_choose', function () {
	 $("div.mask").fadeIn();
	 $.ajax({
		 url:"../base/jump?page=form3",
		 success:function(da){
			 $("#sal_div").html(da);
		 }  
	  });
	  return false;
  });
  
   $(document).on('click','#tr_pos_desc', function () {
	  $("div.mask").fadeIn();
	  $.ajax({
		 url:"../base/jump?page=form4",
		 success:function(da){
			 $("#introduce_div").html(da);
		 }  
	  });
	  return false;
  });

   function showTextBox(){
	   $.ajax({
		   type:"GET",
		   url:"../base/jump?page=textBoxSuccess",
		   success: function (data) {
			   $("div.mask").fadeIn();
			   $("#msgbox_div").html(data);
		   },
	   	   error: function (data) {
				$.alert("服务器繁忙,请稍后再试","提示");
		   }
	   
	   });
   }
</script>