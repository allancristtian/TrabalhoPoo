public class Movimentacao {
    private String tipo; 
    private int quantidade;

    
    public Movimentacao(String tipo, int quantidade) {
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format("Quantidade: %d, Tipo: %s", quantidade, tipo);
    }
}

