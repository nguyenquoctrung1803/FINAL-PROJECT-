package com.sinhvien.finalproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.sinhvien.finalproject.Activities.HomeActivity;
import com.sinhvien.finalproject.Activities.WelcomeActivity;
import com.sinhvien.finalproject.DAO.NhanVienDAO;
import com.sinhvien.finalproject.DTO.NhanVienDTO;
import com.sinhvien.finalproject.R;

public class DisplayInformationFragment extends Fragment {
    TextView i4_Hoten, i4_Birth, i4_Gender, i4_Email, i4_Phonenum, i4_Logout;
    FragmentManager fragmentManager;
    NhanVienDAO nhanVienDAO;
    int manv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.displayinformation_layout,container,false);
        ((HomeActivity)getActivity()).getSupportActionBar().setTitle("Thông tin");
        setHasOptionsMenu(false);

        i4_Hoten = view.findViewById(R.id.i4_hoten);
        i4_Birth = view.findViewById(R.id.i4_birth);
        i4_Gender = view.findViewById(R.id.i4_gender);
        i4_Email = view.findViewById(R.id.i4_mail);
        i4_Phonenum = view.findViewById(R.id.i4_phonenum);
        i4_Logout = view.findViewById(R.id.i4_logout);


        nhanVienDAO = new NhanVienDAO(getActivity());
        Intent intent = getActivity().getIntent();
        manv = intent.getIntExtra("manv",0);
        NhanVienDTO nhanVienDTO = nhanVienDAO.LayNVTheoMa(manv);
        i4_Hoten.setText(nhanVienDTO.getHOTENNV());
        i4_Birth.setText(nhanVienDTO.getNGAYSINH());
        i4_Gender.setText(nhanVienDTO.getGIOITINH());
        i4_Email.setText(nhanVienDTO.getEMAIL());
        i4_Phonenum.setText(nhanVienDTO.getSDT());
        i4_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), WelcomeActivity.class);
                startActivity(intent);
            }
        });

        return  view;
    }



}
