package com.example.planrprojectthree;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start LoginActivity when the app starts
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        // Finish the MainActivity so that it doesn't stay in the back stack
        finish();
    }
}
