package main;

import labis.cvorovi.CvorDSListe;
import labis.exception.LabisException;
import labis.liste.ADSLista;

public class DSLista extends ADSLista {

	@Override
	public void popuniListu() throws LabisException {

		/*
		 * if (prvi == null) { return; }
		 * 
		 * CvorDSListe pom = prvi; CvorDSListe novi = null;
		 * 
		 * while (pom.sledeci != null) {
		 * 
		 * if ((pom.sledeci.podatak - pom.podatak) > 1) { // for (int i =
		 * pom.podatak+1; i < pom.sledeci.podatak; i++) { novi = new
		 * CvorDSListe(pom.podatak + 1, pom, pom.sledeci); pom.sledeci.prethodni
		 * = novi; pom.sledeci = novi; // } } pom = pom.sledeci; }
		 */

		popuniListu(prvi);

	}

	public void popuniListu(CvorDSListe pom) throws LabisException {

		if (pom == null || pom.sledeci == null) {
			return;
		}

		if ((pom.sledeci.podatak - pom.podatak) > 1) {
			CvorDSListe novi = new CvorDSListe(pom.podatak + 1, pom, pom.sledeci);
			pom.sledeci.prethodni = novi;
			pom.sledeci = novi;

		}

		popuniListu(pom.sledeci);

	}

	/*
	 * @Override public CvorDSListe elementUSredini() throws LabisException {
	 * 
	 * if (prvi == null) { throw new LabisException("prazna lista."); } int
	 * brojac = 0;
	 * 
	 * CvorDSListe pom = prvi; CvorDSListe srednji = prvi; while (pom != null) {
	 * 
	 * brojac++; if (brojac / 2 == 0) { srednji = srednji.sledeci; } pom =
	 * pom.sledeci; } return srednji; }
	 */
	@Override
	public CvorDSListe elementUSredini() throws LabisException {

		if (prvi == null || prvi.sledeci == null || prvi.sledeci.sledeci == null) {
			return prvi;
		}

		CvorDSListe brzi = prvi;
		CvorDSListe spori = prvi;
		while (brzi.sledeci != null && brzi.sledeci.sledeci != null) //while(brzi!=null && brzi.sledeci!=null)//ako ima 5elelemenata vraca 3i
		{																									 // ako imamo 4elemenata vraca 3i		
			brzi = brzi.sledeci.sledeci;
			spori = spori.sledeci;
		}

		return spori;
	}

}
