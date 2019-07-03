package com.android.yucheng.easypermission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.call_phone_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.makeCell(MainActivity.this,"12345678911");
            }
        });
    }
}
