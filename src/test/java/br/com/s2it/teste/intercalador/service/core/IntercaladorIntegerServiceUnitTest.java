package br.com.s2it.teste.intercalador.service.core;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import br.com.s2it.teste.intercalador.service.IntercaladorNumeroService;

/**
 * Teste unitário da classe {@link IntercaladorIntegerService}.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class IntercaladorIntegerServiceUnitTest {
	
	private IntercaladorNumeroService<Integer> intercaladorIntegerService;
	
	@Before
	public void setup() {
		intercaladorIntegerService = new IntercaladorIntegerService();
	}
	
	@Test
	public void deveIntercalarNumerosInteirosComMesmaQuantidadeDeDigitos() {
		Integer numeroIntercalado = intercaladorIntegerService.intercalar(123, 567);

		assertNotNull(numeroIntercalado);
		Assert.assertEquals("O numero intercalado deve ser 152637.", Integer.valueOf(152637), numeroIntercalado);
	}
	
	@Test
	public void deveIntercalarNumerosInteirosComQuantidadeDeDigitosDiferente() {
		Integer numeroIntercalado = intercaladorIntegerService.intercalar(1025, 51);

		assertNotNull(numeroIntercalado);
		Assert.assertEquals("O numero intercalado deve ser 150125.", Integer.valueOf(150125), numeroIntercalado);
	}
	
	@Test
	public void deveRetornarMenosUmAoExcederUmMilhaoDuranteIntercalacao() {
		Integer menosUm = intercaladorIntegerService.intercalar(1025, 5158);

		assertNotNull(menosUm);
		Assert.assertEquals("O numero intercalado deve ser -1.", Integer.valueOf(-1), menosUm);
	}

}
