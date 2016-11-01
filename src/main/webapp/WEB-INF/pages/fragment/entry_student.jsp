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
<c:forEach items="${BestStudents}" var="student" varStatus="vs"> 
        <li>
          <a href="#" class="item-link item-content">
            <div class="item-media"><img src="<%=path%>/${student.headPicture}" width="65" height="65" style="border-radius:50%;"></div>
            <div class="item-inner" style="padding:5px;background-image:url(#FFF)">
               <div class="item-title-row" >
                   <div class="item-mid" style="table-layout: fixed">
                        <h3 style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">${student.studentName}</h3>
                        <div style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;"><img src="${path}/images/wanted_iconfont-gongwenbaoxian.png" width="17" height="17"/> ${student.positionName}</div>
                         <div style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;"><img src="${path}/images/wanted_iconfont-icon.png" width="17" height="17"/> 入职${student.employed}</div>
                   </div>
                   <div class="item-right">
                      <img src="${path}/images/${student.levelId}.png" width="40" style="margin-top: 9%;margin-bottom: 7%">
                       <div>i码士 - p${student.levelId}</div>
                        <!--<div><b>￥${student.salary}</b>月薪</div>-->
                   </div>
               </div>
            </div>
          </a>
        </li>
      </c:forEach>