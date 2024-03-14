package fr.upec.episen.contrat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/** Acces RMI de la classe Compte */
public interface CompteDistant extends Remote {
    public Integer getNumero() throws RemoteException;
    public Double getSolde() throws RemoteException;
}
