package ua.com.idea.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;

/**
 * Created by cheb on 7/25/15.
 */
public class MapViewForScroll extends MapView {


    public MapViewForScroll(Context context) {
        super(context);
    }

    public MapViewForScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapViewForScroll(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MapViewForScroll(Context context, GoogleMapOptions options) {
        super(context, options);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // Disallow ScrollView to intercept touch events.
                this.getParent().requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_UP:
                // Allow ScrollView to intercept touch events.
                this.getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }

        // Handle MapView's touch events.
        super.onTouchEvent(ev);
        return true;
    }
}
