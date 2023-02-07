package com.example.teams.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "games")
public class Game {
    @PrimaryKey(autoGenerate = true)
    public int g_id;
    @ColumnInfo(name="game_id")
    public String game_Id;

}
