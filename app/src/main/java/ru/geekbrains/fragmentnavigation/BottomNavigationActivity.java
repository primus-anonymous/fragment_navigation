package ru.geekbrains.fragmentnavigation;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        if (savedInstanceState == null) {
            addFragment(new MainFragment(), "MainFragment");
        }

        final BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);

        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_settings:
                        addFragment(new SettingsFragment(), "SettingsFragment");
                        break;

                    case R.id.action_favorite:
                        addFragment(new FavoriteFragment(), "FavoriteFragment");
                        break;

                    case R.id.action_main:
                        addFragment(new MainFragment(), "MainFragment");
                        break;
                }
                return false;
            }
        });

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {

        } else {

        }
    }

    private void addFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, tag)
                .commit();
    }
}