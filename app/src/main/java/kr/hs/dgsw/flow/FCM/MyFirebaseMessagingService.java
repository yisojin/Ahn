package kr.hs.dgsw.flow.FCM;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by leesojin on 2018. 5. 21..
 */

public class MyFirebaseMessagingService extends IntentService {

    private static final String TAG = "RegIntentService";

//    private NotificationHub hub;


    public MyFirebaseMessagingService() {
        super(TAG);
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }


}
