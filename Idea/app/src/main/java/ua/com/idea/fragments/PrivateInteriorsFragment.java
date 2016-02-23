package ua.com.idea.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.rightutils.rightutils.collections.RightList;
import com.rightutils.rightutils.loaders.BaseLoader;
import com.rightutils.rightutils.loaders.LoaderListener;

import ua.com.idea.R;
import ua.com.idea.activities.CategoryActivity;
import ua.com.idea.adapters.GridChildAdapter;
import ua.com.idea.application.IdeaApplication;
import ua.com.idea.entities.Category;
import ua.com.idea.entities.Chidlren;
import ua.com.idea.loaders.PrivateInteriorLoader;
import ua.com.idea.utils.SystemUtils;


/**
 * Created by cheb on 7/18/15.
 */
public class PrivateInteriorsFragment extends Fragment implements AdapterView.OnItemClickListener {
    private static final String TAG = PrivateInteriorsFragment.class.getSimpleName();
    private GridView gridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_private, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = (GridView)view.findViewById(R.id.grid);
        gridView.setOnItemClickListener(this);


        if (SystemUtils.useServer) {
            // using server
            final PrivateInteriorLoader privateInteriorLoader = new PrivateInteriorLoader(getActivity(), 1);
            privateInteriorLoader.setLoaderListener(new LoaderListener<Boolean>() {
                @Override
                public void onLoadFinished(FragmentActivity fragmentActivity, Fragment fragment, Boolean aBoolean, BaseLoader<Boolean> baseLoader) {
                    if (aBoolean) {
                        GridChildAdapter adapter = new GridChildAdapter(getActivity(),
                                R.layout.item_child, R.id.txt_name,
                                privateInteriorLoader.getCategory().getChidlren());
                        gridView.setAdapter(adapter);
                        Log.i(TAG, "Saved Categories size: " + IdeaApplication.dbUtils.getAll(Category.class));
                        Log.i(TAG, "Saved Childrens size: " + IdeaApplication.dbUtils.getAll(Chidlren.class).size());
                    } else {
                        SystemUtils.toast(getContext(), "Loading error");
                    }
                }

                @Override
                public void onCancelLoad() {
                    privateInteriorLoader.cancelLoad();
                }
            });
            privateInteriorLoader.execute();
        }else{
            //using DB
            RightList<Chidlren> chidlrens = IdeaApplication.dbUtils.getAllWhere("parent = 9", Chidlren.class);
            GridChildAdapter adapter = new GridChildAdapter(getActivity(),
                    R.layout.item_child, R.id.txt_name,chidlrens);
            gridView.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), CategoryActivity.class);
        intent.putExtra(Chidlren.class.getSimpleName(),
                (Chidlren) gridView.getAdapter().getItem(position));
        startActivity(intent);
    }
}
