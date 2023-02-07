package com.example.teams.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.teams.model.Score;

import java.util.List;
@Dao
public interface ScoreDao {
    @Query("SELECT * FROM scores WHERE team_name=:team_name AND game_id=:game_id")
    List<Score> getTeamScores(String team_name,String game_id);
    @Query("SELECT * FROM scores")
    List<Score> getAllScores();
    @Query("SELECT * FROM scores WHERE team_name=:team_name")
    List<Score>getTeam(String team_name);
    @Insert
    void insertScore(Score score);
}
