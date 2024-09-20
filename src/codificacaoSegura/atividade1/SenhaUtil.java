package codificacaoSegura.atividade1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SenhaUtil {
	private static final String ALGORITMO_HASH = "SHA-256";
	private static final SecureRandom random = new SecureRandom();
	private static final int ITERACOES = 1000;

	public static String gerarSalt() {
		byte[] salt = new byte[32];
		random.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}

	// Gera o hash da senha usando o salt e as iterações
	public static String gerarHash(String senha, String salt) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(ALGORITMO_HASH);
		md.update(Base64.getDecoder().decode(salt));
		byte[] senhaHash = md.digest(senha.getBytes());

		for (int i = 0; i < ITERACOES; i++) {
			md.update(senhaHash);
			senhaHash = md.digest();
		}

		return Base64.getEncoder().encodeToString(senhaHash);
	}
}
