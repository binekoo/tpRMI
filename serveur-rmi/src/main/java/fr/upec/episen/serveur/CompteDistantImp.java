package fr.upec.episen.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CompteDistantImp extends UnicastRemoteObject implements CompteDistant{
    protected Compte compte;

    public CompteDistantImp(Compte cpt) throws RemoteException{
        this.compte = cpt;
    }

    @Override
    public Integer getNumero() throws RemoteException {
        return compte.getNumero();
    }

    @Override
    public Double getSolde() throws RemoteException {
        return compte.getSolde();
    }
}
