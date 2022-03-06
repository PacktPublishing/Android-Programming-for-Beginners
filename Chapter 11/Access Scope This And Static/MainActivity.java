package com.gamecodeschool.accessscopethisandstatic;

import android.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Every time we do this, the constructor runs
        AlienShip girlShip = new AlienShip();
        AlienShip boyShip = new AlienShip();

        // Look no objects; using the static method
        Log.i("numShips: ", "" + AlienShip.getNumShips());

        // This works because shipName is public
        girlShip.shipName = "Corrine Yu";
        boyShip.shipName = "Andre LaMothe";

        // This won't work because shieldStrenth is private:
        // girlShip.shieldStrength = 999;

        // But we have a public getter
        Log.i("girlShip shieldStrngth: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());

        // But we can't do this because it's private:
        // boyShip.setShieldStrength(1000000);

        // Let's shoot some ships
        girlShip.hitDetected();
        Log.i("girlShip shieldStrngth: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());
        boyShip.hitDetected();
        boyShip.hitDetected();
        boyShip.hitDetected();
        Log.i("girlShip shieldStrngth: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());
        boyShip.hitDetected();// ahhh
        Log.i("girlShip shieldStrngth: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());
        Log.i("numShips: ", "" + AlienShip.getNumShips());
    }

}
