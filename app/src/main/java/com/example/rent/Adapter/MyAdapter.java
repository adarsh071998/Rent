package com.example.rent.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rent.Fragments.HomeFragment;
import com.example.rent.Fragments.NotificationFragment;
import com.example.rent.Fragments.ShortListFragment;

public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                ShortListFragment shortListFragment = new ShortListFragment();
                return shortListFragment;
            case 2:
                NotificationFragment notificationFragment= new NotificationFragment();
                return notificationFragment;
            default:
                return null ;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){

            case 0 : return "Home";
            case 1 : return "Short List";
            case 2 : return "Notification";
            default:return null;
        }
    }
}
