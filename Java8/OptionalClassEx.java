import java.util.Optional;

public class OptionalClassEx {
    public static void main(String[] args) {
        Optional<String> optionalValue1 = Optional.of("Malar");
        Optional<String> optionalValue2 = Optional.empty();
        String value = null;
        Optional<String> optionalValue3 = Optional.ofNullable(value);
        String name = "Gen";
        Optional<String> optionalValue4 = Optional.ofNullable(name);
        if(optionalValue3.isPresent()) {
            System.out.println("Value is present: " + optionalValue3.get());
        } else {
            System.out.println("Value is absent");
        }

        optionalValue1.ifPresent(value1 -> System.out.println("Value is present: " + value1));
        optionalValue2.ifPresentOrElse(
            value2 -> System.out.println("Value is present: " + value2),
            () -> System.out.println("Value is absent")
        );

        System.out.println("Name or Default: " + optionalValue2.orElse("Default value")); // returns string
        System.out.println("Name or Get: " + optionalValue2.orElseGet(() -> "Default value"));
        Optional<String> upperCased = optionalValue1.map(String::toUpperCase);
        System.out.println("Uppercased: " + upperCased.orElse("No value present"));

        Optional<String> upperCased1 = optionalValue2.map(String::toUpperCase);
        System.out.println("Uppercased: " + upperCased1.orElse("No value present"));

        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("Nested"));
        Optional<String> flattened = nestedOptional.flatMap(inner -> inner.map(str -> str + " value"));
        System.out.println("Flattened: " + flattened.orElse("No value present"));

        Optional<Optional<String>> nestedOptional1 = Optional.of(Optional.ofNullable(null));
        Optional<String> flattened1 = nestedOptional1.flatMap(inner -> inner.map(str -> str + " value"));
        System.out.println("Flattened: " + flattened1.orElse("No value present"));
    }

}