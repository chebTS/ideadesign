package ua.com.idea.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rightutils.rightutils.collections.RightList;

import ua.com.idea.fragments.PictureRecentDetailsFragment;

/**
 * Created by cheb on 7/18/15.
 */
public class PicturesRecentAdapter extends FragmentPagerAdapter {

    private RightList<String> images;


    public PicturesRecentAdapter(FragmentManager fm, RightList<String> images) {
        super(fm);
        this.images = images;
    }

    @Override
    public Fragment getItem(int position) {
        return PictureRecentDetailsFragment.newInstance(images.get(position));
    }

    @Override
    public int getCount() {
        return images.size();
    }
}
