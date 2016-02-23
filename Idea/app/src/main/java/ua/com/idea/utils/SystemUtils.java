package ua.com.idea.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by cheb on 9/13/15.
 */
public class SystemUtils {
    public static boolean useServer = false;
    public static String TAG = SystemUtils.class.getSimpleName();

    public static final String JSON_URL_PREFIX = "?format=json";

    public static final String BASE_URL = "http://i-idea.com.ua";

    public static final String PORTFOLIO_URL = BASE_URL + "/ru/portfolio";

    public static final String PRIVATE_INTERIOR_URL = PORTFOLIO_URL + "/chastnye-interery" + JSON_URL_PREFIX;

    public final static ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    public static Toast toast;


    public static void toast(Context context, String message) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.show();

        Log.i(TAG, "toast: " + message);
    }
}

