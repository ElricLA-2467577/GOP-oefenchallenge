package mastermind.board;

public enum Color {
    RED(1),
    ORANGE(2),
    BLUE(3),
    GREEN(4),
    PURPLE(5),
    WHITE(6),
    INVALID(-1);

    private final int m_value;

    Color(final int value) {
        m_value = value;
    }

    public static int maxColors() {
        return 6;
    }

    public int getId() { return m_value; }


    public static Color fromString(String str) throws IllegalArgumentException {
        switch (str.toLowerCase()) {
            case "red" : {
                return RED;
            }
            case "orange": {
                return ORANGE;
            }
            case "blue" : {
                return BLUE;
            }
            case "green" : {
                return GREEN;
            }
            case "purple": {
                return PURPLE;
            }
            case "white": {
                return WHITE;
            }
        }

        throw new IllegalArgumentException(str + " is not a supported color!");
    }
}