import estoque.Estoque;
import estoque.Produto;
import usuarios.Usuario;

public class Main {
    public static void main(String[] args) {
        // Exemplo de uso
        Estoque estoque = new Estoque();
        estoque.adicionarProduto(new Produto(1, "Notebook", "Notebook Dell", 10, 3500.0));
        estoque.gerarRelatorio();

        Usuario usuario = new Usuario(1, "João", "joao", "123", "ADMIN");
        System.out.println("Usuário: " + usuario.getNome());
    }
}
