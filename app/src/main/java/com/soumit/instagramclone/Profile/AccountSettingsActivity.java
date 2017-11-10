package com.soumit.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.soumit.instagramclone.R;
import com.soumit.instagramclone.Utils.SectionsPagerAdapter;

import java.util.ArrayList;

/**
 * Created by SOUMIT on 10/31/2017.
 */

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";
    private Context mContext;

    private SectionsPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accout_settings);
        mContext = AccountSettingsActivity.this;
        Log.d(TAG, "onCreate: started");
        viewPager = (ViewPager) findViewById(R.id.container);
        relativeLayout = (RelativeLayout) findViewById(R.id.relLayout1);

        setupSettingsList();

        setupFragments();

        //setting up backarrow to navigate back to "profileActivity"
        ImageView backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating back to ProfileActivity");
                finish();
            }
        });

    }

    private void setupFragments(){
        pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), "Edit profile");
        pagerAdapter.addFragment(new SignoutFragment(), "Sign out");
    }

    private void setViewPager(int fragmentNumber){
        relativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setViewPager: navigation to fragment: " + fragmentNumber);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }


    private void setupSettingsList(){
        Log.d(TAG, "setupSettingsList: initializing account settings list");
        ListView listView = (ListView) findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add("Edit profile");
        options.add("Sign out");

        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.d(TAG, "onItemClick: navigating to fragment#" + position);
                setViewPager(position);
            }
        });

    }

}


















