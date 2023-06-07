package xingyun.service;


import java.util.List;
import xingyun.dao.*;
import xingyun.model.JndebResult;


public class UpdateMengXiangresultService {



    public void tidyJndResult() {
        JndebResultDAO resultDAO = new JndebResultDAO();
        JndebDAO dao = new JndebDAO();
        System.out.println("开始整理");
        Long a[] = resultDAO.getMaxReslut();
        int startid = dao.findIdByIssue(a[0]);
        int totalstart = Integer.parseInt(String.valueOf(a[1]));
        int totaloddeven = Integer.parseInt(String.valueOf(a[2]));
        int total = Integer.parseInt(String.valueOf(a[3]));
        List<JndebResult> list = dao.tidyJndeb(startid, totalstart, totaloddeven,total);
        Long startLong = Long.valueOf(((JndebResult)list.get(0)).getStart());
        int id = resultDAO.findIdByStart(startLong);
        resultDAO.updateJndebresult(id, (JndebResult)list.get(0));
        list.remove(0);
        resultDAO.addJndebresult(list);
    }



    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        UpdateMengXiangresultService service = new UpdateMengXiangresultService();
        service.tidyJndResult();
        long endTime = System.currentTimeMillis();
        System.out.println((new StringBuilder("\u7A0B\u5E8F\u8FD0\u884C\u65F6\u95F4\uFF1A")).append(endTime - startTime).append("ms").toString());
    }
}