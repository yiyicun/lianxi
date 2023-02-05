package xingyun.action;

import java.io.*;

import javax.servlet.http.*;

import xingyun.service.InfoMxJndebService;

public class JNDEBtrendAction extends HttpServlet {

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		InfoMxJndebService service = new InfoMxJndebService();
		int rows = Integer.valueOf(request.getParameter("rows"));
		int page = Integer.valueOf(request.getParameter("page"));
		System.out.println(page);
		System.out.println(rows);
		String sb = service.trend(page, rows);
		try {
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
			
	
	}
}
