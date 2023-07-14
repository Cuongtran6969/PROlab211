
package constant;

/**
 *
 * @author dangx
 */
public interface Regex {
    char[] HEXDIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    String REGEX_BINARY = "[01]*";
    String REGEX_DECIMAL = "[0-9]*";
    String REGEX_HEXADECIMAL = "[0-9A-F]*";
}
