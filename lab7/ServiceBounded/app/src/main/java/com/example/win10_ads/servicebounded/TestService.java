package com.example.win10_ads.servicebounded;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

public class TestService extends Service {
    private SpecialBinder iBinder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        iBinder= new SpecialBinder();
        return iBinder;
    }

    public String getRandomString(){
        return "Sample String is "+new Random().nextInt();
    }

    public class SpecialBinder extends Binder{
        public TestService getTestService(){
            return TestService.this;
        }
    }
}
