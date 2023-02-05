package xingyun.action;

import java.io.*;

import javax.servlet.http.*;

import xingyun.service.InfoMxJndebService;

public class JndEBStatsAction extends HttpServlet {

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		InfoMxJndebService service = new InfoMxJndebService();
		int length = Integer.valueOf(request.getParameter("length"));
		String sb = service.stats(length);
		try {
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
	
	}
}
