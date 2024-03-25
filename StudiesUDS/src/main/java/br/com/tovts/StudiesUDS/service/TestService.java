package br.com.tovts.StudiesUDS.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    private Double saldo = 10d;

    public Double getSaldo() {
        return saldo;
    }

    public void reset() {
        this.saldo = 10d;
    }

    public synchronized void saca(Double valor) {
        if (valor > this.saldo) {
            return;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.saldo = this.saldo - valor;
    }
}
