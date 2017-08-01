package me.hipo.projects.kendhia.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;



public class MessageBoxCompound extends LinearLayout {

    private EditText mMsgBoxEditText;
    private ImageButton mMsgBoxImgButton;


    public MessageBoxCompound(Context context) {
        super(context);
    }

    public MessageBoxCompound(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MessageBoxCompound(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MessageBoxCompound(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MessageBoxCompound);

        String text = a.getString(R.styleable.MessageBoxCompound_text);
        a.recycle();

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.message_box_compound, this, true);

        mMsgBoxEditText = (EditText)getChildAt(0);
        mMsgBoxEditText.setText(text);

        mMsgBoxImgButton = (ImageButton)getChildAt(1);

        setOrientation(LinearLayout.HORIZONTAL);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }

    public void setClickListener(OnClickListener onClickListener) {
        mMsgBoxImgButton.setOnClickListener(onClickListener);
        postInvalidate();
    }


    public String getText() {
        return mMsgBoxEditText.getText().toString();
    }
}
