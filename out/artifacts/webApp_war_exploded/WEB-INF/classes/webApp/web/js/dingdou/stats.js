function stats(){     //生成统计图表

     var date = document.getElementById("date").value ; 
    
     if( date == "" ) {
     
        alert("日期为空");
     	return false;
     
     } else {
     
    	 var o = document.getElementById("tabletype");
	 	 var tablevalue =o.options[o.options.selectedIndex].value;
	 	 
	 	
		//声明报表对象 
		 $.ajax({
     		     url:"dindouebstats?date="+date+"&tablevalue="+tablevalue,
     			 type:"post",
     			 dataType:"json",
     			 success:function(json){
				 	
				 	var xaxis = json.dates;
				 
				    var length = parseInt(xaxis.length);
				   
				    if( length > 200){
				      document.getElementById("stats").style.width = "4000px";
				    }else{
				      document.getElementById("stats").style.width = "100%";
				    }
					var chart = new Highcharts.Chart({
		              chart: {
			          renderTo: 'stats',                  //div层
			          defaultSeriesType:'spline',        //图标类型
			        
		              },
		
		              title: {
			            text: 'pc统计图',
						style: {
					       font: 'normal 12px Verdana'
						}
		              },
		
		              xAxis: {                                //X轴坐标值
			            categories: xaxis,
			            labels: {
				          y:20,
				          style: {
					        font: 'normal 13px Verdana'
						  }
			            }
			
		              },
		
		              yAxis: {                                 //Y轴坐标值
			            title: {
				          text: '数量',
			            }
		              },
		
		             legend: {                                //右边悬浮提示                        
			           enabled: false
		             },
		
		             plotOptions: {
		               column: {
					     dataLabels: {
					       enabled: true ,                 //是否直接显示点的数据
						   x: 28,
						   y: -5                    
					      },
					       enableMouseTracking: true   //鼠标经过点时是否显示
					   }
			       },
					        
		           tooltip: {                              //点的提示框
			         formatter: function(){
				       return this.x+":"+this.y + '次';
			           }
		           },
		           series: [{                              //点的数据
			         name: 'box'
		           }]
		
		         
		           
	              });
	              chart.series[0].setData(json.total); 
	             
			      },
				  error: function(){   
                         alert("数据加载失败"); 
				  }

    	 });   
	  return true;
	}                             
}