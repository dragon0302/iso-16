package dataManagment;

public class ardress {

    private String Nazzione;
    private String Citta;
    private int cap;
    private int Civico;
    private String via;
    private String CF_cliente;

    public ardress(){

        this.Nazzione="";
        this.Citta="";
        this.cap=0;
        this.Civico=0;
        this.via="";
        this.CF_cliente="";

    }

    public String getNazzione() {
        return Nazzione;
    }

    public void setNazzione(String nazzione) {
        Nazzione = nazzione;
    }

    public String getCitta() {
        return Citta;
    }

    public void setCitta(String citta) {
        this.Citta = citta;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public int getCivico() {
        return Civico;
    }

    public void setCivico(int civico) {
        Civico = civico;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCF_cliente() {
        return CF_cliente;
    }

    public void setCF_cliente(String CF_cliente) {
        this.CF_cliente = CF_cliente;
    }


}
