function check() {
	$.ajax( {
		url : "lastTime",
		type : "post",
		dataType : "json",
		success : checkResult,
		error : function() {
			alert("error");
		}
	});
}

//增加PK10
function addPK10() {

	var options = {
		type : "post",
		url : "addeePK",
		dataType : "json",
		success : settree,
		error : function() {
			alert("error");
		}
	};

	$('#fomr3').ajaxSubmit(options);

}

function settree(json, type) {

	if (json == 1) {

		alert("添加成功");
	} else if (json == 0) {

		alert("数据已是最新");
	} else {

		alert("添加失败");
	}
}

function zmandmx() {

	var zm = $('#zmString').val();
	var mx = $('#mxString').val();

	$.ajax( {
		url : "duiBiZmAndMx",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zm,
			"mxString" : mx
		},
		success : zmAndmxresult,
		error : function() {
			alert("error");
		}
	});
}

function zmAndmxresult(msg) {
	alert("芝麻和梦想" + msg);
}

function mxandguguo() {

	var mx = $('#mxString').val();
	var guguo = $('#ggString').val();

	$.ajax( {
		url : "duiBiMxAndGuguo",
		type : "post",
		dataType : "json",
		data : {
			"ggString" : guguo,
			"mxString" : mx
		},
		success : mxandguguoresult,
		error : function() {
			alert("error");
		}
	});

}

//加拿大 
function mxzmjnd() {

	var mx = $('#mxString').val();
	var zm = $('#zmString').val();

	$.ajax( {
		url : "duiBiMxAndZmJnd",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zm,
			"mxString" : mx
		},
		success : mxandguguoresult,
		error : function() {
			alert("error");
		}
	});

}

//芝麻维多利亚加拿大 28
function zmwdlyjnd28() {

	var wdly = $('#wdlyString').val();
	var zm = $('#zmString').val();

	$.ajax( {
		url : "duiBiZmAndWdlyJnd",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zm,
			"wlyaString" : wdly
		},
		success : zmwdlyjnd28result,
		error : function() {
			alert("error");
		}
	});

}

//芝麻梦想加拿大16
function mxzmjnd16() {

	var mx = $('#mxString').val();
	var zm = $('#zmString').val();

	$.ajax( {
		url : "duiBiMxAndZmJndsl",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zm,
			"mxString" : mx
		},
		success : mxzmjnd16result,
		error : function() {
			alert("error");
		}
	});

}

//咕果梦想加拿大 16
function mxguguojnd16() {

	var mx = $('#mxString').val();
	var gg = $('#ggString').val();

	$.ajax( {
		url : "duiBiMxAndGuguoJndsl",
		type : "post",
		dataType : "json",
		data : {
			"ggString" : guguo,
			"mxString" : mx
		},
		success : mxguguojnd16result,
		error : function() {
			alert("error");
		}
	});
}

//咕果蛋蛋乐园北京28
function guoguodandanbj28() {

	var mx = $('#mxString').val();
	var ggString = $('#ggString').val();
	var ddString = $('#ddString').val();
	$.ajax( {
		url : "duiBiGuguoAndDanDan",
		type : "post",
		dataType : "json",
		data : {
			"ggString" : ggString,
			"ddString" : ddString
		},
		success : guoguodandanBj28result,
		error : function() {
			alert("error");
		}
	});
}

//芝麻咕果北京28
function zmguguobj28() {

	var ggString = $('#ggString').val();
	var zmString = $('#zmString').val();
	$.ajax( {
		url : "duiBiZmAndGuguo",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"ggString" : ggString
		},
		success : zmguguobj28result,
		error : function() {
			alert("error");
		}
	});
}

//给币EEpc
function gbeepc() {

	var yiyiString = $('#yiyiString').val();
	var gbString = $('#gbString').val();
	$.ajax( {
		url : "duiBiGeiBiAndEePC",
		type : "post",
		dataType : "json",
		data : {
			"gbString" : gbString,
			"eeString" : yiyiString
		},
		success : gbeepcresult,
		error : function() {
			alert("error");
		}
	});
}

//给币EEpc
function gbeeJnd28() {

	var yiyiString = $('#yiyiString').val();
	var gbString = $('#gbString').val();
	$.ajax( {
		url : "duiBiGeiBiAndEeJndeb",
		type : "post",
		dataType : "json",
		data : {
			"gbString" : gbString,
			"eeString" : yiyiString
		},
		success : gbeeJndresult,
		error : function() {
			alert("error");
		}
	});
}

