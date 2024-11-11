// ButtonFragment.java
package com.example.elecciones.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.elecciones.R;

public class ButtonFragment extends Fragment {

    private int buttonTextResId;
    private View.OnClickListener onClickListener;

    public ButtonFragment(int buttonTextResId, View.OnClickListener onClickListener) {
        this.buttonTextResId = buttonTextResId;
        this.onClickListener = onClickListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        Button button = view.findViewById(R.id.fragment_button);
        button.setText(buttonTextResId);
        button.setOnClickListener(onClickListener);
        return view;
    }
}