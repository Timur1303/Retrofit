package kg.app.retrofit.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Film {
    @SerializedName("title")
    private String title;
    private String id;
    private String description;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
