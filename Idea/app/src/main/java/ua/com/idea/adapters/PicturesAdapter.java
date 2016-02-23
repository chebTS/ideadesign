package ua.com.idea.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rightutils.rightutils.collections.RightList;

import ua.com.idea.entities.Image;
import ua.com.idea.entities.StubItemTempClass;
import ua.com.idea.fragments.PictureFragment;

/**
 * Created by cheb on 7/18/15.
 */
public class PicturesAdapter extends FragmentPagerAdapter {

    private RightList<Image> images;


    public PicturesAdapter(FragmentManager fm, RightList<Image> images) {
        super(fm);
        this.images = images;
    }

    @Override
    public Fragment getItem(int position) {
        return PictureFragment.newInstance(images.get(position));
    }

    @Override
    public int getCount() {
        return images.size();
    }
}
