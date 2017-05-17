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

        /*1st checkboxes question*/
        CheckBox right1 = (CheckBox) findViewById(R.id.a21);
        CheckBox right2 = (CheckBox) findViewById(R.id.a22);
        CheckBox wrong1 = (CheckBox) findViewById(R.id.a23);

        if (right1.isChecked() && right2.isChecked() && !wrong1.isChecked()) {
            ans++;
        }

        /*2nd checkboxes question*/
        right1 = (CheckBox) findViewById(R.id.a41);
        right2 = (CheckBox) findViewById(R.id.a42);
        CheckBox right3 = (CheckBox) findViewById(R.id.a43);
        CheckBox right4 = (CheckBox) findViewById(R.id.a44);

        if (right1.isChecked() && right2.isChecked() && right3.isChecked() && right4.isChecked()) {
            ans++;
        }

        /*3rd checkboxes question*/
        right1 = (CheckBox) findViewById(R.id.a51);
        right2 = (CheckBox) findViewById(R.id.a52);
        wrong1 = (CheckBox) findViewById(R.id.a53);

        if (right1.isChecked() && right2.isChecked() && !wrong1.isChecked()) {
            ans++;
        }

        /*1st radio question*/
        RadioButton rad = (RadioButton) findViewById(R.id.a33);
        if (rad.isChecked()) {
            ans++;
        }
        /*2nd radio question*/
        rad = (RadioButton) findViewById(R.id.a62);
        if (rad.isChecked()) {
            ans++;
        }

        /*open question*/
        EditText open = (EditText) findViewById(R.id.open);
        if (open.getText().toString().toLowerCase().trim().equals("kerosene")) {
            ans++;
        }

        int correct = 6;
        if (ans == correct) {
            score = "All answers correct!";
        } else {
            mistakes = correct - ans;
            Integer.toString(mistakes);
            score = "Review your answers to " + mistakes + " questions.";
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
