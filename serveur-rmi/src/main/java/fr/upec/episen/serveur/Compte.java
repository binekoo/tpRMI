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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Compte : ");
        builder.append(" Nuemero " + numero);
        builder.append(" Solde : " + solde);
        return builder.toString();
    }

    @Override
    public int hashCode(){
        return this.numero;
    }

    @Override
    public boolean equals (Object obj){
        if (obj==this){
            return true;
        }
        else {
            if(obj instanceof Compte){
                Compte cpt = (Compte) obj;
                if ( cpt.numero==this.numero && cpt.solde==this.solde){
                    return true;
                }
                else return false;
            }
            else return false;
        }
    }
}
