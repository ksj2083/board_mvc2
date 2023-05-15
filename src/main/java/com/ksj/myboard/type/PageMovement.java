package com.ksj.myboard.type;

public class PageMovement {

    private String url;
    private PageMovementType pageMovementType;

    public PageMovement(String url, PageMovementType pageMovementType) {
        this.url = url;
        this.pageMovementType = pageMovementType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PageMovementType getPageMovementType() {
        return pageMovementType;
    }

    public void setPageMovementType(PageMovementType pageMovementType) {
        this.pageMovementType = pageMovementType;
    }
}
