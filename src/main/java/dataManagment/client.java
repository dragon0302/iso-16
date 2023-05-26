package dataManagment;

public class client {

    private String CF;
    private String Nome;
    private String Cogniome;
    private String Data_di_nascita;
    private String telefono;
    private String email;
    private String Username;
    private String PW;

    public client(){

        this.CF="";
        this.Nome="";
        this.Cogniome="";
        this.Data_di_nascita="";
        this.telefono="";
        this.email="";
        this.Username="";
        this.PW="";

    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCogniome() {
        return Cogniome;
    }

    public void setCogniome(String cogniome) {
        Cogniome = cogniome;
    }

    public String getData_di_nascita() {
        return Data_di_nascita;
    }

    public void setData_di_nascita(String data_di_nascita) {
        Data_di_nascita = data_di_nascita;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }
}
