package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void whenPositionIsValid() {
        BishopBlack bishopBlack = new BishopBlack(A1);
        Cell expected = A1;
        Cell result = bishopBlack.position();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenCopyIsValid() {
        BishopBlack bishopBlack = new BishopBlack(H8);
        Cell result = bishopBlack.copy(G7).position();
        Cell expected = G7;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenWayIsValid() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell[] result = bishopBlack.way(G5);
        Cell[] expected = new Cell[]{D2, E3, F4, G5};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenWayIsNotValid() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(G4);
                });
        assertThat(exception.getMessage())
                .isEqualTo("Could not way by diagonal from %s to %s", C1, G4);
    }
}
