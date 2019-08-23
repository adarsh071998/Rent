package com.example.rent;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.rent.Fragments.ProfileFragment;

public class Home extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private android.support.v7.widget.Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeStuff();

        setSupportActionBar(toolbar);

        setUpNavigationView(navigationView);

        drawerToggle = setupDrawerToggle();
        drawerLayout.addDrawerListener(drawerToggle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameContent,new TabFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_home);
        setTitle("Rent");

    }

    void initializeStuff(){
        drawerLayout   =  findViewById(R.id.drawerLayout);
        toolbar        =  findViewById(R.id.toolbar);
        navigationView =  findViewById(R.id.navigationDrawer);
    }


    private void setUpNavigationView(final NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        //replace the current fragment with the new fragment.
                        Fragment selectedFragment = selectDrawerItem(menuItem);
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frameContent, selectedFragment).commit();
                        // the current menu item is highlighted in navigation tray.
                        navigationView.setCheckedItem(menuItem.getItemId());
                        if(menuItem.getItemId() == R.id.nav_home)
                        {
                            setTitle("Rent");
                        }else {
                            setTitle(menuItem.getTitle());
                        }
                        //close the drawer when user selects a nav item.
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


    public Fragment selectDrawerItem(MenuItem menuItem){
        Fragment fragment = null;
        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                fragment = new TabFragment();
                break;
            case R.id.nav_post_property:
                fragment = new PostPropertyFragment();
                break;
            case R.id.nav_logout:
                fragment=null;
                login();
                break;

            case R.id.nav_profile:
                fragment = new ProfileFragment();
                break;
        }
        return fragment;
    }
    void login()
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }


    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.drawer_open,R.string.drawer_close);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }


    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


}
