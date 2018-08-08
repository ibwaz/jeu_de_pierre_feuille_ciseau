package com.example.wazir.jeu_pierre_feuille_ciseau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_pierre, b_feuille, b_ciseau;
    TextView tv_score;
    ImageView iv_ChoixOrdinateur, iv_ChoixHumain;

    int ScoreHumain, ScoreOrdinateur = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_pierre = (Button) findViewById(R.id.b_pierre);
        b_ciseau = (Button) findViewById(R.id.b_ciseau);
        b_feuille = (Button) findViewById(R.id.b_feuille);

        iv_ChoixOrdinateur = (ImageView) findViewById(R.id.iv_ChoixOrdinateur);
        iv_ChoixHumain = (ImageView) findViewById(R.id.iv_ChoixHumain);

        tv_score = (TextView) findViewById(R.id.tv_score);


        b_feuille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //J'indique la bonne figure lorsque je clique sur un boutton
              iv_ChoixHumain.setImageResource(R.drawable.feuille);
              String message = play_turn("feuille");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Humain :" + Integer.toString(ScoreHumain) + "Ordinateur" + Integer.toString(ScoreOrdinateur));

            }
        });

        b_ciseau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_ChoixHumain.setImageResource(R.drawable.ciseau);
                String message = play_turn("ciseau");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Humain :" + Integer.toString(ScoreHumain) + "Ordinateur" + Integer.toString(ScoreOrdinateur));

            }
        });

        b_pierre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_ChoixHumain.setImageResource(R.drawable.pierre);
                String message = play_turn("pierre");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Humain :" + Integer.toString(ScoreHumain) + "Ordinateur" + Integer.toString(ScoreOrdinateur));

            }
        });
    }

    public String play_turn (String choix_joueur ) {
        String choix_ordinateur = "";
        Random r = new Random();
        //Je choisis le nombre 1, 2 ou 3
        int choix_joueur_nombre = r.nextInt(3) + 1;
        if (choix_joueur_nombre == 1){
            choix_ordinateur = "pierre";
        } else

        if (choix_joueur_nombre == 2){
            choix_ordinateur = "ciseau";
        } else

        if (choix_joueur_nombre == 3){
            choix_ordinateur = "feuille";
        }

        //Je montre l'image sur laquelle est basée le choix de l'ordinateur
        if (choix_ordinateur == "pierre") {
            iv_ChoixOrdinateur.setImageResource(R.drawable.pierre);
        } else

        if (choix_ordinateur == "ciseau") {
            iv_ChoixOrdinateur.setImageResource(R.drawable.ciseau);
        } else

        if (choix_ordinateur == "feuille") {
            iv_ChoixOrdinateur.setImageResource(R.drawable.feuille);
        }


        //Je détermine lequel des 2 partie (entre choix_humain et choix_ordianteur) remporte le match
        if (choix_ordinateur == choix_joueur){
            return "Match nul.  Personne ne gagne";
        }
        else if (choix_joueur == "pierre" && choix_ordinateur == "ciseau"){
            ScoreHumain ++;
            return "La pierre ecrase le ciseau. Tu gagne!";
        }
        else if (choix_joueur == "pierre" && choix_ordinateur == "feuille"){
            ScoreOrdinateur ++;
            return "La feuille enroule la pierre.   L'ordinateur gagne!";
        }
        else if (choix_joueur == "ciseau" && choix_ordinateur == "pierre"){
            ScoreOrdinateur ++;
            return "La pierre ecrase le ciseau. L'ordinateur gagne!";
        }
        else if (choix_joueur == "ciseau" && choix_ordinateur == "feuille") {
            ScoreHumain++;
            return "Le ciseau coupe la feuille. Tu gange!";
        }
        else if (choix_joueur == "feuille" && choix_ordinateur == "pierre") {
            ScoreHumain++;
            return "La feuille enroule la pierre. Tu gagne!";
        }
        else if (choix_joueur == "feuille" && choix_ordinateur == "ciseau") {
            ScoreOrdinateur++;
            return "Le ciseau coupe la feuille. L'ordinateur gagne!";
        }
        else return "Pas sûr";

    }
}
