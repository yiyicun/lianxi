function letuadd(session){
	
    	$.ajax({
     				url:"letuadd",
     			    type: "post",
     			    dataType: "json",
     				success:letusettree,
					error: function(){alert("error");}
    			    });
}

function mengxiang_jndAdd(session) {

//	$.ajax({
//			url:"jndAdd",
//		    type: "post",
//		    dataType: "json",
//		    data: {session:"session"},
//			success:mengxiangjndsettree,
//		error: function(){alert("error");}
//	    });
//	
	
		var options = {
				type: "post",
				url: "jndAdd",
				dataType: "json",
				success: mengxiangjndsettree
		};
		
		$('#fomr1').ajaxSubmit(options); 
	
	
}

function doudouAdd(session){

    	$.ajax({
     				url:"doudouAdd",
     			    type: "post",
     			    dataType: "json",
     			    data: "session="+session,
     				success:doudousettree,
					error: function(){alert("error");}
    			    });

}

function pcdandanAdd(session){
    	
    	var options = {
				type: "post",
				url: "pcdandanAdd",
				dataType: "json",
				success: settree,
				error: function(){alert("error");}
		};
		
		$('#fomr2').ajaxSubmit(options); 
}


function yiyi_jsebAdd(session){
	
	var options = {
			type: "post",
			url: "yiyiAdd",
			dataType: "json",
			success: settree,
			error: function(){alert("error");}
	};
	
	$('#fomr3').ajaxSubmit(options); 
}

function xyz_jsebAdd(session){
	
	var options = {
			type: "post",
			url: "xyzAdd",
			dataType: "json",
			success: settree,
			error: function(){alert("error");}
	};
	
	$('#fomr8').ajaxSubmit(options); 
}

function dingdou_jsebAdd(session){
	
	var options = {
			type: "post",
			url: "dingdouAdd",
			dataType: "json",
			success: settree,
			error: function(){alert("error");}
	};
	
	$('#fomr9').ajaxSubmit(options); 
}


function douwan_jsebAdd(session){
	
	var options = {
			type: "post",
			url: "douwanAdd",
			dataType: "json",
			success: settree,
			error: function(){alert("error");}
	};
	
	$('#fomr10').ajaxSubmit(options); 
}


function gibi_jsebAdd(session){
	
	var options = {
			type: "post",
			url: "geibiAdd",
			dataType: "json",
			success: settree,
			error: function(){alert("error");}
	};
	
	$('#fomr6').ajaxSubmit(options); 
}


function zhiMaXiXi_ebAdd(session){
    	
    	var options = {
    			type: "post",
    			url: "zhiMaXiXiAdd",
    			dataType: "json",
    			 data: "session="+session,
    			success: settree,
    			error: function(){alert("error");}
    	};
    	
    	$('#fomr4').ajaxSubmit(options); 	
}

function zhiMaXiXiAdd_klebAdd(session){
	
	var options = {
			type: "post",
			url: "zhiMaXiXiAdd_kleb",
			dataType: "json",
			 data: "session="+session,
			success: settree,
			error: function(){alert("error");}
	};
	
	$('#fomr5').ajaxSubmit(options); 	
	

}

function zhiMaXiXiAdd__pkAdd(session){
	
	var options = {
			type: "post",
			url: "zhiMaXiXiAdd_pk10",
			dataType: "json",
			 data: "session="+session,
			success: settree,
			error: function(){alert("error");}
	};
	
	$('#fomr7').ajaxSubmit(options); 	
	

}




//乐乐厅急速28
function leleting_JiSuErBaAdd(session){
    	$.ajax({
     				url:"leleting_JiSuErBa",
     			    type: "post",
     			    dataType: "json",
     			    data: "session="+session,
     				success:leleting_JiSuErBaResult,
					error: function(){alert("error");}
    			    });
}

//快乐8
function kuaile_Add(){
	$.ajax({
		url:"kuaileEB",
		type: "post",
		dataType: "json",
		success:kuaile_Result,
		error: function(){alert("error");}});
}

function leleting_kuaileAdd(session){
	$.ajax({
 				url:"leleting_kuaileAdd",
 			    type: "post",
 			    dataType: "json",
 			    data: "session="+session,
 				success:leleting_kuaileResult,
				error: function(){alert("error");}
			    });
}

function galadouAdd(){
   $.ajax({
     	url:"galadouAdd",
     	type: "post",
     	dataType: "json",
     	success:settree,
		error: function(){alert("error");}
   });
}

function check() {
	  $.ajax({
	     	url:"lastTime",
	     	type: "post",
	     	dataType: "json",
	     	success:checkResult,
			error: function(){alert("error");}
	   });
}

function checkResult(json) {
	
	$('#timeFlat').css("display","none");
	var result = "";
	var flat = 0;
	if(json[0].pcdandan != 0 ) {
		result = "pc未更新"+json[0].pcdandan+"天";
		flat = 1 ;
	}

	if(json[0].zhimaxixi != 0 ) {
		result = "芝麻西西幸运28未更新"+json[0].zhimaxixi+"天";
		flat = 1 ;
	}
	
	
	if(json[0].zhima_kl != 0 ) {
		result = "芝麻西西快乐28未更新"+json[0].zhima_kl+"天";
		flat = 1 ;
	}
	
	if(json[0].kuaile != 0 ) {
		result = "北京快乐8未更新"+json[0].kuaile+"天";
		flat = 1 ;
	}
	
	if(json[0].mengxiangeb != 0 ) {
		result = "梦想加拿大28未更新"+json[0].mengxiangeb+"天";
		flat = 1 ;
	}
	
	
	if(flat == 0 ){
		$('#timeFlat').css("display","inline");
		$('#timeFlat').val("所有数据已最新");
	} else {
		$('#timeFlat').css("display","inline");
		$('#timeFlat').val(result);
	}
	
}

function letusettree(json){
  

    if(json[0].leturesultString == "letuerba" ){
      alert("乐途28添加失败");
    } 
    
    
    if(json[0].kaixinresultString == "letukaixin" ){
      alert("乐途开心添加失败");
    } else {
      alert("添加成功");
    }
}



function doudousettree(json){
  

    if(json[0].doudouerbaresult == "doudouerba" ){
      alert("豆豆28添加失败");
    } 
    
    if(json[0].doudoukaixinresult == "doudoukaixin" ){
      alert("豆豆开心添加失败");
    } else{
      alert("添加成功");
    }
}

function zhima_klebsettree(json) {
	
	 if(json[0].result > 0){
		    
	      alert("添加成功");
	 } else if(json[0].result == 0){
	    
	      alert("数据已是最新");
	 } else if(json[0].result == -1){
	    
	      alert("添加失败");
	 }
	
}
function settree(json,type){

    if(json[0].result == 1){
    
      alert("添加成功");
   }
   else if(json[0].result == 0){
    
      alert("数据已是最新");
   }else {
    
      alert("添加失败");
   }
}

function leleting_kuaileResult(json){

    if(json[0].result == 1){
    
      alert("添加成功");
   }
   else if(json[0].result == 0){
    
      alert("数据已是最新");
   }else {
    
      alert("添加失败");
   }
}

function leleting_JiSuErBaResult(json){

    if(json[0].result == 1){
    
      alert("添加成功");
   }
   else if(json[0].result == 0){
    
      alert("数据已是最新");
   }else {
    
      alert("添加失败");
   }
}


function kuaile_Result(json){

   if(json[0].result == 0){
      alert("添加成功");
   } else {
      alert("添加失败");
   }
}


function mengxiangjndsettree(json){

   if(json[0].result == 0){
	  
   } else {
     
   }
}

