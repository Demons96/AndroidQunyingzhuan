package com.imooc.systeminfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text);

        String systemInfoStr = SystemInfoTools.getBuildInfo();
        systemInfoStr += "-------------------------------------\r\n";
        systemInfoStr += SystemInfoTools.getSystemPropertyInfo();
        textView.setText(systemInfoStr);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelephonyManager TelephonyMgr = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
                @SuppressLint("MissingPermission") String szImei = TelephonyMgr.getDeviceId();
                Toast.makeText(MainActivity.this, "szImei:" + szImei, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
