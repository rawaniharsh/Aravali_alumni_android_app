package com.ana.aravalialumni;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        android.support.v4.app.Fragment fragment= null;
        int id = item.getItemId();


        if (id == R.id.profile) {

            FragmentProfile fragmentProfile = new FragmentProfile();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,fragmentProfile)
                    .addToBackStack(null)
                    .commit();
        }
        else if (id == R.id.members) {
            FragmentMembers fragmentMembers = new FragmentMembers();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,fragmentMembers)
                    .addToBackStack(null)
                    .commit();

            }

        else if (id == R.id.events) {
            FragmentEvents fragmentEvents = new FragmentEvents();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,fragmentEvents)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.Jobs) {
            FragmentJobs fragmentJobs = new FragmentJobs();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,fragmentJobs)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.Settings) {
            FragmentSettings fragmentSettings = new FragmentSettings();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,fragmentSettings)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.logout) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
