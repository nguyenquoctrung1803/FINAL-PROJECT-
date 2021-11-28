package com.sinhvien.finalproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinhvien.finalproject.DAO.NhanVienDAO;
import com.sinhvien.finalproject.R;

public class resetPassword extends AppCompatActivity {

    EditText password,repassword;
    TextView username;
    Button btnxacnhan;
    NhanVienDAO nhanVienDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repassword);

        password = findViewById(R.id.txt_login_password);
        repassword = findViewById(R.id.txt_login_repassword);
        btnxacnhan = findViewById(R.id.btn_login_Xacnhan);
        username = findViewById(R.id.user_repass);

        nhanVienDAO= new NhanVienDAO(this);

        Intent intent = getIntent();
        username.setText(intent.getStringExtra("username"));


        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                if (pass.equals(repass)) {


                    Boolean updatePassword = nhanVienDAO.updatePassword(user, pass);
                    if (updatePassword == true) {

                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(resetPassword.this, "Đã cập nhật lại mật khẩu ! ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(resetPassword.this, "Cập nhật mật khẩu không thành công!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(resetPassword.this, "Mật khẩu không khớp !!", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}
