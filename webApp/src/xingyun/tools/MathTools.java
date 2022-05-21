package xingyun.tools;

import java.util.List;



import xingyun.model.Jndeb;
import xingyun.model.JndebResult;

public class MathTools {

	
	//求均线
	public static List<JndebResult> average(List<JndebResult> list,List<Integer> aveList){
		return list;
	}
		
		
	//求最大值 	//求最小值
	public static int[] getMaxMin(List<Jndeb> dataList) {
		int max = 0;
		int min = 0;
		int size = dataList.size();
		int total = 0;
		int zhong = 0;
		int bian = 0;
		for (int i = 0; i < size; i++) {
			Jndeb jndeb = dataList.get(i);
			int result = jndeb.getResult();
			if( result > 9 && result < 18 ) {
				zhong++;
			} else {
				bian++;
			}
			Double b = bian * 1.272;
			total = zhong-b.intValue();
			if( total > max ) {
				max = total;
			} 
			if( total < min ) {
				min = total;
			} 
			
			
		}
		int[] a = new int[]{max,min};
		return a;
	}
	

	
		
	
	
}
