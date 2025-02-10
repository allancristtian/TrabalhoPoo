public class GerenciadorClientes {
    private static final String ARQUIVO = "clientes.dat";
    private List<Cliente> clientes;

    public GerenciadorClientes() {
        this.clientes = carregarClientes(); 
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        salvarClientes(); 
    }

    private void salvarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(clientes);
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    private List<Cliente> carregarClientes() {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            return new ArrayList<>(); 
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (List<Cliente>) ois.readObject(); 
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os clientes" + e.getMessage());
            return new ArrayList<>(); 
        }
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente foi cadastrado");
        } else {
            System.out.println("Clientes cadastrados:");
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }
}
