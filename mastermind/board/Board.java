package mastermind.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private final List<Row> m_guessHistory;
    private final int m_rowSize;
    private final int m_colorLimit;
    private Row m_solution;

    public Board(int rowSize, int colorLimit) {
        if (rowSize <= 0 || colorLimit <= 0) throw new IllegalArgumentException("rowSize/colorLimit must be > 0");
        m_rowSize = rowSize;
        m_colorLimit = colorLimit;
        m_guessHistory = new ArrayList<>();
        m_solution = null;
    }

    public void setSolution(Row solution) {
        if (solution == null || solution.getLength() != m_rowSize)
            throw new IllegalArgumentException("solution length must match rowSize");
        m_solution = solution;
    }

    public List<Row> getGuessHistory() {
        return Collections.unmodifiableList(m_guessHistory);
    }

    public int getRowSize() { return m_rowSize; }
    public int getColorLimit() { return m_colorLimit; }
    public Row getSolution() { return m_solution; }

    public Row getComparisonToSolution(Row guess, Row solution) {
        if (guess == null || solution == null) throw new IllegalArgumentException("guess/solution must be non-null");
        int len = m_rowSize; Row result = new Row(len); boolean[] used = new boolean[len], exact = new boolean[len];
        for (int i = 0; i < len; i++) {
            result.setColor(i, Color.INVALID);
            if (guess.getPeg(i).getColor() == solution.getPeg(i).getColor()) {
                result.setColor(i, Color.RED); exact[i] = used[i] = true;
            }
        }
        for (int i = 0; i < len; i++)
            if (!exact[i])
                for (int j = 0; j < len; j++)
                    if (!used[j] && guess.getPeg(i).getColor() == solution.getPeg(j).getColor()) {
                    result.setColor(i, Color.WHITE); used[j] = true; break; }
        return result;
    }

    public boolean isRightCombination(Row comparisonToSolutionRow) {
        for (int i = 0; i < m_rowSize; i++) if (comparisonToSolutionRow.getPeg(i).getColor() != Color.RED) return false;
        return true;
    }

    public void addGuess(Row guess) {
        if (guess == null || guess.getLength() != m_rowSize) throw new IllegalArgumentException("invalid guess");
        m_guessHistory.add(guess);
    }
}
