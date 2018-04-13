package kr.hs.dgsw.ahn.Model;

import java.io.StringBufferInputStream;
import java.util.HashMap;

/**
 * Created by leesojin on 2018. 4. 10..
 */

public class UserAuth {

    private int idx;
    private String email;
    private String password;
    private String name;
    private String gender;
    private String mobile;
    private int class_idx;
    private int class_number;

    @Override
    public String toString() {
        return "UserAuth{" +
                "idx=" + idx +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", class_idx=" + class_idx +
                ", class_number=" + class_number +
                '}';
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
