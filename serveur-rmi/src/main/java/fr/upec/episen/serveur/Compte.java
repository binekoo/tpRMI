package fr.upec.episen.serveur;

public class Compte {
    protected Integer numero;
    protected Double solde;

    public Compte(int numero){
        this.numero = numero;
        this.solde = 0.0;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
}
