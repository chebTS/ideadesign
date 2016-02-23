package ua.com.idea.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.rightutils.rightutils.collections.RightList;
import com.rightutils.rightutils.loaders.BaseLoader;
import com.rightutils.rightutils.loaders.LoaderListener;

import ua.com.idea.R;
import ua.com.idea.adapters.CategoryAdapter;
import ua.com.idea.application.IdeaApplication;
import ua.com.idea.entities.Chidlren;
import ua.com.idea.entities.Image;
import ua.com.idea.entities.Item;
import ua.com.idea.loaders.CategoryItemsLoader;
import ua.com.idea.utils.SystemUtils;


/**
 * Created by cheb on 7/18/15.
 */
public class CategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = CategoryActivity.class.getSimpleName();
    private Chidlren chidlren;
    private RightList<Item> items;
    private GridView gridView;
    private CategoryAdapter adapterNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setupToolbar();

        if (getIntent().hasExtra(Chidlren.class.getSimpleName())) {
            chidlren = (Chidlren) getIntent().getSerializableExtra(Chidlren.class.getSimpleName());
            if (chidlren != null) {
                ((TextView) findViewById(R.id.txt_title)).setText(chidlren.getName());
                gridView = (GridView ) findViewById(R.id.grid);
                gridView.setOnItemClickListener(this);

                if (SystemUtils.useServer) {
                    //using server
                    final CategoryItemsLoader categoryItemsLoader = new CategoryItemsLoader(CategoryActivity.this, 0, chidlren.getLink());
                    categoryItemsLoader.setLoaderListener(new LoaderListener<Boolean>() {
                        @Override
                        public void onLoadFinished(FragmentActivity fragmentActivity, Fragment fragment, Boolean aBoolean, BaseLoader<Boolean> baseLoader) {
                            if (aBoolean) {
                                CategoryActivity.this.items = categoryItemsLoader.getItems();
                                Log.i(TAG, "Items size : " + items.size());
                                adapterNew = new CategoryAdapter(CategoryActivity.this, R.layout.item_folder, R.id.txt_date, items);
                                gridView.setAdapter(adapterNew);

                                Log.i(TAG, "Saved items size: " + IdeaApplication.dbUtils.getAll(Item.class).size());
                                Log.i(TAG, "Saved images size: " + IdeaApplication.dbUtils.getAll(Image.class).size());


                            } else {
                                SystemUtils.toast(CategoryActivity.this, "Error");
                            }
                        }

                        @Override
                        public void onCancelLoad() {
                            categoryItemsLoader.cancelLoad();
                        }
                    });
                    categoryItemsLoader.execute();
                }else{
                    //using db
                    items = IdeaApplication.dbUtils.getAllWhere("catid = " + chidlren.getId() +" order by created DESC ", Item.class);
                    adapterNew = new CategoryAdapter(CategoryActivity.this, R.layout.item_folder, R.id.txt_date, items);
                    gridView.setAdapter(adapterNew);
                }
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(CategoryActivity.this, PicturesActivity.class);
        intent.putExtra(Item.class.getSimpleName(), (Item)gridView.getAdapter().getItem(position));
        startActivity(intent);
    }
}