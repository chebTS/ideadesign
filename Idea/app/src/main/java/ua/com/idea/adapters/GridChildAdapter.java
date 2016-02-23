package ua.com.idea.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ua.com.idea.R;
import ua.com.idea.entities.Chidlren;
import ua.com.idea.utils.SystemUtils;

/**
 * Created by cheb on 9/13/15.
 */
public class GridChildAdapter extends ArrayAdapter<Chidlren> {
    private static  final  String TAG = GridChildAdapter.class.getSimpleName();
    public GridChildAdapter(Context context, int resource, int textViewResourceId, List<Chidlren> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        Chidlren chidlren = getItem(position);
        ((TextView) v.findViewById(R.id.txt_name)).setText(chidlren.getName());
        final ImageView imgPicture = (ImageView)v.findViewById(R.id.img_picture);
        Glide.with(getContext()).load(SystemUtils.BASE_URL + chidlren.getImage())
                .error(R.drawable.grid_stub_4_3_b_w)
                .placeholder(R.drawable.grid_stub_4_3_b_w)
                //.fitCenter().centerCrop()
                .into(imgPicture);

        return v;
    }
}
