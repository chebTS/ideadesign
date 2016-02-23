package ua.com.idea.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rightutils.rightutils.collections.RightList;
import com.viewpagerindicator.CirclePageIndicator;

import ua.com.idea.R;
import ua.com.idea.adapters.PicturesAdapter;
import ua.com.idea.application.IdeaApplication;
import ua.com.idea.entities.Image;
import ua.com.idea.entities.Item;

/**
 * Created by cheb on 7/18/15.
 */
public class PicturesActivity extends AppCompatActivity {
    private static final String TAG = PicturesActivity.class.getSimpleName();
    private ViewPager pager;
    private PicturesAdapter adapter;
    private Item item;
    private ImageView imgInfo;
    private TextView txtFullText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        setupToolbar();
        if (getIntent().hasExtra(Item.class.getSimpleName())) {
            item = (Item) getIntent().getSerializableExtra(Item.class.getSimpleName());
            ((TextView) findViewById(R.id.txt_title)).setText(item.getTitle());
            pager = (ViewPager) findViewById(R.id.pager);
            Log.i(TAG, "Item:" + item.toString());

            RightList<Image> images = IdeaApplication.dbUtils.getAllWhere("itemid = " + item.getId(), Image.class);
            adapter = new PicturesAdapter(getSupportFragmentManager(), images);
//            adapter = new PicturesAdapter(getSupportFragmentManager(), item.getImages());
            pager.setAdapter(adapter);
            pager.setOffscreenPageLimit(3);

            CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
            indicator.setViewPager(pager);
            imgInfo = (ImageView) findViewById(R.id.img_info);
            if (item.getFulltext() != null && item.getFulltext().length() > 0) {
                txtFullText = (TextView)findViewById(R.id.txt_full_text);
                txtFullText.setText(Html.fromHtml(item.getFulltext()));
                imgInfo.setVisibility(View.VISIBLE);
                txtFullText.setMovementMethod(new ScrollingMovementMethod());
                imgInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (txtFullText.getVisibility() == View.GONE) {
                            txtFullText.setVisibility(View.VISIBLE);
                        }else{
                            txtFullText.setVisibility(View.GONE);
                        }
                    }
                });
            }
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
