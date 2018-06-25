package kr.hs.dgsw.flow.Model;

/**
 * Created by leesojin on 2018. 6. 25..
 */

public class NoticeFile {

    private int idx;
    private String uploadName;
    private String uploadDir;
    private int noticeIdx;

    @Override
    public String toString() {
        return "NoticeFile{" +
                "idx=" + idx +
                ", uploadName='" + uploadName + '\'' +
                ", uploadDir='" + uploadDir + '\'' +
                ", noticeIdx=" + noticeIdx +
                '}';
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getUploadName() {
        return uploadName;
    }

    public void setUploadName(String uploadName) {
        this.uploadName = uploadName;
    }

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public int getNoticeIdx() {
        return noticeIdx;
    }

    public void setNoticeIdx(int noticeIdx) {
        this.noticeIdx = noticeIdx;
    }
}
