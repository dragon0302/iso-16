package dataManagment;

import java.io.Serializable;

public class product implements Serializable {

    private int codice;
    private float prezzo;
    private String descrizione;
    private String Categoria;
    private Float Media_Valutazioni;
    private String Amministratore;
    private String nome;
    private int quantità;


    public product() {

        this.codice = 0;
        this.prezzo = 0.0f;
        this.descrizione = "";
        this.Categoria = "";
        this.Media_Valutazioni = 0.0f;
        this.Amministratore = "";
        this.nome="";
        this.quantità=0;

    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }

    public float getMedia_Valutazioni() {
        return Media_Valutazioni;
    }

    public void setMedia_Valutazioni(float media_Valutazioni) {
        Media_Valutazioni = media_Valutazioni;
    }

    public String getAmministratore() {
        return Amministratore;
    }

    public void setAmministratore(String amministratore) {
        Amministratore = amministratore;
    }
}