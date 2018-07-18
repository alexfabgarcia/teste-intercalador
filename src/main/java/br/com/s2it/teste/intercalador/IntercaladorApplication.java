package br.com.s2it.teste.intercalador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.NumberUtils;

import br.com.s2it.teste.intercalador.service.IntercaladorNumeroService;

@SpringBootApplication
public class IntercaladorApplication implements CommandLineRunner {
	
	@Autowired
	private IntercaladorNumeroService<Integer> intercaladorIntegerService;

	public static void main(String[] args) {
		SpringApplication.run(IntercaladorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length != 2) {
			throw new IllegalArgumentException("Sao esperados dois inteiros como argumentos.");
		}
		
		try {
			Integer numeroA = NumberUtils.parseNumber(args[0], Integer.class);
			Integer numeroB = NumberUtils.parseNumber(args[1], Integer.class);
			
			Integer intercalado = intercaladorIntegerService.intercalar(numeroA, numeroB);
			
			System.out.println(intercalado);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("O argumento informado nao corresponde a um numero inteiro. ", e);
		}		
	}
}
