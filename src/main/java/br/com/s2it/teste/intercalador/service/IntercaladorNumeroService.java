package br.com.s2it.teste.intercalador.service;

/**
 * Serviço responsável por intercalar dígitos de números.
 * @param <T> Classe que extende {@link Number}.
 */
public interface IntercaladorNumeroService<T extends Number> {
	
	/**
	 * Realiza a intercalação de dígitos dos números informados.
	 * <br />
	 * Ex: numeroA = 1025, numeroB = 51, retorno será 150125.
	 * @param numeroA O primeiro número.
	 * @param numeroB O segundo número.
	 * @return Retorno o número com dígitos intercalados.
	 */
	T intercalar(T numeroA, T numeroB);

}