//芝麻EE加拿大28
function zmeejnd28() {

	var yiyiString = $('#yiyiString').val();
	var zmString = $('#zmString').val();
	$.ajax( {
		url : "duiBiZmAndEeJnd",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"eeString" : yiyiString
		},
		success : zmeejnd28result,
		error : function() {
			alert("error");
		}
	});
}

//芝麻EE加拿大16
function zmeejnd16() {

	var yiyiString = $('#yiyiString').val();
	var zmString = $('#zmString').val();
	$.ajax( {
		url : "duiBiZmAndEeJndslAction",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"eeString" : yiyiString
		},
		success : zmeejnd16result,
		error : function() {
			alert("error");
		}
	});
}








//得胜豆玩pc28
function dsdwPc28() {
	var dsString = $('#dsString').val();
	var dwString = $('#dwString').val();
	$.ajax( {
		url : "duiBiDsAndDwPc",
		type : "post",
		dataType : "json",
		data : {
			"dwString" : dwString,
			"dsString" : dsString
		},
		success : dsStringResult(),
		error : function() {
			alert("error");
		}
	});
}


//得胜豆玩北京28
function dsdwJnd28() {
	var dsString = $('#dsString').val();
	var dwString = $('#dwString').val();
	$.ajax( {
		url : "duiBiDsAndDwJnd",
		type : "post",
		dataType : "json",
		data : {
			"dwString" : dwString,
			"dsString" : dsString
		},
		success : dsStringResult(),
		error : function() {
			alert("error");
		}
	});
}



//芝麻豆玩北京28
function zmdwBj28() {

	var zmString = $('#zmString').val();
	var dwString = $('#dwString').val();
	$.ajax( {
		url : "zmdwBj28",
		type : "post",
		dataType : "json",
		data : {
			"dwString" : dwString,
			"zmString" : zmString
		},
		success : zmdwBj28Result(),
		error : function() {
			alert("error");
		}
	});
}

//芝麻豆玩北京16
function zmdwBj16() {

	var zmString = $('#zmString').val();
	var dwString = $('#dwString').val();
	$.ajax( {
		url : "zmdwBj16",
		type : "post",
		dataType : "json",
		data : {
			"dwString" : dwString,
			"zmString" : zmString
		},
		success : zmdwBj16Result(),
		error : function() {
			alert("error");
		}
	});
}

//芝麻豆玩加拿大28
function zmdwJnd28() {

	var zmString = $('#zmString').val();
	var dwString = $('#dwString').val();
	
	$.ajax( {
		url : "zmdwJnd28",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"dwString" : dwString
		},
		success : settree,
		error : function() {
			alert("error");
		}
	});
	
	
	
}

//芝麻豆玩加拿大16
function zmdwJnd16() {

	var zmString = $('#zmString').val();
	var dwString = $('#dwString').val();
	
	$.ajax( {
		url : "zmdwJnd16",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"dwString" : dwString
		},
		success : settree,
		error : function() {
			alert("error");
		}
	});
	
	
}

//幸运猪豆玩北京28
function xyzdwBj28() {

	var xyzString = $('#xyzString').val();
	var dwString = $('#dwString').val();
	
	$.ajax( {
		url : "xyzdwBj28",
		type : "post",
		dataType : "json",
		data : {
			"xyzString" : xyzString,
			"dwString" : dwString
		},
		success : settree,
		error : function() {
			alert("error");
		}
	});
	
	
	
}

//幸运猪豆玩加拿大28
function xyzdwPc28() {

	var xyzString = $('#xyzString').val();
	var dwString = $('#dwString').val();
	
	$.ajax( {
		url : "xyzdwPc28",
		type : "post",
		dataType : "json",
		data : {
			"xyzString" : xyzString,
			"dwString" : dwString
		},
		success : settree,
		error : function() {
			alert("error");
		}
	});
	
	
	
}

//幸运猪豆玩加拿大28
function xyzdwJnd28() {

	var xyzString = $('#xyzString').val();
	var dwString = $('#dwString').val();
	
	$.ajax( {
		url : "xyzdwJnd28",
		type : "post",
		dataType : "json",
		data : {
			"xyzString" : xyzString,
			"dwString" : dwString
		},
		success : settree,
		error : function() {
			alert("error");
		}
	});
	
	
	
}

