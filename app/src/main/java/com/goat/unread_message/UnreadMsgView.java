package com.goat.unread_message;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * Created by zengwendi on 2017/5/12.
 * 未读消息View
 */

public class UnreadMsgView extends FrameLayout {
    //图
    private TextViewIcon mIconView;
    //未读消息数
    private TextView mMsgTv;
    //文字描述
    private TextView mText;
    private TextViewIcon mMsgBgView;
    private View mMsgCon;
    private int msgMaxLeng;
    private int msgNum;
    //图
    private String icCode;
    private int icColor;
    private int icSize;
    //文字
    private String text;
    private int textColor;
    private int textSize;
    //消息
    private int msgBgColor;
    private int msgTvColor;

    public UnreadMsgView(Context context) {
        this(context, null);
    }

    public UnreadMsgView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UnreadMsgView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);

    }

    private void initView(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_unread_msg, null);
        mIconView = (TextViewIcon) view.findViewById(R.id.text_icon);
        mMsgTv = (TextView) view.findViewById(R.id.msg_tv);
        mMsgBgView = (TextViewIcon) view.findViewById(R.id.msg_bg);
        mText = (TextView) view.findViewById(R.id.text);
        mMsgCon = view.findViewById(R.id.msg_con);
        TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.UnreadMsgStyle);
        //图形自定义属性
        icCode = type.getString(R.styleable.UnreadMsgStyle_ic_text);
        icColor = type.getColor(R.styleable.UnreadMsgStyle_ic_color, Color.WHITE);
        icSize = type.getDimensionPixelSize(R.styleable.UnreadMsgStyle_ic_size, 0);
        if (!TextUtils.isEmpty(icCode)) {
            mIconView.setText(icCode);
        }
        mIconView.setTextColor(icColor);
        mIconView.setTextSize(TypedValue.COMPLEX_UNIT_PX, icSize);
        //文字自定义属性
        text = type.getString(R.styleable.UnreadMsgStyle_text);
        textColor = type.getColor(R.styleable.UnreadMsgStyle_text_color, Color.RED);
        textSize = type.getDimensionPixelSize(R.styleable.UnreadMsgStyle_text_size, 0);
        if (!TextUtils.isEmpty(text)) {
            mText.setText(text);
        }
        mText.setTextColor(textColor);
        mText.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        //消息自定义属性
        msgNum = type.getInteger(R.styleable.UnreadMsgStyle_msg_number, 0);
        msgBgColor=type.getColor(R.styleable.UnreadMsgStyle_msg_bg_color, Color.RED);
        msgTvColor=type.getColor(R.styleable.UnreadMsgStyle_msg_tv_color, Color.WHITE);
        mMsgBgView.setTextColor(msgBgColor);
        mMsgTv.setTextColor(msgTvColor);
        mMsgTv.setText(String.valueOf(msgNum));

        addView(view);
        type.recycle();
    }


    public void setMsgNum(int msgNum) {
        this.msgNum = msgNum;
        if (msgNum == 0) {
            mMsgCon.setVisibility(GONE);
        } else if (msgNum < 100) {
            mMsgCon.setVisibility(VISIBLE);
            mMsgTv.setText(String.valueOf(msgNum));
        } else {
            mMsgCon.setVisibility(VISIBLE);
            mMsgTv.setText("···");
        }
    }

    public void setIcCode(String icCode) {
        this.icCode = icCode;
        if (!TextUtils.isEmpty(icCode)) {
            mIconView.setText(icCode);
        }
    }

    //设置消息显示
    public void setMsgVisibility(int visibility) {
        mMsgCon.setVisibility(visibility);
    }

    //获取消息数量
    public int getMsgNum() {
        return msgNum;
    }
}
