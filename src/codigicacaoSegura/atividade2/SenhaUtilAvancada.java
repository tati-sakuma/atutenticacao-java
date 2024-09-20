package codigicacaoSegura.atividade2;

import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class SenhaUtilAvancada {
    private static final String ALGORITMO_HASH = "PBKDF2WithHmacSHA256"; // Define o algoritmo de hash a ser usado
    private static final int ITERACOES = 50000; // Número de iterações para o processo de hashing
    private static final int TAMANHO_BYTES = 256; // Tamanho do hash em bytes

    // Gera o hash da senha usando PBKDF2
    public static String gerarHash(String senha, String salt) throws NoSuchAlgorithmException {
        try {
            KeySpec spec = new PBEKeySpec(senha.toCharArray(), Base64.getDecoder().decode(salt), ITERACOES, TAMANHO_BYTES);
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITMO_HASH);
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash); // Retorna o hash final codificado em Base64
        } catch (Exception e) {
            throw new NoSuchAlgorithmException("Erro ao gerar hash", e);
        }
    }

    // Gera um salt aleatório
    public static String gerarSalt() {
        byte[] salt = new byte[32]; // Cria um array de bytes para o salt
        new SecureRandom().nextBytes(salt); // Preenche o array com bytes aleatórios
        return Base64.getEncoder().encodeToString(salt); // Retorna o salt codificado em Base64
    }
}

