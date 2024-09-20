package codigicacaoSegura.atividade2;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AutenticacaoAvancada {
    private static Map<String, String[]> usuarios = new HashMap<>(); // Mapa para armazenar usuários, hashes e salts

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in); 
        boolean loggedIn = false; 

        // Loop principal que continua até o usuário fazer login ou escolher sair
        while (!loggedIn) {
            System.out.println("1. Registrar");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt(); 
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    // Registro de novo usuário
                    System.out.print("Nome de usuário: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    // Validações de nome de usuário e senha
                    if (!isValidUsername(usuario)) {
                        System.out.println("Nome de usuário inválido! Deve ter pelo menos 5 caracteres.");
                    } else if (!isValidPassword(senha)) {
                        System.out.println("Senha inválida! Deve ter pelo menos 8 caracteres, incluindo letras e números.");
                    } else if (usuarios.containsKey(usuario)) {
                        System.out.println("Usuário já registrado!");
                    } else {
                        // Gera salt e hash para a senha
                        String salt = SenhaUtilAvancada.gerarSalt();
                        String hash = SenhaUtilAvancada.gerarHash(senha, salt);

                        // Armazena o usuário, hash e salt
                        usuarios.put(usuario, new String[]{hash, salt});
                        System.out.println("Usuário registrado com sucesso!");
                    }
                    break;

                case 2:
                    // Login de usuário
                    System.out.print("Nome de usuário: ");
                    String usuarioLogin = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senhaLogin = scanner.nextLine();

                    // Recupera os dados do usuário
                    String[] dados = usuarios.get(usuarioLogin);
                    if (dados != null) {
                        String hashArmazenado = dados[0];
                        String salt = dados[1];

                        // Gera o hash da senha fornecida e compara com o hash armazenado
                        String hash = SenhaUtilAvancada.gerarHash(senhaLogin, salt);
                        if (hash.equals(hashArmazenado)) {
                            System.out.println("Login bem-sucedido!");
                            loggedIn = true; 
                        } else {
                            System.out.println("Senha incorreta!");
                        }
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }
                    break;

                case 3:
                    // Sair do sistema
                    System.out.println("Saindo...");
                    loggedIn = true; 
                    break;

                default:
                    // Opção inválida
                    System.out.println("Opção inválida! Retornando ao menu inicial.");
                    break;
            }
        }

        scanner.close(); 
    }

    // Valida se o nome de usuário tem pelo menos 5 caracteres
    private static boolean isValidUsername(String username) {
        return username.length() >= 5;
    }

    // Valida se a senha tem pelo menos 8 caracteres, incluindo letras e números
    private static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*[a-zA-Z].*") && password.matches(".*[0-9].*");
    }
}
