package mastermind;

import mastermind.board.Color;

public class GameView {
    public Color getColorInput() {
        System.out.print("Enter a color: ");
        String input = System.console().readLine();
        try {
            return Color.fromString(input);
        } catch (IllegalArgumentException e) {
            return Color.INVALID;
        }
    }
}
