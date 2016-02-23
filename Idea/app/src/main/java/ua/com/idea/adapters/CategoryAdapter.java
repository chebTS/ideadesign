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
import ua.com.idea.entities.Item;
import ua.com.idea.utils.SystemUtils;

/**
 * Created by cheb on 9/13/15.
 */
public class CategoryAdapter extends ArrayAdapter<Item> {
    private static  final  String TAG = CategoryAdapter.class.getSimpleName();

    public CategoryAdapter(Context context, int resource, int textViewResourceId, List<Item> objects) {
        super(context, resource, textViewResourceId, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        Item item = getItem(position);

        try {
            String data = item.getCreated();
            data = data.substring(0, data.indexOf(" "));
            ((TextView) v.findViewById(R.id.txt_date)).setText(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

       // ((TextView) v.findViewById(R.id.txt_date)).setText("!!!!");
        final ImageView imgPicture = (ImageView)v.findViewById(R.id.img_picture);
        Glide.with(getContext()).load(SystemUtils.BASE_URL + item.getImage())
                .error(R.drawable.grid_stub_4_3_b_w)
                .placeholder(R.drawable.grid_stub_4_3_b_w)
                //.fitCenter().centerCrop()
                .into(imgPicture);

        return v;
    }
}
