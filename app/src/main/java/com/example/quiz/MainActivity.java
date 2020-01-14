package com.example.quiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static SharedPreferences sharedPreferences;
    TextView tvBest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBest = findViewById(R.id.tvBestScore);
        sharedPreferences = this.getSharedPreferences("com.example.sharedemo", Context.MODE_PRIVATE);
        tvBest.setText(sharedPreferences.getString("bestScore","$ 0"));


    }

    public void startQuiz(View view) {
        Intent intent = new Intent(this, QuizActivity.class );
        startActivity(intent);
    }

    public void info(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Info");
        alertDialog.setIcon(android.R.drawable.ic_menu_info_details);
        alertDialog.setMessage("Kwoty gwarantowane w grze $ 1000,        $ 40 000, $1 000 000.");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
