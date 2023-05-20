package com.example.iso16;

import java.io.Serializable;

public class prodotto implements Serializable {

    int codice;
    float prezzo;
    String descrizione;
    String Categoria;
    Float Media_Valutazioni;
    String Amministratore;


    public prodotto() {

        this.codice = -1;
        this.prezzo = 0.0f;
        this.descrizione = "";
        this.Categoria = "";
        this.Media_Valutazioni = 0.0f;
        this.Amministratore = "";

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