package xingyun.action;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import xingyun.service.InfoMxJndebService;

public class JndStatsAction extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String date = request.getParameter("date");
		int tablevalue = Integer.valueOf(request.getParameter("tablevalue"));
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0L);
		response.setCharacterEncoding("UTF-8");
		System.out.println(date);
		String sString = null;

		try {
			long startTime = System.currentTimeMillis();
			InfoMxJndebService service = new InfoMxJndebService();
			
			try {
				
				
				if( tablevalue == 0){
					sString = service.getZbByDay(date);
				} else if( tablevalue == 1){
					sString = service.getBilizbByhour(date);
				} else if( tablevalue == 2){
					sString = service.getBilidxByhour(date);
				} else if( tablevalue == 3){
					sString = service.getBilidsByhour(date);
				} else if( tablevalue == 4){
					sString = service.diejiazbByhour(date);
				} else if( tablevalue == 5){
					sString = service.diejiadxByhour(date);
				} else if( tablevalue == 6){
					sString = service.diejiadsByhour(date);
				}  
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			long endTime = System.currentTimeMillis();
			System.out.println("共运行了" + (endTime - startTime) / 1000 + "秒");
			response.getWriter().write(sString);
			
		} catch (RuntimeException e) {
			
			e.printStackTrace();
			response.getWriter().write(sString);
			
		}

	}

}
