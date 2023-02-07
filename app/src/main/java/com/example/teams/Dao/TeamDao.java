package com.example.teams.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.teams.model.Team;

import java.util.List;
@Dao
public interface TeamDao {
    @Query("SELECT * FROM teams")
    List<Team> getAllTeams();
    @Insert
    void insertTeam(Team team);
}
