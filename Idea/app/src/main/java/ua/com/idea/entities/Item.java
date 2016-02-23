package ua.com.idea.entities;

import com.rightutils.rightutils.collections.RightList;

import java.io.Serializable;

/**
 * Created by cheb on 9/13/15.
 */
public class Item implements Serializable{
    private int id;
    private String title;
    private String alias;
    private String link;
    private int catid;
    private String introtext;
    private String fulltext;
    private String image;
    private String modified;
    private RightList<Image> images;
    private String hits;
    private String created;

    public Item() {
    }

    public Item(int id, String title, String alias, String link, int catid, String introtext, String fulltext, String image, String modified, RightList<Image> images, String hits, String created) {
        this.id = id;
        this.title = title;
        this.alias = alias;
        this.link = link;
        this.catid = catid;
        this.introtext = introtext;
        this.fulltext = fulltext;
        this.image = image;
        this.modified = modified;
        this.images = images;
        this.hits = hits;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", alias='" + alias + '\'' +
                ", link='" + link + '\'' +
                ", catid=" + catid +
                ", introtext='" + introtext + '\'' +
                ", fulltext='" + fulltext + '\'' +
                ", image='" + image + '\'' +
                ", modified='" + modified + '\'' +
                ", images=" + images +
                ", hits='" + hits + '\'' +
                ", created='" + created + '\'' +
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public RightList<Image> getImages() {
        return images;
    }

    public void setImages(RightList<Image> images) {
        this.images = images;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
