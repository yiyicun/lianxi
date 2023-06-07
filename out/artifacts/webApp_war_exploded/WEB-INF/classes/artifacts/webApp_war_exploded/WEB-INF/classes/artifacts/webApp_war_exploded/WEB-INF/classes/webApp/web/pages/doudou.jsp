﻿<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>28采集器</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<base href="<%=basePath%>">
		<link rel="StyleSheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
		
		<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="js/directory.js"></script>
		<script type="text/javascript" src="js/ddsmoothmenu.js"></script>
		<script type="text/javascript" src="js/doudou.js"></script>
	
	
	

	</head>
    <body>
 
		<div id=container>

			<!-- //头部图片 -->
			<div id="banner" >
				<img src="images/bj.jpg" >
			</div>

			<!-- //菜单栏 -->
			<div id="biuuu" class="ddsmoothmenu">
			</div>
			<br />
			
			<div id="zw">
			范围:
			<input type="text" id="start" style="width:100px;">
			到
			<input type="text" id="end" style="width:100px;">
			间隔:
			<input type="text" id="cycle" style="width:100px;">
			
			 </div>
			 
			 <div id="jieguo" >
			 </div>
   
        </div>
  </body>
</html>
