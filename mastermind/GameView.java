// @author Mathijs, Elric - group 13
package mastermind;

import mastermind.board.Board;
import mastermind.board.Color;
import mastermind.board.Row;
import mastermind.player.Role;

import java.text.ParseException;

public class GameView {

    public void printInfo(String info) {
        System.out.println(info);
    }

    public void printColor(Color color) {
        if (color == null)
            System.out.print("X");
        else
            System.out.print(color);
    }

    public void printColorLn(Color color) {
        System.out.println(color.toString());
    }


    public void printAllAvailableColors(int limit) {
        for (int i = 0; i < limit; i++) {
            printColorLn(Color.fromId(i));
        }
    }

    public void printRow(Row row) {
        for (int i = 0; i < row.getLength(); i++ ) {
            printColor(row.getPeg(i).getColor());
            if (i != row.getLength() - 1)
                System.out.print(", ");
        }
        System.out.print("\n");
    }

    public Color getColorInput(int col, Board board) {
        System.out.print("Enter a color for column [" + col + "]: ");
        String input = System.console().readLine();
        try {
            Color result = Color.fromString(input);
            if (result.getId() >= board.getColorLimit())
                throw new IllegalStateException("Color invalid.");
            return result;
        } catch (Exception e) {
            return Color.INVALID;
        }
    }

    public Role getHumanRoleInput() {
        System.out.print("Do you want to be the breaker or maker? [maker/breaker]: ");
        String input = System.console().readLine().toLowerCase();
        while (!input.equals("maker") && !input.equals("breaker"))
            input = System.console().readLine().toLowerCase();

        if (input.equals("maker")) {
            return Role.MAKER;
        } else {
            return Role.BREAKER;
        }
    }

    public int getIntInput(String question) {
        System.out.print(question + " [0<]:");
        try {
            return Integer.parseInt(System.console().readLine());
        } catch (Exception e) {
            return -1;
        }
    }


    public int getMaxGuessesInput() {
        String question = "How many guesses will the breaker get?";
        int input = getIntInput(question);
        while (input <= 0) {
            input = getIntInput(question);
        }
        return input;
    }

    public int getRowSizeInput(){
        String question = "How big will the code be?";
        int input = getIntInput(question);
        while (input <= 0) {
            input = getIntInput(question);
        }
        return input;
    }

    public int getColorLimitInput(){
        String question = "With how many colors will you play? ["+Color.maxColors()+">]";
        int input = getIntInput(question);
        while (input <= 0 || input >= Color.maxColors()) {
            input = getIntInput(question);
        }
        return input;
    }
}
