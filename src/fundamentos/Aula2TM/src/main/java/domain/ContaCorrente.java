package fundamentos.Aula2TM.src.main.java.domain;

import javax.naming.OperationNotSupportedException;

public class ContaCorrente {

    private double saldo;
    private double limite;
    private String nroConta;

    public ContaCorrente() {
    }

    public ContaCorrente(double saldo, double limite, String nroConta) {
        this.saldo = saldo;
        this.limite = limite;
        this.nroConta = nroConta;
    }

    public ContaCorrente(ContaCorrente cc) {
        this.saldo = cc.saldo;
        this.nroConta = cc.nroConta;
        this.limite = cc.limite;
    }

    public void deposito(double valor){
        this.saldo += valor;
    }

    public void saque(double valor) throws OperationNotSupportedException {
        if (this.saldo >= valor)
            this.saldo -= valor;
        else if (valor <= (saldo + limite)){
            this.limite -= valor - this.saldo;
            this.saldo = 0;
        }
        else
            throw new OperationNotSupportedException("Saldo insuficiente");
    }

    public void devolucao(double valor){
        this.deposito(valor);
    }

    public void tranferencia(ContaCorrente destino, double valor) throws OperationNotSupportedException {
        if (this.saldo >= valor) {
            destino.deposito(valor);
            this.saldo -= valor;
        }
        else if (valor <= (saldo + limite)){
            this.limite -= valor - this.saldo;
            this.saldo = 0;
            destino.deposito(valor);
        }else
            throw new OperationNotSupportedException("Saldo insuficiente");
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String getNroConta() {
        return nroConta;
    }

    public void setNroConta(String nroConta) {
        this.nroConta = nroConta;
    }
}
