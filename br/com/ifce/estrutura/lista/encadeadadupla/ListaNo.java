package br.com.ifce.estrutura.lista.encadeadadupla;

public class ListaNo {
	DuploNo primeiro;
	DuploNo ultimo;
	private int count = 0;

	public void append(DuploNo duploNo) {
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

	public void addFrente(DuploNo duploNo) {
		if (primeiro == null) {
			primeiro = duploNo;
		} else {
			primeiro.setAnterior(duploNo);
			duploNo.setProximo(primeiro);
			primeiro = duploNo;
		}
		count++;
	}

	public ListaNo(DuploNo primeiro, DuploNo ultimo) {
		super();
		this.primeiro = primeiro;
		this.ultimo = ultimo;
	}

	public void varrerListaDupla(DuploNo duplo) {
		if (duplo.getProximo() != null) {
			System.out.println(duplo);
			varrerListaDupla(duplo.getProximo());
		} else {
			System.out.println(duplo);
		}
	}

	private int varrerListPraContar(DuploNo duploNo) {
		if (duploNo.getProximo() == null) {
			return 1;
		} else {
			return 1 + varrerListPraContar(duploNo.getProximo());
		}
	}

	private int varrerListaVerificarPosicao(DuploNo duploNo, String busca) {
		if (duploNo == null) {
			return -1;
		}
		if (duploNo.getDescricao().toUpperCase().equals(busca.toUpperCase())) {
			return 0;
		}
		return 1 + varrerListaVerificarPosicao(duploNo.getProximo(), busca);
	}

	public String pegarPosicaoDescricao(String descricao){
		if (containsName(descricao) == false){
			return "Nome não encontrado";
		}
		if (varrerListaVerificarPosicao(primeiro, descricao) == -1) {
			return "Lista Vazia";
		}
		return "O nome procurado está na posição " + varrerListaVerificarPosicao(primeiro, descricao);
	}

	public int countManual() {
		if (primeiro == null) {
			return 0;
		} else if (ultimo == null) {
			return 1;
		}
		return varrerListPraContar(primeiro);
	}

	private DuploNo varrerListaBuscarDuploNoPorDescricao(DuploNo duploNo, String busca) {
		if (duploNo == null) {
			return null;
		}
		if (duploNo.getDescricao().toUpperCase().equals(busca.toUpperCase())) {
			return duploNo;
		}
		return varrerListaBuscarDuploNoPorDescricao(duploNo.getProximo(), busca);
	}

	public boolean containsName(String descricao) {
		if (varrerListaBuscarDuploNoPorDescricao(primeiro, descricao) == null) {
			return false;
		}
		return true;
	}
	
	public void addMeio(DuploNo No, int posicao){
		if (posicao <= 0){
			addFrente(No);
		}else if (posicao >= getCount()){
			append(No);
		} else {
			DuploNo local = primeiro;
			for(int i = 0; i < posicao-1; i++){
				local = local.getProximo();
			}
			No.setAnterior(local);
			No.setProximo(local.getProximo());
			local.setProximo(No);
			No.getProximo().setAnterior(No);
			count++;
		}
	}
	
	private void imprimirListaDupla(DuploNo duploNo, int posicao){
		if (duploNo != null){
			System.out.println(posicao + "  " + duploNo.getDescricao());
			if (duploNo.getProximo() != null){
				imprimirListaDupla(duploNo.getProximo(), posicao + 1);
			}
		} else {
			System.out.println("Lista Vazia");
		}
	}

	public void imprimirLista(){
		int posicao = 0;
		imprimirListaDupla(primeiro, posicao);
	}

	public int getCount() {
		return count;
	}
}