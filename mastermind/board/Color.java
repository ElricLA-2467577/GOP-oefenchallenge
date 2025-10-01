// @author Mathijs Follon - Groep 13
package mastermind.board;


public enum Color {
    RED(0),
    ORANGE(1),
    BLUE(2),
    GREEN(3),
    PURPLE(4),
    WHITE(5),
    INVALID(-1);

    private final int m_value;

    private static final String[] names =  {
            "red",
            "orange",
            "blue",
            "green",
            "purple",
            "white"
    };

    Color(final int value) {
        m_value = value;
    }

    public static int maxColors() {
        return 6;
    }

    @Override
    public String toString() {
        if (getId() == -1) {
            return "X";
        }
        return names[getId()];
    }


    public int getId() { return m_value; }

    /**
     * Translates an id to a Color object
     * @param id the input to be converted to a color
     * @return Color that is in a one-to-one relation to its value, may be INVALID when id is not related to a color
     * @pre id is not null
     */
    public static Color fromId(int id) {
        for (Color color : Color.values()) {
            if (color.getId() == id) {
                return color;
            }
        }
        return INVALID;
    }

    /**
     * Translates a string to a Color object
     * @param str the input to be converted to a color
     * @return Color that is in a one-to-one relation to a lowered string
     * @throws IllegalArgumentException when the given string is not translateable to a Color
     * @pre str is not null
     */
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