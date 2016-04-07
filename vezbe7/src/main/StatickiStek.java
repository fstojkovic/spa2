package main;

import labis.cvorovi.CvorDSListe;
import labis.exception.LabisException;
import labis.statickeStrukture.AStatickiStek;
import labis.test.ListGenerator;

public class StatickiStek extends AStatickiStek {

	public StatickiStek(int kapacitet) {
		super(kapacitet);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ispisiStekObrnuto() throws LabisException {
		if (prazanStek()) {
			return;
		}

		int pomocna = pop();
		ispisiStekObrnuto();
		System.out.println(pomocna);
		push(pomocna);
	}
	 
	//3-22						I pom=22 / vrh = 2(pop)  syso 7 10 20 22 vrh 3 push
	//2-10						II pom =10 / vrh = 1 (pop) syso 7 10 20 vrh 2 push
	//1-20						III pom = 20 / vrh = 0 (pop) syso 7 10 vrh 1 push
	//0-7						IV pom = 7 / vrh =-1 kad vraca syso 7  vrh 0 push
							//	V vraca return;
	
	// 
	
	public static void main(String[] args) {
		
		DSLista lista = new DSLista();
		int[] elementi  = new int[]{2,8,11};
		ListGenerator.napraviDSListuCommon(lista, elementi, false);
		try {
			lista.popuniListu();
		} catch (LabisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CvorDSListe pom = lista.prvi;
		while(pom!=null){
			System.out.println(pom.podatak);
			pom=pom.sledeci;
		}
	}
	
	}
