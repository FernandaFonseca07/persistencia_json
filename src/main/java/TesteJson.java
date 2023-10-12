import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TesteJson {
    static Map<String, String> dadosTesteMap = new HashMap<>(); //Criação do Map para abrigar o Json
    static Gson gson = new Gson(); //Biblioteca do goole para fazer manipulção do Json
    static Reader reader;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        leituraJson();
        escritaJson();
    }

    public static void leituraJson () throws FileNotFoundException {
        reader = new FileReader("C:\\Users\\Fernanda\\Desktop\\QA ACADEMY\\selenium_cucumber\\persistencia_json\\src\\main\\resources\\massaTeste.json");
        dadosTesteMap = gson.fromJson(reader, Map.class);

        System.out.println(dadosTesteMap.get("url"));
        System.out.println(dadosTesteMap.get("produto"));
        System.out.println(dadosTesteMap.get("valor"));
    }

    public static void escritaJson () throws IOException {
        dadosTesteMap.put("email", "teste@teste.com");
        dadosTesteMap.put("senha", "teste@teste");
        FileWriter writer = new FileWriter("C:\\Users\\Fernanda\\Desktop\\QA ACADEMY\\selenium_cucumber\\persistencia_json\\src\\main\\resources\\copia_massaTeste.json");
        gson.toJson(dadosTesteMap, writer);
        writer.flush();
        writer.close();
        System.out.println(dadosTesteMap.get("email"));
        System.out.println(dadosTesteMap.get("senha"));
    }


}
