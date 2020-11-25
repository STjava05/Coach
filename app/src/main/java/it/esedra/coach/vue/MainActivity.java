package it.esedra.coach.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import it.esedra.coach.R;
import it.esedra.coach.controler.Control;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        /**
         * creation d object de type control, en effet pour creer un object on doit utiliser new
         * mais ici notre class control est private et final donc on peut pas instancier l object
         * raison pour la quelle on a creer un systeme qui nous permet de virer par un singleton
         * getInstance qui est une methode static sur la classe
         */

    }

    // proprietes
    private EditText textpeso;
    private EditText textAltezza;
    private EditText textAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Control control;

    /**
     * methode locale qui permet de faire le lien entre mes proprietes
     * et le ses objets graphiques
     */
    private void init (){
        textpeso =  (EditText) findViewById(R.id.textPeso);
        textAltezza = (EditText) findViewById(R.id.textAltezza);
        textAge = (EditText) findViewById(R.id.textAge);
       rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);
        this.control= Control.getInstance();
         ecouteCalcul();

    }

    /**
     * creation du lien entre la vue et le controleur
     * ecoute d evenement sur bouton calcul
     */
    private void ecouteCalcul(){
        ((Button)findViewById(R.id.btncalc)).setOnClickListener(new Button.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */

            public void onClick(View v) {
               // Toast.makeText(MainActivity.this,"test",Toast.LENGTH_SHORT).show();
                // ( methode pour tester)

                //declaration de variables locales
                Integer peso=0;
                Integer altezza=0;
                Integer age=0;
                Integer sexe=0;

                /**
                 * pour eviter que le programme se plante on met un try catch
                 * et recuper les donnees saisies
                 */
                try {
                    peso = Integer.parseInt(textpeso.getText().toString());
                    altezza = Integer.parseInt(textAltezza.getText().toString());
                    age = Integer.parseInt(textAge.getText().toString());

                }catch (Exception e){};
                if (rdHomme.isChecked()){
                    sexe=1;
                }
                //controle des donnees
                if (peso==0 || altezza==0 || age==0){
                  //  Toast.makeText(MainActivity.this,"saisie incorrecte",Toast.LENGTH_SHORT).show();
                   // ( methode pour tester)
                } else {
                    afficheResult(peso,altezza,age,sexe);

                }
                }
            });
    }

    /**
     * affichage de l IMG du message et de l image
     * @param peso
     * @param altezza
     * @param age
     * @param sexe
     */
    private void afficheResult(Integer peso, Integer altezza, Integer age, Integer sexe ){
      //creation du profil et recuperation des informations
        this.control.createProfil(peso, altezza, age, sexe);
        float img = this.control.getIMG();
        String message= this.control.getMessage();
        // afffichage
        if (message=="normal"){
            imgSmiley.setImageResource(R.drawable.normal);
            lblIMG.setTextColor(Color.GREEN);
        }else {
            lblIMG.setTextColor(Color.RED);
            if (message=="magro"){
                imgSmiley.setImageResource(R.drawable.magro);


            }else {
                imgSmiley.setImageResource(R.drawable.sovrapeso);
            }
        }
         lblIMG.setText(String.format("%.01f", img)+ ": IMG" +message);

               }
}

