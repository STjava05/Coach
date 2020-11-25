package it.esedra.coach.modele

import org.junit.Test

class ProfilTest  {
    //creazione di profil
    private Profil profil = new Profil(peso: 67, altezza :145, age: 35,sexe: 0);
    //resultat IMG
    private float img = (float) 32.2;
    //message attesa
    private String message = "sovrapeso";

    @Test
    void testGetImg() throws Exception {
      //comapraison de l IMG avec l objet prpfile qui fait appel a la methode getImg
        assertEquals(img, profil.getImg() ,0.1);
    }
  @Test
    void testGetMessage() throws Exception {
      //assertEquals permet de comparer entre le retour de cette methode et la variable message
        assertEquals(message,profil.getMessage());
    }
}
