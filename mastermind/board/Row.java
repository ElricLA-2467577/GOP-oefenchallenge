// @author Mathijs - group 13

package mastermind.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Row {
    private final Peg[] m_row;

    public Row(int rowSize) {
        m_row = new Peg[rowSize];
    }

    public void setColor(int index, Color color) {
        m_row[index] = new Peg(color);
    }

    public int getLength() {
        return m_row.length;
    }

    public Peg getPeg(int index){
        return m_row[index];
    }

    public Collection<Color> getColorRow() {
        ArrayList<Color> row = new ArrayList<>();
        for (int i = 0; i < m_row.length; i++) {
            row.add(m_row[i].getColor());
        }

        return row;
    }

    public boolean contains(Peg p) {
        for (Peg peg : m_row) if (peg.equals(p)) return true;
        return false;
    }

    public Row copy() {
        Row c = new Row(m_row.length);
        for (int i = 0; i < m_row.length; i++) {
            c.setColor(i, m_row[i].getColor());
        }
        return c;
    }
}
