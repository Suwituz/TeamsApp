package com.example.teams.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.teams.model.Game;

import java.util.List;

@Dao
public interface GameDao {

    @Query("SELECT * FROM games")
    List<Game> getAllGames();
    @Insert
    void insertGame(Game game);
}
