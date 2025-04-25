public class Medico {
    private String nome;
    private String cpf;
    private String telefone;
    private Boolean status;

    public Medico(String nome, String cpf, String telefone, Boolean status) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Boolean getStatus() {
        return status;
    }

    public void exibirInformacoes() {
        System.out.println("Médico: " + nome + " | CPF: " + cpf + " | Telefone: " + telefone + " | Status: " + status);
    }
}
