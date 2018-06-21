package kr.hs.dgsw.flow.Model;

import java.util.Date;

/**
 * Created by leesojin on 2018. 4. 23..
 */

public class GoOut {
    private String start_time;
    private String end_time;
    private String reason;

    @Override
    public String toString() {
        return "GoOut{" +
                "start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
