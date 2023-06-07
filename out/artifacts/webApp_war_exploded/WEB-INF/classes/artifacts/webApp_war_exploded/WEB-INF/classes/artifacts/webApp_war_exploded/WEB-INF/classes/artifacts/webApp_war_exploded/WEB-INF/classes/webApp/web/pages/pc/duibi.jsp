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
		<link rel="stylesheet" type="text/css" href="css/dingshi.css" />
		
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<script type="text/javascript" src="js/directory.js"></script>
		<script type="text/javascript" src="js/ddsmoothmenu.js"></script>
		<script type="text/javascript" src="js/dingshi.js"></script>
	
	

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
			
			<div id="dd">
				<br />输入芝麻session:
				<input type="text" id="zmString" style="width:400px;" />&nbsp
				<input type="button" style="width:85px;" value="单投快乐28"  onclick='javascript:kleb()' />
				<input type="button" style="width:75px;" value="停止快乐28"  id="stop_zm_kl" onclick='javascript:changeFlat(9)' />
				<input type="button" style="width:85px;" value="单投幸运28"  onclick='javascript:klxyeb()' />	
				<input type="button" style="width:75px;" value="停止幸运28"  id="stop_zm_xy" onclick='javascript:changeFlat(10)' />
				<input type="button" style="width:40px;" value="清空"  onclick='javascript:clearZmString()' />
				
				<br /><br />输入维多利亚session:
				<input type="text" id="wdlyString" style="width:400px;" />&nbsp<input type="button" style="width:50px;" value="清空"  onclick='javascript:clearWdlyString()' />
				
				<form  id="fomr4" name="form4"  method="post">
				<br /><br />幸运猪session:
				<input type="text" id="xyzString" name="xyzString" style="width:500px;" />&nbsp
				<input type="button" style="width:72px;" value="单投急速28"  onclick='javascript:xyzsebDantou()' />
				<input type="button" style="width:70px;" value="停止急速28"  id="stop_xyz_jseb"  onclick='javascript:changeFlat(18)' />
				<input type="button" style="width:40px;" value="清空"  onclick='javascript:clearxyzString()' />
				</form>
				
				<form  id="fomr5" name="form5"  method="post">
				<br />丁豆网session:
				<input type="text" id="ddString" name="ddString" style="width:500px;" />&nbsp
				<input type="button" style="width:72px;" value="单投急速28"  onclick='javascript:ddjsebDantou()' />
				<input type="button" style="width:70px;" value="停止急速28"  id="stop_dd_jseb"  onclick='javascript:changeFlat(19)' />
				<input type="button" style="width:40px;" value="清空"  onclick='javascript:clearddString()' />
				</form>
				
				<form  id="fomr3" name="form3"  method="post">
				<br />咿咿session:
				<input type="text" id="yiyiString" name="yiyiString" style="width:200px;" />&nbsp
				<input type="button" style="width:85px;" value="单投加拿大28"  onclick='javascript:jndDantou()' />
				<input type="button" style="width:80px;" value="停止加拿大28"    id="stop_ee_jnd" onclick='javascript:changeFlat(8)' />
				<input type="button" style="width:72px;" value="单投急速28"  onclick='javascript:jsebDantou()' />
				<input type="button" style="width:70px;" value="停止急速28"  id="stop_ee_jseb"  onclick='javascript:changeFlat(7)' />
				<input type="button" style="width:72px;" value="单投pk10"  onclick='javascript:eepk10antou()' />
				<input type="button" style="width:72px;" value="停止pk10"  id="stop_ee_pk10"  onclick='javascript:changeFlat(17)' />
				<input type="button" style="width:40px;" value="清空"  onclick='javascript:clearYiyiString()' />
				<input type="button" style="width:70px;" value="添加pk10"  onclick='javascript:addPK10()' />
				</form>
				
				<br />输入给币session:
				<input type="text" id="gbString" style="width:400px;" />&nbsp
				<input type="button" style="width:72px;" value="单投急速28"  onclick='javascript:gbJsebDantou()' />
				<input type="button" style="width:82px;" value="停止幸运28"  id="stop_gb_jseb"  onclick='javascript:changeFlat(11)' />
				<input type="button" style="width:72px;" value="单投PK10冠军"  onclick='javascript:gbPK10GJDantou()' />
				<input type="button" style="width:72px;" value="停止单投PK10冠军"  id="stop_gb_pk10gj"  onclick='javascript:changeFlat(15)' />
				<input type="button" style="width:40px;" value="清空"  onclick='javascript:clearGeibiString()' />
				<br /><br><br />
				
				
				<input type ="button"  value="开始芝麻和给币北京16定时"  onclick='javascript:zmgbBj16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止开始芝麻和给币北京16" onclick='javascript:changeFlat(26)' >     
       			<br><br />
       			
       			<input type ="button"  value="开始芝麻和给币加拿大28定时"  onclick='javascript:zmgbJnd28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和给币加拿大28" onclick='javascript:changeFlat(25)' >     
				<br><br />
				
				<input type ="button"  value="开始芝麻和给币加拿大16定时"  onclick='javascript:zmgbJnd16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和给币加拿大16" onclick='javascript:changeFlat(27)' >     
				<br><br />
				
				
				<input type ="button"  value="开始芝麻和维多利亚加拿大28定时"  onclick='javascript:zmwdlyjnd28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和维多利亚加拿大28" onclick='javascript:changeFlat(21)' >     
       			<br><br />
       			
       			
       			<input type ="button"  value="开始芝麻和维多利亚北京28定时"  onclick='javascript:duibiZmAndWdlyBj28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和维多利亚北京28" onclick='javascript:changeFlat(24)' >     
       			<br><br />
       			
       			<input type ="button"  value="开始芝麻和丁豆北京28定时"  onclick='javascript:zmddzm28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和丁豆北京28" onclick='javascript:changeFlat(22)' >     
       			<br><br />
       			
       			<input type ="button"  value="开始芝麻和丁豆加拿大28定时"  onclick='javascript:zmddjnd28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和丁豆加拿大28" onclick='javascript:changeFlat(23)' >     
       			<br><br />
       			
       			
				
				<input type ="button"  value="开始给币和EEpc28定时"  onclick='javascript:gbeepc()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止给币和EEPC28" onclick='javascript:changeFlat(13)' >     
       			<br><br />
       			<input type ="button"  value="开始给币和加拿大28定时"  onclick='javascript:gbeeJnd28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止给币和加拿大28" onclick='javascript:changeFlat(14)' >     
       			<br><br />
       			<input type ="button"  value="开始芝麻和EE北京28定时"  onclick='javascript:zmguguobj28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和咕果北京28" onclick='javascript:changeFlat(4)' >     
       			<br><br />
       			<input type ="button"  value="开始芝麻和EE加拿大28定时"  onclick='javascript:zmeejnd28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和咕果加拿大28" onclick='javascript:changeFlat(5)' > 
				<br><br />
       			<input type ="button"  value="开始芝麻和EE加拿大16定时"  onclick='javascript:zmeejnd16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和咕果加拿大16" onclick='javascript:changeFlat(6)' > 
				<br><br />
				<br><br />
				<br><br />
       		</div>
        </div>
  </body>
</html>
