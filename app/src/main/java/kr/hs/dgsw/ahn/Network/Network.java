package kr.hs.dgsw.ahn.Network;

import org.json.JSONArray;

import kr.hs.dgsw.ahn.Activity.RegisterActivity;
import kr.hs.dgsw.ahn.Model.ResponseFormat;
import kr.hs.dgsw.ahn.Model.UserAuth;
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
    Call<ResponseFormat> signin(@Body UserAuth auth);
    //register
@POST("auth/signup")
    Call<ResponseFormat> signup(@Body UserAuth auth);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://flow.cafe24app.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
