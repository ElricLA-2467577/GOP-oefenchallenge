package mastermind;

import mastermind.board.Board;
import mastermind.board.Row;
import mastermind.player.*;
import mastermind.strategy.RandomStrategy;
import mastermind.strategy.Strategy;

public class MasterMindGame {
    private final GameView m_view;
    private Player m_breaker;
    private Player m_maker;
    private Board m_board;
    private boolean m_isBreakerHuman;
    private int m_guessesLeft;

    public MasterMindGame() { m_view = new GameView(); }

    private void init() {
        initPlayers();
        initBoard();
    }

    private void initBoard() {
        m_guessesLeft = m_view.getMaxGuessesInput();
        m_board = new Board(m_view.getRowSizeInput(), m_view.getColorLimitInput());
        m_board.setSolution(m_maker.getStartCombination(m_board));
    }

    private void initPlayers() {
        Strategy strategy = new RandomStrategy();
        Role humanRole = m_view.getHumanRoleInput();
        if (humanRole == Role.BREAKER) {
            m_isBreakerHuman = true;
            m_breaker = new HumanPlayer(Role.BREAKER, m_view);
            m_maker = new ComputerPlayer(Role.MAKER, strategy);
        } else {
            m_isBreakerHuman = false;
            m_breaker = new ComputerPlayer(Role.BREAKER, strategy);
            m_maker = new HumanPlayer(Role.MAKER, m_view);
        }
    }

    public void start() {
        init();
        if (m_isBreakerHuman) m_view.printInfo("Computer has set the code.");
        while (m_guessesLeft > 0) {
            iterateGameLoop();
        }
        m_view.printInfo("Out of guesses — Maker wins. Solution was:");
        m_view.printRow(m_board.getSolution());
    }

    private void iterateGameLoop() {
        m_view.printInfo("Guesses left: " + m_guessesLeft);
        Row guess = m_breaker.getGuess(m_board);
        Row feedback = m_board.getComparisonToSolution(guess, m_board.getSolution());
        m_board.addGuess(guess);
        if (!m_isBreakerHuman) { m_view.printInfo("Computer guessed:"); m_view.printRow(guess); }
        m_view.printInfo("Feedback:"); m_view.printRow(feedback);
        if (m_board.isRightCombination(feedback)) { m_view.printInfo("Breaker wins!"); return; }
        m_guessesLeft--;
    }
}
