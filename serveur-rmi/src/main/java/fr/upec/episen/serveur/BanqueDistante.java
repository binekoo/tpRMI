package fr.upec.episen.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BanqueDistante extends Remote {
    public CompteDistant getCompte(final int numero) throws RemoteException;
    
} 