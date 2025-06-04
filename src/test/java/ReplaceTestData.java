public class ReplaceTestData {
    public static final char[] SOURCE_DEFAULT = "abcdeabcde".toCharArray();
    public static final char[] FIND_ABC = "abc".toCharArray();
    public static final char[] REPLACE_XY = "xy".toCharArray();
    public static final char[] EXPECTED_REPLACED_XY = "xydexyde".toCharArray();

    public static final char[] SOURCE_NO_MATCH = "abcdef".toCharArray();
    public static final char[] FIND_XYZ = "xyz".toCharArray();
    public static final char[] REPLACE_12 = "12".toCharArray();

    public static final char[] FIND_EMPTY = new char[0];

    public static final char[] SOURCE_REPEAT_AB = "abcabc".toCharArray();
    public static final char[] REPLACE_1234 = "1234".toCharArray();
    public static final char[] EXPECTED_REPLACED_1234 = "1234c1234c".toCharArray();

    public static final char[] SOURCE_PARTIAL_MATCH = "abxab".toCharArray();
}
