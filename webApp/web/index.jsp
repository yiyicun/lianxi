<%@ page language="java" pageEncoding="UTF-8"%>
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

  <link rel="StyleSheet" type="text/css" href="css/all.css" />
  <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

  <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
  <script type="text/javascript" src="js/jquery.form.js"></script>
  <script type="text/javascript" src="js/directory.js"></script>
  <script type="text/javascript" src="js/ddsmoothmenu.js"></script>
  <script type="text/javascript" src="js/add.js"></script>




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

    <form  id="fomr2" name="form2"  method="post">
      <br />输入session:
      <input type="text" id="dandansession" name="dandansession" style="width:400px;">
      <input type="button"  style="padding:2px;" value="添加蛋蛋数据" onclick='javascript: pcdandanAdd(document.getElementById("dandansession").value);'>
    </form>

    <form  id="fomr4" name="form4"  method="post">
      <br />输入session:
      <input type="text" id="zhimaxixi_kuaileSession" name="zhimaxixi_kuaileSession"  style="width:400px;">
      <input type="button"  style="padding:2px;" value="添加芝麻西西幸运28数据" onclick='javascript: zhiMaXiXi_ebAdd(document.getElementById("zhimaxixi_kuaileSession").value);'>
      <br />
    </form>

    <form  id="fomr5" name="form5"  method="post">
      <br />输入session:
      <input type="text" id="zhiMaXiXiAdd_klebSession" name="zhiMaXiXiAdd_klebSession"  style="width:400px;">
      <input type="button"  style="padding:2px;" value="添加芝麻西西快乐28数据" onclick='javascript: zhiMaXiXiAdd_klebAdd(document.getElementById("zhiMaXiXiAdd_klebSession").value);'>
      <br />
    </form>

    <form  id="fomr1" name="form1"  method="post">
      <br />输入session:<input type="text" id="jndsession" name="jndsession" style="width:400px;">
      <input type="button"  style="padding:2px;" value="添加梦想加拿大28数据" onclick='javascript: mengxiang_jndAdd();'>
      <br />
    </form>


    <form  id="fomr7" name="form7"  method="post">
      <br />输入session:<input type="text" id="pksession" name="pksession" style="width:400px;">
      <input type="button"  style="padding:2px;" value="添加PK10数据" onclick='javascript: zhiMaXiXiAdd__pkAdd();'>
      <br />
    </form>

    <form  id="fomr8" name="form8"  method="post">
      <br />输入session:<input type="text" id="xyzsession" name="xyzsession" style="width:400px;">
      <input type="button"  style="padding:2px;" value="添加幸运猪急速28数据" onclick='javascript: xyz_jsebAdd();'>
      <br />
    </form>

    <form  id="fomr10" name="form10"  method="post">
      <br />输入session:<input type="text" id="douwansession" name="douwansession" style="width:400px;">
      <input type="button"  style="padding:2px;" value="添加豆玩急速28数据" onclick='javascript: douwan_jsebAdd();'>
      <br />
    </form>


    <form  id="fomr6" name="form4"  method="post">
      <br />输入session:<input type="text" id="gbsession" name="gbsession" style="width:400px;">
      <input type="button"  style="padding:2px;" value="添加给币急速28数据" onclick='javascript: gibi_jsebAdd();'>
      <br />
    </form>

    <br />
    <div style="text-align:center;margin:5px 5px 5px 160px">
      <input type="button"  style="padding:2px;" value="添加北京快乐8数据" onclick='javascript:kuaile_Add();'>
    </div>




    <div style="text-align:left;margin:5px 5px 5px 20px">
      <input type="button"  style="padding:2px;" value="检查更新" onclick='javascript:check(); '>
      <input type="text"  id="timeFlat" style="width:400px;margin-left:10px;border:0px;padding:2px;display:none;"  />
    </div>




  </div>

</div>
</body>
</html>
