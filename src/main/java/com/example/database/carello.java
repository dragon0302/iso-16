package com.example.database;

import java.util.ArrayList;
import java.util.List;

public class carello {

    private List<prodotto> prodotti;

    public carello(){
        prodotti = new ArrayList<>();
    }

    public void AggungiProdotto(prodotto nuovo){

        prodotti.add(nuovo);

    }

    public void rimuoviProdotto(prodotto rimuovi){
        for (prodotto cli : prodotti){
            if (cli.getCodice() == rimuovi.getCodice()){
                prodotti.remove(cli);
                break;
            }
        }
    }

    public List<prodotto> getProdotto() {
        return prodotti;
    }
}
