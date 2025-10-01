package mastermind.player;

import mastermind.board.Board;
import mastermind.board.Row;

public abstract class Player {
    private Role m_role;

    public Player(Role role) {
        m_role = role;
    }

    public Role getRole() {
        return m_role;
    }

    public abstract Row getGuess(Board board);
    public abstract Row getStartCombination(Board board);
}
