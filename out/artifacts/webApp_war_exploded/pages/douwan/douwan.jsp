<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
			
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
	<head>
		<title>ee28日趋势</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		
		<script type="text/javascript" language="javascript"
			 src="<%=basePath%>/js/My97DatePicker/WdatePicker.js" ></script>
		
		
		<base href="<%=basePath%>">


		<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
		<link rel="StyleSheet" type="text/css" href="css/all.css" />
		<link rel="StyleSheet" type="text/css" href="css/letu/stats.css" />
	
	
		<script type="text/javascript" src="js/jquery-1.4.4.js"></script>
		<script type="text/javascript" src="js/directory.js"></script>
		<script type="text/javascript" src="js/ddsmoothmenu.js"></script>
	    <script type="text/javascript" src="js/highcharts.js"></script>
	    <script type="text/javascript" src="js/douwan/stats.js"></script>
	    <script type="text/javascript" src="js/exporting.js"></script>
		

</head>
<body>
		<div id="container">

			

			<!-- //头部图片 -->
			<div id="banner" >
			<img src="images/bj.jpg" >
			</div>

			<!-- //菜单栏 -->
			<div id="biuuu" class="ddsmoothmenu">
			</div>
			<br />
			
		    <div id="zw">
			<div id="query" >
				<span id="table">
					<select id="tabletype">
					<option value=1>急速28中边比/时</option> 
					<option value=2>急速28大小比/时</option> 
					<option value=3>急速28单双比/时</option> 
					<option value=4>幸运28中边比叠加</option>
					<option value=5>幸运28大小比叠加</option>  
					<option value=6>幸运28单双比叠加</option>
					<option value=13>幸运28中边/期</option>
					<option value=14>幸运28大小比/期</option>  
					<option value=15>幸运28单双比/期</option>  
				
					</select>
				</span>
				<input id="date"  type="text"/>
				<img onclick="WdatePicker({el:'date'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22">
				<input type="button"  onclick="return stats();" value="开始统计"  >
				
			</div>
			 <div id="gundong">
            	<div id="stats" style="font-size: 12px;"></div>
			</div>
			
		    </div> 
	       
		
        
         </div>
	</body>
</html>