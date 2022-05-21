$(document).ready( function(){
       finddoudou();
});


function finddoudou(){

   		var start = $('#start').value; 
		var end = $('#end').value; 
		var cycle = $('#cycle').value;


		$.ajax({
        	url: "findDoudou",
        	type: "post",
        	dataType: "json",
        	success: getDoudou
    });

}

function getDoudou(msg){

	alert(msg);



}           