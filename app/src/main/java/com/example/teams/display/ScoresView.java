package com.example.teams.display;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.teams.Dao.TeamsDatabase;
import com.example.teams.R;
import com.example.teams.configuration.ConfigGame;
import com.example.teams.model.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class ScoresView extends Fragment {
    TextView team;
    ConfigGame config = new ConfigGame();
    TeamsDatabase db;
    TextView team1;
    TextView team2;
    TextView team1Name;
    TextView R1;TextView R2;TextView R3;TextView R4;TextView R5;
    TextView team1R1;TextView team1R2;TextView team1R3;TextView team1R4;TextView team1R5;
    Fragment frag2;
    TextView team2R1;TextView team2R2;TextView team2R3;TextView team2R4;TextView team2R5;
    ListView l;
    TextView game1Id ;TextView game1R1;TextView game1R2;TextView game1R3;TextView game1R4;TextView game1R5;
    TextView game2Id ;TextView game2R1;TextView game2R2;TextView game2R3;TextView game2R4;TextView game2R5;
    TextView game3Id ;TextView game3R1;TextView game3R2;TextView game3R3;TextView game3R4;TextView game3R5;
    TextView game4Id ;TextView game4R1;TextView game4R2;TextView game4R3;TextView game4R4;TextView game4R5;
    TextView game5Id ;TextView game5R1;TextView game5R2;TextView game5R3;TextView game5R4;TextView game5R5;
    TextView team2Name;
    TextView T2game1id;TextView T2game1R1;TextView T2game1R2;TextView T2game1R3;TextView T2game1R4;TextView T2game1R5;
    TextView T2game2id;TextView T2game2R1;TextView T2game2R2;TextView T2game2R3;TextView T2game2R4;TextView T2game2R5;
    TextView T2game3id;TextView T2game3R1;TextView T2game3R2;TextView T2game3R3;TextView T2game3R4;TextView T2game3R5;
    TextView T2game4id;TextView T2game4R1;TextView T2game4R2;TextView T2game4R3;TextView T2game4R4;TextView T2game4R5;
    TextView T2game5id;TextView T2game5R1;TextView T2game5R2;TextView T2game5R3;TextView T2game5R4;TextView T2game5R5;
    int t1g1Total;int t1g2Total;int t1g3Total;int t1g4Total;int t1g5Total;
    int t2g1Total;int t2g2Total;int t2g3Total;int t2g4Total;int t2g5Total;
    ArrayList<Integer>t1Total= new ArrayList<>();
    ArrayList<Integer>t2Total = new ArrayList<>();
    int t1max;int t2max;
    int t1min;int t2min;int t1ovscore;int t2ovscore;
   TextView game1; TextView g1maximum;TextView g2maximum;TextView g3maximum;TextView g4maximum;TextView g5maximum;
    TextView game2;TextView g1minimum;TextView g2minimum;TextView g3minimum;TextView g4minimum;TextView g5minimum;
    TextView game3;TextView g1winner;TextView g2winner;TextView g3winner;TextView g4winner;TextView g5winner;
   TextView game4; TextView game;TextView lowest;TextView highest;TextView winner;
   TextView game5;
   TextView overall;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.scores_activity, container, false);
        db= TeamsDatabase.getInstance(this.getContext());
        Bundle bundle = getArguments();
        team1= view.findViewById(R.id.team1);
        team2=view.findViewById(R.id.team2);

        team1Name = view.findViewById(R.id.team1Name);
        game1Id = view.findViewById(R.id.game1id);game1R1 = view.findViewById(R.id.game1R1);game1R2 = view.findViewById(R.id.game1R2);game1R3 = view.findViewById(R.id.game1R3);game1R4 = view.findViewById(R.id.game1R4);game1R5 = view.findViewById(R.id.game1R5);
        team = view.findViewById(R.id.Team);
        game2Id = view.findViewById(R.id.game2id);game2R1=view.findViewById(R.id.game2R1);game2R2=view.findViewById(R.id.game2R2);game2R3 = view.findViewById(R.id.game2R3);game2R4=view.findViewById(R.id.game2R4);game2R5 = view.findViewById(R.id.game2R5);
        game3Id = view.findViewById(R.id.game3id);game3R1 = view.findViewById(R.id.game3R1);game3R2 = view.findViewById(R.id.game3R2);game3R3 = view.findViewById(R.id.game3R3);game3R4 = view.findViewById(R.id.game3R4);game3R5 = view.findViewById(R.id.game3R5);
        game4Id =view.findViewById(R.id.game4id);game4R1 = view.findViewById(R.id.game4R1);game4R2=view.findViewById(R.id.game4R2);game4R3=view.findViewById(R.id.game4R3);game4R4=view.findViewById(R.id.game4R4);game4R5=view.findViewById(R.id.game4R5);
       game5Id = view.findViewById(R.id.game5id);game5R1=view.findViewById(R.id.game5R1);game5R2=view.findViewById(R.id.game5R2);game5R3=view.findViewById(R.id.game5R3);game5R4=view.findViewById(R.id.game5R4);game5R5=view.findViewById(R.id.game5R5);
       T2game1id = view.findViewById(R.id.T2game1id);T2game1R1=view.findViewById(R.id.T2game1R1);T2game1R2=view.findViewById(R.id.T2game1R2);T2game1R3=view.findViewById(R.id.T2game1R3);T2game1R4=view.findViewById(R.id.T2game1R4);T2game1R5=view.findViewById(R.id.T2game1R5);
        T2game2id = view.findViewById(R.id.T2game2id);T2game2R1=view.findViewById(R.id.T2game2R1);T2game2R2=view.findViewById(R.id.T2game2R2);T2game2R3=view.findViewById(R.id.T2game2R3);T2game2R4=view.findViewById(R.id.T2game2R4);T2game2R5=view.findViewById(R.id.T2game2R5);
        T2game3id = view.findViewById(R.id.T2game3id);T2game3R1=view.findViewById(R.id.T2game3R1);T2game3R2=view.findViewById(R.id.T2game3R2);T2game3R3=view.findViewById(R.id.T2game3R3);T2game3R4=view.findViewById(R.id.T2game3R4);T2game3R5=view.findViewById(R.id.T2game3R5);
        T2game4id = view.findViewById(R.id.T2game4id);T2game4R1=view.findViewById(R.id.T2game4R1);T2game4R2=view.findViewById(R.id.T2game4R2);T2game4R3=view.findViewById(R.id.T2game4R3);T2game4R4=view.findViewById(R.id.T2game4R4);T2game4R5=view.findViewById(R.id.T2game4R5);
        T2game5id = view.findViewById(R.id.T2game5id);T2game5R1=view.findViewById(R.id.T2game5R1);T2game5R2=view.findViewById(R.id.T2game5R2);T2game5R3=view.findViewById(R.id.T2game5R3);T2game5R4=view.findViewById(R.id.T2game5R4);T2game5R5=view.findViewById(R.id.T2game5R5);
       team2Name=view.findViewById(R.id.team2Name);
       g1minimum = view.findViewById(R.id.llowest1);g2minimum = view.findViewById(R.id.llowest2);g3minimum =view.findViewById(R.id.llowest3);g4minimum=view.findViewById(R.id.llowest4);g5minimum=view.findViewById(R.id.llowest5);
       g1maximum = view.findViewById(R.id.lhighest1);g2maximum = view.findViewById(R.id.lhighest2);g3maximum = view.findViewById(R.id.lhighest3);g4maximum=view.findViewById(R.id.lhighest4);g5maximum=view.findViewById(R.id.lhighest5);
      g1winner=view.findViewById(R.id.lwinner1);g2winner = view.findViewById(R.id.lwinner2);g3winner=view.findViewById(R.id.lwinner3);g4winner = view.findViewById(R.id.lwinner4);g5winner=view.findViewById(R.id.lwinner5);
      game = view.findViewById(R.id.Game);lowest = view.findViewById(R.id.lowest);highest = view.findViewById(R.id.highest);winner = view.findViewById(R.id.winner);
     game1 = view.findViewById(R.id.lGame1);game2 = view.findViewById(R.id.lGame2);game3=view.findViewById(R.id.lGame3);
     game4 = view.findViewById(R.id.lGame4);game5 = view.findViewById(R.id.lGame5);
     overall = view.findViewById(R.id.OveralWinner);

     String gameId = bundle.getString("gameSelected");
        java.util.List <Score> scores1 = config.getTeamScores(db, "Team1", gameId);
        List<Score> scores2 = config.getTeamScores(db, "Team2", gameId);
        List<Score> sco = config.getTeam(db,"Team1");
        List<Score> g1Scores = config.getTeamScores(db, "Team1", "1000");
        List<Score> g2Scores = config.getTeamScores(db, "Team1", "1001");
        List<Score> g3Scores = config.getTeamScores(db, "Team1", "1002");
        List<Score> g4Scores = config.getTeamScores(db, "Team1", "1003");
        List<Score> g5Scores = config.getTeamScores(db, "Team1", "1004");

        List<Score> T2g1Scores = config.getTeamScores(db, "Team2", "1000");
        List<Score> T2g2Scores = config.getTeamScores(db, "Team2", "1001");
        List<Score> T2g3Scores = config.getTeamScores(db, "Team2", "1002");
        List<Score> T2g4Scores = config.getTeamScores(db, "Team2", "1003");
        List<Score> T2g5Scores = config.getTeamScores(db, "Team2", "1004");

        // ListAdapterss

            if(gameId.equals("Overall")) {


                game.setText("Game");lowest.setText("Lowest");highest.setText("Highest");winner.setText("Winner");
                game1.setText("1000");
                game2.setText("1001");
                game3.setText("1002");
                game4.setText("1003");
                game5.setText("1004");
                team1Name.setText("Team one");
                team.setText("Game ID");
                R1 = view.findViewById(R.id.R1);
                R1.setText("R1");
                R2 = view.findViewById(R.id.R2);
                R2.setText("R2");
                R3 = view.findViewById(R.id.R3);
                R3.setText("R3");
                R4 = view.findViewById(R.id.R4);
                R4.setText("R4");
                R5 = view.findViewById(R.id.R5);
                R5.setText("R5");

                for (Score sc1 : g1Scores) {
                    game1Id.setText("1000");
                    game1R1.setText(Integer.toString(sc1.round1));
                    game1R2.setText(Integer.toString(sc1.round2));
                    game1R3.setText(Integer.toString(sc1.round3));
                    game1R4.setText(Integer.toString(sc1.round4));
                    game1R5.setText(Integer.toString(sc1.round5));
                    t1g1Total = sc1.round1+sc1.round2+sc1.round3+sc1.round4+sc1.round5;
                    //System.out.println("lllllllllllllll"+t1g1Total);
                   t1Total.add(t1g1Total);

                }
                for (Score sc2 : g2Scores) {
                    game2Id.setText("1001");
                    game2R1.setText(Integer.toString(sc2.round1));
                    game2R2.setText(Integer.toString(sc2.round2));
                    game2R3.setText(Integer.toString(sc2.round3));
                    game2R4.setText(Integer.toString(sc2.round4));
                    game2R5.setText(Integer.toString(sc2.round5));
                    t1g2Total = sc2.round1+sc2.round2+sc2.round3+sc2.round4+sc2.round5;
                    t1Total.add(t1g2Total);
                }
                for(Score sc3:g3Scores)
                {
                    game3Id.setText("1002");
                    game3R1.setText(Integer.toString(sc3.round1));
                    game3R2.setText(Integer.toString(sc3.round2));
                    game3R3.setText(Integer.toString(sc3.round3));
                    game3R4.setText(Integer.toString(sc3.round4));
                    game3R5.setText(Integer.toString(sc3.round5));
                    t1g3Total = sc3.round1+sc3.round2+sc3.round3+sc3.round4+sc3.round5;
                    t1Total.add(t1g3Total);
                }
                for(Score sc4:g4Scores)
                {
                    game4Id.setText("1003");
                    game4R1.setText(Integer.toString(sc4.round1));
                    game4R2.setText(Integer.toString(sc4.round2));
                    game4R3.setText(Integer.toString(sc4.round3));
                    game4R4.setText(Integer.toString(sc4.round4));
                    game4R5.setText(Integer.toString(sc4.round5));
                    t1g4Total = sc4.round1+sc4.round2+sc4.round3+sc4.round4+sc4.round5;
                    t1Total.add(t1g4Total);
                }
                for(Score sc5:g5Scores)
                {
                    game5Id.setText("1004");
                    game5R1.setText(Integer.toString(sc5.round1));
                    game5R2.setText(Integer.toString(sc5.round2));
                    game5R3.setText(Integer.toString(sc5.round3));
                    game5R4.setText(Integer.toString(sc5.round4));
                    game5R5.setText(Integer.toString(sc5.round5));
                    t1g5Total=sc5.round1+sc5.round2+sc5.round3+sc5.round4+sc5.round5;
                    t1Total.add(t1g5Total);
                }
                t1ovscore = t1g1Total+t1g2Total+t1g3Total+t1g4Total+t1g5Total;
                t1max = Collections.max(t1Total);
                t1min = Collections.max(t1Total);
                team2Name.setText("Team Two");
                for(Score t2sc1:T2g1Scores)
                {
                    T2game1id.setText("1000");
                    T2game1R1.setText(Integer.toString(t2sc1.round1));
                    T2game1R2.setText(Integer.toString(t2sc1.round2));
                    T2game1R3.setText(Integer.toString(t2sc1.round3));
                    T2game1R4.setText(Integer.toString(t2sc1.round4));
                    T2game1R5.setText(Integer.toString(t2sc1.round5));
                    t2g1Total = t2sc1.round1+t2sc1.round2+t2sc1.round3+t2sc1.round4+t2sc1.round5;
                    t2Total.add(t2g1Total);
                }
                for(Score t2sc2:T2g2Scores)
                {
                    T2game2id.setText("1001");
                    T2game2R1.setText(Integer.toString(t2sc2.round1));
                    T2game2R2.setText(Integer.toString(t2sc2.round2));
                    T2game2R3.setText(Integer.toString(t2sc2.round3));
                    T2game2R4.setText(Integer.toString(t2sc2.round4));
                    T2game2R5.setText(Integer.toString(t2sc2.round5));
                    t2g2Total=t2sc2.round1+t2sc2.round2+t2sc2.round3+t2sc2.round4+t2sc2.round5;
                    t2Total.add(t2g2Total);
                }
                for(Score t2sc3:T2g3Scores)
                {
                    T2game3id.setText("1002");
                    T2game3R1.setText(Integer.toString(t2sc3.round1));
                    T2game3R2.setText(Integer.toString(t2sc3.round2));
                    T2game3R3.setText(Integer.toString(t2sc3.round3));
                    T2game3R4.setText(Integer.toString(t2sc3.round4));
                    T2game3R5.setText(Integer.toString(t2sc3.round5));
                    t2g3Total = t2sc3.round1+t2sc3.round2+t2sc3.round3+t2sc3.round4+t2sc3.round5;
                    t2Total.add(t2g3Total);

                }
                for(Score t2sc4:T2g4Scores)
                {
                    T2game4id.setText("1003");
                    T2game4R1.setText(Integer.toString(t2sc4.round1));
                    T2game4R2.setText(Integer.toString(t2sc4.round2));
                    T2game4R3.setText(Integer.toString(t2sc4.round3));
                    T2game4R4.setText(Integer.toString(t2sc4.round4));
                    T2game4R5.setText(Integer.toString(t2sc4.round5));
                    t2g4Total = t2sc4.round1+t2sc4.round2+t2sc4.round3+t2sc4.round4+t2sc4.round5;
                    t2Total.add(t2g4Total);
                }
                for(Score t2sc5:T2g5Scores)
                {
                    T2game5id.setText("1004");
                    T2game5R1.setText(Integer.toString(t2sc5.round1));
                    T2game5R2.setText(Integer.toString(t2sc5.round2));
                    T2game5R3.setText(Integer.toString(t2sc5.round3));
                    T2game5R4.setText(Integer.toString(t2sc5.round4));
                    T2game5R5.setText(Integer.toString(t2sc5.round5));
                    t2g5Total = t2sc5.round1+t2sc5.round2+t2sc5.round3+t2sc5.round4+t2sc5.round5;
                    t2Total.add(t2g5Total);

                }
                t2ovscore=t2g1Total+t2g2Total+t2g3Total+t2g4Total+t2g5Total;
                t2max = Collections.max(t2Total);
                t2min = Collections.min(t2Total);
                if (t1ovscore>t2ovscore)
                {
                    overall.setText("The Overall winner is Team one");
                }
                else
                {
                    overall.setText("The Overall winner is Team two");
                }
                if(t1g1Total>t2g1Total)
                {
                    g1minimum.setText(Integer.toString(t2g1Total));
                    g1maximum.setText(Integer.toString(t1g1Total));
                    g1winner.setText("Team one");
                }
                else
                {
                    g1minimum.setText(Integer.toString(t1g1Total));
                    g1maximum.setText(Integer.toString(t2g1Total));
                    g1winner.setText("Team two");
                }

                if(t1g2Total>t2g2Total)
                {
                    g2minimum.setText(Integer.toString(t2g2Total));
                    g2maximum.setText(Integer.toString(t1g2Total));
                    g2winner.setText("Team one");
                }
                else
                {
                    g2minimum.setText(Integer.toString(t1g2Total));
                    g2maximum.setText(Integer.toString(t2g2Total));
                    g2winner.setText("Team two");
                }
                if(t1g3Total>t2g3Total)
                {
                    g3minimum.setText(Integer.toString(t2g3Total));
                    g3maximum.setText(Integer.toString(t1g3Total));
                    g3winner.setText("Team one");
                }
                else
                {
                    g3minimum.setText(Integer.toString(t1g3Total));
                    g3maximum.setText(Integer.toString(t2g3Total));
                    g3winner.setText("Team two");
                }
                if(t1g4Total>t2g4Total)
                {
                    g4minimum.setText(Integer.toString(t2g4Total));
                    g4maximum.setText(Integer.toString(t1g4Total));
                    g4winner.setText("Team one");
                }
                else
                {
                    g4minimum.setText(Integer.toString(t1g4Total));
                    g4maximum.setText(Integer.toString(t2g4Total));
                    g4winner.setText("Team two");
                }
                if(t1g5Total>t2g5Total)
                {
                    g5minimum.setText(Integer.toString(t2g5Total));
                    g5maximum.setText(Integer.toString(t1g5Total));
                    g5winner.setText("Team one");
                }
                else
                {
                    g5minimum.setText(Integer.toString(t1g5Total));
                    g5maximum.setText(Integer.toString(t2g5Total));
                    g5winner.setText("Team two");
                }



            }

            else {

                team1R1 = view.findViewById(R.id.team1R1);
                team1R2 = view.findViewById(R.id.team1R2);
                team1R3 = view.findViewById(R.id.team1R3);
                team1R4 = view.findViewById(R.id.team1R4);
                team1R5 = view.findViewById(R.id.team1R5);
                team2R1 = view.findViewById(R.id.team2R1);
                team2R2 = view.findViewById(R.id.team2R2);
                team2R3 = view.findViewById(R.id.team2R3);
                team2R4 = view.findViewById(R.id.team2R4);
                team2R5 = view.findViewById(R.id.team2R5);

                team.setText("Team");
                R1 =view.findViewById(R.id.R1);
                R1.setText("R1");
                R2 =view.findViewById(R.id.R2);
                R2.setText("R2");
                R3 =view.findViewById(R.id.R3);
                R3.setText("R3");
                R4 =view.findViewById(R.id.R4);
                R4.setText("R4");
                R5 =view.findViewById(R.id.R5);
                R5.setText("R5");
                for (Score sc : scores1) {

                    team1.setText(sc.team_name);
                    String t1r1 = Integer.toString(sc.round1);
                    team1R1.setText(t1r1);
                    String t1r2 = Integer.toString(sc.round2);
                    team1R2.setText(t1r2);
                    String t1r3 = Integer.toString(sc.round3);
                    team1R3.setText(t1r3);
                    String t1r4 = Integer.toString(sc.round4);
                    team1R4.setText(t1r4);
                    String t1r5 = Integer.toString(sc.round5);
                    team1R5.setText(t1r5);
                }
                for (Score scc : scores2) {
                    team2.setText(scc.team_name);
                    String t1r1 = Integer.toString(scc.round1);
                    team2R1.setText(t1r1);
                    String t1r2 = Integer.toString(scc.round2);
                    team2R2.setText(t1r2);
                    String t1r3 = Integer.toString(scc.round3);
                    team2R3.setText(t1r3);
                    String t1r4 = Integer.toString(scc.round4);
                    team2R4.setText(t1r4);
                    String t1r5 = Integer.toString(scc.round5);
                    team2R5.setText(t1r5);
                }
            }
        return  view;
    }
}
