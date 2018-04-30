package kr.hs.dgsw.flow.Model;

/**
 * Created by leesojin on 2018. 4. 15..
 */

public class LoginAuth {

    private String email;
    private String pw;

    @Override
    public String toString() {
        return "LoginAuth{" +
                "email='" + email + '\'' +
                ", pw='" + pw + '\'' +
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
}
