import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) throws Exception {

        List<Integer> myNumbersList = List.of(12, 5, 5, 6, 8, 4, 11, 22);
        List<String> myStringsList = List.of("learn spring", "spring mvc", "learn java", "learn aws", "learn react",
                "MIDI", "OS2", "kubernetes", "SK8");

        System.out.println("Hello");
        printListInStructured(myNumbersList);
        System.out.println("****************************");
        printListFunctional(myNumbersList);
        System.out.println("structured: ***************************");
        printEvenNumbersStructured(myNumbersList);
        System.out.println("functional: ***************************");
        printEvenNumbersFunctional(myNumbersList);
        System.out.println("printNumbersLambda: ***************************");
        printNumbersLambda(myNumbersList);
        System.out.println("printOddNumbersLambda: ***************************");
        printOddNumbersLambda(myNumbersList);
        System.out.println("printSpringLambda: ***************************");
        printSpringLambda(myStringsList);
        System.out.println("printStringsLambda: ***************************");
        printStringsLambda(myStringsList);
        System.out.println("printFourOrMoreLetters: ***************************");
        printFourOrMoreLetters(myStringsList);
        System.out.println("printSquares: ***************************");
        printSquares(myNumbersList);
        System.out.println("printCubeOfOddNumbers: ***************************");
        printCubeOfOddNumbers(myNumbersList);
        System.out.println("printCharacterLengths: ***************************");
        printCharacterLengths(myStringsList);
        System.out.println("startsWith: ***************************");
        startsWith(myStringsList);
    }

    private static void printListInStructured(List<Integer> numbers) {
        for (int theNumber : numbers) {
            System.out.println(theNumber);
        }
    }

    private static void printListFunctional(List<Integer> numbers) {
        // convert to stream of elements, one after the other, a sequence
        numbers.stream()
                // .forEach(App::printMyStuff); // method reference
                .forEach(System.out::println);
        // .forEach();
    }

    private static void printMyStuff(int theNumber) {
        System.out.println("functional: " + theNumber);
    }

    private static boolean evenCheck(int theNumber) {
        return theNumber % 2 == 0;
    }

    private static void printEvenNumbersStructured(List<Integer> myNumbers) {
        for (int item : myNumbers) {
            if (item % 2 == 0) {
                System.out.println(item);
            }
        }
    }

    private static void printEvenNumbersFunctional(List<Integer> theNumbers) {
        theNumbers.stream()
                .filter(App::evenCheck)
                .forEach(System.out::println);
        // theNumber.stream().forEach(
        // .filter()
        // .forEach(System.out::println);
        // );
    }

    private static void printNumbersLambda(List<Integer> theNumbers) {
        theNumbers.stream()
                .filter(item -> item % 2 == 0)
                .forEach(System.out::println);
    }

    private static void printOddNumbersLambda(List<Integer> theNumbers) {
        theNumbers.stream()
                .filter(item -> item % 2 != 0)
                .forEach(System.out::println);
    }

    private static void printSpringLambda(List<String> theStrings) {
        theStrings.stream()
                .filter(item -> item.contains("spring"))
                .forEach(System.out::println);
    }

    private static void printStringsLambda(List<String> theStrings) {
        theStrings.stream()
                .forEach(System.out::println);
    }

    private static void printFourOrMoreLetters(List<String> theStrings) {
        theStrings.stream()
                .filter(item -> item.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printSquares(List<Integer> theNumbers) {
        theNumbers.stream()
                .map(eachNumber -> eachNumber * eachNumber) // take number, ...
                .forEach(System.out::println);
    }

    private static void printCubeOfOddNumbers(List<Integer> theNumbers) {
        theNumbers.stream()
                .filter(item -> item % 2 != 0)
                .map(item -> item * 3)
                .forEach(System.out::println);
    }

    private static void printCharacterLengths(List<String> theStrings) {
        theStrings.stream()
                .map(item -> item = String.valueOf(item.length()))
                .forEach(System.out::println);
    }

    private static void startsWith(List<String> theStrings) {
        Predicate<? super String> predicate = item -> item.startsWith("z");
        Optional<String> optional = theStrings.stream().filter(predicate).findFirst();
        // optional for potential null
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get()); // throws excption for 'z'

        /*
         * Optional<String> fruit = Optional.of("bannana");
         * Optional<String> empty = Optional.empty(); // instead of null
         */
    }
}
