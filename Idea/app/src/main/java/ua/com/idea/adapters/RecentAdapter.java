package ua.com.idea.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rightutils.rightutils.collections.RightList;

import ua.com.idea.entities.RecentItem;
import ua.com.idea.fragments.PictureRecentFragment;

/**
 * Created by cheb on 7/18/15.
 */
public class RecentAdapter extends FragmentPagerAdapter {

    private RightList<RecentItem> recentItems;


    public RecentAdapter(FragmentManager fm, RightList<RecentItem> recentItems) {
        super(fm);
        this.recentItems = recentItems;
    }

    @Override
    public Fragment getItem(int position) {
        return PictureRecentFragment.newInstance(recentItems.get(position));
    }

    @Override
    public int getCount() {
        return recentItems.size();
    }
}
