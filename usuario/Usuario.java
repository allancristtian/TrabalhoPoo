
package usuarios;

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String permissao;

    public Usuario(int id, String nome, String login, String senha, String permissao) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.permissao = permissao;
    }

    // Getters e Setters
}
