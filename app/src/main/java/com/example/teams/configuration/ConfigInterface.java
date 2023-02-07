package com.example.teams.configuration;

import com.example.teams.Dao.TeamsDatabase;
import com.example.teams.model.Game;
import com.example.teams.model.Score;
import com.example.teams.model.Team;

import java.util.List;

public interface ConfigInterface {
    void createScore(TeamsDatabase db);
    void createTeam(TeamsDatabase db);
    void createGame(TeamsDatabase db);

    List<Team> getTeams(TeamsDatabase db);
    List<Score> getTeamScores(TeamsDatabase db, String teamName,String game_id);
    List<Score> getScores(TeamsDatabase db);
    List<Game> getGame(TeamsDatabase db);
    List<Score>getTeam(TeamsDatabase db,String teamName);


}
