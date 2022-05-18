package br.com.ifce.estrutura.lista.encadeadadupla;

public class TesteDuploEncadeado {

	public static void main(String[] args) {
		ListaNo listaDupla = new ListaNo(null, null);
		FilaNo filaDupla = new FilaNo(null, null);
		PilhaNo pilhaDupla = new PilhaNo(null, null);
		
		System.out.println("manuseando a Lista \n");

		listaDupla.append(new DuploNo("Daniel"));
		listaDupla.append(new DuploNo("Joao"));
		listaDupla.append(new DuploNo("Francisco"));
		listaDupla.append(new DuploNo("Raimundo"));
		
		System.out.println("Count manual: " + listaDupla.countManual());
		System.out.println("Count por variavel: " + listaDupla.getCount());
		
		System.out.println("Tem nome francisco? " + listaDupla.containsName("francisco"));
		System.out.println(listaDupla.pegarPosicaoDescricao("Francisco"));
		listaDupla.imprimirLista();
		listaDupla.addMeio(new DuploNo("Paulin"), 2);
		listaDupla.addFrente(new DuploNo("Leozin"));
		listaDupla.imprimirLista();

		System.out.println("manuseando a fila \n");

		filaDupla.add(new DuploNo("Daniel2"));
		filaDupla.add(new DuploNo("Joao2"));
		filaDupla.add(new DuploNo("Francisco2"));
		filaDupla.add(new DuploNo("Raimundo2"));
		
		System.out.println("Count manual: " + filaDupla.countManual());
		System.out.println("Count por variavel: " + filaDupla.getCount());
		
		System.out.println("Tem nome francisco2? " + filaDupla.containsName("francisco2"));
		System.out.println(filaDupla.pegarPosicaoDescricao("Francisco2"));
		filaDupla.imprimirFila();
		filaDupla.remover();
		filaDupla.imprimirFila();

		System.out.println("manuseando a pilha \n");

		pilhaDupla.addTopo(new DuploNo("Daniel3"));
		pilhaDupla.addTopo(new DuploNo("Joao3"));
		pilhaDupla.addTopo(new DuploNo("Francisco3"));
		pilhaDupla.addTopo(new DuploNo("Raimundo3"));
		
		System.out.println("Count manual: " + pilhaDupla.countManual());
		System.out.println("Count por variavel: " + pilhaDupla.getCount());
		
		System.out.println("Tem nome francisco3? " + pilhaDupla.containsName("francisco3"));
		System.out.println(filaDupla.pegarPosicaoDescricao("Francisco3"));
		pilhaDupla.imprimirPilha();
		pilhaDupla.remover();
		pilhaDupla.imprimirPilha();
		
	}
}
