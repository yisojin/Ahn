package kr.hs.dgsw.flow;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by leesojin on 2018. 5. 30..
 */

public class GetToken {
    public String tokenInfo(){
        String token = FirebaseInstanceId.getInstance().getToken();
        return token;
    }
}
