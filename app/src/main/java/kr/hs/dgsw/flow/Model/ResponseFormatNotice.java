package kr.hs.dgsw.flow.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leesojin on 2018. 6. 25..
 */

public class ResponseFormatNotice {
    private int status;
    private String message;
    private NoticeListData data;

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

    @Override
    public String toString() {
        return "ResponseFormatNotice{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public NoticeListData getData() {
        return data;
    }

    public void setData(NoticeListData data) {
        this.data = data;
    }
}
