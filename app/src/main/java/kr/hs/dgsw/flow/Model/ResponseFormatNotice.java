package kr.hs.dgsw.flow.Model;

/**
 * Created by leesojin on 2018. 6. 25..
 */

public class ResponseFormatNotice {
    private int status;
    private String message;
    private Notice data;

    @Override
    public String toString() {
        return "ResponseFormatNotice{" +
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

    public Notice getData() {
        return data;
    }

    public void setData(Notice data) {
        this.data = data;
    }
}
