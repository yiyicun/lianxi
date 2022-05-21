package xingyun.model;

import java.sql.Timestamp;

public class Jndeb {
	 private int id;
	 private long issue;
	 private Timestamp time;
	 private byte r1;
	 private byte r2;
	 private byte r3;
	 private byte result;
	 
	 
	 
  
    public byte getR1() {
		return r1;
	}

	public void setR1(byte r1) {
		this.r1 = r1;
	}

	public byte getR2() {
		return r2;
	}

	public void setR2(byte r2) {
		this.r2 = r2;
	}

	public byte getR3() {
		return r3;
	}

	public void setR3(byte r3) {
		this.r3 = r3;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIssue() {
        return issue;
    }

    public void setIssue(long issue) {
        this.issue = issue;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

   
}