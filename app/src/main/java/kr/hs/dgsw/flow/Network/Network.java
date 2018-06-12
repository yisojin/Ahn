package kr.hs.dgsw.flow.Network;

import kr.hs.dgsw.flow.Model.GoOut;
import kr.hs.dgsw.flow.Model.JoinAuth;
import kr.hs.dgsw.flow.Model.LoginAuth;
import kr.hs.dgsw.flow.Model.ResponseFormat;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Body;
import retrofit.http.Header;
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

    //go out
    @POST("out/go")
    Call<ResponseFormat> goout(@Header("Authorization") String Token, @Body GoOut goOut);

    //sleep out
    @POST("out/sleep")
    Call<ResponseFormat> sleepout(@Header("Authorization") String Token, @Body GoOut goOut);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://flow.cafe24app.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
