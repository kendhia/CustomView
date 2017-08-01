package me.hipo.projects.kendhia.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MessageBoxCompound mMsgBox;
    LinearLayout mScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScrollView = (LinearLayout) findViewById(R.id.scrollView);

        mMsgBox = (MessageBoxCompound) findViewById(R.id.message_box);
        mMsgBox.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = mMsgBox.getText();
                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.msg_txt, mScrollView, false);
                tv.setText(msg);
                mScrollView.addView(tv, 0);
            }
        });

    }
}
