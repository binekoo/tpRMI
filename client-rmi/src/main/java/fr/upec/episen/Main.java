package fr.upec.episen;

import java.io.InputStream;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    protected static Logger mainLog = LogManager.getLogger(Main.class);
    protected static Properties props = new Properties();

    public static void main(String[] args) {
        mainLog.warn("client-rmi started");
        //0. Charger les properties
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
        try{
            props.load(is);
            //1. Se connecter à l'annuaire
            final int PORT = Integer.parseInt(props.getProperty("rmi.port"));
            Registry registry = LocateRegistry.getRegistry(PORT);
            String serviceUrl = props.getProperty("banque.service.url");
            Remote remote = registry.lookup(serviceUrl);
            if(remote != null){
                mainLog.warn(remote.toString());
            }
            //2. Rechercher dans le service bmci
            //3. Demander le solde de son compte.
        } catch (Exception ioe){
            mainLog.error(ioe.getMessage());
        }
        
    }
}