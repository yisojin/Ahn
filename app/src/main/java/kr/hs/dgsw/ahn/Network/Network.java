package kr.hs.dgsw.ahn.Network;

import kr.hs.dgsw.ahn.Model.JoinAuth;
import kr.hs.dgsw.ahn.Model.LoginAuth;
import kr.hs.dgsw.ahn.Model.ResponseFormat;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by leesojin on 2018. 4. 10..
 */

public interface Network {

    //login
@POST("auth/signin")
    Call<ResponseFormat> signin(@Body LoginAuth auth);
    //register
@POST("auth/signup")
    Call<ResponseFormat> signup(@Body JoinAuth auth);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://flow.cafe24app.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