//给币豆玩加拿大28
function gbdwJnd28() {

	var gbString = $('#gbString').val();
	var dwString = $('#dwString').val();
	

	
	var options = {
			type : "post",
			url : "gbAndDwJnd28",
			dataType : "json",
			success : settree,
			error : function() {
				alert("error");
			}
		};

	$('#formdou').ajaxSubmit(options);
	
	
	
}

//给币豆玩加拿大16
function gbdwJnd16() {

	var gbString = $('#gbString').val();
	var dwString = $('#dwString').val();
	
	var options = {
			type : "post",
			url : "gbAndDwJnd16",
			dataType : "json",
			success : settree,
			error : function() {
				alert("error");
			}
		};

	$('#formdou').ajaxSubmit(options);
}

//给币豆玩加拿大16
function gbdwpc28() {

	var gbString = $('#gbString').val();
	var dwString = $('#dwString').val();
	$.ajax( {
		url : "gbAndDwPc28",
		type : "post",
		dataType : "json",
		data : {
			"gbString" : gbString,
			"dwString" : dwString
		},
		success : gbdwPc28result,
		error : function() {
			alert("error");
		}
	});
}

//芝麻咕果加拿大28
function zmguguojnd28() {

	var ggString = $('#ggString').val();
	var zmString = $('#zmString').val();
	$.ajax( {
		url : "duiBiZmAndGuguoJnd",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"ggString" : ggString
		},
		success : zmguguojnd28result,
		error : function() {
			alert("error");
		}
	});
}

//芝麻维多利亚加拿大28
function duibiZmAndWdlyBj28() {

	var gbString = $('#gbString').val();
	var zmString = $('#zmString').val();
	$.ajax( {
		url : "duibiZmgbJnd16duibiZmgbJnd16",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"gbString" : gbString
		},
		success : zmgbjnd16result,
		error : function() {
			alert("error");
		}
	});
}

//芝麻维多利亚加拿大28
function duibiZmAndWdlyBj28() {

	var wlyaString = $('#wdlyString').val();
	var zmString = $('#zmString').val();
	$.ajax( {
		url : "duibiZmAndWdlyBj28",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"wlyaString" : wlyaString
		},
		success : zmguguobj28result,
		error : function() {
			alert("error");
		}
	});
}

//芝麻丁豆北京28
function zmddzm28() {

	var ddString = $('#ddString').val();
	var zmString = $('#zmString').val();
	$.ajax( {
		url : "duibiZmAndDingdouBj28",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"ddString" : ddString
		},
		success : zmddbj28result,
		error : function() {
			alert("error");
		}
	});
}

//芝麻丁豆加拿大28
function zmddjnd28() {

	var ddString = $('#ddString').val();
	var zmString = $('#zmString').val();
	$.ajax( {
		url : "duibiZmAndDingdouJnd28",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"ddString" : ddString
		},
		success : zmddjnd28result,
		error : function() {
			alert("error");
		}
	});
}

function zmguguojnd16() {

	var ggString = $('#ggString').val();
	var zmString = $('#zmString').val();
	$.ajax( {
		url : "duiBiZmAndGuguoJndsl",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"ggString" : ggString
		},
		success : zmguguojnd16result,
		error : function() {
			alert("error");
		}
	});
}

//单投北京28-芝麻
function kleb() {

	var zmString = $('#zmString').val();
	$.ajax( {
		url : "dantouZmKleb",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString
		},
		success : dantouZmKlebresult,
		error : function() {
			alert("error");
		}
	});

}

//单投北京28-芝麻
function klxyeb() {

	var zmString = $('#zmString').val();
	$.ajax( {
		url : "dantouZmXyeb",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString
		},
		success : dantouZmKlebresult,
		error : function() {
			alert("error");
		}
	});

}

//单投加拿大28-咿咿
function jndDantou() {

	var yiyiString = $('#yiyiString').val();

	$.ajax( {
		url : "dantouJndebYiyi",
		type : "post",
		dataType : "json",
		data : {
			"yiyiString" : yiyiString
		},
		success : jndDantouresult,
		error : function() {
			alert("error");
		}
	});

}

//单投急速28-咿咿
function jsebDantou() {

	var yiyiString = $('#yiyiString').val();

	$.ajax( {
		url : "dantouJsebYiyi",
		type : "post",
		dataType : "json",
		data : {
			"yiyiString" : yiyiString
		},
		success : jndDantouresult,
		error : function() {
			alert("error");
		}
	});

}


