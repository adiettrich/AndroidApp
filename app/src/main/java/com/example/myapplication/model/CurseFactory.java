package com.example.myapplication.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
public class CurseFactory {

    private final ArrayList<Curse> curses = new ArrayList<Curse>();

    public void initCurses(){
        curses.add(Curse.builder().eng(null).ger("Gehirnakrobat").level(0).build());
        curses.add(Curse.builder().eng(null).ger("Hodenkobold").level(0).build());
        curses.add(Curse.builder().eng(null).ger("Gesichtsgrätsche").level(0).build());
        curses.add(Curse.builder().eng(null).ger("Popelnascher").level(0).build());
        curses.add(Curse.builder().eng(null).ger("Hurensohn").level(0).build());
        curses.add(Curse.builder().eng(null).ger("Holzroller").level(0).build());
        curses.add(Curse.builder().eng(null).ger("Evolutionsbremse").level(0).build());
        curses.add(Curse.builder().eng(null).ger("Sacknaht").level(0).build());
        curses.add(Curse.builder().eng(null).ger("Steckdosenbefruchter").level(0).build());
        curses.add(Curse.builder().eng(null).ger("Clerasiltestgelände").level(0).build());
    }

    public ArrayList<Curse> getCurses() {
        return this.curses;
    }

    public Curse getCurse(int id) throws Exception{
        for(int i=0; i < curses.size(); i++){
            if(curses.get(i).getId() == id){
                return curses.get(i);
            }
        }
        throw  new Exception("Index not found!");
    }
    

}
