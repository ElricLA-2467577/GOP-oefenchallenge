// @author Mathijs - group 13
package mastermind.strategy;

import mastermind.board.Board;
import mastermind.board.Row;

public interface Strategy {
    public Row getGuess(Board board);
    public Row getStartCombination(Board board);
}
