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
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Light ON , invisible , set B2 to visible
                mButton2.setVisibility(view.VISIBLE);
                mButton1.setVisibility(view.INVISIBLE);
            }
        });
        mButton2 = root.findViewById(R.id.OFF_LIGHT) ;
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Light OFF , invisible , set B1 to visible
                mButton1.setVisibility(view.VISIBLE);
                mButton2.setVisibility(view.INVISIBLE);
            }
        });
        mButton3 = root.findViewById(R.id.ON_FAN) ;
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Fan ON , invisible , set B4 to visible
                mButton4.setVisibility(view.VISIBLE);
                mButton3.setVisibility(view.INVISIBLE);
            }
        });
        mButton4 = root.findViewById(R.id.OFF_FAN) ;
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Light OFF , invisible , set B3 to visible
                mButton4.setVisibility(view.INVISIBLE);
                mButton3.setVisibility(view.VISIBLE);
            }
        });
        return root;
    }
}
