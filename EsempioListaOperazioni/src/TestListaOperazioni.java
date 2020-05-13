// classe che testa i metodi di ListaOperazioni
// compilare con javac TestListaOperazioni.java
// eseguire con java TestListaOperazioni
import java.io.IOException;

public class TestListaOperazioni {
	private ListaOperazioni lsop = new ListaOperazioni();
	
	public void testLeggiFile() {
		lsop.svuota();
		try {
			lsop.leggiFile("resources/operazioni.csv"); 
			System.out.println("OK testLeggiFile");
		} catch (IOException e) {
			System.out.println("FAILED testLeggiFile");
		}
	}
	
	public void testInserisciSum() {
		lsop.svuota();
		try {
			lsop.inserisci("SUM,1,2,3,4");
			System.out.println("OK testInserisciSum");
		} catch (IOException e) {
			System.out.println("FAILED testInserisciSum");
		}		
	}
	
	public void testInserisciMul() {
		lsop.svuota();
		try {
			lsop.inserisci("MUL,1,2,3,4");
			System.out.println("OK testInserisciMul");
		} catch (IOException e) {
			System.out.println("FAILED testInserisciMul");
		}
	}
	
	public void testInserisciSconosciuto() {
		lsop.svuota();
		try {
			lsop.inserisci("ABC,1,2,3,4");
			System.out.println("FAILED testInserisciSconosciuto");
		} catch (IOException e) {
			System.out.println("OK testInserisciSconosciuto");
		}
	}
	
	private void testCalcolaSommaTotale() {
		lsop.svuota();
		
		try {
			lsop.inserisci("SUM,1,2,3,4");	// res: 10 
			lsop.inserisci("MUL,1,2,3,4");	// res: 24
		} catch (IOException e) {
			System.out.println("FAILED testCalcolaSommaTotale: errore di parsing");
			return;
		}

		if (lsop.calcolaSommaTotale() == 34f)
			System.out.println("OK testCalcolaSommaTotale");
		else
			System.out.println("FAILED testCalcolaSommaTotale: risultato non corretto");
	}
	
	public static void main(String[] args) {
		TestListaOperazioni t = new TestListaOperazioni();
		
		t.testLeggiFile();
		t.testInserisciMul();
		t.testInserisciSum();
		t.testInserisciSconosciuto();
		t.testCalcolaSommaTotale();
	}
}