//单投豆玩急速28
function dwjsebDantou() {

	var dwString = $('#dwString').val();

	$.ajax( {
		url : "dantouJsebYiyi",
		type : "post",
		dataType : "json",
		data : {
			"dwString" : dwString
		},
		success : jndDantouresult,
		error : function() {
			alert("error");
		}
	});

}

//单投豆玩加拿大28
function dwjndDantou() {

	var dwString = $('#dwString').val();
	var type = $('#type').val();
	console.info(type);
	$.ajax( {
		url : "dwjnd28Dantou",
		type : "post",
		dataType : "json",
		data : {
			"dwString" : dwString,
			"type":type
		},
		success : jndDantouresult,
		error : function() {
			alert("error");
		}
	});

}

//单投幸运猪急速28
function xyzsebDantou() {

	var xyzString = $('#xyzString').val();
	$.ajax( {
		url : "xyzsebDantou",
		type : "post",
		dataType : "json",
		data : {
			"xyzString" : xyzString
		},
		success : xyzDantouresult,
		error : function() {
			alert("error");
		}
	});
}

//单投丁豆猪急速28
function ddjsebDantou() {

	var ddString = $('#ddString').val();
	$.ajax( {
		url : "ddjsebDantou",
		type : "post",
		dataType : "json",
		data : {
			"ddString" : ddString
		},
		success : ddDantouresult,
		error : function() {
			alert("error");
		}
	});
}

//单投豆玩急速28
function dwjsebDantou() {

	var dwString = $('#dwString').val();
	$.ajax( {
		url : "dwjsebDantou",
		type : "post",
		dataType : "json",
		data : {
			"dwString" : dwString
		},
		success : ddDantouresult,
		error : function() {
			alert("error");
		}
	});
}

//单投PK10-咿咿
function eepk10antou() {

	var yiyiString = $('#yiyiString').val();

	$.ajax( {
		url : "yiyiPK10",
		type : "post",
		dataType : "json",
		data : {
			"yiyiString" : yiyiString
		},
		success : jndDantouresult,
		error : function() {
			alert("error");
		}
	});

}

//单投急速28-给币
function gbJsebDantou() {

	var geibiString = $('#gbString').val();

	$.ajax( {
		url : "dantouJsebGeiBi",
		type : "post",
		dataType : "json",
		data : {
			"geibiString" : geibiString
		},
		success : geibiJsebresult,
		error : function() {
			alert("error");
		}
	});

}

//芝麻给币加拿大28
function zmgbJnd28() {

	var gbString = $('#gbString').val();
	var zmString = $('#zmString').val();

	$.ajax( {
		url : "zmgbJnd28",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"geibiString" : gbString
		},
		success : zmgbJnd28result,
		error : function() {
			alert("error");
		}
	});

}

//芝麻给币北京16
function zmgbBj16() {

	var gbString = $('#gbString').val();
	var zmString = $('#zmString').val();

	$.ajax( {
		url : "zmgbBj16",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"geibiString" : gbString
		},
		success : zmgbbj16result,
		error : function() {
			alert("error");
		}
	});

}

//芝麻给币加拿大16
function zmgbJnd16() {

	var gbString = $('#gbString').val();
	var zmString = $('#zmString').val();

	$.ajax( {
		url : "duibiZmgbJnd16",
		type : "post",
		dataType : "json",
		data : {
			"zmString" : zmString,
			"geibiString" : gbString
		},
		success : zmgbJnd16result,
		error : function() {
			alert("error");
		}
	});

}

//单投PK10冠军-给币
function gbPK10GJDantou() {

	var geibiString = $('#gbString').val();

	$.ajax( {
		url : "dantouGeiBiPK10GJ",
		type : "post",
		dataType : "json",
		data : {
			"geibiString" : geibiString
		},
		success : gbPK10GJDantouresult,
		error : function() {
			alert("error");
		}
	});

}

function clearZmString() {
	$('#zmString').val("");
}

function clearWdlyString() {
	$('#wdlyString').val("");
}

function clearMxString() {
	$('#mxString').val("");
}

function clearGuguoString() {
	$('#ggString').val("");
}

function clearddString() {
	$('#ddString').val("");
}

function clearYiyiString() {
	$('#yiyiString').val("");
}

function clearGeibiString() {
	$('#gbString').val("");
}

function clearxyzString() {
	$('#xyzString').val("");
}

function clearDouwanString() {
	$('#dwString').val("");
}


function cleardsString() {
	$('#dsString').val("");
}


function gbeepcresult(msg) {
	alert("启动" + msg);
}

function gbeeJndresult(msg) {
	alert("启动" + msg);
}

