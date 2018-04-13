package kr.hs.dgsw.ahn.Model;

/**
 * Created by leesojin on 2018. 4. 11..
 */

public class ResponseFormat {
    private int status;
    private String message;
    private UserAuth data;

    @Override
    public String toString() {
        return "ResponseFormat{" +
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

    public UserAuth getData() {
        return data;
    }

    public void setData(UserAuth data) {
        this.data = data;
    }
}
