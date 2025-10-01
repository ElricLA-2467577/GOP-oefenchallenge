package mastermind.board;

import java.util.ArrayList;
import java.util.Arrays;

public class Row {
    private Peg[] m_row;

    public Row(int rowSize) {
        m_row = new Peg[rowSize];
    }

    public void setColor(int index, Color color) {
        m_row[index] = new Peg(color);
    }
}
