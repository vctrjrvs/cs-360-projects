package com.example.planrprojectthree;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        dbHelper = new DatabaseHelper(this);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button createAccountButton = findViewById(R.id.createAccountButton);

        loginButton.setOnClickListener(v -> loginUser());
        createAccountButton.setOnClickListener(v -> createAccount());
    }

    private void loginUser() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (dbHelper.checkUser(username, password)) {
            // Successful login
            // Navigate to data display screen
            // Example: startActivity(new Intent(LoginActivity.this, DataDisplayActivity.class));
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
        } else {
            // Failed login
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    private void createAccount() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (dbHelper.addUser(username, password)) {
            // Account creation successful
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
        } else {
            // Account creation failed
            Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show();
        }
    }
}
