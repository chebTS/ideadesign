package ua.com.idea.entities;

import java.io.Serializable;

/**
 * Created by cheb on 9/13/15.
 */
public class Chidlren implements Serializable {
    private int id;
    private String name;
    private String alias;
    private String description;
    private int parent;
    private String extraFieldsGroup;
    private String ordering;
    private String image;
    private String plugins;
    private String numOfItems;
    private String link;

    public Chidlren() {

    }

    public Chidlren(int id, String name, String alias, String description, int parent, String extraFieldsGroup, String ordering, String image, String plugins, String numOfItems, String link) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.description = description;
        this.parent = parent;
        this.extraFieldsGroup = extraFieldsGroup;
        this.ordering = ordering;
        this.image = image;
        this.plugins = plugins;
        this.numOfItems = numOfItems;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Chidlren{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                ", parent=" + parent +
                ", extraFieldsGroup='" + extraFieldsGroup + '\'' +
                ", ordering='" + ordering + '\'' +
                ", image='" + image + '\'' +
                ", plugins='" + plugins + '\'' +
                ", numOfItems='" + numOfItems + '\'' +
                ", link='" + link + '\'' +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getOrdering() {
        return ordering;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlugins() {
        return plugins;
    }

    public void setPlugins(String plugins) {
        this.plugins = plugins;
    }

    public String getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(String numOfItems) {
        this.numOfItems = numOfItems;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
