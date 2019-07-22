package com.raiyan.automate.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.raiyan.automate.Fragments.FragmentLogin;
import com.raiyan.automate.Fragments.FragmentSignUp;
import com.raiyan.automate.R;
import com.raiyan.automate.Adapters.LoginSignupViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    LoginSignupViewPagerAdapter loginSignupViewPagerAdapter;

    FragmentLogin fragmentLogin;
    FragmentSignUp fragmentSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPagerLoginSignIn);
        loginSignupViewPagerAdapter = new LoginSignupViewPagerAdapter(getSupportFragmentManager());

        //Adding Fragments
        fragmentLogin = new FragmentLogin();
        fragmentSignUp = new FragmentSignUp();
        loginSignupViewPagerAdapter.addFragment(fragmentLogin,"Login");
        loginSignupViewPagerAdapter.addFragment(fragmentSignUp,"SignUp");
        viewPager.setAdapter(loginSignupViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Login");
        tabLayout.getTabAt(1).setText("SignUp");

    }
}
