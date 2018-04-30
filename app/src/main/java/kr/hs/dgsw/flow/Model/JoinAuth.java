package kr.hs.dgsw.flow.Model;

/**
 * Created by leesojin on 2018. 4. 15..
 */

public class JoinAuth {

    private String email;
    private String pw;
    private String name;
    private String gender;
    private String mobile;
    private int class_idx;
    private int class_number;

    @Override
    public String toString() {
        return "JoinAuth{" +
                "email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", class_idx=" + class_idx +
                ", class_number=" + class_number +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getClass_idx() {
        return class_idx;
    }

    public void setClass_idx(int class_idx) {
        this.class_idx = class_idx;
    }

    public int getClass_number() {
        return class_number;
    }

    public void setClass_number(int class_number) {
        this.class_number = class_number;
    }
}
