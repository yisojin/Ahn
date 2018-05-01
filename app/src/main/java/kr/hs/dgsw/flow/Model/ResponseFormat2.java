package kr.hs.dgsw.flow.Model;

/**
 * Created by leesojin on 2018. 4. 30..
 */

public class ResponseFormat2 {
    private int status;
    private String message;
    private GoOut data;

    @Override
    public String toString() {
        return "ResponseFormat2{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GoOut getData() {
        return data;
    }

    public void setData(GoOut data) {
        this.data = data;
    }
}
