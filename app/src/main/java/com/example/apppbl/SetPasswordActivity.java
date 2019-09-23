package com.example.apppbl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.apppbl.bean.MemberBean;

public class SetPasswordActivity extends AppCompatActivity {

    final EditText mEdtSetPwd = findViewById(R.id.edtSetPwd);
    private Button mBtnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);

        findViewById(R.id.btnSet0).setOnClickListener(btnSetOnClick);
        findViewById(R.id.btnSet1).setOnClickListener(btnSetOnClick);
        findViewById(R.id.btnSet2).setOnClickListener(btnSetOnClick);
        findViewById(R.id.btnSet3).setOnClickListener(btnSetOnClick);
        findViewById(R.id.btnSet4).setOnClickListener(btnSetOnClick);
        findViewById(R.id.btnSet5).setOnClickListener(btnSetOnClick);
        findViewById(R.id.btnSet6).setOnClickListener(btnSetOnClick);
        findViewById(R.id.btnSet7).setOnClickListener(btnSetOnClick);
        findViewById(R.id.btnSet8).setOnClickListener(btnSetOnClick);
        findViewById(R.id.btnSet9).setOnClickListener(btnSetOnClick);

        mBtnSet = findViewById(R.id.btnSet);
        mBtnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 비밀번호 설정 버튼 누를 시
                String mText = mEdtSetPwd.getText().toString();
                MemberBean memberBean = new MemberBean();
                // EditText의 문자열이 MemberBean의 memPwd에 저장
                memberBean.memPwd = mText;
            }
        });
    }

    private View.OnClickListener btnSetOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String mText = mEdtSetPwd.getText().toString();
            if(((Button)view).getText().toString().equals("del")) {
                mEdtSetPwd.setText(mText.substring(0,mText.length()-1));
            } else {
                mText += ((Button) view).getText();
                mEdtSetPwd.setText(mText);
            }
        }
    };
}
