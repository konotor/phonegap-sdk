package com.demach.konotor;

import com.demach.konotor.Konotor;
import com.demach.konotor.access.K;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import com.google.android.gcm.GCMBaseIntentService;

@SuppressLint("NewApi")
public class GCMIntentService extends GCMBaseIntentService {

    private static final String TAG = "GCMIntentService";

    public GCMIntentService() {
        super(K.ANDROID_PROJECT_SENDER_ID);
    }

    @Override
    public void onRegistered(Context context, String registrationId) {
         Konotor.getInstance(context).handleGcmOnUnRegistered(registrationId);
    }

    @Override
    public void onUnregistered(Context context, String registrationId) {
          Konotor.getInstance(context).handleGcmOnRegistered(registrationId);
    }

    @Override
    protected void onMessage(Context context, Intent intent) {
        Konotor.getInstance(context).handleGcmOnMessage(intent);
    }

    @Override
    public void onError(Context context, String errorId) {
        Konotor.getInstance(context).handleGcmOnError(errorId);
    }

}
