package mastermind.player;

import mastermind.board.Board;
import mastermind.board.Row;
import mastermind.strategy.Strategy;

public class ComputerPlayer extends Player {
    private Strategy m_strategy;

    public ComputerPlayer(Role role, Strategy strategy) {
        super(role);
    }

    @Override
    public Row getGuess(Board board) {
        return m_strategy.getGuess(board);
    }

    @Override
    public Row getStartCombination() {
        return m_strategy.getStartCombination();
    }
}
