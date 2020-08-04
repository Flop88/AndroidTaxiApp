package ru.mvlikhachev.taxiapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import ru.mvlikhachev.taxiapp.R;

public class ChooseModeActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(ChooseModeActivity.this,
                    DriverMapsActivity.class));
        }
    }

    public void goToPassengerSignIn(View view) {
        startActivity(new Intent(
                ChooseModeActivity.this,
                PassengerSignInActivity.class
        ));
    }

    public void goToDriverSignIn(View view) {
        startActivity(new Intent(
                ChooseModeActivity.this,
                DriverSignInActivity.class
        ));
    }
}