package reflection;

import java.util.Date;
import java.util.List;

public class BodyMsg {

    private String bankNo;
    private String cusNo;
    private String uuid;
    private Integer lifeIndex;
    private Date startDate;
    private List<SubMsg> subMsgList;

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getLifeIndex() {
        return lifeIndex;
    }

    public void setLifeIndex(Integer lifeIndex) {
        this.lifeIndex = lifeIndex;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<SubMsg> getSubMsgList() {
        return subMsgList;
    }

    public void setSubMsgList(List<SubMsg> subMsgList) {
        this.subMsgList = subMsgList;
    }

    @Override
    public String toString() {
        return "BodyMsg{" +
                "bankNo='" + bankNo + '\'' +
                ", cusNo='" + cusNo + '\'' +
                ", uuid='" + uuid + '\'' +
                ", lifeIndex=" + lifeIndex +
                ", startDate=" + startDate +
                ", subMsgList=" + subMsgList +
                '}';
    }
}
