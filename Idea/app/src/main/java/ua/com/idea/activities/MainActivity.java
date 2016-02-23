package ua.com.idea.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import ua.com.idea.R;
import ua.com.idea.fragments.AboutFragment;
import ua.com.idea.fragments.PlaceHolderFragment;
import ua.com.idea.fragments.PrivateInteriorsFragment;
import ua.com.idea.fragments.RecentFragment;

/**
 * Created by cheb on 7/16/15.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    protected ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout drawerLayout;
    private NavigationView mNavigationView;
    private TextView txtTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        initNavigationDrawer();
        showFragment(mNavigationView.getMenu().getItem(0));
        mNavigationView.setCheckedItem(mNavigationView.getMenu().getItem(0).getItemId());
    }

    private void initNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        setupActionBarDrawerToogle();
        if (mNavigationView != null) {
            setupDrawerContent(mNavigationView);
        }
    }

    private void setupToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        txtTitle = (TextView) findViewById(R.id.txt_title);
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupActionBarDrawerToogle() {
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close) /* "close drawer" description */ {

            public void onDrawerClosed(View view) {
            }

            public void onDrawerOpened(View drawerView) {
            }
        };
        drawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void setupDrawerContent(NavigationView navigationView) {
         navigationView.setNavigationItemSelectedListener(
                 new NavigationView.OnNavigationItemSelectedListener() {
                     @Override
                     public boolean onNavigationItemSelected(MenuItem menuItem) {
                         menuItem.setChecked(true);
                         drawerLayout.closeDrawers();
                         showFragment(menuItem);
                         return true;
                     }
                 });
    }



    private void showFragment(MenuItem menuItem){
        Log.i(TAG,"id: " + menuItem.getItemId());
        Fragment fragment = new PlaceHolderFragment();
        FragmentManager fm =((FragmentActivity) MainActivity.this).getSupportFragmentManager();

        switch (menuItem.getItemId()){
            case R.id.nav_recent:
                txtTitle.setText(R.string.recent_title);
                fragment = new RecentFragment();
                break;
            case R.id.nav_private:
                txtTitle.setText(R.string.private_interiors_title);
                fragment = new PrivateInteriorsFragment();
                break;
            case R.id.nav_public:
                txtTitle.setText(R.string.public_interiors_title);
                break;
            case R.id.nav_favorites:
                txtTitle.setText(R.string.favorites_title);
                break;
            case R.id.nav_about:
                txtTitle.setText(R.string.about_title);
                fragment = new AboutFragment();
                break;
            case R.id.nav_order:
                txtTitle.setText(R.string.order_online_title);
                break;
        }
        fm.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

    }

    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }

    protected boolean isNavDrawerOpen() {
        return drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }



}
