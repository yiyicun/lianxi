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
     		     url:"jndStats?date="+date+"&tablevalue="+tablevalue,
     			 type:"post",
     			 dataType:"json",
     			 success:function(json){
				 	
				 	var xaxis = json.dates;
				    
					var chart = new Highcharts.Chart({
		              chart: {
			          renderTo: 'stats',                  //div层
			          defaultSeriesType:'spline',        //图标类型
			        
		              },
		
		              title: {
			            text: '加拿大统计图',
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
		           },{                              //点的数据
			         name: '212121222'
		           }]
		
		         
		           
	              });
	              chart.series[0].setData(json.total); 
	              var chang = [];
	              for(var i = 0 ;i<json.total.length;i++) {
	            	  if( tablevalue == 1 || tablevalue == 13 ||  tablevalue == 13) {
	            		  chang.push(1.272);
	            	  } else if(tablevalue == 0 ){
	            		  chang.push(3115);
	            	  } else  {
	            		  chang.push(json.junxian);
	            	  }
	              }
	              chart.series[1].setData(chang); 
			      },
				  error: function(){   
                         alert("数据加载失败"); 
				  }

    	 });   
	  return true;
	}                             
}