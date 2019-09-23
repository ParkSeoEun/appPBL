package com.example.apppbl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apppbl.bean.MemberBean;

public class LockActivity extends AppCompatActivity {

    final EditText mEdtPwd  = findViewById(R.id.edtPwd);
    private String mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        findViewById(R.id.btn0).setOnClickListener(btnOnClick);
        findViewById(R.id.btn1).setOnClickListener(btnOnClick);
        findViewById(R.id.btn2).setOnClickListener(btnOnClick);
        findViewById(R.id.btn3).setOnClickListener(btnOnClick);
        findViewById(R.id.btn4).setOnClickListener(btnOnClick);
        findViewById(R.id.btn5).setOnClickListener(btnOnClick);
        findViewById(R.id.btn6).setOnClickListener(btnOnClick);
        findViewById(R.id.btn7).setOnClickListener(btnOnClick);
        findViewById(R.id.btn8).setOnClickListener(btnOnClick);
        findViewById(R.id.btn9).setOnClickListener(btnOnClick);
        findViewById(R.id.btnDel).setOnClickListener(btnOnClick);

        MemberBean memberBean = new MemberBean();
        // 패스워드 비교
        if(TextUtils.equals(mEdtPwd.getText().toString(), memberBean.memPwd)) {
            // 패스워드 일치 시 MainActivity로 이동
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
        } else { // 비밀번호 불일치
            // 토스트 메세지 띄움
            Toast.makeText(this, "비밀번호가 틀렸습니다.", Toast.LENGTH_LONG).show();
            // EditText 부분 초기화
            mEdtPwd.setText("");
        }
    }

    private View.OnClickListener btnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mText = mEdtPwd.getText().toString();
            // del 버튼 누를 시 마지막에 입력한 숫자 삭제
            if (((Button)view).getText().toString().equals("del")) {
                mEdtPwd.setText(mText.substring(0,mText.length()-1));
            } else { // 숫자 버튼 누를 시 editText 마지막 부분에 해당 버튼의 text 추가
                mText += ((Button) view).getText();
                mEdtPwd.setText(mText);
            }
        }
    };
}