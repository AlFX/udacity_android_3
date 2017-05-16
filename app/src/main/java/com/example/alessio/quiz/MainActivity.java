package com.example.alessio.quiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // gets all the stuff to evaluate the user's score
    // calculates the score
    public void master(View view) {
        String username = username();
        String answers = answers();
        toast(username, answers);
    }

    // called by master
    private String username() {
        EditText nameField = (EditText) findViewById(R.id.username);
        Editable nameEditable = nameField.getText();
        String username = nameEditable.toString();
        return (username);
    }

    // called by master
    private String answers() {
        int mistakes = 0;
        String score = "";
        int ans = 0;

        CheckBox right = (CheckBox) findViewById(R.id.a21);
        if (right.isChecked()) {
            ans++;
        }
        right = (CheckBox) findViewById(R.id.a22);
        if (right.isChecked()) {
            ans++;
        }
        CheckBox wrong = (CheckBox) findViewById(R.id.a23);
        if (!wrong.isChecked()) {
            ans ++;
        }

        right = (CheckBox) findViewById(R.id.a41);
        if (right.isChecked()) {
            ans++;
        }
        right = (CheckBox) findViewById(R.id.a42);
        if (right.isChecked()) {
            ans++;
        }
        right = (CheckBox) findViewById(R.id.a43);
        if (right.isChecked()) {
            ans++;
        }
        right = (CheckBox) findViewById(R.id.a44);
        if (right.isChecked()) {
            ans++;
        }

        right = (CheckBox) findViewById(R.id.a51);
        if (right.isChecked()) {
            ans++;
        }
        right = (CheckBox) findViewById(R.id.a52);
        if (right.isChecked()) {
            ans++;
        }
        wrong = (CheckBox) findViewById(R.id.a53);
        if (!wrong.isChecked()) {
            ans ++;
        }

        RadioButton rad = (RadioButton) findViewById(R.id.a33);
        if (rad.isChecked()) {
            ans++;
        }
        rad = (RadioButton) findViewById(R.id.a62);
        if (rad.isChecked()) {
            ans++;
        }

        EditText open = (EditText) findViewById(R.id.open);


        if (open.getText().toString().equals("kerosene") ||
            open.getText().toString().equals("Kerosene") ||
            open.getText().toString().equals("KEROSENE")) {
            ans ++;
        }

        int correct = 13;
        if (ans == correct) {
            score = "All answers correct!";
        } else {
            mistakes = correct - ans;
            Integer.toString(mistakes);
            score = "Review your answers, there are " + mistakes + " mistakes.";
        }
        return (score);
    }

    // called by master
    private void toast(String username, String answers) {
        Context context = getApplicationContext();

        String text = username + ",\n" +
                "thanks for submitting your answers.\n" +
                answers;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
