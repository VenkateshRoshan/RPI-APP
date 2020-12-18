package com.example.rpi.Room_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rpi.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Room_4 extends Fragment {

    public Button mButton1, mButton2;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    String mLightPath = "Room_4/Light";
    String mFanPath = "Room_4/Fan";
    LinearLayout mLight, mFan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.room_4, container, false);
        mDatabase = FirebaseDatabase.getInstance();
        mLight = root.findViewById(R.id.LightBG);
        mFan = root.findViewById(R.id.FanBG);
        mButton1 = root.findViewById(R.id.LightState);
        mButton2 = root.findViewById(R.id.FanState);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef = mDatabase.getReference(mLightPath);

                if (mButton1.getText().toString() == "ON") {
                    mButton1.setText("OFF");
                    mLight.setBackgroundResource(R.drawable.bg_button_off);
                    mRef.setValue("OFF");
                } else {
                    mButton1.setText("ON");
                    mLight.setBackgroundResource(R.drawable.bg_button_on);
                    mRef.setValue("ON");
                }
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef = mDatabase.getReference(mFanPath);
                if (mButton2.getText().toString() == "ON") {
                    mButton2.setText("OFF");
                    mFan.setBackgroundResource(R.drawable.bg_button_off);
                    mRef.setValue("OFF");
                } else {
                    mButton2.setText("ON");
                    mFan.setBackgroundResource(R.drawable.bg_button_on);
                    mRef.setValue("ON");
                }
            }
        });
        return root;
    }
}
