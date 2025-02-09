class Pedido {
    private Produto produto;
    private int quantidade;
    private double subtotal;

    public ItemPedido(Produto produto, int quantidade) {
        if (quantidade > produto.getQuantidade()) {
            throw new IllegalArgumentException("Estoque insuficiente para o produto " + produto.getNome());
        }
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = quantidade * produto.getPreco();
        produto.removerQuantidade(quantidade);
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return String.format("Produto: %s, Quantidade: %d, Subtotal: %.2f", produto.getNome(), quantidade, subtotal);
    }
}