function xyzDantouresult(msg) {
	alert("启动" + msg);
}

function gbPK10GJDantouresult(msg) {
	alert("启动" + msg);
}

function mxzmjnd16result(msg) {
	alert("启动" + msg);
}

function geibiJsebresult(msg) {
	alert(msg);
}

function dantouZmKlebresult(msg) {
	alert("结果:" + msg);
}

function jndDantouresult(msg) {
	//alert("结果:"+msg);
}

function mxandguguoresult(msg) {
	alert("梦想和芝麻加拿大28" + msg);
}

function ddDantouresult(msg) {
	alert("丁豆网急速28" + msg);
}

function mxzmjnd16result(msg) {
	alert("梦想和芝麻加拿大16" + msg);
}

function guoguodandanBj28result(msg) {
	alert("咕果和蛋蛋乐园 北京28" + msg);
}

function zmwdlyjnd28result(msg) {
	alert("维多利亚和芝麻加拿大28" + msg);
}

function zmeejnd28result(msg) {
	alert("梦想和ee加拿大28" + msg);
}

function zmeejnd16result(msg) {
	alert("梦想和ee加拿大16" + msg);
}

function zmguguobj28result(msg) {
	alert("梦想和咕果 北京28" + msg);
}

function zmguguojnd28result(msg) {
	alert("梦想和咕果加拿大28" + msg);
}

function zmguguojnd16result(msg) {
	alert("梦想和咕果加拿大16" + msg);
}

function zmddbj28result(msg) {
	alert("芝麻和丁豆北京28" + msg);
}

function zmddjnd28result(msg) {
	alert("芝麻和丁豆加拿大28" + msg);
}

function zmguguobj28result(msg) {

	alert("芝麻和北京28" + msg);

}

function zmgbJnd28result(msg) {

	alert("芝麻和给币加拿大28" + msg);

}

function zmgbJnd16result(msg) {

	alert("芝麻和给币加拿大16" + msg);

}
function zmgbbj16result(msg) {

	alert("芝麻和给币北京16" + msg);

}

function dsStringResult(msg) {

	alert("得胜和豆玩加拿大28" + msg);

}



function gbdwJnd28result(msg) {

	alert("给币和豆玩加拿大28" + msg);

}

function gbdwPc28result(msg) {

	alert("给币和豆玩pc28" + msg);

}

function gbdwJnd16result(msg) {

	alert("给币和豆玩加拿大16" + msg);

}

