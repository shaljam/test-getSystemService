package com.test.testgetsystemservice;

import android.app.AlarmManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textViewLog;
    Button btnAlarm;
    Button btnWifi;

    String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLog = findViewById(R.id.tv_log);
        btnAlarm = findViewById(R.id.btn_alarm);
        btnWifi = findViewById(R.id.btn_wifi);

        textViewLog.setMovementMethod(new ScrollingMovementMethod());

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "\n [" + getCurrentDate() +
                        "] before Alarm";
                textViewLog.append(msg);

                AlarmManager alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                msg = "\n [" + getCurrentDate() +
                "] after hashCode: " + alarmMgr.hashCode() + "\n";
                textViewLog.append(msg);
            }
        });

        btnWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "\n [" + getCurrentDate() +
                        "] before Wifi";
                textViewLog.append(msg);

                // using getApplicationContext
                WifiManager wifiManager = (WifiManager) getApplicationContext()
                        .getSystemService(Context.WIFI_SERVICE);

                msg = "\n [" + getCurrentDate() +
                        "] after hashCode: " + wifiManager.hashCode() + "\n";
                textViewLog.append(msg);
            }
        });
    }
}
