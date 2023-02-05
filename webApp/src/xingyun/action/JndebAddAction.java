package xingyun.action;

import xingyun.service.AddDouWanService;
import xingyun.service.UpdateMengXiangresultService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JndebAddAction extends HttpServlet {

	private static String url = "https://ctubhcf2022.com/sgame.php";
	private static String host = "ctubhcf2022.com";
	private static String referer = "https://ctubhcf2022.com/game.php";


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		StringBuilder sb = new StringBuilder();
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0L);
		response.setCharacterEncoding("UTF-8");
		String sessionString = request.getParameter("jndsession");
		
		long startTime = System.currentTimeMillis();
		AddDouWanService service = new AddDouWanService();
		UpdateMengXiangresultService updateService = new UpdateMengXiangresultService();
		String[] resultString = new String[2];
		try {
			resultString = service.addJnd28(sessionString,url,host,referer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		updateService.tidyJndResult();
		long endTime = System.currentTimeMillis();
		System.out.println("共运行了" + (endTime - startTime) / 1000 + "秒");
		sb.append("[{\"result\":\"");
		sb.append(resultString);
		sb.append("\"}]");
		response.getWriter().write(sb.toString());
		System.out.println(sb.toString());
			
	
	}
}
