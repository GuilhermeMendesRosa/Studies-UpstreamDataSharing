package br.com.alura.main;

import br.com.alura.Pessoa;
import com.google.gson.Gson;

public class ObjectToJSON {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1, "Guilheme", "1209713027");

        String json = new Gson().toJson(pessoa);
        System.out.println(json);

    }
}
