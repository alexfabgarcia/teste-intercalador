package br.com.s2it.teste.intercalador.service.core;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.s2it.teste.intercalador.service.IntercaladorNumeroService;

/**
 * Serviço que implementa {@link IntercaladorNumeroService} para números inteiros.
 */
@Service
public class IntercaladorIntegerService implements IntercaladorNumeroService<Integer> {

	private static final Integer NUMERO_MAXIMO_INTERCALACAO = 1000000;
	private static final int NUMERO_MAXIMO_INTERCALACAO_EXCEDIDO = -1;

	@Override
	public Integer intercalar(Integer numeroA, Integer numeroB) {
		Assert.notNull(numeroA, "O primeiro numero nao pode ser nulo.");
		Assert.notNull(numeroB, "O segundo numero nao pode ser nulo.");
		
		String a = String.valueOf(numeroA);
		String b = String.valueOf(numeroB);
		StringBuilder intercalador = new StringBuilder(a.length() + b.length());
		int maxLength = Math.max(a.length(), b.length());
		
		for (int i = 0; i < maxLength; i++) {
			if (i < a.length()) {
				intercalador.append(a.charAt(i));
			}
			if (i < b.length()) {
				intercalador.append(b.charAt(i));
			}
		}
		
		try {
			Integer c = Integer.valueOf(intercalador.toString());
			
			if (c > NUMERO_MAXIMO_INTERCALACAO) {
				return NUMERO_MAXIMO_INTERCALACAO_EXCEDIDO;
			} else {
				return c;
			}
		} catch (NumberFormatException e) {
			return NUMERO_MAXIMO_INTERCALACAO_EXCEDIDO;
		}
	}

}
