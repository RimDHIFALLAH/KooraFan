package com.koora.koorafan.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.koora.koorafan.R;
import com.koora.koorafan.utils.SharedPreferencesUtil;


public class ProfileFrag extends Fragment {

    TextView txtName, txtEmail, txtAge;
    Button btnQuit;
    public ProfileFrag() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        txtName = root.findViewById(R.id.txtName);
        txtEmail = root.findViewById(R.id.txtEmail);
        txtAge = root.findViewById(R.id.txtAge);
        btnQuit = root.findViewById(R.id.btnQuit);

        txtName.setText(SharedPreferencesUtil.readStringToShared(getActivity(),"name"));
        txtEmail.setText(SharedPreferencesUtil.readStringToShared(getActivity(),"email"));
        txtAge.setText(SharedPreferencesUtil.readStringToShared(getActivity(),"age"));


        btnQuit.setOnClickListener(v -> {
            getActivity().finish();
        SharedPreferencesUtil.clearCache();

    });
        return root;
    }
}