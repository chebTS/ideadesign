package ua.com.idea.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.viewpagerindicator.CirclePageIndicator;

import ua.com.idea.R;
import ua.com.idea.adapters.PicturesRecentAdapter;
import ua.com.idea.application.IdeaApplication;
import ua.com.idea.entities.RecentItem;


/**
 * Created by cheb on 7/18/15.
 */
public class PicturesRecentActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = PicturesRecentActivity.class.getSimpleName();
    private ViewPager pager;
    private PicturesRecentAdapter adapter;
    private RecentItem recentItem;
    private ToggleButton btnFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        setupToolbar();
        if (getIntent().hasExtra(RecentItem.class.getSimpleName())) {
            btnFav = (ToggleButton) findViewById(R.id.btn_fav);
            btnFav.setOnCheckedChangeListener(this);
            //.setOnClickListener(this);
            recentItem = (RecentItem) getIntent().getSerializableExtra(RecentItem.class.getSimpleName());
            Log.i(TAG, "LOG: " + recentItem.toString());

            Log.i(TAG, "Items in DB: " +  IdeaApplication.dbUtils.getAll(RecentItem.class).size());
            ((TextView) findViewById(R.id.txt_title))
                    .setText(recentItem.getTitle());
            pager = (ViewPager) findViewById(R.id.pager);
            Log.i(TAG, "Item:" + recentItem.toString());

            adapter = new PicturesRecentAdapter(getSupportFragmentManager(), recentItem.getImages());
            pager.setAdapter(adapter);
            pager.setOffscreenPageLimit(3);

            CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
            indicator.setViewPager(pager);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.btn_fav:
                Log.i(TAG, "FAV" + isChecked);
                break;
        }
    }



    private void setupToolbar() {
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_content);
        coordinatorLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.back_btn);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
