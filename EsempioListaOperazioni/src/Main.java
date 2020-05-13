// classe che chiama metodi di ListaOperazioni
// compilare con javac MainOperazioni.java
// eseguire con java MainOperazioni
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String csvFile = "resources/operazioni.csv";
		ListaOperazioni lsop = new ListaOperazioni();

		System.out.println("File csv: " + csvFile);
		lsop.leggiFile(csvFile);
		System.out.println("Somma totale: "+ lsop.calcolaSommaTotale());
	}
}