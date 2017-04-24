package com.jacky.fragmenttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText tv,tv2;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (EditText) findViewById(R.id.test_tv);
        tv2 = (EditText) findViewById(R.id.test_tv2);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChildFragment fragment = new ChildFragment();
                fragment.setCallBack(new ChildFragment.Callback() {
                    @Override
                    public void onResult(String data) {
                        tv2.setText(data);
                    }
                });
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main,fragment)
                        .addToBackStack("child")
                        .commit();
            }
        });


    }
}
