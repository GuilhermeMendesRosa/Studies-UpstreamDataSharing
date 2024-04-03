package br.com.alura.main;

import br.com.alura.Pessoa;
import com.google.gson.Gson;

public class JSONToObject {
    public static void main(String[] args) {
        String json = "{\"id\":1,\"nome\":\"Guilheme\",\"cpf\":\"1209713027\"}\n";

        Pessoa pessoa = new Gson().fromJson(json, Pessoa.class);

        System.out.printf("%s - %s", pessoa.getNome(), pessoa.getCpf());
    }
}
