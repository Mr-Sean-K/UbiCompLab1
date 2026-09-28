package com.example.form;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    EditText phone;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.nameText);
        email = (EditText) findViewById(R.id.emailText);
        password = (EditText) findViewById(R.id.passText);
        phone = (EditText) findViewById(R.id.phoneText);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Submit(View view){
        String validateName = name.getText().toString();
        String validateNumber = phone.getText().toString();

        boolean nameCheck = true;
        boolean numberCheck = true;

        // validation
        for (int i = 0; i < validateName.length(); i++) {
            char c = validateName.charAt(i);
            if (!Character.isLetter(c)) {
                nameCheck = false;
                break;
            }
        }

        for (int i = 0; i < validateNumber.length(); i++) {
            char c = validateNumber.charAt(i);
            if (!Character.isDigit(c)) {
                numberCheck = false;
                break;
            }
        }

        // toast
        if (nameCheck && numberCheck) {
            Toast.makeText(this, "Thank you " + validateName + ", your request is being processed.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter a valid name and phone number.", Toast.LENGTH_SHORT).show();
        }
    }

}