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




//???????????????28
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

//??????8
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
		result = "pc?????????"+json[0].pcdandan+"???";
		flat = 1 ;
	}

	if(json[0].zhimaxixi != 0 ) {
		result = "??????????????????28?????????"+json[0].zhimaxixi+"???";
		flat = 1 ;
	}
	
	
	if(json[0].zhima_kl != 0 ) {
		result = "??????????????????28?????????"+json[0].zhima_kl+"???";
		flat = 1 ;
	}
	
	if(json[0].kuaile != 0 ) {
		result = "????????????8?????????"+json[0].kuaile+"???";
		flat = 1 ;
	}
	
	if(json[0].mengxiangeb != 0 ) {
		result = "???????????????28?????????"+json[0].mengxiangeb+"???";
		flat = 1 ;
	}
	
	
	if(flat == 0 ){
		$('#timeFlat').css("display","inline");
		$('#timeFlat').val("?????????????????????");
	} else {
		$('#timeFlat').css("display","inline");
		$('#timeFlat').val(result);
	}
	
}

function letusettree(json){
  

    if(json[0].leturesultString == "letuerba" ){
      alert("??????28????????????");
    } 
    
    
    if(json[0].kaixinresultString == "letukaixin" ){
      alert("????????????????????????");
    } else {
      alert("????????????");
    }
}



function doudousettree(json){
  

    if(json[0].doudouerbaresult == "doudouerba" ){
      alert("??????28????????????");
    } 
    
    if(json[0].doudoukaixinresult == "doudoukaixin" ){
      alert("????????????????????????");
    } else{
      alert("????????????");
    }
}

function zhima_klebsettree(json) {
	
	 if(json[0].result > 0){
		    
	      alert("????????????");
	 } else if(json[0].result == 0){
	    
	      alert("??????????????????");
	 } else if(json[0].result == -1){
	    
	      alert("????????????");
	 }
	
}
function settree(json,type){

    if(json[0].result == 1){
    
      alert("????????????");
   }
   else if(json[0].result == 0){
    
      alert("??????????????????");
   }else {
    
      alert("????????????");
   }
}

function leleting_kuaileResult(json){

    if(json[0].result == 1){
    
      alert("????????????");
   }
   else if(json[0].result == 0){
    
      alert("??????????????????");
   }else {
    
      alert("????????????");
   }
}

function leleting_JiSuErBaResult(json){

    if(json[0].result == 1){
    
      alert("????????????");
   }
   else if(json[0].result == 0){
    
      alert("??????????????????");
   }else {
    
      alert("????????????");
   }
}


function kuaile_Result(json){

   if(json[0].result == 0){
      alert("????????????");
   } else {
      alert("????????????");
   }
}


function mengxiangjndsettree(json){

   if(json[0].result == 0){
	  
   } else {
     
   }
}

