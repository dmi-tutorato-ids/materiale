
// ListaOperazioni.java
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListaOperazioni {
	List<Operazione> listaOperazioni = new ArrayList<>();

	public void leggiFile(String csvFile) throws IOException {
		try (BufferedReader f = Files.newBufferedReader(Paths.get(csvFile))) {
			while (true) {
				String riga = f.readLine(); // legge una linea dal file
				if (riga == null)
					break; // controlla se il file e' finito
				inserisci(riga);
			}
		}
	}

	public void inserisci(String csvOperazione) throws IOException {
		String operazione = parseOperazione(csvOperazione);
		String operandi = parseOperandi(csvOperazione);

		switch (operazione) {
			case "SUM":
				listaOperazioni.add(new Somma(operandi));
				break;
			case "MUL":
				listaOperazioni.add(new Moltiplicazione(operandi));
				break;
			default:
				throw new IOException("Errore di parsing: Operazione sconosciuta " + operazione);
		}
	}

	private String parseOperazione(String riga) {
		return riga.substring(0, riga.indexOf(','));
	}

	private String parseOperandi(String riga) {
		return riga.substring(riga.indexOf(',') + 1);
	}

	public float calcolaSommaTotale() {
		float risultato = 0;

		for (Operazione op : listaOperazioni) {
			risultato += op.calcolaRisultato();
		}

		return risultato;
	}

	public void svuota() {
		listaOperazioni = new ArrayList<>();
	}

}