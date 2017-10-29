package com.soumit.instagramclone.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.soumit.instagramclone.R;
import com.soumit.instagramclone.Utils.BottomNavigationViewHelper;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private Context mContext = HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: starting");

        setupBottomNavigationView();
        setupViewPager();
    }

    /**
     * Responsible for adding 3 tabs: camera, Home, Messages
     */

    public void setupViewPager(){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment());   //0
        adapter.addFragment(new HomeFragment());     //1
        adapter.addFragment(new MessagesFragment()); //2
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_instagram);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);
    }

    /**
     * BottomNavigationView setup
     */
   private void setupBottomNavigationView(){
       Log.d(TAG, "setupBottomNavigationView: setting up bottom navigation view");
       BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
       BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
       BottomNavigationViewHelper.enableNavigation(mContext , bottomNavigationViewEx);
       Menu menu = bottomNavigationViewEx.getMenu();
       MenuItem menuItem = menu.getItem(0);
       menuItem.setChecked(true);
   }


}


















