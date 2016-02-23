package ua.com.idea.entities;

import com.rightutils.rightutils.collections.RightList;
import com.rightutils.rightutils.db.ColumnDAO;
import com.rightutils.rightutils.db.TableName;

import java.io.Serializable;

/**
 * Created by cheb on 12/20/15.
 */
@TableName("RecentFavorites")
public class RecentItem implements Serializable{
    private int id;
    private String title;
    private int catid;
    private String introtext;
    private String annotation;
    private String previmage;
    private String created;
    private String url;
    private int ratingid;
    private int ratingsum;
    private int ratingcount;
    private String author;
    private int progectid;
    @ColumnDAO
    private RightList<String> images;

    public RecentItem() {
    }

    public RecentItem(int id, String title, int catid, String introtext, String annotation, String previmage, String created, String url, int ratingid, int ratingsum, int ratingcount, String author, int progectid, RightList<String> images) {
        this.id = id;
        this.title = title;
        this.catid = catid;
        this.introtext = introtext;
        this.annotation = annotation;
        this.previmage = previmage;
        this.created = created;
        this.url = url;
        this.ratingid = ratingid;
        this.ratingsum = ratingsum;
        this.ratingcount = ratingcount;
        this.author = author;
        this.progectid = progectid;
        this.images = images;
    }

    @Override
    public String toString() {
        return "RecentItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", catid=" + catid +
                ", introtext='" + introtext + '\'' +
                ", annotation='" + annotation + '\'' +
                ", previmage='" + previmage + '\'' +
                ", created='" + created + '\'' +
                ", url='" + url + '\'' +
                ", ratingid=" + ratingid +
                ", ratingsum=" + ratingsum +
                ", ratingcount=" + ratingcount +
                ", author='" + author + '\'' +
                ", progectid=" + progectid +
                ", images=" + images +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getIntrotext() {
        return introtext;
    }

    public void setIntrotext(String introtext) {
        this.introtext = introtext;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getPrevimage() {
        return previmage;
    }

    public void setPrevimage(String previmage) {
        this.previmage = previmage;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRatingid() {
        return ratingid;
    }

    public void setRatingid(int ratingid) {
        this.ratingid = ratingid;
    }

    public int getRatingsum() {
        return ratingsum;
    }

    public void setRatingsum(int ratingsum) {
        this.ratingsum = ratingsum;
    }

    public int getRatingcount() {
        return ratingcount;
    }

    public void setRatingcount(int ratingcount) {
        this.ratingcount = ratingcount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getProgectid() {
        return progectid;
    }

    public void setProgectid(int progectid) {
        this.progectid = progectid;
    }

    public RightList<String> getImages() {
        return images;
    }

    public void setImages(RightList<String> images) {
        this.images = images;
    }
}