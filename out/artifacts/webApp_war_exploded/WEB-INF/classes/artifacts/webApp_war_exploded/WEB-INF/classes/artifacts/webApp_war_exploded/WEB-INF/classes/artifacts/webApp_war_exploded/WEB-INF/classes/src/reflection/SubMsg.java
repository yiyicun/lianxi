package reflection;

import java.util.Date;

public class SubMsg {

    private String uuid;
    private String subMsgNo;
    private Date subStartDate;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSubMsgNo() {
        return subMsgNo;
    }

    public void setSubMsgNo(String subMsgNo) {
        this.subMsgNo = subMsgNo;
    }

    public Date getSubStartDate() {
        return subStartDate;
    }

    public void setSubStartDate(Date subStartDate) {
        this.subStartDate = subStartDate;
    }

    @Override
    public String toString() {
        return "SubMsg{" +
                "uuid='" + uuid + '\'' +
                ", subMsgNo='" + subMsgNo + '\'' +
                ", subStartDate=" + subStartDate +
                '}';
    }
}
