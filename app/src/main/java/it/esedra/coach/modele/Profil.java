package it.esedra.coach.modele;

public class Profil {
    //creation de constantes quont pourra pas modifier qui vont garder en memoire ses differentes valeurs
    private static final  Integer minDonna = 15;
    private static final Integer maxDonna = 30;
    private static final Integer minUomo= 10;
    private static final Integer maxUomo = 20;
    ;
   //proprietes
    private Integer peso;
    private Integer altezza;
    private Integer age;
    private Integer sexe;
    private Float img;
    private String message;

    public Profil(Integer peso, Integer altezza, Integer age, Integer sexe){
        this.peso=peso;
        this.altezza= altezza;
        this.age=age;
        this.sexe=sexe;
        this.calculIMG();
        this.resultIMG();
    }
    /**
     *  ici on aura pas besoin de setters car elles seront valoriser par le constructeur
     *   pour rappel un setter c est pour valoriser une propriete
     *   par contre on utilise des guetters pour pouvoir les recuperer
     * @return
     */
    public Integer getPeso() {
        return peso;
    }

    public Integer getAltezza() {
        return altezza;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public Float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    /**
     * selon wikipedia le calcul de IMG en fonction de la masse M (kg) et de la taille T (m) :
     * IMG = (1,2 × M / T² ) + (0,23 × âge) - (10,8 × S) - 5,4
     * S=1 per i uomini S=0 pour les donne
     * methode calculIMG qui ne retourne rien(void) et ne recois aucune parametre
     */
    private void calculIMG(){
        //calul de l altezza qui est en cm ce aui veut dire on prend l altezza en cm /100 pour l avoir en metre

        float altezzaM = altezza /100;
        this.img=(float) (1.2*peso/(altezzaM*altezzaM)+(0.23*age)-(10.83*sexe)-5.4);
    }

    private void resultIMG(){
        // creation de variables locales pour valoriser le min et le max
        Integer min;
        Integer max;
        if(sexe==0){     // on a affaire a una donna
            min=minDonna;
            max=maxDonna;
        }else {          //on a affaire a un uomo
            min=minUomo;
            max=maxUomo;

        }
        //messaggio correspondante
        message="normal";
        if(img<min){
         message="troppo magro" ;
        }else {
            if(img>max){
                message="sovrapeso";
            }
        }
    }
}