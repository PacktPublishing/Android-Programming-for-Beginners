package com.gamecodeschool.basicclasses;

import android.util.Log;

/**
 * Created by John on 27/02/2016.
 */
public class Soldier {
    int health;
    String soldierType;

    void shootEnemy(){
        //let's print which type of soldier is shooting
        Log.i(soldierType, " is shooting");
    }

}
