function gettree(){
     	
       			$.ajax({
     				url:"tree/bindBur.action",
     				type:"post",
     				dataType:"json",
     				success:settree,
					error: function(){alert("读取数据有误");}
					
    			    });
      		}
  		
  		
	    function settree(msg){
   			
         
    		d = new dTree('d'); 
        	d.add(0,-1,"深圳");
        	
        	var k1=0;
        	var k2=0;
        	var k3=0;
        	
        	
        	for(var i=0;i<msg.length;i++){
        	
        	
			  
        	     
        	   k1=k1+msg[i].bureauload.length;
        	 
        	     for(var j=0;j<msg[i].bureauload.length;j++){
        	       if(msg[i].bureauload[j].waybox != undefined){
        	       k3=k3+msg[i].bureauload[j].waybox.length;
        	       }
        	      }
        	   
        	   
            }
            
       
  		}
