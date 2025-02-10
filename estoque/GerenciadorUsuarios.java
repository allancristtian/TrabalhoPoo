import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuarios {
  private static final string ARQUIVO = "usuarios.dat";

public static void salvarUsuarios(List<Usuario> usuarios) {
  try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))){
    oos.writeObject(usuarios);
    System.out.println("Usuarios foram salvos com sucesso");
  }catch(IOException e) {
    System.out.println("Erro ao salvar usuarios" +e.getMessage());
  }
}

public static List<Usuario> carregarUsuarios(){
  File arquivo = new File(ARQUIVO);
  if(!arquivo.exists()){
    return new ArrayList<>();
  }
  try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))){
    return (List<Usuario>) ois.readObject();
  } catch (IOException | ClassNotFoundException e){
    System.out.println("Erro ao carregar os usuarios"  e.getMessage());
    return new ArrayList<>();
  }
}
}
