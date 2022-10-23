package wordlepeaksai.tools;

/*
 *
 * ASCII TABLE VALUE RANGES:
 *  65-90 (A-Z)
 *  97-122 (a-z)
 *  48-57 (0-9)
 *
 */

public class Convertor {

    /**
     * Converts a letter to its position in the alphabet (index)
     * @param letter character lowercase letter
     * @return index position of letter in the alphabet
     */
    public static int l2n(char letter) {
        return (int)letter - 97;
    }

    /**
     * Converts an index position to its corresponding letter in the alphabet
     * @param index index position of the wanted letter
     * @return character alphabetical lowercase letter that sits in the given index position
     */
    public static int n2l(int index) {
        return (char)(index+97);
    }

    /**
     * Converts an index position to its corresponding letter in the alphabet
     * @param index index position of the wanted letter
     * @return character alphabetical lowercase letter that sits in the given index position
     */
    public static int n2l(short index) {
        return (char)(index+97);
    }

}
