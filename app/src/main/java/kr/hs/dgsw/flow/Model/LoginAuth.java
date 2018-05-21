package kr.hs.dgsw.flow.Model;

/**
 * Created by leesojin on 2018. 4. 15..
 */

public class LoginAuth {

    private String email;
    private String pw;
    private String registration_token;

    @Override
    public String toString() {
        return "LoginAuth{" +
                "email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                ", registration_token='" + registration_token + '\'' +
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

    public String getRegistration_token() {
        return registration_token;
    }

    public void setRegistration_token(String registration_token) {
        this.registration_token = registration_token;
    }
}
