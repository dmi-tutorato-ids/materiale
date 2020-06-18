package org.ids.libri;

public class Libro {
	public enum Categoria {
		FANTASY, CYBERPUNK, THRILLER, STORICO, INFORMATICA
	}
	
	String titolo;
	Categoria categoria;
	int prezzo;

	public Libro(String nome, Categoria categoria, int prezzo) {
		this.titolo = nome;
		this.categoria = categoria;
		this.prezzo = prezzo;
	}

	public String getTitolo() {
		return titolo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return titolo + " (" + categoria + ", " + prezzo + "€)";
	}

}