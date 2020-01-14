package com.example.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvWartosc;
    TextView tvPytanie;
    TextView tvTimer;
    Button bOdpA;
    Button bOdpB;
    Button bOdpC;
    Button bOdpD;
    Button nextLevel;
    String correct;
    String score;

    String [][] odpowiedzi;
    String [][] pytanieWartosc;
    int [] pytanieOdpowiedz;

    int pytanie = 0;

    boolean czyWygrana;

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvWartosc = findViewById(R.id.tvWartosc);
        tvPytanie = findViewById(R.id.tvPytanie);
        tvTimer = findViewById(R.id.tvTimer);
        bOdpA = findViewById(R.id.bOdpA);
        bOdpB = findViewById(R.id.bOdpB);
        bOdpC = findViewById(R.id.bOdpC);
        bOdpD = findViewById(R.id.bOdpD);
        nextLevel = findViewById(R.id.button);

        odpowiedzi = new String[12][4];
        odpowiedzi[0][0] = "przysposobienie";
        odpowiedzi[0][1] = "aborcja";
        odpowiedzi[0][2] = "adopcja";
        odpowiedzi[0][3] = "symbioza";

        odpowiedzi[1][0] = "ponton";
        odpowiedzi[1][1] = "gondola";
        odpowiedzi[1][2] = "galera";
        odpowiedzi[1][3] = "żaglówka";

        odpowiedzi[2][0] = "herbata";
        odpowiedzi[2][1] = "kawa";
        odpowiedzi[2][2] = "mleko";
        odpowiedzi[2][3] = "sok";

        odpowiedzi[3][0] = "olej";
        odpowiedzi[3][1] = "smalec";
        odpowiedzi[3][2] = "masło";
        odpowiedzi[3][3] = "tran";

        odpowiedzi[4][0] = "klown";
        odpowiedzi[4][1] = "komik";
        odpowiedzi[4][2] = "satyryk";
        odpowiedzi[4][3] = "pajac";

        odpowiedzi[5][0] = "myszołów";
        odpowiedzi[5][1] = "orzeł";
        odpowiedzi[5][2] = "jastrząb";
        odpowiedzi[5][3] = "sokół";

        odpowiedzi[6][0] = "major";
        odpowiedzi[6][1] = "komandor";
        odpowiedzi[6][2] = "admirał";
        odpowiedzi[6][3] = "bosman";

        odpowiedzi[7][0] = "branka";
        odpowiedzi[7][1] = "zabór";
        odpowiedzi[7][2] = "jasyr";
        odpowiedzi[7][3] = "osaczenie";

        odpowiedzi[8][0] = "Spokojny";
        odpowiedzi[8][1] = "Indyjski";
        odpowiedzi[8][2] = "Atlantycki";
        odpowiedzi[8][3] = "Arktyczny";

        odpowiedzi[9][0] = "2";
        odpowiedzi[9][1] = "3";
        odpowiedzi[9][2] = "5";
        odpowiedzi[9][3] = "4";

        odpowiedzi[10][0] = "Syriusz";
        odpowiedzi[10][1] = "Łabędzia";
        odpowiedzi[10][2] = "Polarna";
        odpowiedzi[10][3] = "Słońce";

        odpowiedzi[11][0] = "4";
        odpowiedzi[11][1] = "6";
        odpowiedzi[11][2] = "8";
        odpowiedzi[11][3] = "10";


        pytanieWartosc  = new String[12][2];
        pytanieWartosc[0][0] = "Jak nazywa się uznanie cudzego dziecka za swoje?";
        pytanieWartosc[0][1] = "$ 500";

        pytanieWartosc[1][0] = "Co pływa po kanale Weneckim?";
        pytanieWartosc[1][1] = "$ 1 000";

        pytanieWartosc[2][0] = "Jak nazywa się tradycyjny napój Anglików pity po południu?";
        pytanieWartosc[2][1] = "$ 2 000";

        pytanieWartosc[3][0] = "Jak nazywa się rybi tłuszcz?";
        pytanieWartosc[3][1] = "$ 5 000";

        pytanieWartosc[4][0] = "Kto rozśmiesza ludzi w cyrku?";
        pytanieWartosc[4][1] = "$ 10 000";

        pytanieWartosc[5][0] = "Jak nazywa się ptak w godle Polski?";
        pytanieWartosc[5][1] = "$ 20 000";

        pytanieWartosc[6][0] = "Jak nazywa się oficer marynarki?";
        pytanieWartosc[6][1] = "$ 40 000";

        pytanieWartosc[7][0] = "Jak nazywała się niewola tatarska lub turecka?";
        pytanieWartosc[7][1] = "$ 75 000";

        pytanieWartosc[8][0] = "Który z oceanów jest największy?";
        pytanieWartosc[8][1] = "$ 125 000";

        pytanieWartosc[9][0] = "Z iloma państwami graniczy Hiszpania?";
        pytanieWartosc[9][1] = "$ 250 000";

        pytanieWartosc[10][0] = "Jaka jest najbliższa gwiazda Ziemi?";
        pytanieWartosc[10][1] = "$ 500 000";

        pytanieWartosc[11][0] = "Z ilu graczy składa się drużyna polo?";
        pytanieWartosc[11][1] = "$ 1 000 000";

        pytanieOdpowiedz = new int[12];
        pytanieOdpowiedz[0] = 2;
        pytanieOdpowiedz[1] = 1;
        pytanieOdpowiedz[2] = 0;
        pytanieOdpowiedz[3] = 3;
        pytanieOdpowiedz[4] = 0;
        pytanieOdpowiedz[5] = 1;
        pytanieOdpowiedz[6] = 1;
        pytanieOdpowiedz[7] = 2;
        pytanieOdpowiedz[8] = 0;
        pytanieOdpowiedz[9] = 1;
        pytanieOdpowiedz[10] = 3;
        pytanieOdpowiedz[11] = 0;
        start();
    }
    public void upadteTime(int secondsLeft){
        int seconds = secondsLeft;
        tvTimer.setText(String.format("%02d", seconds)+" s");
    }

    public void start(){
        if(pytanie == 1 || pytanie == 6 || pytanie ==11){
            tvWartosc.setTextColor(Color.RED);
        } else {
            tvWartosc.setTextColor(Color.BLACK);
        }
        score = pytanieWartosc[pytanie][1];
        bOdpA.setOnClickListener(this);
        bOdpB.setOnClickListener(this);
        bOdpC.setOnClickListener(this);
        bOdpD.setOnClickListener(this);
        nextLevel.setText("Dalej");
        int para = pytanieOdpowiedz[pytanie];
        correct = odpowiedzi[pytanie][para];
       // Toast.makeText(this, correct, Toast.LENGTH_SHORT).show();
        tvWartosc.setText(pytanieWartosc[pytanie][1]);
        tvPytanie.setText(pytanieWartosc[pytanie][0]);
        bOdpA.setText(odpowiedzi[pytanie][0]);
        bOdpB.setText(odpowiedzi[pytanie][1]);
        bOdpC.setText(odpowiedzi[pytanie][2]);
        bOdpD.setText(odpowiedzi[pytanie][3]);

        countDownTimer = new CountDownTimer(10500,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                upadteTime((int) (millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                wrongAnswer();
                tvTimer.setText("00 s");
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bOdpA:
                if (bOdpA.getText().equals(String.valueOf(correct))) {
                    correctAnswer();
                } else {
                    wrongAnswer();
                }
                break;
            case R.id.bOdpB:
                if (bOdpB.getText().equals(String.valueOf(correct))){
                    correctAnswer();
                } else {
                    wrongAnswer();
                }
                break;
            case R.id.bOdpC:
                if (bOdpC.getText().equals(String.valueOf(correct))){
                    correctAnswer();
                } else {
                    wrongAnswer();
                }
                break;
            case R.id.bOdpD:
                if (bOdpD.getText().equals(String.valueOf(correct))){
                    correctAnswer();
                } else {
                    wrongAnswer();
                }
                break;
            default:
                break;
        }
    }

    public void correctAnswer(){
        bOdpA.setEnabled(false);
        bOdpB.setEnabled(false);
        bOdpC.setEnabled(false);
        bOdpD.setEnabled(false);
        countDownTimer.cancel();
        nextLevel.setVisibility(View.VISIBLE);
        nextLevel.setVisibility(View.VISIBLE);

        if(pytanie == 1 || pytanie == 6 || pytanie ==11){
            MainActivity.sharedPreferences.edit().putString("bestScore", score).apply();
            if(pytanie == 11){
                czyWygrana = true;
            }
        } else {

        }
        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(czyWygrana){
                    Intent intent = new Intent(getApplicationContext(), Wygrana.class);
                    startActivity(intent);
                } else {
                    levelUp();
                }
            }
        });
    }

    public void wrongAnswer(){
        bOdpA.setEnabled(false);
        bOdpB.setEnabled(false);
        bOdpC.setEnabled(false);
        bOdpD.setEnabled(false);
        countDownTimer.cancel();
        nextLevel.setText("Koniec gry");
        nextLevel.setVisibility(View.VISIBLE);
        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                koniec();
            }
        });


    }
    public void levelUp(){
        pytanie += 1;
        nextLevel.setVisibility(View.INVISIBLE);
        bOdpA.setEnabled(true);
        bOdpB.setEnabled(true);
        bOdpC.setEnabled(true);
        bOdpD.setEnabled(true);
        start();
    }

    public void koniec(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
