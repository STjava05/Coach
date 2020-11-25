package it.esedra.coach.controler;

import it.esedra.coach.modele.Profil;
/**
 * on met la class control en final parceque on veut pas une autre classe herite d elle
 * et on veut pas generer une autre instance
 */
public final class Control {
    // cette instance vest declarer null parceque elle va etre generer un seule fois
    private static Control instance = null;
   // creation de la propriete Profil pour recuperer les donnes quon avait sur le constructeur Profil
    private Profil profil;


    private Control(){
        super();
    }

    /**
     * creazione d une methode de l instance qui va etre accessible de l exterieur
     *  qui va permette de remplir cet instance une seule fois
     * @return instance
     */
    public static final Control getInstance(){
     // dans ce cas si mon instance=null cela veur dire quelle n est pas encore gerener
        if(Control.instance==null){
            // alors dans ce cas on vas la generer
            Control.instance= new Control();
        }
        return Control.instance;
    }
    /**
     *
     * @param peso
     * @param altezza in cm
     * @param age
     * @param sexe  1=uomo,  0=donna
     * creer une nouvelle methode profil qui ne retourne rien et qui va recevoir les informations qui sont dans vue
     */
    public void createProfil(Integer peso, Integer altezza, Integer age, Integer sexe){
        profil = new Profil(peso, altezza, age, sexe);
    }


    /**
     * recuperer le calcul de img de profil
     * @return Img
     */
    public float getIMG(){
        return profil.getImg();
    }

    /**
     * recuperation du message de profil
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }
}
