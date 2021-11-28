package com.sinhvien.finalproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinhvien.finalproject.DAO.NhanVienDAO;
import com.sinhvien.finalproject.R;

public class PasswordActivity extends AppCompatActivity {

    EditText txt_login_username;
    Button btn_login_rePassword;
    NhanVienDAO nhanVienDAO;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_password);


        txt_login_username = findViewById(R.id.txtl_login_TenDN);
        btn_login_rePassword = findViewById(R.id.btn_login_rePassword);

        nhanVienDAO = new NhanVienDAO(this);

        btn_login_rePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = txt_login_username.getText().toString();

                int checkuser = nhanVienDAO.checkUser(username);

            if(checkuser != 0 ){
                Intent intent = new Intent(getApplicationContext(), resetPassword.class);
                intent.putExtra("tenDN", username);
                startActivity(intent);
            }else {
                Toast.makeText(PasswordActivity.this, "Tên đăng nhập không tồn tại !", Toast.LENGTH_SHORT).show();
            }

            }
        });



    }
}
