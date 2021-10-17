public class Estudante{

    private String nome;
    private String dtNascimento;
    private String email;
    private String senha;
    private Cidade cidade;


    public Estudante(String nome, String dtNascimento, String email, String senha, Cidade cidade) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
    }
       
    public Estudante() {

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNascimento() {
        return this.dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void exibeDadosEstudante() {
        System.out.println("\tNome: " + nome);
        System.out.println("\tData de Nascimento: " + dtNascimento);
        System.out.println("\tE-mail: " + email);
        System.out.println("\tSenha: " + senha);
        System.out.println("\tNome da cidade: " +cidade.getNomeCidade());
    }

    
}