package com.sinhvien.finalproject.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.sinhvien.finalproject.Activities.HomeActivity;
import com.sinhvien.finalproject.DAO.DonDatDAO;
import com.sinhvien.finalproject.DAO.LoaiMonDAO;
import com.sinhvien.finalproject.DAO.NhanVienDAO;
import com.sinhvien.finalproject.DTO.NhanVienDTO;
import com.sinhvien.finalproject.R;

import java.util.List;

public class DisplayInformationFragment extends Fragment {

    NhanVienDAO nhanVienDAO;
    List<NhanVienDTO> nhanVienDTOS;
    int maquyen = 0, manv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.displayinformation_layout,container,false);
        ((HomeActivity)getActivity()).getSupportActionBar().setTitle("Thông Tin Cá Nhân");
        setHasOptionsMenu(true);

        TextView tv_information_Hoten = (TextView) view.findViewById(R.id.txt_information_hoten);





        return view;
    }


}
