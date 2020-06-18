package org.ids.libri;

import org.ids.libri.Libro.Categoria;

public class Libreria {

	private Libreria() {}

	private static int i = 0;
	
	private static Libro[] prodPool = new Libro[] { 
			new Libro("Leviathan", Categoria.FANTASY, 20),
			new Libro("Trono di Spade", Categoria.FANTASY, 40),
			new Libro("Signore degli Anelli", Categoria.FANTASY, 25),

			new Libro("Neuromante", Categoria.CYBERPUNK, 15), 
			new Libro("Monnalisa Cyberpunk", Categoria.CYBERPUNK, 12),
			new Libro("Mirrorshades", Categoria.CYBERPUNK, 10),

			new Libro("Profondo Blu", Categoria.THRILLER, 8), 
			new Libro("Invasion", Categoria.THRILLER, 12),

			new Libro("Storia di una capinera", Categoria.STORICO, 5),
			new Libro("Design Pattern", Categoria.INFORMATICA, 35) };

	public static Libro gen() {
		return prodPool[i++ % prodPool.length];
	}

	public static void reset() {
		i = 0;
	}
}