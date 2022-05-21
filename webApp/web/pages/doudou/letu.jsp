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
		<title>28采集器</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		
		<script type="text/javascript" language="javascript"
			 src="<%=basePath%>/js/My97DatePicker/WdatePicker.js" ></script>
		
		
		<base href="<%=basePath%>">


		<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
		<link rel="StyleSheet" type="text/css" href="css/all.css" />
		<link rel="StyleSheet" type="text/css" href="css/letu/stats.css" />
	
	
		<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="js/directory.js"></script>
		<script type="text/javascript" src="js/ddsmoothmenu.js"></script>
	    <script type="text/javascript" src="js/highcharts.js"></script>
	    <script type="text/javascript" src="js/doudou/stats.js"></script>
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
			
		    
			<div id="query" >
			<span id="table">
			<select id="tabletype">
			<option value=1>幸运28图中边比</option> 
			<option value=2>幸运28图连中次数</option> 
			<option value=3>幸运28图连边次数</option> 
			<option value=4>幸运28图大小比</option> 
			<option value=5>幸运28图连大次数</option> 
			<option value=6>幸运28图连小次数</option> 
			<option value=7>幸运28图单双比</option> 
			<option value=8>幸运28图连单次数</option> 
			<option value=9>幸运28图连双次数</option>
			<option value=10>幸运28图中边比/小时</option>
			<option value=11>幸运28图大小比/小时</option>  
			<option value=12>幸运28图单双比/小时</option>
			<option value=13>幸运28图中边/期</option>
			<option value=14>幸运28图大小比/期</option>  
			<option value=15>幸运28图单双比/期</option>  
			<option value=16>开心16图中边比</option> 
			<option value=17>开心16图连边次数</option>
			<option value=18>开心16图大小比</option>  
			<option value=19>开心16图连大数</option>
			<option value=20>开心16图连小数</option>  
			<option value=21>开心16图单双比</option> 
			<option value=22>开心16图连单数</option>  
			<option value=23>开心16图连双数</option> 
			<option value=24>开心16图中边比/小时</option> 
			<option value=25>开心16图大小比/小时</option>  
			<option value=26>开心16图单双比/小时</option> 
			<option value=27>开心16图中边比/期</option> 
			<option value=28>开心16图大小比/期</option>  
			<option value=29>开心16图单双比/期</option> 
			</select>
		</span>
				<input id="date"  type="text"/>
				<img onclick="WdatePicker({el:'date'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22">
				<input type="button"  onclick="return stats();" value="开始统计">
			</div>
            
			<div id="stats" style="font-size: 12px;">
			</div>
			
				  
	       
		
        
         </div>
	</body>
</html>