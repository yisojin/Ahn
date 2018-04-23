package kr.hs.dgsw.ahn.Model;

import java.util.Date;

/**
 * Created by leesojin on 2018. 4. 23..
 */

public class GoOut {
    private Date start_time;
    private Date end_time;
    private String reason;

    @Override
    public String toString() {
        return "GoOut{" +
                "start_time=" + start_time +
                ", end_time=" + end_time +
                ", reason='" + reason + '\'' +
                '}';
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
