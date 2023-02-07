package com.example.teams.configuration;

import com.example.teams.Dao.TeamsDatabase;
import com.example.teams.model.Game;
import com.example.teams.model.Score;
import com.example.teams.model.Team;

import java.util.ArrayList;
import java.util.List;

public class ConfigGame implements ConfigInterface {

    @Override
    public void createTeam(TeamsDatabase db) {
        ArrayList<String>teams = new ArrayList<>();
        teams.add("Team1");
        teams.add("Team2");

        for(String team : teams)
        {
            Team team1 = new Team();
            team1.teamName = team;
            db.teamDao().insertTeam(team1);
        }
    }

    @Override
    public void createGame(TeamsDatabase db) {
        ArrayList<String> games = new ArrayList<>();
        games.add("1000");
        games.add("1001");
        games.add("1003");
        games.add("1004");
        games.add("1002");
        games.add("Overall");
        for(String game:games)
        {
            Game game1 = new Game();
            game1.game_Id = game;
            db.gameDao().insertGame(game1);
        }
    }

    @Override
    public void createScore(TeamsDatabase db) {
        ArrayList<Score>scores = new ArrayList<>();
        Score score1 = new Score();
        score1.gameId = "1000";score1.round1 =90;score1.round2=80;score1.round3=85;score1.round4=78;score1.round5=95;score1.team_name= "Team1";
        scores.add(score1);
        Score game2 = new Score();
        game2.gameId="1001";game2.round1=89;game2.round2=79;game2.round3=98;game2.round4=94;game2.round5=96;game2.team_name= "Team1";
        scores.add(game2);
        Score game3 = new Score();
        game3.team_name= "Team1";game3.gameId="1002";game3.round1=69;game3.round2=78;game3.round3=92;game3.round4=97;game3.round5=99;
        scores.add(game3);
        Score game4 = new Score();
        game4.team_name= "Team1";game4.gameId="1003";game4.round1=95;game4.round2=89;game4.round3=91;game4.round4=83;game4.round5=77;
        scores.add(game4);
        Score game5 = new Score();
        game5.team_name= "Team1";game5.gameId="1004";game5.round1=100;game5.round2=94;game5.round3=86;game5.round4=76;game5.round5=69;
        scores.add(game5);


        Score game6 = new Score();
        game6.gameId = "1000";game6.round1 =89;game6.round2=90;game6.round3=58;game6.round4=87;game6.round5=59;game6.team_name= "Team2";
        scores.add(game6);
        Score game7 = new Score();
        game7.gameId="1001";game7.round1=98;game7.round2=97;game7.round3=87;game7.round4=79;game7.round5=86;game7.team_name= "Team2";
        scores.add(game7);
        Score game8 = new Score();
        game8.team_name= "Team2";game8.gameId="1002";game8.round1=96;game8.round2=87;game8.round3=98;game8.round4=79;game8.round5=89;
        scores.add(game8);
        Score game9 = new Score();
        game9.team_name= "Team2";game9.gameId="1003";game9.round1=85;game9.round2=98;game9.round3=93;game9.round4=93;game9.round5=97;
        scores.add(game9);
        Score game10 = new Score();
        game10.team_name= "Team2";game10.gameId="1004";game10.round1=99;game10.round2=87;game10.round3=68;game10.round4=86;game10.round5=82;
        scores.add(game10);
        for(Score gamee:scores)
        {
            db.scoreDao().insertScore(gamee);

        }
    }



    @Override
    public List<Team> getTeams(TeamsDatabase db) {
        List<Team>teams =  db.teamDao().getAllTeams();
        return teams;
    }

    @Override
    public List<Score> getTeamScores(TeamsDatabase db, String teamName,String game_id) {
        List<Score>games = db.scoreDao().getTeamScores(teamName,game_id);
        return games;

    }

    @Override
    public List<Score> getScores(TeamsDatabase db) {
        List<Score>scores = db.scoreDao().getAllScores();
        return scores;
    }

    @Override
    public List<Game> getGame(TeamsDatabase db) {
        List<Game>games = db.gameDao().getAllGames();
        return games;
    }

    @Override
    public List<Score> getTeam(TeamsDatabase db, String teamName) {
        List<Score>scores = db.scoreDao().getTeam(teamName);
        return scores;
    }


}
