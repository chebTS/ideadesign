package ua.com.idea.application;

import android.app.Application;

import ua.com.idea.db.DBUtils;

/**
 * Created by cheb on 11/8/15.
 */
public class IdeaApplication extends Application {
    public static DBUtils dbUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        dbUtils = DBUtils.newInstance(this, "idea.sqlite", 1);
    }
}
