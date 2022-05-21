var CurrentPageIndex = 1;
var length = 100;

$.ajax({
        url: "jndtrend",
        type: "post",
        dataType: "json",
        data: "page=1&rows=50",
        success: show,
        error:function(){alert("error!");}
}); 


$.ajax({
    url: "jndEBstats?length="+length,
    type: "post",
    dataType: "json",
    success: showStats
});  


function stats() {
	
	var l = $("#statsCount").val();

	$.ajax({
	    url: "jndEBstats?length="+l,
	    type: "post",
	    dataType: "json",
	    success: showStats
	});  
}



function showStats(msg) {
	
	var da = msg[0].da;
	var xiao = msg[0].xiao;
	
	var dan = msg[0].dan;
	var shuang = msg[0].shuang;
	
	var zhong = msg[0].zhong;
	var bian = msg[0].bian;
	
	$("#da").html(da);
	$("#xiao").html(xiao);
	
	$("#dan").html(dan);
	$("#shuang").html(shuang);
	
	$("#zhong").html(zhong);
	$("#bian").html(bian);
	
	
}


function changetext(a){
	var e = e || window.event;
	if(e.keyCode == 13){
		onsubmit(a,3);
	}
}


function onsubmit(a,b) {
	
	$("#mtb").empty();
	if( b == 1 ){
		if( CurrentPageIndex >=20 ){
			CurrentPageIndex +=CurrentPageIndex ;
		} else {
			CurrentPageIndex = a;
		}
	} else if( b == 3){
		
		CurrentPageIndex = a;
		
	} else {
		CurrentPageIndex =  parseInt(CurrentPageIndex) + a;
		console.info(CurrentPageIndex);
		if( CurrentPageIndex == 0 ){
			CurrentPageIndex = 1;
		}
		
	}

	$.each($("#ymtd a"), function(i){ 
			if( i == CurrentPageIndex+1) {
				$(this).css("font-weight","bold");
				$(this).css("color","#CC0000");
			} else {
				$(this).css("font-weight","normal");
				$(this).css("color","#3366CC");
			}
		});
	$("#dq").html(CurrentPageIndex);
	$.ajax({
        url: "jndtrend",
        type: "post",
        dataType: "json",
        data: "page="+ CurrentPageIndex +"&rows=50",
        success: show
	});

	
}

function show(msg) {
	var length = msg.length;
	for(i = 0; i < length; i++){
		
		
		var sum = msg[i].sum;
		var oNewTr = document.createElement("TR");
		oNewTr.style.color="#ffffff";
		//期数
		var oNewTd = document.createElement("TD");
		oNewTd.style.backgroundColor ="#ffffff";
		oNewTd.style.fontSize ="10px";
		oNewTd.style.width ="100px";
		oNewTd.style.color ="#000000";
		oNewTd.innerHTML=msg[i].issue;	
		oNewTr.appendChild(oNewTd);
		
		//时间 
		var oNewTd = document.createElement("TD");
		oNewTd.style.backgroundColor ="#ffffff";
	    oNewTd.style.color ="#000000";
		oNewTd.style.fontSize ="12px";
		oNewTd.style.width ="200px";
		oNewTd.style.height ="35px";
		oNewTd.innerHTML=msg[i].time;	
		oNewTr.appendChild(oNewTd);
		
		//号码
		var result = msg[i].result.split(",");
		var sum= 0;
		for(k = 0; k < result.length; k++){
			var oNewTd = document.createElement("TD");
			oNewTd.innerHTML=result[k];
		    oNewTd.style.backgroundColor ="#ffffff";
		    oNewTd.style.color ="#000000";
		    oNewTd.style.fontSize ="12px";
		    if(k ==3 ){
		    	sum = result[3];
		    	oNewTd.style.fontSize ="14px";
		    	oNewTd.style.color ="red";
		    }
		    oNewTr.appendChild(oNewTd);	
		}
		
		//大小
		oNewTd = document.createElement("TD");
		if( sum > 13){
			oNewTd.innerHTML="大";
			oNewTd.style.backgroundColor="#EA2640";
			oNewTd.style.width ="30px";
		}
		oNewTr.appendChild(oNewTd);
		

		oNewTd = document.createElement("TD");
		if( sum < 14){
		oNewTd.innerHTML="小";
		oNewTd.style.backgroundColor="#FF8040";
		oNewTd.style.width ="30px";
		}
		oNewTr.appendChild(oNewTd);
		
		//单双
		oNewTd = document.createElement("TD");
		if( sum%2!=0 ){
			oNewTd.innerHTML="单";
			oNewTd.style.backgroundColor="#EA2640";
			oNewTd.style.width ="30px";
		} 
		oNewTr.appendChild(oNewTd);
		

		oNewTd = document.createElement("TD");
		if( sum%2==0 ){
		oNewTd.innerHTML="双";
		oNewTd.style.backgroundColor="#FF8040";
		oNewTd.style.width ="30px";
		}
		oNewTr.appendChild(oNewTd);
		
		//中边
		oNewTd = document.createElement("TD");
		if( sum >  9 && sum < 18){
			oNewTd.innerHTML="中";
			oNewTd.style.backgroundColor="#EA2640";
			oNewTd.style.width ="30px";
		} 
		oNewTr.appendChild(oNewTd);
		

		oNewTd = document.createElement("TD");
		if( sum <  10 || sum > 17){
			oNewTd.innerHTML="边";
			oNewTd.style.backgroundColor="#FF8040";
			oNewTd.style.width ="30px";
		}
		oNewTr.appendChild(oNewTd);
		
	
		document.getElementById("mtb").appendChild(oNewTr);
		

	}
}