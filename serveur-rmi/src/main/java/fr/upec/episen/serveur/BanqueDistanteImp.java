package fr.upec.episen.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.MessageFormat;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BanqueDistanteImp extends UnicastRemoteObject implements BanqueDistante{
    protected static Logger banqueLog = LogManager.getLogger(BanqueDistanteImp.class);
    protected Banque banque;

    public BanqueDistanteImp(Banque banque) throws RemoteException{
        this.banque = banque;
    }

    @Override
    public CompteDistant getCompte(final int numero) throws RemoteException{
        banqueLog.warn("BanqueDistanteImp.getCompte() : " + numero);
        Optional<Compte> opt = banque.getCompte(numero);
        if(opt.isPresent()){
            CompteDistant cd = new CompteDistantImp(opt.get());
            return cd;
        } else {
            String pattern = new String("Le numéro ? est invalide");
            String msg = MessageFormat.format(pattern, numero);
            throw new RemoteException(msg);
        }
    }
    
}
