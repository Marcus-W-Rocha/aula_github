public class Cliente {
    private int cpf;
    private String nome;
    public Cliente (String nome, int cpf){
        this.cpf = cpf;
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public int getCpf() {
        return cpf;
    }

}
