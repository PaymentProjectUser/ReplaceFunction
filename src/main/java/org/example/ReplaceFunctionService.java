package org.example;

public class ReplaceFunctionService {
    public static char[] customReplace(char[] source, char[] find, char[] replace) {
        if (find.length == 0) {
            return source;
        }

        int resultLength = source.length;

        if (replace.length > find.length) {
            resultLength = source.length * find.length;
        }

        char[] result = new char[resultLength];
        char[] tempFindArray = new char[find.length];

        int indexFindSymbol = 0;
        int amountOfFindSymbolInFindArray = 0;
        int currentResultIndex = 0;

        for (char currentSymbol : source) {
            if (currentSymbol == find[indexFindSymbol]) {
                tempFindArray[indexFindSymbol] = currentSymbol;
                amountOfFindSymbolInFindArray++;
                indexFindSymbol++;

                if (amountOfFindSymbolInFindArray == find.length) {
                    
                    currentResultIndex = writeReplace(result, currentResultIndex, replace);
                    indexFindSymbol = 0;
                    amountOfFindSymbolInFindArray = 0;
                    tempFindArray = new char[find.length];
                }

            } else {

                if (amountOfFindSymbolInFindArray > 0) {
                    
                    currentResultIndex = writeTempFindToResult(result, currentResultIndex, tempFindArray, amountOfFindSymbolInFindArray);
                    tempFindArray = new char[find.length];
                    indexFindSymbol = 0;
                    amountOfFindSymbolInFindArray = 0;
                }

                result[currentResultIndex] = currentSymbol;
                currentResultIndex++;
            }
        }

        if (amountOfFindSymbolInFindArray > 0) {
            currentResultIndex = writeTempFindToResult(result, currentResultIndex, tempFindArray, amountOfFindSymbolInFindArray);
        }

        return cutTheResultArray(result, currentResultIndex);
    }

    private static int writeReplace(char[] result, int currentResultIndex, char[] replace) {
        for (char currentReplaceSymbol : replace) {
            result[currentResultIndex] = currentReplaceSymbol;
            currentResultIndex++;
        }
        return currentResultIndex;
    }

    private static int writeTempFindToResult(char[] result, int currentResultIndex, char[] tempFindArray, int count) {
        int currentIteratorAmount = 1;

        for (char currentTempFindArraySymbol : tempFindArray) {
            result[currentResultIndex] = currentTempFindArraySymbol;
            currentResultIndex++;

            if (currentIteratorAmount == count) {
                break;
            }
            currentIteratorAmount++;
        }

        return currentResultIndex;
    }

    private static char[] cutTheResultArray(char[] inputResult, int length) {
        char[] result = new char[length];
        int index = 0;
        
        for (char currentResultSymbol : inputResult) {
            result[index] = currentResultSymbol;
            index++;
            if (index == length) {
                break;
            }
        }

        return result;
    }
}
