package com.example.teams.Dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.teams.model.Game;
import com.example.teams.model.Score;
import com.example.teams.model.Team;

@Database(entities = {Team.class, Score.class, Game.class}, version  = 5,exportSchema = false)
public abstract class TeamsDatabase extends RoomDatabase {

    public abstract ScoreDao scoreDao();
    public abstract TeamDao teamDao();
    public abstract GameDao gameDao();
    public static TeamsDatabase instance;

    public static TeamsDatabase getInstance(Context context)
    {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), TeamsDatabase.class, "scores_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
