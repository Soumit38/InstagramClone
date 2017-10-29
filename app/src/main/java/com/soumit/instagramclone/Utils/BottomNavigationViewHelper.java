package com.soumit.instagramclone.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.soumit.instagramclone.Home.HomeActivity;
import com.soumit.instagramclone.Likes.LikeActivity;
import com.soumit.instagramclone.Profile.ProfileActivity;
import com.soumit.instagramclone.R;
import com.soumit.instagramclone.Search.SearchActivity;
import com.soumit.instagramclone.Share.ShareActivity;

/**
 * Created by SOUMIT on 10/29/2017.
 */

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHelper";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "Setting up bottomNavigationview");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationView view){
        view.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_house:
                        Intent intent_house = new Intent(context, HomeActivity.class);
                        context.startActivity(intent_house);
                        break;

                    case R.id.ic_search:
                        Intent intent_search = new Intent(context, SearchActivity.class);
                        context.startActivity(intent_search);
                        break;

                    case R.id.ic_circle:
                        Intent intent_circle = new Intent(context, ShareActivity.class);
                        context.startActivity(intent_circle);
                        break;

                    case R.id.ic_alert:
                        Intent intent_alert = new Intent(context, LikeActivity.class);
                        context.startActivity(intent_alert);
                        break;

                    case R.id.ic_android:
                        Intent intent_android = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent_android);
                        break;

                }
            }
        });
    }

}

























