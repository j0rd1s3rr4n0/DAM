import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculadoraEnrega {

	/*
	 @Test
	void test() {
		fail("Not yet implemented");
	}
	*/

	@Test
	public void testSuma() {
		//Suma de nombres enters
		double resultado = Calculadora.suma(3, 5);
		double esperado = 8;
		assertEquals(resultado,esperado);

		//Suma de nombres decimals
		double resultado1 = Calculadora.suma(3.2, 5.2);
		double esperado1 = 8.4;
		assertEquals(resultado1,esperado1);

		//Suma de nombres negatius
		double resultado2 = Calculadora.suma(-3, -5);
		double esperado2 = -8;
		assertEquals(resultado2,esperado2);

		//Suma de qualsevol nombre amb l'element neutre de la suma (que és el zero)
		double resultado3 = Calculadora.suma(3, 0);
		double esperado3 = 3;
		assertEquals(resultado3,esperado3);
	}

	@Test
	public void testResta() {

		//Resta de nombres enters
		double resultado = Calculadora.resta(3, 5);
		double esperado = -2;
		assertEquals(resultado,esperado);

		//Resta de nombres decimals
		double resultado1 = Calculadora.resta(3.2, 5.2);
		double esperado1 = -2.0;
		assertEquals(resultado1,esperado1);

		//Resta de nombres negatius
		double resultado2 = Calculadora.resta(-3, -5);
		double esperado2 = 2;
		assertEquals(resultado2,esperado2);

		//Resta de qualsevol nombre amb l'element neutre de la resta (que és el zero)
		double resultado3 = Calculadora.resta(3, 0);
		double esperado3 = 3;
		assertEquals(resultado3,esperado3);
	}

	@Test
	public void testMulti() {

		//Multiplicar nombres enters
		double resultado = Calculadora.multi(3, 5);
		double esperado = 15.0;
		assertEquals(resultado,esperado);

		//Multiplicar nombres decimals
		double resultado1 = Calculadora.multi(3.2, 5.2);
		double esperado1 = 16.64;
		assertEquals(resultado1,esperado1);

		//Multiplicar un nombre positiu per un negatiu
		double resultado2 = Calculadora.multi(3, 5);
		double esperado2 = 15;
		assertEquals(resultado2,esperado2);

		//Multiplicar dos nombres negatius
		double resultado3 = Calculadora.multi(-3, -5);
		double esperado3 = 15;
		assertEquals(resultado3,esperado3);

		//Multiplicar qualsevol nombre per l'element neutre de la multiplicació (que és el zero)
		double resultado4 = Calculadora.multi(3,0);
		double esperado4 = 0;
		assertEquals(resultado4,esperado4);

	}

	@Test
	public void testDivi() {

		//Dividir nombres enters
		double resultado = Calculadora.divi(3, 5);
		double esperado = 0.6;
		assertEquals(resultado,esperado);

		//Dividir nombres decimals
		double resultado1 = Calculadora.divi(3.2, 5.2);
		double esperado1 = 0.6153846153846154;
		assertEquals(resultado1,esperado1);

		//Dividir un nombre positiu entre un negatiu
		double resultado2 = Calculadora.divi(3, 5);
		double esperado2 = 0.6;
		assertEquals(resultado2,esperado2);

		//Dividir dos nombres negatius
		double resultado3 = Calculadora.divi(-3, -5);
		double esperado3 = 0.6;
		assertEquals(resultado3,esperado3);

		//Dividir qualsevol nombre per l'element neutre de la multiplicació (que és l'1)
		double resultado4 = Calculadora.divi(3, 1);
		double esperado4 = 3;
		assertEquals(resultado4,esperado4);

		//Dividir qualsevol nombre entre zero i retornar un missatge d'error controlat.
		IllegalArgumentException error=Assertions.assertThrows(IllegalArgumentException.class, () -> Calculadora.divi(3, 0));
		Assertions.assertEquals("Infinito", error.getMessage());
		


	}
}