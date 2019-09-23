package com.example.apppbl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.apppbl.bean.MemberBean;

public class SetLockActivity extends AppCompatActivity {

    private RadioButton mRadSet, mRadSetNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_lock);

        mRadSet = findViewById(R.id.radSet);
        mRadSetNo = findViewById(R.id.radSetNo);
        mRadSet.setOnClickListener(onClickRadio);
        mRadSetNo.setOnClickListener(onClickRadio);
        // 기본적으로 암호 설정이 안됨
        mRadSetNo.setChecked(true);
    }

    private RadioButton.OnClickListener onClickRadio = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 암호 사용으로 체크될 시
            if(mRadSet.isChecked()) {
                // 암호 설정 액티비티로 넘어감
                Intent i = new Intent(getApplicationContext(), SetPasswordActivity.class);
                startActivity(i);
            } else  {
                // 암호 사용안함으로 체크될 시
                MemberBean memberBean = new MemberBean();
                memberBean.memPwd = "";
            }
        }
    };
}
