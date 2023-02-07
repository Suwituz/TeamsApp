package com.example.teams.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "scores")
public class Score {
    @PrimaryKey(autoGenerate = true)
    public int score_id;
    @ColumnInfo(name="game_id")
    public String gameId;
    @ColumnInfo(name="team_name")
    public  String  team_name;
    @ColumnInfo(name="R1")
    public int round1;
    @ColumnInfo(name="R2")
    public int round2;
    @ColumnInfo(name="R3")
    public int round3;
    @ColumnInfo(name="R4")
    public int round4;
    @ColumnInfo(name="R5")
    public int round5;
}
