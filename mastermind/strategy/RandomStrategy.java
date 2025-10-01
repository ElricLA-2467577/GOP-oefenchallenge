//@author vincent-13

package mastermind.strategy;

import mastermind.board.Board;
import mastermind.board.Color;
import mastermind.board.Row;
import java.util.Random;

public class RandomStrategy implements Strategy {

    /**
    * Generate a random guess
    *
    * @param board the current game board, can't be null
    * @return row object with randomly selected colors
    * @pre board != null
    * @post result != null && result.length() == board.getRowSize()
    */
    @Override
    public Row getGuess(Board board) {
        return generateRandomRow(board);
    }

    /**
    * Generate a random start combination
    *
    * @param board the current game board, can't be null
    * @return row object with randomly selected colors
    * @pre board != null
    * @post result != null && result.length() == board.getRowSize()
    */
    @Override
    public Row getStartCombination(Board board) {
        return generateRandomRow(board);
    }

    /**
    * Generates random row based on board width and color amount
    *
    * @param board the current game board, can't be null
    * @return row object with randomly selected colors
    * @pre board != null
    * @post result != null && result.length() == board.getRowSize()
    */
    private Row generateRandomRow(Board board) {
        Random random = new Random();
        Row row = new Row(board.getRowSize());

        for (int i = 0; i < board.getRowSize(); i++) {
            int colorID = random.nextInt(board.getColorLimit());
            row.setColor(i, Color.fromId(colorID));
        }

        return row;
    }
}
