package com.example.rpi.Room_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rpi.R;

public class Room_4 extends Fragment {

    public Button mButton1 , mButton2 , mButton3 , mButton4 ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.room_4, container, false);
        mButton1 = root.findViewById(R.id.ON_LIGHT) ;
        mButton2 = root.findViewById(R.id.OFF_LIGHT) ;
        mButton3 = root.findViewById(R.id.ON_FAN) ;
        mButton4 = root.findViewById(R.id.OFF_FAN) ;
        return root;
    }
}
