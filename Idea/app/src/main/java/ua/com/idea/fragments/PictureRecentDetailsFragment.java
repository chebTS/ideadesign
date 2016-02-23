package ua.com.idea.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ua.com.idea.R;
import ua.com.idea.utils.SystemUtils;

/**
 * Created by cheb on 7/18/15.
 */
public class PictureRecentDetailsFragment extends Fragment {

    private static final String TAG = PictureRecentDetailsFragment.class.getSimpleName();
    private static final String key = "image";

    public static PictureRecentDetailsFragment newInstance(String image) {
        PictureRecentDetailsFragment fragment = new PictureRecentDetailsFragment();
        Bundle b = new Bundle();
        b.putString(key, image);
        fragment.setArguments(b);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_picture, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imgPicture = (ImageView) view.findViewById(R.id.img_picture);
        String path = getArguments().getString(key);
        Log.i(TAG, SystemUtils.BASE_URL + path);
        Glide.with(getContext()).load(SystemUtils.BASE_URL + path)
                .error(R.drawable.placeholder_4_3_photoes)
                .placeholder(R.drawable.placeholder_4_3_photoes)
                //.fitCenter().centerCrop()
                .into(imgPicture);
    }
}
