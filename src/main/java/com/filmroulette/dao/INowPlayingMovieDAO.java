package com.filmroulette.dao;

import java.io.IOException;

public interface INowPlayingMovieDAO {

    String fetchNowPlayingMovieData() throws IOException;
}
