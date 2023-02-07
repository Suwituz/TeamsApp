package com.example.teams.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teams")
public class Team {
    @PrimaryKey(autoGenerate = true)
    public int team_id;

    @ColumnInfo(name = "team_name")
    public String teamName;
}
