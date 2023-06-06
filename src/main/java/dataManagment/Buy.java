package dataManagment;

public class Buy {

    private String CodiceSconto;
    private String CodiceProdotto;
    private int quantità;

    public Buy(){

        this.CodiceSconto="";
        this.CodiceProdotto="";
        this.quantità=0;

    }

    public String getCodiceSconto() {
        return CodiceSconto;
    }

    public void setCodiceSconto(String codiceSconto) {
        CodiceSconto = codiceSconto;
    }

    public String getCodiceProdotto() {
        return CodiceProdotto;
    }

    public void setCodiceProdotto(String codiceProdotto) {
        CodiceProdotto = codiceProdotto;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }
}
