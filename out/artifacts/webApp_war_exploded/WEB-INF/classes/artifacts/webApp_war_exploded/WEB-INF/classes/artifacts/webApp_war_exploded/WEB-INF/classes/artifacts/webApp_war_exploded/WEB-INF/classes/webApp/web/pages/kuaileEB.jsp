<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>北京快乐8趋势</title>
    
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	
	<link rel="StyleSheet" type="text/css" href="css/all.css" />
	<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
	<link rel="stylesheet" type="text/css" href="css/kuaileEB.css" />
		
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/directory.js"></script>
	<script type="text/javascript" src="js/ddsmoothmenu.js"></script>
	<script type="text/javascript" src="js/kuaileEB.js"></script>

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
			
			<div id="jilu">
				<form id="pagination" action="jndtrend" method="post" name="pagination">
					<div><span style="padding-right:15px" >近  <input type="text" id="statsCount" style="width:70px;margin-right:5px" />期</span><input style="margin-right:5px;" onclick="javascript:stats()"  type="button" value="统计" ></div>
	 			</form>
				
				<table  align="center" cellpadding="0" cellspacing="0" id="countTable">
						<tr>
							<td class="one">统计次数-></td><td id="da"></td><td id="xiao"></td><td id="dxhe"></td><td id="dan"></td>
							<td id="shuang"></td><td id="odd"></td><td id="even"></td><td id="oehe"></td>
							<td id="shang"></td><td id="xia"></td><td id="sxhe"></td>
						</tr>
				</table>
				
				<table  align="center" cellpadding="0" cellspacing="0" id="jiluTable">
					<tbody id="mtb">
						<tr><td  align="center" class="qihao">期号</td><td align="center">时间</td>
						<td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td>
						<td>11</td><td>12</td><td>13</td><td>14</td><td>15</td><td>16</td><td>17</td><td>18</td><td>19</td><td>20</td><td>和</td>
						<td>大</td><td>小</td><td>和</td><td>单</td><td>双</td><td>奇</td><td>偶</td><td>和</td><td>上</td><td>下</td><td>和</td></tr>
					</tbody>
				</table>
				<br>
				<input id="CurrentPageIndex" name="CurrentPageIndex" type="hidden" />
				<table id="yema" cellpadding="0" cellspacing="0" align="center" width="100%">
				   <tbody>
				      <tr>
					     <td align="left">
							<span style="cursor:pointer;" title="当前页">
								<span class="common"> &nbsp; &nbsp;当前页：</span>
								<span id="dq" style="color:#CC0000;font-weight:bold;">1</span>
							</span>
						 </td>
						 <td align="right" id="ymtd">
							<span class="point14"> | </span>
							<a target="_top" href="javascript:onsubmit(1,1);">
								<span class="point14" title="首页">
									<img border="0" src="images/pgblack-1.png">
								</span>
							</a>
							<a target="_top" href="javascript:onsubmit(-1,2);">
								<span class="point14" title="前一页">
									<img border="0" src="images/pgblack-3.png">
								</span>
							</a>
							<a target="_top"  style="color:#CC0000; font-weight:bold;"  href="javascript:onsubmit(1,1);" >1</a>
						   		<a target="_top" href="javascript:onsubmit(2,1);">2</a>
								<a target="_top" href="javascript:onsubmit(3,1);">3</a>
								<a target="_top" href="javascript:onsubmit(4,1);">4</a>
								<a target="_top" href="javascript:onsubmit(5,1);">5</a>
								<a target="_top" href="javascript:onsubmit(6,1);">6</a>
								<a target="_top" href="javascript:onsubmit(7,1);">7</a>
								<a target="_top" href="javascript:onsubmit(8,1);">8</a>
								<a target="_top" href="javascript:onsubmit(9,1);">9</a>
								<a target="_top" href="javascript:onsubmit(10,1);">10</a>
							<a target="_top" href="javascript:onsubmit(1,2);">
							<span class="point14" title="后一页">
								<img border="0" src="images/pgblack-4.png">
							</span>
							</a>
							<a target="_top" href="javascript:onsubmit(20,1);">
								<span class="point14" title="尾页">
									<img border="0" src="images/pgblack-6.png">
								</span>
							</a>
							<span class="point14"> | &nbsp; &nbsp;&nbsp; &nbsp;</span>
					     </td>
				     </tr>
				   </tbody>
				</table>
				<br>
	 		</div>
	 		<div id="footer">底部</div>
	 </div>		
  </body>
</html>
