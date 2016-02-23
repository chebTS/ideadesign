package ua.com.idea.entities;

import com.rightutils.rightutils.collections.RightList;
import com.rightutils.rightutils.db.ColumnIgnore;
import com.rightutils.rightutils.db.TableName;

/**
 * Created by cheb on 9/13/15.
 */

@TableName ("Category")
public class Category {
    private int id;
    private String name;
    private String alias;
    private String link;
    private int parent;
    private String extraFieldsGroup;
    private String image;
    private String ordering;
    @ColumnIgnore
    private RightList<Chidlren> chidlren;

    public Category() {
    }

    public Category(int id, String name, String alias, String link, int parent, String extraFieldsGroup, String image, String ordering, RightList<Chidlren> chidlren) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.link = link;
        this.parent = parent;
        this.extraFieldsGroup = extraFieldsGroup;
        this.image = image;
        this.ordering = ordering;
        this.chidlren = chidlren;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", link='" + link + '\'' +
                ", parent=" + parent +
                ", extraFieldsGroup='" + extraFieldsGroup + '\'' +
                ", image='" + image + '\'' +
                ", ordering='" + ordering + '\'' +
                ", chidlren=" + chidlren +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getExtraFieldsGroup() {
        return extraFieldsGroup;
    }

    public void setExtraFieldsGroup(String extraFieldsGroup) {
        this.extraFieldsGroup = extraFieldsGroup;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOrdering() {
        return ordering;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    public RightList<Chidlren> getChidlren() {
        return chidlren;
    }

    public void setChidlren(RightList<Chidlren> chidlren) {
        this.chidlren = chidlren;
    }
}