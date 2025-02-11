import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Persistencia {


    public static void salvarDados(String arquivo, String dados) {
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write(dados);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " +e.getMessage());
        }
    }
    public static String carregarDados(String arquivo) {
        StringBuilder dados = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                dados.append(linha).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
        return dados.toString();
    }
}
