package mastermind.player;

import mastermind.GameView;
import mastermind.board.Board;
import mastermind.board.Color;
import mastermind.board.Row;

public class HumanPlayer extends Player {
    private GameView m_view;

    public HumanPlayer(Role role, GameView view) {
        super(role);
    }

    @Override
    public Row getGuess(Board board) {
        int rowSize = board.getRowSize();
        Row code = new Row(rowSize);

        for (int i = 0; i < rowSize; i++) {
            Color color = m_view.getColorInput();
            while (color.equals(Color.INVALID))
                color = m_view.getColorInput();

            code.setColor(i, color);
        }

        System.out.println("");
        return null;
    }

    @Override
    public Row getStartCombination() {
        return null;
    }
}
