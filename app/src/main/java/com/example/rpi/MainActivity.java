package com.example.rpi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.rpi.Room_4.Room_4;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public FrameLayout mFrameLayout;
    public Room_4 m_room_4;
    public Toolbar mToolbar;
    private DrawerLayout mDrawer;
    private NavigationView mNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawer = findViewById(R.id.drawer_layout);

        mNavView = findViewById(R.id.navigation_view);

        mFrameLayout = findViewById(R.id.container_Drawer);

        mNavView.setNavigationItemSelectedListener(this);
        m_room_4 = new Room_4();
        loadFragment(m_room_4) ;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.main_menu_Room_4 :
                m_room_4 = new Room_4();
                loadFragment(m_room_4) ;
                mToolbar.setTitle("Home");
                mNavView.setCheckedItem(R.id.main_menu_Room_4);
                mDrawer.closeDrawer(GravityCompat.START);
                return true;

        }
        return false;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_Drawer, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}