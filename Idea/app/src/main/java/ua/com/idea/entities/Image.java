package ua.com.idea.entities;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by cheb on 9/13/15.
 */
public class Image implements Serializable {

    private String caption;
    private String credits;
    @JsonProperty("XSmall")
    private String XSmall;
    @JsonProperty("Small")
    private String Small;
    @JsonProperty("Medium")
    private String Medium;
    @JsonProperty("Large")
    private String Large;
    @JsonProperty("XLarge")
    private String XLarge;
    @JsonProperty("Generic")
    private String Generic;
    private int itemid;

    public Image() {
    }


    public Image(String caption, String credits, String XSmall, String small, String medium, String large, String XLarge, String generic, int itemid) {
        this.caption = caption;
        this.credits = credits;
        this.XSmall = XSmall;
        Small = small;
        Medium = medium;
        Large = large;
        this.XLarge = XLarge;
        Generic = generic;
        this.itemid = itemid;
    }

    @Override
    public String toString() {
        return "Image{" +
                "caption='" + caption + '\'' +
                ", credits='" + credits + '\'' +
                ", XSmall='" + XSmall + '\'' +
                ", Small='" + Small + '\'' +
                ", Medium='" + Medium + '\'' +
                ", Large='" + Large + '\'' +
                ", XLarge='" + XLarge + '\'' +
                ", Generic='" + Generic + '\'' +
                ", itemid=" + itemid +
                '}';
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getXSmall() {
        return XSmall;
    }

    public void setXSmall(String XSmall) {
        this.XSmall = XSmall;
    }

    public String getSmall() {
        return Small;
    }

    public void setSmall(String small) {
        Small = small;
    }

    public String getMedium() {
        return Medium;
    }

    public void setMedium(String medium) {
        Medium = medium;
    }

    public String getLarge() {
        return Large;
    }

    public void setLarge(String large) {
        Large = large;
    }

    public String getXLarge() {
        return XLarge;
    }

    public void setXLarge(String XLarge) {
        this.XLarge = XLarge;
    }

    public String getGeneric() {
        return Generic;
    }

    public void setGeneric(String generic) {
        Generic = generic;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
}

