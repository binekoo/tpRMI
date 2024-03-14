package fr.upec.episen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    protected static Logger mainLog = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        mainLog.warn("serveur-rmi started");
    }
}