package org.ids.libri;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.assertj.core.api.Assertions.*; // AssertJ

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.ids.libri.Libro.Categoria;
import org.junit.Before;
import org.junit.Test;

public class TestLibri {
    @Before
    public void resetLibreria() {
        Libreria.reset();
    }
    
    @Test
    public void stampa10Libri() {
        Stream.generate(Libreria::gen)
            .limit(10)
            .forEach(System.out::println);
        
        assertTrue(true);
    }

    @Test
    public void contaLibriCyberpunk() {
        long cnt = Stream.generate(Libreria::gen)
            .limit(10)
            .filter(x -> x.getCategoria() == Categoria.CYBERPUNK)
            .peek(System.out::println)
            .count();

        assertEquals(3, cnt);
    }

    @Test
    public void prezzoCompresoTra12e15() {
        List<Libro> list = Stream.generate(Libreria::gen)
			.limit(5)
			.filter(x -> x.getPrezzo() >= 10)
			.filter(x -> x.getPrezzo() <= 15)
            .peek(System.out::println)
            .collect(Collectors.toList());

        assertThat(list).allMatch(x -> x.getPrezzo() >= 10 && x.getPrezzo() <= 15);
    }

    @Test
    public void creaListaTitoliLibriCyberpunkFantasy() {
        List<String> list = Stream.generate(Libreria::gen)
            .limit(10)
            .filter(x -> x.getCategoria() == Categoria.CYBERPUNK 
                || x.getCategoria() == Categoria.FANTASY)
            .map(Libro::getTitolo)
            .peek(System.out::println)
            .collect(Collectors.toList());
        
        assertThat(list).containsOnly("Leviathan", "Trono di Spade", 
            "Signore degli Anelli", "Neuromante", 
            "Monnalisa Cyberpunk", "Mirrorshades");
    }

    @Test
    public void creaLista10LibriCyberpunk() {
        List<Libro> list = Stream.generate(Libreria::gen)
            .filter(x -> x.getCategoria() == Categoria.CYBERPUNK) 
            .limit(10)
            .peek(System.out::println)
            .collect(Collectors.toList());
        
        assertThat(list).hasSize(10);
        assertThat(list).allMatch(x -> x.getCategoria() == Categoria.CYBERPUNK);
    }

    @Test
    public void checkSePresenteBurningChrome() {
        boolean presente = Stream.generate(Libreria::gen) 
            .limit(10) 
            .peek(System.out::println)
            .filter(x -> x.getTitolo().equals("Burning Chrome"))
            .findAny()
            .isPresent(); //oppure al negativo: isEmpty()
        
        assertThat(presente).isFalse();
    }

    @Test
    public void sommaCosti_reduce() {
        int sum = Stream.generate(Libreria::gen)
            .limit(5)
            .peek(System.out::println)
            .map(Libro::getPrezzo)
            .reduce(0, Integer::sum);

        assertThat(sum).isEqualTo(112);
    }

    @Test
    public void sommaCosti_sum() {
        int sum = Stream.generate(Libreria::gen)
            .limit(5)
            .peek(System.out::println)
            .mapToInt(Libro::getPrezzo)
            .sum();

        assertThat(sum).isEqualTo(112);
    }

    @Test
    public void sommaCostiInDollari() {
        final double EUR_USD = 1.12;
        
        double sum = Stream.generate(Libreria::gen)
			.limit(5)
            .map(Libro::getPrezzo)
            .peek(System.out::println)
			.map(x -> x * EUR_USD)
			.peek(System.out::println)
			.reduce(0.0, Double::sum);

        System.out.println("expected:" + sum);
        System.out.println("actual:" + 112 * EUR_USD);

        assertThat(sum).isEqualTo(112 * EUR_USD, offset(0.001));
    }

    @Test
    public void libroMenoCaroDa12InSu() {
        Optional<Libro> book = Stream.generate(Libreria::gen)
            .limit(5)
            .filter(x -> x.getPrezzo() >= 12)
            .peek(System.out::println)
            .min(Comparator.comparing(Libro::getPrezzo));

        if (book.isPresent())
            assertThat(book.get().getTitolo()).isEqualTo("Monnalisa Cyberpunk");
        else
            fail("should be present");
    }

    @Test
    public void libriOrdinatiPerPrezzo() {
        List<Libro> list = Stream.generate(Libreria::gen)
			.limit(10)
			.sorted(Comparator.comparing(Libro::getPrezzo))
            .peek(System.out::println)
            .collect(Collectors.toList());

        assertThat(list).isSortedAccordingTo(Comparator.comparing(Libro::getPrezzo));
    }

    @Test
    public void stampaTotaleVenditePerLibro_senzaGroupingBy() {
        // genero una lista di libri venduti
        List<Libro> vendite = Stream.generate(Libreria::gen)
			.limit(20)
			.collect(Collectors.toList());

		vendite.stream()
			.map(Libro::getTitolo)
			.distinct()
			.peek(t -> System.out.print("Titolo: " + t + " Conteggio: "))
            .forEach(t -> System.out.println(
				vendite.stream()
				.filter(x -> x.getTitolo().equals(t)).count()));

        assertTrue(true);
    }

    @Test
    public void stampaPerCategoria_senzaGroupingBy() {
        // genero una lista di libri
        List<Libro> list = Stream.generate(Libreria::gen)
			.limit(10)
			.collect(Collectors.toList());

		list.stream()
			.map(Libro::getCategoria)
			.distinct()
			.peek(c -> System.out.println("Categoria: " + c))
			.forEach(c -> 
				list.stream()
				.filter(x -> x.getCategoria() == c)
				.map(Libro::getTitolo)
                .forEach(t -> System.out.println("- " + t)));

        assertTrue(true);
    }

