package ua.com.idea.loaders;

import android.support.v4.app.FragmentActivity;

import com.rightutils.rightutils.loaders.BaseLoader;
import com.rightutils.rightutils.utils.RightUtils;

/**
 * Created by cheb on 9/13/15.
 */
public abstract class RightBaseLoader<T> extends BaseLoader<T> {

    private final FragmentActivity activity;

    public RightBaseLoader(FragmentActivity fragmentActivity, int loaderId) {
        super(fragmentActivity, loaderId);
        this.activity = fragmentActivity;
        //setTheme(R.style.LoaderTheme);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        RightUtils.hideKeyboard(activity);
    }

    public FragmentActivity getActivity() {
        return activity;
    }
}