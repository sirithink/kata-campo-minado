package campominado;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CampoTest {

	@Test
	public void campoSemMinas() {
		Campo campo = new Campo("...");
		assertEquals("000", campo.dicas());
	}
	
	@Test
	public void campoComMinas() {
		Campo campo = new Campo(".*..");
		byte mina = campo.dicas().getBytes()[1];
		assertEquals('*', mina);
	}
	
	@Test
	public void campoComMinasDicasADireita() {
		Campo campo = new Campo(".*..");
		byte dica = campo.dicas().getBytes()[2];
		assertEquals('1', dica);
	}
	
	@Test
	public void campoComMinasDicasAEsquerda() {
		Campo campo = new Campo(".*..");
		byte dica = campo.dicas().getBytes()[0];
		assertEquals('1', dica);
	}
	
	@Test
	public void campoComMinasDicasAEsquerdaADireita() {
		Campo campo = new Campo(".*.*.");
		String dicas = campo.dicas();
		assertEquals('1', dicas.charAt(0));
		assertEquals('2', dicas.charAt(2));
		assertEquals('1', dicas.charAt(4));
	}
	
	@Test
	public void campoComMinasDicasAbaixoColuna1() {
		Campo campo = new Campo("*..." +
								"...." +
								"....", 4);
		String dicas = campo.dicas();
		assertEquals('1', dicas.charAt(4));
	}
	
	@Test
	public void campoComMinasDicasAcimaColuna1() {
		Campo campo = new Campo("...." +
								"*..." +
								"....", 4);
		String dicas = campo.dicas();
		assertEquals('1', dicas.charAt(8));
	}
	
	@Test
	public void campoComMinasDicasColunaDireita() {
		Campo campo = new Campo("...*" +
								"*..." +
								"....", 4);
		String dicas = campo.dicas();
		assertEquals('1', dicas.charAt(7));
	}
	
	@Test
	public void campoComMinasDicasPisoDireito() {
		Campo campo = new Campo("...*" +
								"*.*." +
								"..*.", 4);
		String dicas = campo.dicas();
		assertEquals('2', dicas.charAt(11));
	}
	
	@Test
	public void multiplasMinasTodasAdjacencias() {
		Campo campo = new Campo("***." +
								"*.*." +
								"***.", 4);
		String dicas = campo.dicas();
		assertEquals('8', dicas.charAt(5));
	}
	
	@Test
	public void mapaDeDicasCompleto() {
		Campo campo = new Campo("*.*." +
								"*..." +
								"*.*.", 4);
		assertEquals("*3*1" +
				     "*522" +
				     "*3*1", campo.dicas());
		System.out.println(campo.dicas());
	}
	
}
