public class Cidade {

    private String nomeCidade;
    private String descricao;
    private String uf;
    private Integer qtdeEstudantes;


    public Cidade(String nomeCidade, String descricao, String uf, Integer qtdeEstudantes) {
        this.nomeCidade = nomeCidade;
        this.descricao = descricao;
        this.uf = uf;
        this.qtdeEstudantes = qtdeEstudantes;
    }
  
    public Cidade() {
    }

    public String getNomeCidade() {
        return this.nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getQtdeEstudantes() {
        return this.qtdeEstudantes;
    }

    public void setQtdeEstudantes(Integer qtdeEstudantes) {
        this.qtdeEstudantes = qtdeEstudantes;
    }

    public void exibeDadosCidade() {
        System.out.println("\tNome da Cidade: " + nomeCidade);
        System.out.println("\tDescrição: " + descricao);
        System.out.println("\tUF: " + uf);
        System.out.println("\tNº de estudantes matriculados na cidade: " + qtdeEstudantes);
    }
}