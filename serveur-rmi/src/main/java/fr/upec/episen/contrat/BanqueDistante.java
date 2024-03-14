package fr.upec.episen.contrat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BanqueDistante extends Remote {
    public CompteDistant getCompte(final int numero) throws RemoteException;
    
} 