package org.ids.libri;

import static org.assertj.core.api.Assertions.*; // AssertJ

/**
 * java.util.function definisce interfacce funzionali comuni:
 * - Function<T, R> [usata da map()] definisce il metodo apply(): T -> R
 * - Predicate<T> [usata da filter()] definisce il metodo test(): T -> boolean
 * - Supplier<T> [usata da generate()] definisce il metodo get(): void -> T
 * - Consumer<T> [usata da peek() e forEach()] definisce il metodo accept(): T -> void 
 * - BinaryOperator<T> [usata da reduce()] definisce il metodo apply(): (T,T) -> T
 */ 
import java.util.function.Function;

import org.junit.Test;

public class TestBasiStream {
	@Test
    public void testFunctionalInterface_Function() {
        Function<Integer, Integer> mulby2 = getMul(2);
        Function<Integer, Integer> mulby3 = getMul(3);

        assertThat(mulby2.apply(10)).isEqualTo(20);
        assertThat(mulby3.apply(10)).isEqualTo(30);
    }

    /**
     * Il metodo (unico) di un'interfaccia funzionale può
     * essere implementato tramite un'espressione lambda.
     * Posso poi restiuire l'oggetto appena creato.
     */
    private Function<Integer, Integer> getMul(int p) {
        return (x -> x * p);
    }

    @Test
    public void testFunctionalInterface_MyFunction() {
        MyMul mulby2 = getMyMul(2);
        MyMul mulby3 = getMyMul(3);

        assertThat(mulby2.mul(10)).isEqualTo(20);
        assertThat(mulby3.mul(10)).isEqualTo(30);
    }

    /**
     * Posso definire anche delle mie interfacce funzionali.
     * Un'interfaccia funzionale può avere un solo metodo.
     * L'unico metodo potrà essere implementato usando un'espressione lambda.
     */
    @FunctionalInterface
    public interface MyMul {
        public int mul(int p);
    }

    private MyMul getMyMul(int p) {
        return (x -> x * p);
    }
}