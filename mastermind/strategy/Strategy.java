package mastermind.strategy;

import mastermind.board.Board;
import mastermind.board.Row;

public interface Strategy {
    public Row getGuess(Board board);
    public Row getStartCombination();
}
