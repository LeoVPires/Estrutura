package br.com.ifce.estrutura.lista.encadeadadupla;

public class FilaNo {
	DuploNo primeiro;
	DuploNo ultimo;
	private int count = 0;

	public void add(DuploNo duploNo) {
		if (primeiro == null) {
			primeiro = duploNo;
		} else if (ultimo == null) {
			ultimo = duploNo;
			primeiro.setProximo(ultimo);
			ultimo.setAnterior(primeiro);
		} else {
			ultimo.setProximo(duploNo);
			duploNo.setAnterior(ultimo);
			ultimo = duploNo;
		}
		count++;
	}

	private void removerUltimo(DuploNo duploNo){
		if (primeiro == null){
			System.out.println("Lista Vazia");
		} else if (ultimo != null){
			primeiro.getProximo().setAnterior(null);
			primeiro = primeiro.getProximo();
		}
	}

	public void remover(){
		removerUltimo(primeiro);
	}

	public FilaNo(DuploNo primeiro, DuploNo ultimo) {
		super();
		this.primeiro = primeiro;
		this.ultimo = ultimo;
	}

	public void varrerFilaDupla(DuploNo duplo) {
		if (duplo.getProximo() != null) {
			System.out.println(duplo);
			varrerFilaDupla(duplo.getProximo());
		} else {
			System.out.println(duplo);
		}
	}

	private int varrerFilaPraContar(DuploNo duploNo) {
		if (duploNo.getProximo() == null) {
			return 1;
		} else {
			return 1 + varrerFilaPraContar(duploNo.getProximo());
		}
	}

	private int varrerFilaVerificarPosicao(DuploNo duploNo, String busca) {
		if (duploNo == null) {
			return -1;
		}
		if (duploNo.getDescricao().toUpperCase().equals(busca.toUpperCase())) {
			return 0;
		}
		return 1 + varrerFilaVerificarPosicao(duploNo.getProximo(), busca);
	}

	public String pegarPosicaoDescricao(String descricao){
		if (containsName(descricao) == false){
			return "Nome não encontrado";
		}
		if (varrerFilaVerificarPosicao(primeiro, descricao) == -1) {
			return "Fila Vazia";
		}
		return "O nome procurado está na posição " + varrerFilaVerificarPosicao(primeiro, descricao);
	}

	public int countManual() {
		if (primeiro == null) {
			return 0;
		} else if (ultimo == null) {
			return 1;
		}
		return varrerFilaPraContar(primeiro);
	}

	private DuploNo varrerFilaBuscarNoPorDescricao(DuploNo duploNo, String busca) {
		if (duploNo == null) {
			return null;
		}
		if (duploNo.getDescricao().toUpperCase().equals(busca.toUpperCase())) {
			return duploNo;
		}
		return varrerFilaBuscarNoPorDescricao(duploNo.getProximo(), busca);
	}

	public boolean containsName(String descricao) {
		if (varrerFilaBuscarNoPorDescricao(primeiro, descricao) == null) {
			return false;
		}
		return true;
	}
	
	private void imprimirFilaDupla(DuploNo duploNo, int posicao){
		if (duploNo != null){
			System.out.println(posicao + "  " + duploNo.getDescricao());
			if (duploNo.getProximo() != null){
				imprimirFilaDupla(duploNo.getProximo(), posicao + 1);
			}
		} else {
			System.out.println("Fila Vazia");
		}
	}

	public void imprimirFila(){
		int posicao = 0;
		imprimirFilaDupla(primeiro, posicao);
	}

	public int getCount() {
		return count;
	}

}