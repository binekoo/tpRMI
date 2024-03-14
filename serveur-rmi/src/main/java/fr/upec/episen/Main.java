package fr.upec.episen;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.upec.episen.contrat.BanqueDistante;
import fr.upec.episen.serveur.Banque;
import fr.upec.episen.serveur.BanqueDistanteImp;

/**Banque serveur */
public class Main {
    protected static Logger mainLog = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        mainLog.warn("serveur-rmi started");
        //1. Création d'objets locaux
        Banque bmci = new Banque("bmci");
        int i1 = bmci.creerCompte();
        mainLog.warn("creation : " + i1);
        int i2 = bmci.creerCompte();
        mainLog.warn("creation : " + i2);
        int i3 = bmci.creerCompte();
        mainLog.warn("creation : " + i3);
        int i4 = bmci.creerCompte();
        mainLog.warn("creation : " + i4);
        mainLog.warn(bmci.toString());
        try{
            //2. Création de l'annuaire
            Registry registry = LocateRegistry.createRegistry(1099);

            //3. Publication des objets accessibles sur le réseau
            //Pour l'instant, bmci en local donc besoin de créer un accès sur le réseau.
            BanqueDistante bd = new BanqueDistanteImp(bmci);
            String url = "rmi://localhost:1099/" + bmci.getNom();
            registry.rebind(url, bd);
            mainLog.warn("bmci est publiée");
            //4. Attendre les requêtes clientes
            Thread.sleep(Duration.ofMinutes(2).toMillis());
        } catch (Exception re){
            mainLog.error(re.getMessage());
        }
        
    }
}