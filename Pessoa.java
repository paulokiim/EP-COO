public class Pessoa {
    String nome;
    String email;
    LocalDate dispInicio;
    LocalDate dispFim;

    public void setDispInicio (LocalDate dispInicio) {
        this.dispInicio = dispInicio;
    }
    public LocalDate getDispInicio () {
        return this.dispInicio;
    }

    public void setDispFim (LocalDate dispFim) {
        this.dispFim = dispFim;
    }
    public LocalDate getDispFim () {
        return this.dispFim;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }
    public String getNome () {
        return this.nome;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    public String getEmail () {
        return this.email;
    }
}