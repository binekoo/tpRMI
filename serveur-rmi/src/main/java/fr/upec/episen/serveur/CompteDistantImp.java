package fr.upec.episen.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompteDistantImp extends UnicastRemoteObject implements CompteDistant{
    protected static Logger cptLog = LogManager.getLogger(CompteDistantImp.class);
    protected Compte compte;

    public CompteDistantImp(Compte cpt) throws RemoteException{
        this.compte = cpt;
    }

    @Override
    public Integer getNumero() throws RemoteException {
        Integer result = compte.getNumero();
        cptLog.warn("CompteDistantImp :: getNumero() " + result);
        return result;
    }

    @Override
    public Double getSolde() throws RemoteException {
        Double result = compte.getSolde();
        cptLog.warn("CompteDistantImp :: getSolde() " + result);
        return result;
    }
}
