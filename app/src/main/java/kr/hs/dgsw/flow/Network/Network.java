package kr.hs.dgsw.flow.Network;

import kr.hs.dgsw.flow.Model.GoOut;
import kr.hs.dgsw.flow.Model.JoinAuth;
import kr.hs.dgsw.flow.Model.LoginAuth;
import kr.hs.dgsw.flow.Model.ResponseFormat;
import kr.hs.dgsw.flow.Model.ResponseFormatNotice;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.HEAD;
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
    Call<ResponseFormat> goout(@Header("x-access-token") String Token, @Body GoOut goOut);

    //sleep out
    @POST("out/sleep")
    Call<ResponseFormat> sleepout(@Header("x-access-token") String Token, @Body GoOut goOut);

    //공지
    @GET("/notice")
    Call<ResponseFormatNotice> list(@Header("x-access-token")String token);

    @GET("/notice/{idx}") //notice idx 값 받기
    Call<ResponseFormatNotice> view(@Header("x-access-token")String token);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://flow.cafe24app.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

