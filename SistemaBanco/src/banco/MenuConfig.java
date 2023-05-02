package banco;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuConfig extends Conta {
    int selection;

    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'R$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                data.put(4512837, 1234);
                data.put(2256348, 8585);

                System.out.println("Bem vindo ao sistema bancário");

                System.out.println("Insira seu numero de usuário:");
                setNumeroUsuario(menuInput.nextInt());

                System.out.println("Insira sua senha:");
                setNumeroSenha(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\n" + "Caracteres inválidos! Apenas números são permitidos." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getNumeroUsuario() && entry.getValue() == getNumeroSenha()) {
                    getTipoConta();
                }
            }
            System.out.println("\n" + "Usuario ou senha incorreto." + "\n");
        } while (x == 1);
    }

    public void getTipoConta() {
        System.out.println("Selecione a conta que deseja acessar:");
        System.out.println("Digite 1 - Conta Corrente");
        System.out.println("Digite 2 - Conta Poupança");
        System.out.println("Digite 3 - Sair");
        System.out.println("Escolha: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> getCorrente();
            case 2 -> getPoupanca();
            case 3 -> System.out.println("Obrigado por utilizar nossos serviços!");
            default -> {
                System.out.println("\n" + "Escolha inválida" + "\n");
                getTipoConta();
            }
        }
    }

    public void getCorrente() {
        System.out.println("Conta Corrente: ");
        System.out.println("Digite 1 - Saldo");
        System.out.println("Digite 2 - Sacar");
        System.out.println("Digite 3 - Depositar");
        System.out.println("Digite 4 - Sair");
        System.out.println("Escolha: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Saldo Conta Corrente: " + moneyFormat.format(getSaldoCorrente()));
                getTipoConta();
            }
            case 2 -> {
                getSaqueCorrenteInput();
                getTipoConta();
            }
            case 3 -> {
                getDepositoCorrenteInput();
                getTipoConta();
            }
            case 4 -> System.out.println("Obrigado por utilizar nossos serviços!");
            default -> {
                System.out.println("\n" + "Escolha Inválida." + "\n");
                getCorrente();
            }
        }
    }

    public void getPoupanca() {
        System.out.println("Conta Poupança: ");
        System.out.println("Digite 1 - Saldo");
        System.out.println("Digite 2 - Sacar");
        System.out.println("Digite 3 - Depositar");
        System.out.println("Digite 4 - Sair");
        System.out.println("Escolha: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Saldo Conta Poupança: " + moneyFormat.format(getSaldoPoupanca()));
                getTipoConta();
            }
            case 2 -> {
                getSaquePoupancaInput();
                getTipoConta();
            }
            case 3 -> {
                getDepositoPoupancaInput();
                getTipoConta();
            }
            case 4 -> System.out.println("Obrigado por utilizar nossos serviços!");
            default -> {
                System.out.println("\n" + "Escolha Inválida" + "\n");
                getPoupanca();
            }
        }
    }
}
