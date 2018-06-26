package kr.hs.dgsw.flow.Model;

import java.util.Date;

public class list {
    private int idx;
    private String content;
    private String writer;
    private Date writeDate;
    private Date modifyDate;
    private NoticeFile NoticeFiles;

    @Override
    public String toString() {
        return "list{" +
                "idx=" + idx +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", writeDate=" + writeDate +
                ", modifyDate=" + modifyDate +
                ", NoticeFiles=" + NoticeFiles +
                '}';
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public NoticeFile getNoticeFiles() {
        return NoticeFiles;
    }

    public void setNoticeFiles(NoticeFile noticeFiles) {
        NoticeFiles = noticeFiles;
    }
}
