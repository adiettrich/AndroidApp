package com.example.myapplication.model;


import androidx.annotation.IntRange;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Curse {

    @NonNull
    private String ger;

    @Getter
    @Setter
    private String eng;

    @IntRange(from = 0, to = 10)
    private int level;

    @PrimaryKey(autoGenerate = true)
    private long id;

    public String getGer(){
        return this.ger;
    }

    public void setGer(String newGer){ this.ger = newGer; }

    public int getLevel(){ return this.level; }

    public void setLevel(int newLvl){ this.level = newLvl; }

    public long getId(){ return this.id; }

}
