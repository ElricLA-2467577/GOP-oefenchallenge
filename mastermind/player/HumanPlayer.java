// @author Mathijs Follon - Groep 13

package mastermind.player;

import mastermind.GameView;
import mastermind.board.Board;
import mastermind.board.Color;
import mastermind.board.Row;


public class HumanPlayer extends Player {
    private final GameView m_view;

    public HumanPlayer(Role role, GameView view) {
        super(role);
        m_view = view;
    }

    /**
     * Get a guess (Row) manually entered from the command line
     * @param board the board of the game
     * @return Row that holds the guess of this player
     * @pre player is a breaker
     * @pre board is not null
     * @pre m_view is not null
     * @post Row has not any INVALID peg colors
     */
    @Override
    public Row getGuess(Board board) {
        int rowSize = board.getRowSize();
        Row code = new Row(rowSize);

        for (int i = 0; i < rowSize; i++) {
            Color color = m_view.getColorInput(i);
            while (color.equals(Color.INVALID))
                color = m_view.getColorInput(i);

            code.setColor(i, color);
        }

        return code;
    }

    /**
     * Gets the start combination that the breaker must guess
     * @param board 
     * @return Row that holds the set combination of this player (as maker)
     * @pre player is a maker
     * @pre board is not null
     * @pre m_view is not null
     * @post Row has not any INVALID peg colors
     */
    @Override
    public Row getStartCombination(Board board) {
        Row code = new Row(board.getRowSize());

        m_view.printInfo("These are the possible colors:");
        m_view.printAllAvailableColors(board.getColorLimit());
        m_view.printInfo("Please set the code ("+board.getRowSize()+" colors):");

        for (int i = 0; i < board.getRowSize(); i++) {
            Color color = m_view.getColorInput(i);
            while (color.equals(Color.INVALID)) {
                m_view.printInfo("Invalid color, try again.");
                color = m_view.getColorInput(i);
            }

            code.setColor(i, color);
        }

        return code;
    }
}
