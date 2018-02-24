package com.mzd.drugstore.bean.generator;

public class Authority {
    private String authorityId;

    private String authorityName;

    private String authorityUri;

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId == null ? null : authorityId.trim();
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    public String getAuthorityUri() {
        return authorityUri;
    }

    public void setAuthorityUri(String authorityUri) {
        this.authorityUri = authorityUri == null ? null : authorityUri.trim();
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authorityId='" + authorityId + '\'' +
                ", authorityName='" + authorityName + '\'' +
                ", authorityUri='" + authorityUri + '\'' +
                '}';
    }
}