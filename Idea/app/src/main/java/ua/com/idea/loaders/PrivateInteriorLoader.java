package ua.com.idea.loaders;

import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.rightutils.rightutils.collections.RightList;
import com.rightutils.rightutils.net.BasicRightRequest;
import com.rightutils.rightutils.utils.RightUtils;

import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.HttpStatus;
import ch.boye.httpclientandroidlib.message.BasicHeader;
import ua.com.idea.application.IdeaApplication;
import ua.com.idea.entities.Category;
import ua.com.idea.entities.Chidlren;
import ua.com.idea.utils.SystemUtils;


import ch.boye.httpclientandroidlib.Header;

/**
 * Created by cheb on 9/13/15.
 */
public class PrivateInteriorLoader extends RightBaseLoader<Boolean> {

    private static final String TAG = PrivateInteriorLoader.class.getSimpleName();
    private Category category;

    public PrivateInteriorLoader(FragmentActivity fragmentActivity, int loaderId) {
        super(fragmentActivity, loaderId);
    }

    @Override
    public Boolean loadInBackground() {
        try{
            if (RightUtils.isOnline(getContext())){
                String url = SystemUtils.PRIVATE_INTERIOR_URL;
                Log.i(TAG, url);
                Header header = new BasicHeader("Content-Type", "application/json");
                HttpResponse response = new BasicRightRequest().getHttpResponse(url, header);
                int status = response.getStatusLine().getStatusCode();
                Log.i(TAG, "status code: " + String.valueOf(status));
                if (status == HttpStatus.SC_OK) {
                    final ResponceData data = SystemUtils.MAPPER.readValue(response.getEntity().getContent(), ResponceData.class);
                    this.category = data.category;
                    Log.i(TAG, this.category.toString());
                    //Category category1 = new Category(4,"Test", "alias", "link", 5, "extra", "image", "ordering", new RightList<Chidlren>());
                    IdeaApplication.dbUtils.add(this.category);
                    IdeaApplication.dbUtils.add(this.category.getChidlren());
                    return true;
                }
            }else{
                SystemUtils.toast(getActivity(), "No internet connection");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private static class ResponceData {
        public Category category;
    }

    public Category getCategory() {
        return category;
    }
}
