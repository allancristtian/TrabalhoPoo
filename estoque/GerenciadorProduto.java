package persistencia;

import estoque.Produto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos{
  private static final String ARQUIVO_PRODUTOS = "produtos.ser";

public static void salvarProdutos(List<Produto> produtos){
  try(
    FileOutputStream arquivo = new FileOutputStream(ARQUIVO_PRODUTOS);
    ObjectOutputStream out = new ObjectOutputStream(arquivo);
    ){
    out.writeObject(produtos);
    System.out.println("Produtos foram salvos com sucesso");
  } catch(IOException e) {
    System.out.println("Erro ao salvar os produtos" +e.getMessage());
  }
}
  public static List<Produto> carregarProdutos(){
    File arquivo = new File(ARQUIVO_PRODUTOS);
      if(!arquivo.exists()){
        return new ArrayList<>():;
      }

  try(
    FileInputStream arquivo = new FileInputStream(ARQUIVO_PRODUTOS);
    ObjectInputStream in = new ObjectInputStream(arquivo);
    ){
    return (List<Produto>) in.readObject();
  }catch (IOException | ClassNotFoundException e){
    System.out.println("Erro ao carregar os produtos" +e.getMessage());
    return new ArrayList<>();
  }
  }
}
