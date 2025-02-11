public class Cliente{
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

    public static Cliente fromString(String linha) {
        String[] partes = linha.split(";");
        int id = Integer.parseInt(partes[0]);
        String nome = partes[1];
        String endereco = partes[2];
        String contato = partes[3];
        return new Cliente(id, nome, endereco, contato);
    }
}
