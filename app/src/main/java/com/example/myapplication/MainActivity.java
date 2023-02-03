package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Common.Bets;
import com.example.myapplication.Common.Donations;
import com.example.myapplication.Common.Login;
import com.example.myapplication.Common.Media;
import com.example.myapplication.Common.NewsLeaderboard;
import com.example.myapplication.Common.Registration;
import com.example.myapplication.Common.Sponsors;

public class MainActivity extends AppCompatActivity {

    //Button registration, profile, stats, fixtures, payments, media, donations, sponsors, bets, settings, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //registration = (Button) findViewById(R.id.btnRegistration);
        //profile = (Button) findViewById(R.id.btnProfile);
        //stats = (Button) findViewById(R.id.btnStats);
        //fixtures = (Button) findViewById(R.id.btnFixtures);
        //payments = (Button) findViewById(R.id.btnPayments);
        //media = (Button) findViewById(R.id.btnMedia);
        //donations = (Button) findViewById(R.id.btnDonations);
        //sponsors = (Button) findViewById(R.id.btnSponsors);
        //bets = (Button) findViewById(R.id.btnBets);
        //settings = (Button) findViewById(R.id.btnSettings);
        //logout = (Button) findViewById(R.id.btnLogout);

       //Adding click listener to register button.
        /*registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });*/
    }


    //method for the buttons
    public void nav(View v){

        switch (v.getId()){

            case R.id.btn_registration:
                startActivity(new Intent(getApplicationContext(),Registration.class));
                break;

            /*case R.id.btn_profile:
                startActivity(new Intent(getApplicationContext(), Profile.class));
                break;*/

            /*case R.id.btn_stats:
                startActivity(new Intent(getApplicationContext(),Stats.class));
                break;*/

            case R.id.btn_fixtures:
                startActivity(new Intent(getApplicationContext(), NewsLeaderboard.class));
                break;

            case R.id.btn_payments:
                startActivity(new Intent(getApplicationContext(),Package.class));
                break;

            case R.id.btn_media:
                startActivity(new Intent(getApplicationContext(), Media.class));
                break;

            case R.id.btn_donations:
                startActivity(new Intent(getApplicationContext(), Donations.class));
                break;

            case R.id.btn_sponsors:
                startActivity(new Intent(getApplicationContext(), Sponsors.class));
                break;

            case R.id.btn_bets:
                startActivity(new Intent(getApplicationContext(), Bets.class));
                break;

            /*case R.id.btn_settings:
                startActivity(new Intent(getApplicationContext(),Settings.class));
                break;*/

            case R.id.btn_logout:
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                break;

            case R.id.btn_home:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
                break;

        }


    }



}