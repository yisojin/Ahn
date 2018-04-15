package kr.hs.dgsw.ahn.Model;

/**
 * Created by leesojin on 2018. 4. 11..
 */

public class ResponseFormat {
    private int status;
    private String message;
    private LoginAuth data;

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

    public LoginAuth getData() {
        return data;
    }

    public void setData(LoginAuth data) {
        this.data = data;
    }
}
