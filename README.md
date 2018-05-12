Flow
====
학교 알림 및 학교 생활개선 앱

Retrofit2
-----------------

### app.gradle
<pre>
implementation 'com.squareup.retrofit:retrofit:2.0.0-beta2'
implementation 'com.squareup.retrofit:converter-gson:2.0.0-beta2'  
</pre>

### androidmenifest
<pre>
<uses-permission android:name="android.permission.INTERNET" />
</pre>

### network
<pre>
public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(HOST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
</pre>
<pre>
@METHOD(URL)
Call<FORMAT_TYPE> METHOD_NAME(@Body MODEL model);
</pre>

### activity
<pre>
final Network network = Network.retrofit.create(Network.class);
           Call<FORMAT_TYPE> call = network.METHOD_NAME(MODEL);
           call.enqueue(new Callback<FORMAT_TYPE>() {
               @Override
               public void onResponse(Response<ResponseFormat> response, Retrofit retrofit) {
                   Log.e("response", response.body().toString());
               }
               @Override
               public void onFailure(Throwable t) {
                   Log.e("response",t.getMessage());
               }
           });
</pre>

school-api
----------

https://github.com/agemor/school-api