function changeFlat(a) {

	var ss = "";
	var flat = 0;
	if (a == 1) {
		ss = "zmAndmx";
	} else if (a == 2) {
		ss = "zmAndmxjnd28";
	} else if (a == 3) {
		ss = "zmAndmxjnd16";
	} else if (a == 4) {
		ss = "zmguguobj28";
	} else if (a == 5) {
		ss = "zmguguojnd28";
	} else if (a == 6) {
		ss = "zmguguojnd16";
	} else if (a == 7) {
		var s = $('#stop_ee_jseb').val();
		if (s == "停止急速28") {
			$('#stop_ee_jseb').val("恢复急速28");
			flat == 0;
		} else {
			$('#stop_ee_jseb').val("停止急速28");
			flat = 1;
		}
		ss = "eejs28";
	} else if (a == 8) {
		var s = $('#stop_ee_jnd').val();
		if (s == "停止加拿大28") {
			$('#stop_ee_jnd').val("恢复加拿大28");
			flat == 0;
		} else {
			$('#stop_ee_jnd').val("停止加拿大28");
			flat = 1;
		}
		ss = "eejnd28";
	} else if (a == 9) {
		var s = $('#stop_zm_kl').val();
		if (s == "停止快乐28") {
			$('#stop_zm_kl').val("恢复快乐28");
			flat == 0;
		} else {
			$('#stop_zm_kl').val("停止快乐28");
			flat = 1;
		}
		ss = "zmkleb";
	} else if (a == 10) {
		var s = $('#stop_zm_xy').val();
		if (s == "停止幸运28") {
			$('#stop_zm_xy').val("恢复幸运28");
			flat == 0;
		} else {
			$('#stop_zm_xy').val("停止幸运28");
			flat = 1;
		}
		ss = "zmbjeb";
	} else if (a == 11) {
		var s = $('#stop_gb_jseb').val();
		if (s == "停止幸运28") {
			$('#stop_gb_jseb').val("恢复幸运28");
			flat = 0;
		} else {
			$('#stop_gb_jseb').val("停止幸运28");
			flat = 1;
		}
		ss = "gbjeb";

	} else if (a == 13) {
		ss = "gbeepc";

	} else if (a == 14) {
		ss = "gbeeJnd28";

	} else if (a == 15) {

		var s = $('#stop_gb_pk10gj').val();
		if (s == "停止单投PK10冠军") {
			$('#stop_gb_jseb').val.info("单投PK10冠军");
			flat = 0;
		} else {
			$('#stop_gb_jseb').val("停止单投PK10冠军");
			flat = 1;
		}
		ss = "gbpk10gj";

	} else if (a == 17) {

		var s = $('#stop_ee_pk10').val();
		if (s == "停止pk10") {
			$('#stop_ee_pk10').val.info("单投pk10");
			flat = 0;
		} else {
			$('#stop_ee_pk10').val("停止pk10");
			flat = 1;
		}
		ss = "eepk10gj";

	} else if (a == 18) {

		var s = $('#stop_xyz_jseb').val();
		if (s == "停止急速28") {
			$('#stop_xyz_jseb').val("恢复急速28");
			flat = 0;
		} else {
			$('#stop_xyz_jseb').val("停止急速28");
			flat = 1;
		}
		ss = "xyzjs28";

	} else if (a == 19) {

		var s = $('#stop_dd_jseb').val();
		if (s == "停止急速28") {
			$('#stop_dd_jseb').val("恢复急速28");
			flat = 0;
		} else {
			$('#stop_dd_jseb').val("停止急速28");
			flat = 1;
		}
		ss = "ddjs28";
	} else if (a == 19) {

		ss = "zmwdlyjnd28";

	} else if (a == 22) {

		ss = "zmddbj28";

	} else if (a == 23) {

		ss = "zmddjnd28";

	} else if (a == 24) {

		ss = "zmwdlybj28";
	} else if (a == 25) {

		ss = "zmgbjnd28";
	} else if (a == 26) {

		ss = "zmgbBj16";
	} else if (a == 27) {

		ss = "zmgbJnd16";

	} else if (a == 40) {

		var s = $('#stop_dw_jseb').val();
		if (s == "停止急速28") {
			$('#stop_dw_jseb').val("恢复急速28");
			flat = 0;
		} else {
			$('#stop_dw_jseb').val("停止急速28");
			flat = 1;
		}
		ss = "dwjs28";
	} else if (a == 41) {

		ss = "zmdwBj28";

	} else if (a == 42) {

		ss = "zmdwBj16";

	} else if (a == 43) {

		ss = "zmdwJnd28";

	} else if (a == 44) {

		ss = "zmdwJnd16";
	} else if (a == 45) {

		var s = $('#stop_dw_jnd').val();
		if (s == "停止加拿大28") {
			$('#stop_dw_jnd').val("恢复加拿大28");
			flat = 0;
		} else {
			$('#stop_dw_jnd').val("停止加拿大28");
			flat = 1;
		}
		ss = "dwjnd28";
	
		
	} else if (a == 61) {

		ss = "dsdwPc";


	} else if (a == 64) {

		ss = "dsdwJnd28";

	}

	$.ajax( {
		url : "changeTimer",
		type : "post",
		data : {
			"gaibian" : ss,
			"flat" : flat
		},
		success : gaibianresult,
		error : function() {
			alert("error");
		}
	});
}

function zmdwBj28Result(ss) {
	alert(ss);

}

function zmdwBj16Result(ss) {
	alert(ss);

}

function zmdwJnd28Result(ss) {
	alert(ss);

}

function zmdwJnd16Result(ss) {
	alert(ss);

}

function gaibianresult(msg) {

	alert(msg);
}

//单投急速28-给币
function beishu() {

	var dwjsebbeishu = $('#dwjsebbeishu').val();

$.ajax({
	url : "changeBeishu",
	type : "post",
	dataType : "json",
	data : {
		"beiflat" : dwjsebbeishu,
		"ss": "dwjs28"
	},
	success : zmAndmxresult,
	error : function() {
		alert("error");
	}
});


}
//单投急速28-给币
function beishuJnd() {

	var dwjndbeishu = $('#dwjndbeishu').val();
	
$.ajax({
	url : "changeBeishu",
	type : "post",
	dataType : "json",
	data : {
		"beiflatJnd28" : dwjndbeishu,
		"ss": "dwjnd28",
		"type": "type"
	},
	success : zmAndmxresult,
	error : function() {
		alert("error");
	}
});





}