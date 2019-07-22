package com.raiyan.automate.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.raiyan.automate.Activities.Homectivity;
import com.raiyan.automate.R;

public class FragmentLogin extends Fragment {

    private static final String TAG = FragmentLogin.class.getSimpleName();

    private Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        loginButton = view.findViewById(R.id.btn_login);
        loginButton.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), Homectivity.class);
            startActivity(intent);
        });
        return view;
    }
}
