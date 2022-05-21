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
			<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<script type="text/javascript" > 
			function addLamp() {
			   
				
	  $.ajax({
	     	url:"addlamp?lampNo=1",
	     	type: "post",
	     	success:checkResult,
			error: function(){alert("error");}
	   });
}

			function checkResult(msg) {
			   alert("hen hao");
			   alert(msg);
			}
		
		 
		</script>
	
	</head>
	<body>
		<div id="container">

			<!-- //头部图片 -->
			<div id="banner">
				
			</div>

			<!-- //菜单栏 -->
			<div id="biuuu" class="ddsmoothmenu">
			</div>

			<div id="zw">
			
				  <div id="add" >
					
							<form id="addForm" name="addForm" method="post">

								<table id="lamp_table_add" border="0" cellspacing='0'
									cellpadding='0' width="80%" align="center">
									
									<tr>
										<td align="left" width="120px">
											路灯编号:
										</td>
										<td align="left">
											<input id="lampNo" name="lampNo" maxLength="20"
												style="width: 155px;">
											<em id="lampNo_add_warn"></em>
										</td>
									</tr>
								  
									
									<tr>
										<td align="left" width="120px">
											所在回路:
										</td>
										<td align="left">
											<select id="loopAddr" name="loopAddr"
												style="width: 158px; height: 22px;">
											</select>
											<em id="boxgruop_add_warn"></em>
										</td>
									</tr>
									
									
									<tr>
										<td align="left" style="width: 120px;">
											回路内的地址:
										</td>
										
										<td align="left">
											<select id="addrCode" name="addrCode"
												style="width: 158px; height: 22px;">
											</select>
											<em id="boxgruop_add_warn"></em>
										</td>
									</tr>
									

									<tr>
										<td align="left" width="120px">
											型号:
										</td>
										<td align="left">
											<input id="lampModel" name="lampModel"
												maxLength="20" style="width: 155px;">
											<em id="lampModel_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											类型:
										</td>
										<td align="left">
											<select id="lampType" name="lampType"
												style="width: 158px; height: 22px;">
												<option value="1">
													LED
												</option>
												<option value="2">
													HID
												</option>
											</select>
											<em id="lampType_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											额定电压:
										</td>
										<td align="left">
											<input id="ratedVoltage" name="ratedVoltage"
												style="width: 155px;">
											<em id="ratedVoltage_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											额定电流:
										</td>
										<td align="left">
											<input id="ratedCurrent" name="ratedCurrent"
												style="width: 155px;">
											<em id="ratedCurrent_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											额定功率:
										</td>
										<td align="left">
											<input id="ratedPower" name="ratedPower"
												style="width: 155px;">
											<em id="ratedPower_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											额定温度:
										</td>
										<td align="left">
											<input id="ratedTemp" name="ratedTemp"
												style="width: 155px;">
											<em id="ratedTemp_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											工作寿命:
										</td>
										<td align="left">
											<input id="workLife" name="workLife"
												style="width: 155px;">
											<em id="workLife_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											已工作时间:
										</td>
										<td align="left">
											<input id="usedTime" name="usedTime"
												style="width: 155px;">
											<em id="usedTime_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											寿命告警门限:
										</td>
										<td align="left">
											<input id="threshold1" name="threshold1"
												style="width: 155px;">
											<em id="threshold1_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											标准照度:
										</td>
										<td align="left">
											<input id="standardBrightness"
												name="standardBrightness" style="width: 155px;">
											<em id="standardBrightness_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											当前照度:
										</td>
										<td align="left">
											<input id="currentBrightness"
												name="currentBrightness" style="width: 155px;">
											<em id="currentBrightness_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											照度告警门限:
										</td>
										<td align="left">
											<input id="threshold2" name="threshold2"
												style="width: 155px;">
											<em id="threshold2_add_warn"></em>
										</td>
									</tr>

									<tr>
										<td align="left" width="120px">
											光源类型:
										</td>
										<td align="left">
											<input id="lightType" name="lightType"
												maxLength="20" style="width: 155px;">
											<em id="lightType_add_warn"></em>
										</td>
									</tr>
									
									
									
									<tr>
										<td align="left" width="120px">
											路灯组别编号:
										</td>
										<td align="left">
											<input id="groupnum" name="groupnum"
												style="width: 155px;">
											<em id="groupnum_add_warn"></em>
										</td>
									</tr>
									
									<tr>
										<td align="left" width="120px">
											全(半)夜灯:
										</td>
										<td align="left">
											<select id="wholeorhalf" name="wholeorhalf"
												style="width: 158px; height: 22px;">
												<option value=1>
													全夜灯
												</option>
												<option value=2>
													半夜灯
												</option>
											</select>
											<em id="wholeorhalf_add_warn"></em>
										</td>
									</tr>
								    
									

									<tr>
										<td align="center" colspan="2">
											<br>
											<input type="submit" onclick="return addLamp()" value="增加"
												style="font-size: 12px" />
											&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="reset" value="取消" style="font-size: 12px" />
											&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="submit" onclick="return close1()" value="关闭"
												style="font-size: 12px" />
										</td>
									</tr>
								</table>

							</form>
							<!-- 添加结束 -->

				
				
			
			     </div>


			</div>
			</div>
	

			<!--页面尾巴开始-->
			<div id="footer">
				&copy;版权所有 广东高力特节能科技服务有限公司
			</div>
			<!--页面尾巴结束-->
		</div>
		
	</body>
</html>
