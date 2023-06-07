var CurrentPageIndex = 1;
var length = 100;

$.ajax({
        url: "kuaileEBtrend",
        type: "post",
        dataType: "json",
        data: "page=1&rows=50",
        success: show
}); 

$.ajax({
    url: "kuaileEBstats?length="+length,
    type: "post",
    dataType: "json",
    success: showStats
});  

function stats() {
	
	var l = $("#statsCount").val();

	$.ajax({
	    url: "kuaileEBstats?length="+l,
	    type: "post",
	    dataType: "json",
	    success: showStats
	});  
}


function showStats(msg) {
	
	var da = msg[0].da;
	var xiao = msg[0].xiao;
	var dxhe = msg[0].dxhe;
	var dan = msg[0].dan;
	var shuang = msg[0].shuang;
	
	var odd = msg[0].odd;
	var even = msg[0].even;
	var oehe = msg[0].oehe;
	var shang = msg[0].shang;
	var xia = msg[0].xia;
	var sxhe = msg[0].sxhe;
	
	$("#da").html(da);
	$("#xiao").html(xiao);
	$("#dxhe").html(dxhe);
	
	$("#dan").html(dan);
	$("#shuang").html(shuang);
	
	$("#odd").html(odd);
	$("#even").html(even);
	$("#oehe").html(oehe);
	
	$("#shang").html(shang);
	$("#xia").html(xia);
	$("#sxhe").html(sxhe);
	
}


function onsubmit(a,b) {
	
	$("#mtb").empty();
	
	if( b == 1 ){
		CurrentPageIndex = a;
	} else {
		console.info(CurrentPageIndex);
		CurrentPageIndex =  CurrentPageIndex + a;
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
        url: "kuaileEBtrend",
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
		oNewTd.style.width ="40px";
		oNewTd.style.color ="#000000";
		oNewTd.innerHTML=msg[i].issue;	
		oNewTr.appendChild(oNewTd);
		
		//时间 
		var oNewTd = document.createElement("TD");
		oNewTd.style.backgroundColor ="#ffffff";
	    oNewTd.style.color ="#000000";
		oNewTd.style.fontSize ="12px";
		oNewTd.style.width ="90px";
		oNewTd.style.height ="35px";
		oNewTd.innerHTML=msg[i].time;	
		oNewTr.appendChild(oNewTd);
		
		//号码
		var result = msg[i].result.split(",");
		for(k = 0; k < result.length; k++){
			var oNewTd = document.createElement("TD");
			oNewTd.innerHTML=result[k];
		    oNewTd.style.backgroundColor ="#ffffff";
		    oNewTd.style.color ="#000000";
		    oNewTd.style.fontSize ="12px";
		    oNewTr.appendChild(oNewTd);		
		}
		
		//总和
		var oNewTd = document.createElement("TD");
		oNewTd.style.backgroundColor ="#ffffff";
	    oNewTd.style.color ="#000000";
		oNewTd.style.fontSize ="12px";
		oNewTd.style.width ="30px";
		oNewTd.innerHTML=sum
		oNewTr.appendChild(oNewTd);
		
		//大小
		oNewTd = document.createElement("TD");
		if( sum > 810){
			oNewTd.innerHTML="大";
			oNewTd.style.backgroundColor="#EA2640";
		}
		oNewTr.appendChild(oNewTd);
		
		


		oNewTd = document.createElement("TD");
		if( sum < 810){
		oNewTd.innerHTML="小";
		oNewTd.style.backgroundColor="#FF8040";
		}
		oNewTr.appendChild(oNewTd);
		

		oNewTd = document.createElement("TD");	
		if( sum == 810){
		oNewTd.innerHTML="和";
		oNewTd.style.backgroundColor="#663399";
		}
		oNewTr.appendChild(oNewTd);

		//单双
		oNewTd = document.createElement("TD");
		if( sum%2!=0 ){
			oNewTd.innerHTML="单";
			oNewTd.style.backgroundColor="#EA2640";
		} 
		oNewTr.appendChild(oNewTd);
		

		oNewTd = document.createElement("TD");
		if( sum%2==0 ){
		oNewTd.innerHTML="双";
		oNewTd.style.backgroundColor="#FF8040";
		}
		oNewTr.appendChild(oNewTd);
		
		//奇偶
		var sum_odd = 0;
		var sum_even = 0;
		for(k = 0; k < result.length; k++){
			if( result[k] % 2 != 0) {
				sum_odd++;
			} else {
				sum_even++;
			}
		}
		
		oNewTd = document.createElement("TD");
		if( sum_odd >  sum_even){
			oNewTd.innerHTML="奇";
			oNewTd.style.backgroundColor="#EA2640";
		} 
		oNewTr.appendChild(oNewTd);
		

		oNewTd = document.createElement("TD");
		if( sum_odd <  sum_even){
			oNewTd.innerHTML="偶";
			oNewTd.style.backgroundColor="#FF8040";
		}
		oNewTr.appendChild(oNewTd);
		
		oNewTd = document.createElement("TD");
		if( sum_odd ==  sum_even){
			oNewTd.innerHTML="和";
			oNewTd.style.backgroundColor="#EA2640";
		} 
		oNewTr.appendChild(oNewTd);
		
		//上下
		var sum_shang = 0;
		var sum_xia = 0;
		for(k = 0; k < result.length; k++){
			if( result[k] <= 40) {
				sum_shang++;
			} else {
				sum_xia++;
			}
		}
		
	
		oNewTd = document.createElement("TD");
		if( sum_shang >  sum_xia){
			oNewTd.innerHTML="上";
			oNewTd.style.backgroundColor="#EA2640";
		} 
		oNewTr.appendChild(oNewTd);
		

		oNewTd = document.createElement("TD");
		if( sum_shang < sum_xia){
		oNewTd.innerHTML="下";
		oNewTd.style.backgroundColor="#FF8040";
		}
		oNewTr.appendChild(oNewTd);
		
		oNewTd = document.createElement("TD");
		if( sum_shang == sum_xia){
		oNewTd.innerHTML="和";
		oNewTd.style.backgroundColor="#FF8040";
		}
		oNewTr.appendChild(oNewTd);

		document.getElementById("mtb").appendChild(oNewTr);
		

	}
}