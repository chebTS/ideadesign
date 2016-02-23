package ua.com.idea.entities;

/**
 * Created by cheb on 7/18/15.
 */
public class StubItemTempClass {
    private long id;
    private String url;

    public StubItemTempClass(long id, String url) {
        this.id = id;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
