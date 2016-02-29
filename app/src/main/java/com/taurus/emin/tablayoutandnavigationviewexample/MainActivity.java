package com.taurus.emin.tablayoutandnavigationviewexample;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.taurus.emin.tablayoutandnavigationviewexample.adapters.TabFragmentAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int navigationItemId;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new TabFragmentAdapter(this, getSupportFragmentManager()));

        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTabIndicator));
        tabLayout.setTabTextColors(getResources().getColor(android.R.color.white), getResources().getColor(android.R.color.white));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        navigationItemId = item.getItemId();
        //Check to see which item was being clicked and perform appropriate action
        switch (navigationItemId){
            case R.id.navigation_item_1:
                tabLayout.getTabAt(0).select();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.navigation_item_2:
                tabLayout.getTabAt(1).select();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.navigation_item_3:
                tabLayout.getTabAt(2).select();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
