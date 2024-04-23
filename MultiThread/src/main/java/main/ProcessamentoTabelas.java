package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProcessamentoTabelas {
    private static final int NUM_TABELAS = 30;
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> multithreads());
        Thread thread2 = new Thread(() -> multithreads());

        thread1.start();
        thread2.start();


    }

    private synchronized static void multithreads() {
        System.out.println("começou");

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_TABELAS; i++) {
            int tabela = i;
            executor.execute(() -> processarTabela(tabela));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Espera até que todas as threads terminem
        } catch (InterruptedException e) {
            // Lidar com a interrupção, se necessário
            Thread.currentThread().interrupt();
        }

        System.out.println("acabou");
    }


    private static void processarTabela(int tabela) {
        // Simula o processamento da tabela
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}