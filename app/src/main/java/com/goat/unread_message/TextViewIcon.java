package com.goat.unread_message;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by zengwendi on 2017/6/19.
 * 矢量图
 */

public class TextViewIcon extends AppCompatTextView {
    public TextViewIcon(Context context) {
        super(context);
        init(context);
    }


    public TextViewIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TextViewIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setTypeface(MyApplication.getIconfont(context));
    }

}
