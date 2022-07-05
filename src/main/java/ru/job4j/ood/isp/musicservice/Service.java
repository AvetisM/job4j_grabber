package ru.job4j.ood.isp.musicservice;

import java.util.List;

public interface Service {
    void playMusic();
    void showLyrics();
    void openArtistProfile();
    void openUserFavorites();
    boolean createFavoritesList(List<Object> favorites);
}
