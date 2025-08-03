import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegEx {
    public static void main(String[] args) {

        // [abc] — any one character a, b, or c
        matchRegex("[abc]", "apple banana cat");  // matches a, a, a, c, a

        // [^abc] — any character except a, b, or c
        matchRegex("[^abc]", "abcxyz");  // matches x, y, z

        // [0-9] — any digit
        matchRegex("[0-9]", "house number 123");  // matches 1, 2, 3

        // | — OR
        matchRegex("cat|dog|fish", "I have a cat and a dog.");  // matches cat, dog

        // . — any character
        matchRegex("c.t", "cat cot cut cet ctt");  // matches all 3-letter words starting with c and ending with t

        // ^ — start of string
        matchRegex("^Hello", "Hello world");  // matches Hello only if it's at start

        // $ — end of string
        matchRegex("world$", "Hello world");  // matches world only if it's at end

        // \d — any digit
        matchRegex("\\d", "abc123");  // matches 1, 2, 3

        // \s — any whitespace
        matchRegex("\\s", "Hello World!");  // matches the space

        // \b — word boundary
        matchRegex("\\bcat", "cathedral cat catfish");  // matches 'cat' at beginning of a word

        // Unicode character (example: \u0041 = 'A')
        matchRegex("\\u0041", "ABCD");  // matches A

        // n+ — one or more
        matchRegex("a+", "baaaabaaa");  // matches aaaa and aaa

        // n* — zero or more
        matchRegex("b*", "baaa");  // matches b, then empty, empty, empty

        // n? — zero or one
        matchRegex("a?", "aaa");  // matches a, a, a, and one empty at end

        // n{x} — exactly x n's
        matchRegex("a{3}", "aa aaa aaaa");  // matches aaa, aaa (from aaaa)

        // n{x,y} — x to y n's
        matchRegex("a{2,3}", "a aa aaa aaaa");  // matches aa, aaa, aaa (from aaaa)

        // n{x,} — at least x n's
        matchRegex("a{2,}", "a aa aaa aaaa");  // matches aa, aaa, aaaa

        // CASE_INSENSITIVE - matches regardless of letter case
        Pattern caseInsensitivePattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher caseInsensitiveMatcher = caseInsensitivePattern.matcher("Java is fun. I like JAVA and javA.");
        System.out.println("Case-insensitive 'java':");
        while (caseInsensitiveMatcher.find()) System.out.println(caseInsensitiveMatcher.group());

        // LITERAL - treats pattern as plain text (no regex)
        Pattern literalPattern = Pattern.compile("1+1=2", Pattern.LITERAL);
        Matcher literalMatcher = literalPattern.matcher("Simple math: 1+1=2 is true.");
        System.out.println("\nLITERAL match for '1+1=2':");
        while (literalMatcher.find()) System.out.println(literalMatcher.group());

        // Without LITERAL - '+' is treated as regex (one or more of previous char)
        Pattern regexPattern = Pattern.compile("1+1=2");
        Matcher regexMatcher = regexPattern.matcher("Simple math: 1+1=2 is true.");
        System.out.println("\nRegex match for '1+1=2':");
        while (regexMatcher.find()) System.out.println(regexMatcher.group());

        String text = "I saw STRASSE A1and Straße A1any STRASSe A0atd";

        // UNICODE_CASE not used - ß and SS are not considered equal
        Pattern caseInsensitiveOnly = Pattern.compile("straße", Pattern.CASE_INSENSITIVE);
        Matcher caseInsensitiveOnlyMatcher = caseInsensitiveOnly.matcher(text);
        System.out.println("\nWithout UNICODE_CASE:");
        while (caseInsensitiveOnlyMatcher.find()) {
            System.out.println(caseInsensitiveOnlyMatcher.group());
        }

        // UNICODE_CASE used - matches ß and SS correctly in Unicode
        Pattern unicodeCasePattern = Pattern.compile("straße", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher unicodeCaseMatcher = unicodeCasePattern.matcher(text);
        System.out.println("\nWith UNICODE_CASE:");
        while (unicodeCaseMatcher.find()) {
            System.out.println(unicodeCaseMatcher.group());
        }

        // (?i) - case insensitive, (?-i) - case sensitive (inline (or) embedded flag)
        Pattern pattern = Pattern.compile("(?i)stra(ß|ss)(?-i)e\\s\\u0041\\d[and]+");
        Matcher matcher = pattern.matcher(text);
        System.out.println("\nInline flag (?i):");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }

    static void matchRegex(String pattern, String input) {
        System.out.println("Pattern: " + pattern + " | Input: \"" + input + "\"");
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        while (m.find()) {
            System.out.println("Match: \"" + m.group() + "\" at index " + m.start());
        }
        System.out.println();
    }
}
