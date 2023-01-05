package com.example.rokdobravecbled;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, R.string.zacetek, Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, R.string.konec, Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}