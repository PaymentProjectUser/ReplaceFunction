import org.example.ReplaceFunctionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReplaceFunctionServiceTest {

    @Test
    void shouldReturn_ReplacedString_When_FoundMatchesInSource() {
        char[] actual = ReplaceFunctionService.customReplace(
                ReplaceTestData.SOURCE_DEFAULT,
                ReplaceTestData.FIND_ABC,
                ReplaceTestData.REPLACE_XY
        );

        assertArrayEquals(ReplaceTestData.EXPECTED_REPLACED_XY, actual);
    }

    @Test
    void shouldReturn_SourceUnchanged_When_FindNotFound() {
        char[] actual = ReplaceFunctionService.customReplace(
                ReplaceTestData.SOURCE_NO_MATCH,
                ReplaceTestData.FIND_XYZ,
                ReplaceTestData.REPLACE_12
        );

        assertArrayEquals(ReplaceTestData.SOURCE_NO_MATCH, actual);
    }

    @Test
    void shouldReturn_SourceUnchanged_When_FindIsEmpty() {
        char[] actual = ReplaceFunctionService.customReplace(
                ReplaceTestData.SOURCE_NO_MATCH,
                ReplaceTestData.FIND_EMPTY,
                ReplaceTestData.REPLACE_XY
        );

        assertArrayEquals(ReplaceTestData.SOURCE_NO_MATCH, actual);
    }

    @Test
    void shouldReturn_ReplacedWithLongerString_When_ReplaceIsLongerThanFind() {
        char[] actual = ReplaceFunctionService.customReplace(
                ReplaceTestData.SOURCE_REPEAT_AB,
                ReplaceTestData.FIND_ABC,
                ReplaceTestData.REPLACE_1234
        );

        assertArrayEquals(ReplaceTestData.EXPECTED_REPLACED_1234, actual);
    }

    @Test
    void shouldReturn_SourceWithTrailingSymbols_When_PartialMatchAtEnd() {
        char[] actual = ReplaceFunctionService.customReplace(
                ReplaceTestData.SOURCE_PARTIAL_MATCH,
                ReplaceTestData.FIND_ABC,
                ReplaceTestData.REPLACE_XY
        );

        assertArrayEquals(ReplaceTestData.SOURCE_PARTIAL_MATCH, actual);
    }
}