    @Test
    public void groupingByCategoria() {
        // genero una lista di libri
        List<Libro> list = Stream.generate(Libreria::gen)
			.limit(10)
			.collect(Collectors.toList());

        // raggruppa in una mappa categoria -> lista libri
        Map<Categoria, List<Libro>> libriPerCategoria = list.stream()
            .collect(Collectors.groupingBy(Libro::getCategoria));

        // stampa la mappa
        libriPerCategoria.forEach((cat,libri) -> System.out.println(cat.name() + ": " + libri));
        
        assertTrue(true);
    }

    @Test
    public void crea7LibriHarryPotterDa15Euro() {
        List<Libro> list = IntStream.rangeClosed(1, 7)
				.mapToObj(n -> new Libro("Harry Potter " + n, Categoria.FANTASY, 15))
                .peek(System.out::println)
                .collect(Collectors.toList());

        // Qualche esempio di asserzione
        assertThat(list).hasSize(7);
        assertThat(list).allMatch(x -> x.getTitolo().matches("Harry Potter [1-7]"));
        assertThat(list).allMatch(x -> x.getCategoria() == Categoria.FANTASY);
        assertThat(list).allMatch(x -> x.getPrezzo() == 15);
        assertThat(list.stream()
            .map(Libro::getTitolo)
            .distinct()
            .collect(Collectors.toList())).hasSize(7);
    }

    @Test
    public void mescolaLista() {
        // genero una lista di libri
        List<Libro> list = Stream.generate(Libreria::gen)
            .limit(5)
            .peek(System.out::println)
			.collect(Collectors.toList());

        System.out.println();

        List<Libro> shuffle = Stream.generate(() -> (int) (Math.random() * list.size()))
            .distinct()
            .limit(list.size())
            .map(i -> list.get(i))
            .peek(System.out::println)
            .collect(Collectors.toList());

        assertThat(shuffle).containsExactlyInAnyOrderElementsOf(list); 
    }

    /**
     * Funzione pura: che non modifica uno stato condiviso (side-effect-free)
     * se parallelizzato con parallel() darà sempre lo stesso risultato
     * (l'ordine dei task paralleli non conta)
     */
    @Test
    public void primoPiuCaroDelPrecedente_funzionePura() {
        List<Libro> list = Stream.generate(Libreria::gen)
            .limit(3)
            .peek(System.out::println)
            .collect(Collectors.toList());

        System.out.println();

        // il range parte da 1 invece che da zero
        Optional<Libro> libro = IntStream.range(1, list.size())
            .parallel()
            .filter(i -> list.get(i - 1).getPrezzo() < list.get(i).getPrezzo())
            .mapToObj(i -> list.get(i))
            .peek(System.out::println)
            .findFirst();
        
        assertThat(libro).isPresent();
        assertThat(libro.get().getTitolo()).isEqualTo("Trono di Spade");
    }

    /**
     * Funzione non pura: che modifica uno stato condiviso (side-effect)
     * se parallelizzato con parallel() NON darà sempre lo stesso risultato
     * (l'ordine dei task paralleli conta)
     */
    @Test
    public void primoPiuCaroDelPrecedente_funzioneNonPura() {
        List<Libro> list = Stream.generate(Libreria::gen)
            //.parallel()
            .limit(3)
            .peek(System.out::println)
            .collect(Collectors.toList());

        System.out.println();

        Optional<Libro> libro = list.stream()
            .filter(x -> isBiggerThanPrev(x))
            .peek(System.out::println)
            .findFirst();

        assertThat(libro).isPresent();
        assertThat(libro.get().getTitolo()).isEqualTo("Trono di Spade");   
    }

    private Libro prev = null; // stato condiviso
    private boolean isBiggerThanPrev(Libro x) {
        if (prev == null) {
            prev = x;
            return false;
        }

        boolean ret = prev.getPrezzo() < x.getPrezzo();
        prev = x;

        return ret;
    }

    @Test
    public void applicaScontiPerCategoria() {
        List<Libro> list = Stream.generate(Libreria::gen)
            .limit(10)
            .peek(System.out::println)
            .collect(Collectors.toList());

        // modifica i prezzi degli elementi nella lista
        list.forEach(x -> x.setPrezzo(
            getSconto(x.getCategoria()).apply(x.getPrezzo())));

        // stampo gli elementi della lista aggiornati
        System.out.println();
        list.forEach(System.out::println);

        // Un esempio di asserzione per il costo del libro design pattern
        Libro dp = list.stream()
            .filter(x -> x.getTitolo().equals("Design Pattern"))
            .findAny()
            .get();

        assertThat(dp.getPrezzo()).isEqualTo(35 * 2 + 10);
    }

    /** Restituisce una funzione di sconto in base alla categoria:
     * - FANTASY -5€
     * - CYBERPUNK -10%
     * - THRILLER -50%
     * - STORICO -0€
     * - INFORMATICA x2+10€ (niente sconti per noi programmatori...)
     * 
     * invece di uno switch, proviamo ad usare una mappa
     */
    public Function<Integer, Integer> getSconto(Categoria cat) {
        Map<Categoria, Function<Integer, Integer>> sconti = Map.of(
            Categoria.FANTASY, x -> Math.abs(x - 5),
            Categoria.CYBERPUNK, x -> (int) Math.floor(x * 0.1), 
            Categoria.THRILLER, x -> (int) Math.floor(x * 0.5),
            Categoria.STORICO, x -> x, 
            Categoria.INFORMATICA, x -> x * 2 + 10);

        return sconti.get(cat);
    }

}
