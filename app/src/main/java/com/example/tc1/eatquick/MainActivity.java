package com.example.tc1.eatquick;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ShareActionProvider;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "drive.google.com");
                intent.setType("text");
                startActivity(Intent.createChooser(intent, "Share via"));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_home);


//        Locale[] locale = Locale.getAvailableLocales();
//        ArrayList<String> countries = new ArrayList<>();
//        String country;
//        for (Locale loc : locale) {
//            country = loc.getDisplayCountry();
//            if (country.length() > 0 && !countries.contains(country)) {
//                countries.add(country);
//            }
//        }
//        Collections.sort(countries, String.CASE_INSENSITIVE_ORDER);
//
//        Spinner citizenship = (Spinner) findViewById(R.id.sp_state);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
//        citizenship.setAdapter(adapter);
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

    private void displaySelectedScreen(int id) {
        Fragment fragment = null;
        Bundle bundle = new Bundle();

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
        }else if (id == R.id.nav_register) {
            fragment = new RegisterFragment();
        } else if (id == R.id.nav_login) {
            fragment = new LoginFragment();
        } else if (id == R.id.nav_help) {
            fragment = new HelpFragment();
        } else if (id == R.id.nav_facebook) {
            bundle.putString("url", "https://www.facebook.com/segun.francis1");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.nav_google) {
            bundle.putString("url", "https://www.google.com");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.nav_twitter) {
            bundle.putString("url", "https://www.twitter.com/segun__francis");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        }
        if(fragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        displaySelectedScreen(id);
        return true;
    }
}