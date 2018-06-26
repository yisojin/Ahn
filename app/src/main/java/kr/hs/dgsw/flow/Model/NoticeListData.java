package kr.hs.dgsw.flow.Model;

import java.util.List;

public class NoticeListData {
    private List<Notice> list;

    @Override
    public String toString() {
        return "NoticeListData{" +
                "list=" + list +
                '}';
    }

    public List<Notice> getList() {
        return list;
    }

    public void setList(List<Notice> list) {
        this.list = list;
    }
}
