package br.com.infnet.pokedex.UI;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import br.com.infnet.pokedex.R;
import br.com.infnet.pokedex.UI.MainActivity;


/**
 * Created by kaike on 25/08/2017.
 */


    public class SplashScreen extends AppCompatActivity implements Runnable {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);

            Handler handler = new Handler();
            handler.postDelayed(this, 3000);
        }

        public void run(){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

