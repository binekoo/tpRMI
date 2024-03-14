package fr.upec.episen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.upec.episen.serveur.Banque;

public class Main {
    protected static Logger mainLog = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        mainLog.warn("serveur-rmi started");
        Banque bmci = new Banque("BMCI");
        int i1 = bmci.creerCompte();
        mainLog.warn("creation : " + i1);
        int i2 = bmci.creerCompte();
        mainLog.warn("creation : " + i2);
        int i3 = bmci.creerCompte();
        mainLog.warn("creation : " + i3);
        int i4 = bmci.creerCompte();
        mainLog.warn("creation : " + i4);
        mainLog.warn(bmci.toString());
    }
}