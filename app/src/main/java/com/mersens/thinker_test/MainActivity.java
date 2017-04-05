package com.mersens.thinker_test;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {
    private TextView tv_msg;
    private Button btn_loadpatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        //在此对TextView不进行初始化直接设置Text会出现空指针的异常
        tv_msg=(TextView)findViewById(R.id.tv_msg);
        tv_msg.setText("TINKER PATCH");
        btn_loadpatch=(Button)findViewById(R.id.btn_loadpatch);
        btn_loadpatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),
                        Environment.getExternalStorageDirectory().getAbsolutePath() +
                                "/patch_debug.apk");
            }
        });
    }
}
