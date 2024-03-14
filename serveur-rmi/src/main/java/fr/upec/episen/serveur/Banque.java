package fr.upec.episen.serveur;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class Banque {
    private static final int MAX = 10000;
    protected String nom;
    protected Set<Compte> comptes;

    public Banque(String nom){
        this.nom = nom;
        this.comptes = new HashSet<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /** acces à un compte */
    public Optional<Compte> getCompte(final int nuemero){
        if(comptes.isEmpty()){
            //Si on a pas de compte et donc on ne peut pas en retourner : ne pas retourner de null car provoque des erreurs.
            //Utiliser l'interface optional pour éviter ça
            return Optional.empty();
        } else {
            //Ensemble non vide :
            for(Compte cpt : comptes){
                if(cpt.getNumero() == nuemero){
                    return Optional.of(cpt);
                }
            }
        }
        return Optional.empty();
    }

    /** creation d'un nouveau compte */
    public Integer creerCompte(){
        //1. tirer un numero
        Random random = new Random(System.currentTimeMillis());
        Optional<Compte> opt = Optional.empty();
        do{
            int num = random.nextInt(MAX);
            //2. tester son existance
            opt = getCompte(num);
            //3. si nouveau alors création
            if(opt.isEmpty()){
                Compte cpt = new Compte(num);
                comptes.add(cpt);
            }
        } while(opt.isEmpty());
        return opt.get().getNumero();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Banque : ");
        builder.append(" Nom : " + nom);
        builder.append(" Comptes : " + comptes.toString());
        return builder.toString();
    }

}
