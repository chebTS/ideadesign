package ua.com.idea.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rightutils.rightutils.collections.RightList;
import com.rightutils.rightutils.loaders.BaseLoader;
import com.rightutils.rightutils.loaders.LoaderListener;
import com.viewpagerindicator.CirclePageIndicator;

import ua.com.idea.R;
import ua.com.idea.adapters.RecentAdapter;
import ua.com.idea.entities.RecentItem;
import ua.com.idea.loaders.RecentLoader;
import ua.com.idea.utils.SystemUtils;

/**
 * Created by cheb on 7/25/15.
 */
public class RecentFragment extends Fragment {
    private static final String TAG = RecentFragment.class.getSimpleName();
    private ViewPager pager;
    private RecentAdapter adapter;
    private RightList<RecentItem> recentItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recent, container, false);

    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pager = (ViewPager) view.findViewById(R.id.pager);


        final RecentLoader recentLoader = new RecentLoader(getActivity(), 0);
        recentLoader.setLoaderListener(new LoaderListener<Boolean>() {
            @Override
            public void onLoadFinished(FragmentActivity fragmentActivity, Fragment fragment, Boolean aBoolean, BaseLoader<Boolean> baseLoader) {
                if (aBoolean) {
                    recentItems = recentLoader.getRecentItems();

                    adapter = new RecentAdapter(getChildFragmentManager(), recentItems);
                    pager.setAdapter(adapter);
                    pager.setOffscreenPageLimit(3);

                    CirclePageIndicator indicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
                    indicator.setViewPager(pager);
                } else {
                    SystemUtils.toast(getActivity(), "Error");
                }
            }

            @Override
            public void onCancelLoad() {
                recentLoader.cancelLoad();
            }
        });
        recentLoader.execute();


    }
}
