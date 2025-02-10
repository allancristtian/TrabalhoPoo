import java.io.Serializble;

public class Cliente implements Serializable {
    private int id;
    private String nome;
    private String endereco;
    private String contato;

    public Cliente(int id, String nome, String endereco, String contato) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    public int getId() { 
        return id; 
    }
    public String getNome() { 
        return nome; 
    }
    public String getEndereco() { 
        return endereco; 
    }
    public String getContato() { 
        return contato; 
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Endereço: " + endereco + ", Contato: " + contato;
    }
}
