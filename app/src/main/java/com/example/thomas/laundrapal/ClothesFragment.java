package com.example.thomas.laundrapal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClothesFragment extends Fragment{

    public static ClothesFragment newInstance() {
        ClothesFragment fragment = new ClothesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clothes , container, false);
        return view;
    }
}
