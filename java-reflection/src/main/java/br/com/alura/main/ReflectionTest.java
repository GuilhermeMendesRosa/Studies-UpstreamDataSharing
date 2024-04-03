package br.com.alura.main;

import br.com.alura.Pessoa;
import br.com.alura.PessoaDTO;
import br.com.alura.refl.Transformator;

import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa = new Pessoa(1, "Guilheme", "1209713027");
        PessoaDTO dto = Transformator.transform(pessoa);
        System.out.printf("%s - %s", dto.getNome(), dto.getCpf());
    }
}
