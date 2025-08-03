import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Strings {
    public static void main(String[] args) {

        // === String Comparison and Interning ===
        String str = "gen digital";
        String strCopy = "gen digital";
        String strCopy1 = str;
        System.out.println("Original String: " + str);
        System.out.println("Copied String: " + strCopy);
        System.out.println("Using '==': " + (str == strCopy)); // "==" - both object should indicate same memory location. otherwise false.
        System.out.println("Using '==': " + (str == strCopy1));
        System.out.println("Using equals(): " + str.equals(strCopy));
        System.out.println();

        // === Multiline String ===
        String text = """
            This is line 1
            This is line 2
            This is line 3
            """;
        System.out.println("Multiline String:\n" + text);

        // === String Creation ===
        String string1 = new String("hello");
        String string2 = new String("hello");
        String string3 = new String(new char[] {'h', 'e','l', 'l', 'o'});
        char[] charArray1 = {'h', 'e','l', 'l', 'o'};
        String string4 = new String(charArray1, 1, 3); // "ell"
        byte[] byteArray = {65, 66, 67, 68, 69}; // A-E
        String string5 = new String(byteArray); // Using default charset
        String string6 = new String(byteArray, StandardCharsets.UTF_8);
        String string7 = string1;
        CharSequence cs1 = new String("avira");
        char[] chArr1 = {'m', 'a', 'l', 'a', 'r'};
        Character[] chArr2 = {'v', 'i', 'z', 'h', 'i'};
        System.out.println(chArr1); // char[] is string when printing alone.
        System.out.println(chArr2); // // Character[] is not string when printing alone.
        System.out.println("CharArray: " + chArr1 + chArr2); // both are not string when concatenating.
        System.out.println("CharArray: " + Arrays.toString(chArr1)+Arrays.toString(chArr2));
        System.out.println("CharSequence: " + cs1);

        System.out.println("String1 (new String): " + string1);
        System.out.println("String2 (new String): " + string2);
        System.out.println("String3 (char[]): " + string3);
        System.out.println("String4 (partial char[]): " + string4);
        System.out.println("String5 (byte[]): " + string5);
        System.out.println("String6 (byte[], UTF-8): " + string6);
        System.out.println("String1 == String2: " + (string1 == string2));
        System.out.println("String1 == String7: " + (string1 == string7));
        System.out.println("String1.equals(String2): " + string1.equals(string2));
        System.out.println();

        // === Code Point Operations ===
        System.out.println("Code point at index 3: " + str.codePointAt(3));
        System.out.println("Code point before index 3: " + str.codePointBefore(3));
        System.out.println("Code point count (0 to 4): " + str.codePointCount(0, 4));
        System.out.println();

        // === String Comparison & Matching ===
        System.out.println("Compare ignoring case: " + string1.compareToIgnoreCase(string2));
        System.out.println("String1 contains String4? " + string1.contains(string4));
        System.out.println("Content equals: " + string1.contentEquals(string4));
        System.out.println("Copy value of charArray1: " + String.copyValueOf(charArray1, 0, 5));
        System.out.println("Ends with 'lo': " + string1.endsWith("lo"));
        string6.getChars(0, 3, charArray1, 2);
        System.out.println("charArray after getChars(): " + Arrays.toString(charArray1));
        System.out.println("Hashcode of string1: " + string1.hashCode());
        String myStrB = "Hello";
        byte[] result = myStrB.getBytes(StandardCharsets.UTF_16);
        System.out.println("Byte array: " + Arrays.toString(result));
        System.out.println("String (UTF-16): " + new String(result, StandardCharsets.UTF_16));

        // === String Utility Methods ===
        System.out.println("Length: " + str.length());
        System.out.println("To Upper Case: " + str.toUpperCase());
        System.out.println("To Lower Case: " + str.toLowerCase());
        System.out.println("Index of 'digital': " + str.indexOf("digital"));
        System.out.println("Last Index of 'digital': " + str.lastIndexOf("digital"));
        System.out.println();

        // === Concatenation and Equality ===
        String str1 = "Norton ";
        String str2 = "LifeLock";
        System.out.println("String1: " + str1);
        System.out.println("String2: " + str2);
        System.out.println("Is String1 empty? " + str1.isEmpty());
        System.out.println("Is String2 empty? " + str2.isEmpty());
        System.out.println("Concatenation using '+': " + str1 + str2);
        System.out.println("Concatenation using concat(): " + str1.concat(str2));
        System.out.println("Equals? " + str1.equals(str2));
        System.out.println("Equals (Ignore Case)? " + str1.equalsIgnoreCase(str2));
        System.out.println("Character at index 3 of str1: " + str1.charAt(3));
        System.out.println("Substring of str1 (1 to 5): " + str1.substring(1, 5));
        System.out.println("Substring of str1 (1 to end): " + str1.substring(1));
        String fruits = String.join(" ", "Orange", "Apple", "Mango");
        System.out.println("Joined Fruits: " + fruits);
        System.out.println();

        // === CompareTo ===
        int comparison = str1.compareTo(str2);
        if (comparison < 0) {
            System.out.println("str1 is less than str2");
        } else if (comparison > 0) {
            System.out.println("str1 is greater than str2");
        } else {
            System.out.println("str1 and str2 are equal");
        }
        System.out.println("Trimmed str1: " + str1.trim());
        System.out.println();

        // === Regex, Replace, Region Matching ===
        String regEx1 = "cat|dog|fish";
        System.out.println("'cat' matches regex? " + "cat".matches(regEx1));
        System.out.println("Region matches (0–3): " + string1.regionMatches(0, string2, 0, 3));
        System.out.println("Region matches (ignore case): " + string1.regionMatches(true, 0, string2, 0, 3));
        System.out.println("Replace 'l' with 'p': " + string1.replace('l', 'p'));
        System.out.println();

        // === Replace All / First ===
        String myStr = "I  love cats. Cats are very easy to love. Cats   are very popular.";
        String regEx2 = "(?i)Cats";
        System.out.println("Original Sentence: " + myStr);
        System.out.println("Replace all 'Cats' with 'dogs': " + myStr.replaceAll(regEx2, "dogs"));
        System.out.println("Replace first 'Cats' with 'dog': " + myStr.replaceFirst(regEx2, "dogs"));
        System.out.println();

        // === Start, Split, Subsequence, Char Array ===
        System.out.println("Starts with 'he'? " + str.startsWith("he"));
        String regEx3 = "\\s+";
        String[] splitArray = myStr.split(regEx3);
        System.out.println("Split on space: " + Arrays.toString(splitArray));
        System.out.println("Subsequence (3 to 8): " + myStr.subSequence(3, 8));
        char[] charArray2 = myStr.toCharArray();
        System.out.println("To Char Array: " + Arrays.toString(charArray2));
        System.out.println("To String: " + myStr.toString());
        System.out.println();

        // === String.valueOf() Examples ===
        System.out.println("=== String.valueOf() examples ===");
        char[] myArray = {'a', 'b', 'c'};
        System.out.println("valueOf(char[]): " + String.valueOf(myArray));
        System.out.println("valueOf(char[],1,2): " + String.valueOf(myArray, 1, 2));
        System.out.println("valueOf(char): " + String.valueOf('A'));
        System.out.println("valueOf(boolean): " + String.valueOf(true));
        System.out.println("valueOf(float): " + String.valueOf(4.5f));
        System.out.println("valueOf(double): " + String.valueOf(5.2));
        System.out.println("valueOf(int): " + String.valueOf(12));
        System.out.println("valueOf(long): " + String.valueOf(1400L));
        System.out.println();

        // === Custom Object ===
        Example ex = new Example();
        System.out.println("valueOf(Example object): " + String.valueOf(ex));
        Object arr = new Integer[] {1,2,3};
        System.out.println("valueOf(object): " + String.valueOf(arr));
        Float[] arr1 = new Float[] {1.2f,3.4f};
        System.out.println("valueOf(Float[]): " + String.valueOf(arr));
    }
}

class Example {
    String name = "example";
}
