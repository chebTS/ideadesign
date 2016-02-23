package ua.com.idea.loaders;

import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.rightutils.rightutils.collections.RightList;
import com.rightutils.rightutils.net.BasicRightRequest;
import com.rightutils.rightutils.net.RequestUtils;
import com.rightutils.rightutils.utils.RightUtils;

import ch.boye.httpclientandroidlib.Header;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.HttpStatus;
import ch.boye.httpclientandroidlib.client.utils.HttpClientUtils;
import ch.boye.httpclientandroidlib.message.BasicHeader;
import ch.boye.httpclientandroidlib.util.EntityUtils;
import ua.com.idea.application.IdeaApplication;
import ua.com.idea.entities.Category;
import ua.com.idea.entities.Image;
import ua.com.idea.entities.Item;
import ua.com.idea.utils.SystemUtils;

/**
 * Created by cheb on 9/13/15.
 */
public class CategoryItemsLoader extends RightBaseLoader<Boolean> {

    private static final String TAG = CategoryItemsLoader.class.getSimpleName();
    private RightList<Item> items;
    private String link;

    public CategoryItemsLoader(FragmentActivity fragmentActivity, int loaderId, String link) {
        super(fragmentActivity, loaderId);
        this.link = link;
    }

    @Override
    public Boolean loadInBackground() {
        try{
            if (RightUtils.isOnline(getContext())){
                String url = SystemUtils.BASE_URL + link + SystemUtils.JSON_URL_PREFIX;
                Log.i(TAG, url);
                Header header = new BasicHeader("Content-Type", "application/json");
                HttpResponse response = new BasicRightRequest().getHttpResponse(url, header);
                int status = response.getStatusLine().getStatusCode();
                Log.i(TAG, "status code: " + String.valueOf(status));
                if (status == HttpStatus.SC_OK) {
//                    Log.i(TAG, "fdfsd: " + EntityUtils.toString(response.getEntity()));
                    final ResponceData data = SystemUtils.MAPPER.readValue(response.getEntity().getContent(), ResponceData.class);
                    this.items = data.items;
                    Log.i(TAG, "First item: " + items.get(0).toString());
                    RightList<Image> images = new RightList<>();
                    for (Item item:items){
                        for (Image image:item.getImages()){
                            image.setItemid(item.getId());
                            images.add(image);
                        }
                    }
                    IdeaApplication.dbUtils.add(this.items);
                    Log.i(TAG, "Images size to add: " + images.size());
                    IdeaApplication.dbUtils.add(images);
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
        public RightList<Item> items;
    }

    public RightList<Item> getItems() {
        return items;
    }
}
