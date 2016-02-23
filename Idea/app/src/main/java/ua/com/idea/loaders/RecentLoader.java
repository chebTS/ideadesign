package ua.com.idea.loaders;

import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.rightutils.rightutils.collections.RightList;
import com.rightutils.rightutils.net.BasicRightRequest;
import com.rightutils.rightutils.utils.RightUtils;

import org.codehaus.jackson.type.TypeReference;

import ch.boye.httpclientandroidlib.Header;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.HttpStatus;
import ch.boye.httpclientandroidlib.message.BasicHeader;
import ua.com.idea.entities.RecentItem;
import ua.com.idea.utils.SystemUtils;

/**
 * Created by cheb on 12/20/15.
 */
public class RecentLoader extends RightBaseLoader<Boolean> {

    private static final String TAG = RecentLoader.class.getSimpleName();
    private RightList<RecentItem> recentItems;

    public RecentLoader(FragmentActivity fragmentActivity, int loaderId) {
        super(fragmentActivity, loaderId);
    }

    @Override
    public Boolean loadInBackground() {
        try{
            if (RightUtils.isOnline(getContext())){
                String url = SystemUtils.BASE_URL + SystemUtils.JSON_URL_PREFIX;
                Log.i(TAG, url);
                Header header = new BasicHeader("Content-Type", "application/json");
                HttpResponse response = new BasicRightRequest().getHttpResponse(url, header);
                int status = response.getStatusLine().getStatusCode();
                Log.i(TAG, "status code: " + String.valueOf(status));
                if (status == HttpStatus.SC_OK) {
//                    Log.i(TAG, "fdfsd: " + EntityUtils.toString(response.getEntity()));
                    recentItems = SystemUtils.MAPPER.readValue(response.getEntity().getContent(), new TypeReference<RightList<RecentItem>>(){});

                    Log.i(TAG, "First item: " + recentItems.get(0).toString());
                    //TODO
//                    RightList<Image> images = new RightList<>();
//                    for (Item item:items){
//                        for (Image image:item.getImages()){
//                            image.setItemid(item.getId());
//                            images.add(image);
//                        }
//                    }
//                    IdeaApplication.dbUtils.add(this.items);
//                    Log.i(TAG, "Images size to add: " + images.size());
//                    IdeaApplication.dbUtils.add(images);
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

    public RightList<RecentItem> getRecentItems() {
        return recentItems;
    }
}
