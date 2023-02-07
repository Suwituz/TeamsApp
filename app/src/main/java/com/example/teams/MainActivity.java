package com.example.teams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.teams.Dao.TeamsDatabase;
import com.example.teams.configuration.ConfigGame;
import com.example.teams.display.ScoresView;
import com.example.teams.model.Game;
import com.example.teams.model.Score;
import com.example.teams.model.Team;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unchecked")
public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    Spinner spin;
    Button select;
    ConfigGame config = new ConfigGame();
    TeamsDatabase db;
    Fragment frag ;
    String selectedTeam;
    ArrayList<String> teams;
    ArrayList<String> games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= TeamsDatabase.getInstance(this.getApplicationContext());
        FragmentManager fm = getSupportFragmentManager();
        frag = fm.findFragmentById(R.id.frag);
        //frag = fm.findFragmentById(R.id.frag);
        List<Team> allTeams = config.getTeams(db);
        List<Score>allScores = config.getTeamScores(db,"Team1","1000");
        System.out.println("helloooooooo"+allScores);
        List<Game>allgames = config.getGame(db);
        spin = (Spinner) findViewById(R.id.spinner);
        teams = new ArrayList<>();
        games = new ArrayList<>();
        select =  findViewById(R.id.button);

        if(allScores.isEmpty())
        {
            config.createScore(db);
            for(Score sc:allScores)
            {
               // System.out.println("heeeeeeeeeeeeyyyyy"+sc.round1);
            }

       }
        if(allgames.isEmpty())
        {
            config.createGame(db);

       }
        for(Game game1:allgames)
        {
            games.add(game1.game_Id);
        }

        spin.setOnItemSelectedListener(this);
        ArrayAdapter mySpinner= new ArrayAdapter(this, android.R.layout.simple_spinner_item,games);
        mySpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(mySpinner);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frag == null)
                {
                    FragmentTransaction ft = fm.beginTransaction();
                    frag = new ScoresView();
                    Bundle bundle = new Bundle();
                    //bundle.putString("selected","hello");
                    bundle.putString("gameSelected", selectedTeam);
                    frag.setArguments(bundle);

                    ft.replace(android.R.id.content,frag, null);
                    ft.commit();
                }
                frag =null;
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedTeam= games.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}