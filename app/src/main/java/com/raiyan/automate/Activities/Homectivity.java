package com.raiyan.automate.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.raiyan.automate.Adapters.HomeScreenViewPagerAdapter;
import com.raiyan.automate.Fragments.HomeFragment;
import com.raiyan.automate.Fragments.RoomFragment;
import com.raiyan.automate.Fragments.StatsFragment;
import com.raiyan.automate.R;

public class Homectivity extends AppCompatActivity {

    private static final String TAG = Homectivity.class.getSimpleName();

    private ViewPager homeViewPager;
    private TabLayout homeBottomTab;

    private HomeScreenViewPagerAdapter homeScreenViewPagerAdapter;
    private RoomFragment roomFragment;
    private HomeFragment homeFragment;
    private StatsFragment statsFragment;

    private ImageView navButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homectivity);

        homeViewPager = findViewById(R.id.home_viewpager);
        homeBottomTab = findViewById(R.id.homeBottomTab);

        homeScreenViewPagerAdapter = new HomeScreenViewPagerAdapter(getSupportFragmentManager());
        roomFragment = new RoomFragment();
        homeFragment = new HomeFragment();
        statsFragment = new StatsFragment();
        homeScreenViewPagerAdapter.addFragment(homeFragment,"Home");
        homeScreenViewPagerAdapter.addFragment(roomFragment,"Rooms");
        homeScreenViewPagerAdapter.addFragment(statsFragment,"Stats");
        homeViewPager.setAdapter(homeScreenViewPagerAdapter);
        homeBottomTab.setupWithViewPager(homeViewPager);

        homeBottomTab.getTabAt(0).setIcon(R.drawable.home_selected);
        homeBottomTab.getTabAt(1).setIcon(R.drawable.rooms_selected);
        homeBottomTab.getTabAt(2).setIcon(R.drawable.graph_selected);

        navButton = findViewById(R.id.nav_button);
        navButton.setOnClickListener(view -> Toast.makeText(Homectivity.this,"Nav Button clicked",Toast.LENGTH_SHORT).show());
    }
}
