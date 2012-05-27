package campominado;

public class Campo {

	private char mapa[][];
	final private int[/*linha*/][/*coluna*/] offsetAdjacencias = 
		                                        {{-1,-1},{-1, 0},{-1, 1},
			                                     { 0,-1},/* X */ { 0, 1},
			                                     { 1,-1},{ 1, 0},{ 1, 1}};
	private int ncolunas;
	private int nlinhas;

	public Campo(String mapa) {
		this(mapa,mapa.length());
	}

	public Campo(String mapa, int colunas) {
		this.ncolunas = colunas;
		this.nlinhas = mapa.length()/colunas;
		this.mapa = preencheCampoCom(mapa,colunas);
	}

	private char[][] preencheCampoCom(String mapa, int colunas_) {
		char[][] campo = new char[mapa.length()/colunas_][colunas_];
		char[] celulas = mapa.toCharArray();
		for(int i = 0; i < celulas.length; i++){
			campo[i/colunas_][i%colunas_] = celulas[i];
		}
		return campo;
	}

	public String dicas() {
		String resultado = "";
		for(int l = 0; l < nlinhas; l++){
			for(int c = 0; c < ncolunas; c++){
				if(mapa[l][c] == '*'){
					resultado += "*";
				} else {
					resultado += String.valueOf(contarOcorrenciasDeMinasNas(adjacencias(l,c)));
				}
			}
		}
		return resultado;
	}
	
	private String adjacencias(int linha, int coluna) {
		String resultado = "";
		for(int[] offset : offsetAdjacencias){
			resultado += verificaLimitesERetornaCelula(linha+offset[0],coluna+offset[1]);
		}
		return resultado;
	}
	
	private String verificaLimitesERetornaCelula(int l, int c) {
		boolean resultado = (l >= 0 && l < nlinhas);
		resultado = resultado && (c >= 0 && c < ncolunas);
		return (resultado ? "" + mapa[l][c] : "");
	}

	private int contarOcorrenciasDeMinasNas(String adjacencias) {
		int ocorrencias = 0;
	    for (int i=0; i < adjacencias.length(); i++) {
	        if (adjacencias.charAt(i) == '*') ocorrencias++;
	    }
	    return ocorrencias;
	}
}
