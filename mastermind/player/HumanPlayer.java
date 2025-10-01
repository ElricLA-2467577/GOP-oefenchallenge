package mastermind.player;

import mastermind.board.Board;
import mastermind.board.Row;

public class HumanPlayer extends Player {
    public HumanPlayer(Role role) {
        super(role);
    }

    @Override
    public Row getGuess(Board board) {
        return null;
    }

    @Override
    public Row getStartCombination() {
        return null;
    }
}
