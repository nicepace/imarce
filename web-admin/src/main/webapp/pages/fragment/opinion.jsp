<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div title="基本信息" style="padding: 10px">
	<table width="100%" class="table_info">

		<tr height="30">
			<td>反馈用户</td>
			<td id="advice_user">${opinion.userId }</td>
		</tr>
		<tr height="30">
			<td width="20%">反馈时间</td>
			<td id="advice_time">${opinion.releaseTimeStr }</td>
		</tr>
		<tr height="260">
			<td>意见内容</td>
			<td id="full_advice">${opinion.opinion }</td>
		</tr>
	</table>

</div>

<style type="text/css">
	td {
		padding-left: 10px;
	}
</style>

</body>
</html>