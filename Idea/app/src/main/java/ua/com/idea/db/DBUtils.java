package ua.com.idea.db;

import android.content.Context;

import com.rightutils.rightutils.db.RightDBUtils;

/**
 * Created by cheb on 11/8/15.
 */

public class DBUtils extends RightDBUtils {
    private static final String TAG = DBUtils.class.getSimpleName();

    public static DBUtils newInstance(Context context, String name, int version) {
        DBUtils dbUtils = new DBUtils();
        dbUtils.setDBContext(context, name, version);
        return dbUtils;
    }
}
