<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,java.io.*"  pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = "";
  
 Properties pro = new Properties();  
 String realpath = request.getRealPath("/WEB-INF");  
 try{  
 //读取配置文件
 FileInputStream in = new FileInputStream(realpath+"/headPicUrl.properties");  
 pro.load(in);  
 }  
 catch(FileNotFoundException e){  
     out.println(e);  
 }  
 catch(IOException e){out.println(e);} 

//通过key获取配置文件
 path = pro.getProperty("headPicUrl"); 
 
 
%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<c:forEach items="${ betterStu }" var="stu" varStatus="statu"> 
        <li style="    padding-top: 2%;    padding-bottom: 2%;">        
          <a href="javascript:;" onclick="goPage('${path}/better_student/go_studentInfo?studentId=${stu.studentId}')"  class="item-link item-content">
             <div class="item-media fixed"><img src="<%=path%>/${stu.headPicture }" width="65" style="border-radius:50%;">
             <img src="${path}/images/${stu.levelId }.png" width="25" class="coner_level" >
             </div>
            <div class="item-inner">
              <div class="item-subtitle" >${stu.studentName }&nbsp;&nbsp;<i>${stu.position }</i></div>
              <div class="item-text" style="overflow: hidden;width:100%;white-space:nowrap;text-overflow:ellipsis;">
                   <ol class="skill_label">
                   <c:forEach items="${stu.knowledge }" var="k" varStatus="statu">
                   	  <li style="margin-bottom:10px">${k.knowledgeName }</li>
                   </c:forEach>
                   </ol>
              </div>
            </div>
          </a>
          
        </li>
</c:forEach>


