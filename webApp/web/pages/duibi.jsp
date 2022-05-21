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
	
		<script type="text/javascript">
			function changetip() {

			var type = $('#type').val();
				$.ajax({
					url : "changeType",
					type : "post",
					dataType : "json",
					data : {
						"type": type
					},
				success : zmAndmxresult,
				error : function() {
					alert("error");
				}
				});
			}
		</script>

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
				<form  id="formdou" name="formdou"  method="post">
				<br />输入芝麻session:
				<input type="text" id="zmString" style="width:400px;" />&nbsp
				<input type="button" style="width:85px;" value="单投快乐28"  onclick='javascript:kleb()' />
				<input type="button" style="width:75px;" value="停止快乐28"  id="stop_zm_kl" onclick='javascript:changeFlat(9)' />
				<input type="button" style="width:85px;" value="单投幸运28"  onclick='javascript:klxyeb()' />	
				<input type="button" style="width:75px;" value="停止幸运28"  id="stop_zm_xy" onclick='javascript:changeFlat(10)' />
				<input type="button" style="width:40px;" value="清空"  onclick='javascript:clearZmString()' />
				
				<br><br />输入豆玩session:
				<input type="text" id="dwString" style="width:400px;" />&nbsp
				<input type="button" style="width:72px;" value="单投急速28"  onclick='javascript:dwjsebDantou()' />
				<input type="button" style="width:82px;" value="停止急速28"  id="stop_dw_jseb"  onclick='javascript:changeFlat(40)' />
				<input type="button" style="width:40px;" value="清空"  onclick='javascript:clearDouwanString()' />
				<input type="text" id="dwjsebbeishu" style="width:100px;" /> 
				<input type="button" onclick='javascript:beishu()'  value="倍数" />
				
				
				
				<br><br />
				<input type="button" style="width:72px;" value="单投急加拿大8"  onclick='javascript:dwjndDantou()' />
				<input type="button" style="width:82px;" value="停止加拿大28"  id="stop_dw_jnd"  onclick='javascript:changeFlat(45)' />
				<input type="button" style="width:40px;" value="清空"  onclick='javascript:clearDouwanString()' />
				<select id="type" onchange="changetip(this)">
					 <option value ="1">大</option>
  					 <option value ="2">小</option>
 					 <option value="3">中</option>
  					 <option value="4">边</option>
  					 <option value="5">单</option>
  					 <option value="6">双</option>
				</select>
				<input type="text" id="dwjndbeishu" style="width:100px;" /> 
				<input type="button" onclick='javascript:beishuJnd()'  value="倍数" />
				
				
				
				<br><br />得胜session:
				<input type="text" id="dsString" name="dsString" style="width:500px;" />&nbsp
				<input type="button" style="width:72px;" value="单投急速28"  onclick='javascript:xyzsebDantou()' />
				<input type="button" style="width:70px;" value="停止急速28"  id="stop_xyz_jseb"  onclick='javascript:changeFlat(18)' />
				<input type="button" style="width:40px;" value="清空"  onclick='javascript:cleardsString()' />
				</form>
				
				<br><br />幸运猪session:
				<input type="text" id="xyzString" name="xyzString" style="width:500px;" />&nbsp
				<input type="button" style="width:72px;" value="单投急速28"  onclick='javascript:xyzsebDantou()' />
				<input type="button" style="width:70px;" value="停止急速28"  id="stop_xyz_jseb"  onclick='javascript:changeFlat(18)' />
				<input type="button" style="width:40px;" value="清空"  onclick='javascript:clearxyzString()' />
				</form>
				
				
				<br /><br />	
				输入维多利亚session:
				<input type="text" id="wdlyString" style="width:400px;" />&nbsp<input type="button" style="width:50px;" value="清空"  onclick='javascript:clearWdlyString()' />
				<form  id="form4" name="form4"  method="post">
				
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
				
				
			
				<input type ="button"  value="开始芝麻和豆玩北京28定时"  onclick='javascript:zmdwBj28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止开始芝麻和豆玩北京28" onclick='javascript:changeFlat(41)' >     
       			<br><br />
				
				<input type ="button"  value="开始芝麻和豆玩北京16定时"  onclick='javascript:zmdwBj16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止开始芝麻和豆玩北京16" onclick='javascript:changeFlat(42)' >     
       			<br><br />
       			
       			<input type ="button"  value="开始芝麻和豆玩加拿大28定时"  onclick='javascript:zmdwJnd28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和豆玩加拿大28" onclick='javascript:changeFlat(43)' >     
				<br><br />
				
				<input type ="button"  value="开始芝麻和豆玩加拿大16定时"  onclick='javascript:zmdwJnd16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和豆玩加拿大16" onclick='javascript:changeFlat(44)' >     
				<br><br />
				
				<div>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~芝麻豆玩分界线~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</div>
				
				
				<input type ="button"  value="开始得胜和豆玩PC28定时"  onclick='javascript:dsdwPc28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止开始得胜和豆玩PC28" onclick='javascript:changeFlat(61)' >     
       			<br><br />
				
				<input type ="button"  value="开始得胜和豆玩北京28定时"  onclick='javascript:dsdwBj28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止开始得胜和豆玩北京28" onclick='javascript:changeFlat(62)' >     
       			<br><br />
				
				<input type ="button"  value="开始得胜和豆玩北京16定时"  onclick='javascript:dsdwBj16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止得胜和豆玩北京16" onclick='javascript:changeFlat(63)' >     
       			<br><br />
       			
       			<input type ="button"  value="开始得胜和豆玩加拿大28定时"  onclick='javascript:dsdwJnd28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止得胜和豆玩加拿大28" onclick='javascript:changeFlat(64)' >     
				<br><br />
				
				<input type ="button"  value="开始得胜和豆玩加拿大16定时"  onclick='javascript:dsdwJnd16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止得胜和豆玩加拿大16" onclick='javascript:changeFlat(65)' >     
				<br><br />
				
				
				<div>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~得胜豆玩分界线~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</div>
				
				<input type ="button"  value="开始幸运猪和豆玩PC28定时"  onclick='javascript:xyzdwPc28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止开始幸运猪和豆玩PC28" onclick='javascript:changeFlat(51)' >     
       			<br><br />
				
				<input type ="button"  value="开始幸运猪和豆玩北京28定时"  onclick='javascript:xyzdwBj28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止开始幸运猪和豆玩北京28" onclick='javascript:changeFlat(52)' >     
       			<br><br />
				
				<input type ="button"  value="开始幸运猪和豆玩北京16定时"  onclick='javascript:zmdwBj16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止开始幸运猪和豆玩北京16" onclick='javascript:changeFlat(53)' >     
       			<br><br />
       			
       			<input type ="button"  value="开始幸运猪和豆玩加拿大28定时"  onclick='javascript:xyzdwJnd28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止幸运猪和豆玩加拿大28" onclick='javascript:changeFlat(54)' >     
				<br><br />
				
				<input type ="button"  value="开始幸运猪和豆玩加拿大16定时"  onclick='javascript:zmdwJnd16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止幸运猪和豆玩加拿大16" onclick='javascript:changeFlat(55)' >     
				<br><br />
				
				
				<div>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~幸运猪豆玩分界线~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</div>
				
				
				<input type ="button"  value="开始芝麻和给币北京16定时"  onclick='javascript:zmgbBj16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止开始芝麻和给币北京16" onclick='javascript:changeFlat(26)' >     
       			<br><br />
       			
       			<input type ="button"  value="开始芝麻和给币加拿大28定时"  onclick='javascript:zmgbJnd28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和给币加拿大28" onclick='javascript:changeFlat(25)' >     
				<br><br />
				
				<input type ="button"  value="开始芝麻和给币加拿大16定时"  onclick='javascript:zmgbJnd16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止芝麻和给币加拿大16" onclick='javascript:changeFlat(27)' >     
				<br><br />
				<div>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~给币豆玩分界线~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</div>
				
				<input type ="button"  value="开始给币和豆玩加拿大28定时"  onclick='javascript:gbdwJnd28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止给币和豆玩加拿大28" onclick='javascript:changeFlat(29)' >     
       			<br><br />
       			
       			
       			<input type ="button"  value="开始给币和豆玩加拿大16定时"  onclick='javascript:gbdwJnd16()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止给币和豆玩加拿大16" onclick='javascript:changeFlat(30)' >     
       			<br><br />
       			
       			<input type ="button"  value="开始给币和豆玩pc28定时"  onclick='javascript:gbdwpc28()' >&nbsp&nbsp&nbsp
				<input type ="button"  value="停止给币和豆玩pc28" onclick='javascript:changeFlat(31)' >     
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
