package br.com.alura.main;

import br.com.alura.Pessoa;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JSONToJSONObject {
    public static void main(String[] args) {
        String json = "{\"id\":1,\"nome\":\"Guilheme\",\"cpf\":\"1209713027\"}\n";

        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);

        System.out.printf("%s - %s", jsonObject.get("nome"), jsonObject.get("cpf"));
    }

}
