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

    @Setter
    @NonNull
    private String ger;

    @Getter
    @Setter
    private String eng;

    @Getter
    @Setter
    @IntRange(from = 0, to = 10)
    private int level;

    @NonNull
    @Getter
    @PrimaryKey(autoGenerate = true)
    private long id;

    public String getGer(){
        return this.ger;
    }

}
