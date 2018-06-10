package com.chosuwai.ted.talks.csw.data.vos;

public class FavoriteVO {

    private String favoriteId;
    private String favoriteDate;
    private ActedUserVO actedUser;

    public String getFavoriteId() {
        return favoriteId;
    }

    public String getFavoriteDate() {
        return favoriteDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
