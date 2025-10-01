package mastermind.player;

import mastermind.board.Board;
import mastermind.board.Row;
import mastermind.strategy.Strategy;
import mastermind.strategy.RandomStrategy;

public class ComputerPlayer extends Player {
    private final Strategy m_strategy;

    /**
    * constructs a ComputerPlayer with a role and a strategy
    *
    * @param role role of the player (BREAKER or code maker)
    */
    public ComputerPlayer(Role role, Strategy strategy) {
        super(role);
        m_strategy = strategy;
    }

    @Override
    public Row getGuess(Board board) {
        return m_strategy.getGuess(board);
    }

    @Override
    public Row getStartCombination(Board board) {
        return m_strategy.getStartCombination(board);
    }
}
