package ua.com.idea.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ua.com.idea.R;
import ua.com.idea.activities.PicturesRecentActivity;
import ua.com.idea.entities.RecentItem;
import ua.com.idea.utils.SystemUtils;

/**
 * Created by cheb on 7/18/15.
 */
public class PictureRecentFragment extends Fragment {

    private static final String TAG = PictureRecentFragment.class.getSimpleName();
    private static final String key_image = "image";
    private static final String key_date = "date";

    public static PictureRecentFragment newInstance(RecentItem recentItem) {
        PictureRecentFragment fragment = new PictureRecentFragment();
        Bundle b = new Bundle();
        b.putString(key_date, recentItem.getCreated());
        b.putSerializable("item", recentItem);
        fragment.setArguments(b);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recent_picture, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            String data = getArguments().getString(key_date);
            data = data.substring(0, data.indexOf(" "));
            ((TextView) view.findViewById(R.id.txt_date)).setText(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageView imgPicture = (ImageView) view.findViewById(R.id.img_picture);
        final RecentItem recentItem = (RecentItem) getArguments().getSerializable("item");
        if (recentItem != null && recentItem.getImages() != null && recentItem.getImages().size() > 0) {
            Log.i(TAG, SystemUtils.BASE_URL + recentItem.getImages().getFirst());
            Glide.with(getContext()).load(SystemUtils.BASE_URL + recentItem.getImages().getFirst())
                    .error(R.drawable.placeholder_4_3_photoes)
                    .placeholder(R.drawable.placeholder_4_3_photoes)
                    //.fitCenter().centerCrop()
                    .into(imgPicture);
            imgPicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), PicturesRecentActivity.class);
                    intent.putExtra(RecentItem.class.getSimpleName(), recentItem);
                    startActivity(intent);
                }
            });
        }
    }
}
