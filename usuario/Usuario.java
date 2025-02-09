
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
    public void getId(int id){
        this.id = id;
    }
    public void getNome(String nome){
        this.nome = nome;
    }
    public void getLogin(String login){
        this.login = login;
    }
    public void getSenha(String senha){
        this.senha = senha;
    }
    public void getPermissao(String permissao){
        this.permissao = permissao;
    }

}
