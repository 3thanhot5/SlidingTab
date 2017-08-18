package itri.vmi.slidingtab;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import itri.vmi.slidingtab.fragment.TabFragment;

public class SlidingTab extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("SlidingTabs");//設定barTitle
        initTabFragment(savedInstanceState);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //Navigation part
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Use the native icon.
        navigationView.setItemIconTintList(null);
        //Set header content.
        View header=navigationView.getHeaderView(0);
        TextView name = header.findViewById(R.id.nav_header);
        name.setText("omg");
    }

/*
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("SlidingTabs");//設定barTitle

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
*/
    private void initTabFragment(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            TabFragment tabFragment = new TabFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_fragment, tabFragment)
                    .commit();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_Connect) {
            // Handle the Connect action
            Log.i("TAG", "onClick: " +id);
        } else if (id == R.id.nav_QRcode) {
            Log.i("TAG", "onClick: " +id);
        } else if (id == R.id.nav_LOGOUT) {
            Log.i("TAG", "onClick: " +id);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

