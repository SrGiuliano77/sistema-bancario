package banco;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Conta {
    private int numeroUsuario;
    private int numeroSenha;
    private double saldoCorrente;
    private double saldoPoupanca;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'R$'###,##0.00");

    public int getNumeroUsuario() {
        return numeroUsuario;
    }

    public int setNumeroUsuario(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
        return numeroUsuario;
    }

    public int getNumeroSenha() {
        return numeroSenha;
    }

    public int setNumeroSenha(int numeroSenha) {
        this.numeroSenha = numeroSenha;
        return numeroSenha;
    }

    public double getSaldoCorrente() {
        return saldoCorrente;
    }

    public double setSaldoCorrente(double saldoCorrente) {
        this.saldoCorrente = saldoCorrente;
        return saldoCorrente;
    }

    public double getSaldoPoupanca() {
        return saldoPoupanca;
    }

    public double setSaldoPoupanca(double saldoPoupanca) {
        this.saldoPoupanca = saldoPoupanca;
        return saldoPoupanca;
    }

    public double calcCorrenteSaque(double quantia) {
        saldoCorrente = (saldoCorrente - quantia);
        return saldoCorrente;
    }

    public double calcPoupancaSaque(double quantia) {
        saldoPoupanca = (saldoPoupanca - quantia);
        return saldoPoupanca;
    }

    public double calcCorrenteDeposito(double quantia) {
        saldoCorrente = (saldoCorrente + quantia);
        return saldoCorrente;
    }

    public double calcPoupancaDeposito(double quantia) {
        saldoPoupanca = (saldoPoupanca + quantia);
        return saldoPoupanca;
    }

    public void getSaqueCorrenteInput() {
        System.out.println("Saldo Conta Corrente: " + moneyFormat.format(saldoCorrente));
        System.out.println("Quantia que deseja sacar: ");
        double quantia = input.nextDouble();

        if (saldoCorrente - quantia >= 0) {
            calcCorrenteSaque(quantia);
            System.out.println("Novo saldo Conta Corrente: " + moneyFormat.format(saldoCorrente));
        } else {
            System.out.println("Saldo não pode ser negativo." + "\n");
        }
    }

    public void getSaquePoupancaInput() {
        System.out.println("Saldo Conta Poupanca: " + moneyFormat.format(saldoPoupanca));
        System.out.println("Quantia que deseja sacar: ");
        double quantia = input.nextDouble();

        if (saldoPoupanca - quantia >= 0) {
            calcPoupancaSaque(quantia);
            System.out.println("Novo saldo Conta Poupanca: " + moneyFormat.format(saldoPoupanca));
        } else {
            System.out.println("Saldo não pode ser negativo." + "\n");
        }
    }

    public void getDepositoCorrenteInput() {
        System.out.println("Saldo Conta Corrente: " + moneyFormat.format(saldoCorrente));
        System.out.println("Quantia que deseja depositar: ");
        double quantia = input.nextDouble();

        if (saldoCorrente + quantia >= 0) {
            calcCorrenteDeposito(quantia);
            System.out.println("Novo saldo Conta Corrente" + moneyFormat.format(saldoCorrente));
        } else {
            System.out.println("Saldo não pode ser negativo." + "\n");
        }
    }

    public void getDepositoPoupancaInput() {
        System.out.println("Saldo Conta Poupanca: " + moneyFormat.format(saldoPoupanca));
        System.out.println("Quantia que deseja depositar: ");
        double quantia = input.nextDouble();

        if (saldoPoupanca + quantia >= 0){
            calcPoupancaDeposito(quantia);
            System.out.println("Novo saldo Conta Poupanca: " + moneyFormat.format(saldoPoupanca));
        }else {
            System.out.println("Saldo não deve ser negativo."+ "\n");
        }
    }
}
