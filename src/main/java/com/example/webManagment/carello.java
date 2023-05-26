package com.example.webManagment;

import dataManagment.product;

import java.util.ArrayList;
import java.util.List;

public class carello {

    private List<product> prodotti;

    public carello(){
        prodotti = new ArrayList<>();
    }

    public void AggungiProdotto(product nuovo){

        prodotti.add(nuovo);

    }

    public void rimuoviProdotto(product rimuovi){
        for (product cli : prodotti){
            if (cli.getCodice() == rimuovi.getCodice()){
                prodotti.remove(cli);
                break;
            }
        }
    }

    public List<product> getProdotto() {
        return prodotti;
    }
}
