package br.com.ifce.estrutura.lista.encadeadadupla;

public class PilhaNo {
	DuploNo primeiro;
	DuploNo ultimo;
	private int count = 0;

	public void addTopo(DuploNo duploNo) {
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

	private void removerTopo(DuploNo duploNo){
		if (primeiro == null){
			System.out.println("Lista Vazia");
		} else if (ultimo != null){
			ultimo.getAnterior().setProximo(null);
			ultimo = ultimo.getAnterior();
		}
	}

	public void remover(){
		removerTopo(primeiro);
	}

	public PilhaNo(DuploNo primeiro, DuploNo ultimo) {
		super();
		this.primeiro = primeiro;
		this.ultimo = ultimo;
	}

	public void varrerPilhaDupla(DuploNo duplo) {
		if (duplo.getProximo() != null) {
			System.out.println(duplo);
			varrerPilhaDupla(duplo.getProximo());
		} else {
			System.out.println(duplo);
		}
	}

	private int varrerPilhaPraContar(DuploNo duploNo) {
		if (duploNo.getProximo() == null) {
			return 1;
		} else {
			return 1 + varrerPilhaPraContar(duploNo.getProximo());
		}
	}

	private int varrerPilhaVerificarPosicao(DuploNo duploNo, String busca) {
		if (duploNo == null) {
			return -1;
		}
		if (duploNo.getDescricao().toUpperCase().equals(busca.toUpperCase())) {
			return 0;
		}
		return 1 + varrerPilhaVerificarPosicao(duploNo.getProximo(), busca);
	}

	public String pegarPosicaoDescricao(String descricao){
		if (containsName(descricao) == false){
			return "Nome não encontrado";
		}
		if (varrerPilhaVerificarPosicao(primeiro, descricao) == -1) {
			return "Pilha Vazia";
		}
		return "O nome procurado está na posição " + varrerPilhaVerificarPosicao(primeiro, descricao);
	}

	public int countManual() {
		if (primeiro == null) {
			return 0;
		} else if (ultimo == null) {
			return 1;
		}
		return varrerPilhaPraContar(primeiro);
	}

	private DuploNo varrerPilhaBuscarNoPorDescricao(DuploNo duploNo, String busca) {
		if (duploNo == null) {
			return null;
		}
		if (duploNo.getDescricao().toUpperCase().equals(busca.toUpperCase())) {
			return duploNo;
		}
		return varrerPilhaBuscarNoPorDescricao(duploNo.getProximo(), busca);
	}

	public boolean containsName(String descricao) {
		if (varrerPilhaBuscarNoPorDescricao(primeiro, descricao) == null) {
			return false;
		}
		return true;
	}
	
	private void imprimirPilhaDupla(DuploNo duploNo, int posicao){
		if (duploNo != null){
			System.out.println(posicao + "  " + duploNo.getDescricao());
			if (duploNo.getProximo() != null){
				imprimirPilhaDupla(duploNo.getProximo(), posicao + 1);
			}
		} else {
			System.out.println("Pilha Vazia");
		}
	}

	public void imprimirPilha(){
		int posicao = 0;
		imprimirPilhaDupla(primeiro, posicao);
	}

	public int getCount() {
		return count;
	}

}