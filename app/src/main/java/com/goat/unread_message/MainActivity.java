package com.goat.unread_message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextIcon = (TextView) findViewById(R.id.text_icon);
//        //为TextView设置指定ttf文字
//        Typeface iconfont = Typeface.createFromAsset(getAssets(), "iconfont/iconfont.ttf");
//        mTextIcon.setTypeface(iconfont);
    }
}
