public class Movimentacao {
    private String tipo;
    private int quantidade;
    private int quantidadeAnterior; 

    public Movimentacao(String tipo, int quantidade, int quantidadeAnterior) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.quantidadeAnterior = quantidadeAnterior;
    }

    @Override
    public String toString() {
        return String.format("Tipo: %s, Quantidade: %d, Quantidade Anterior: %d", tipo, quantidade, quantidadeAnterior);
    }
}
