package com.pursuit.catappfromscratchwithjoannerecyclerview;

public class CatPojo {
    private String id;
    private String url;
    private String[] breeds;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String[] getBreeds() {
        return breeds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBreeds(String[] breeds) {
        this.breeds = breeds;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", url = " + url + ", breeds = " + breeds + "]";
    }
}

