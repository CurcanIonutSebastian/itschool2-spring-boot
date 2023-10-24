package ro.itschool.project.exceptions.practice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringExceptionHandling {

    public static void main(String[] args) {
        String input = "Hello world.";
        int validIndex = 2;
        int invalidIndex = 30;
        printCharAt(input, invalidIndex);
    }

    private static void printCharAt(String input, int index) {
        try {
            System.out.println("character at index " + index + ": " + input.charAt(index));
        } catch (StringIndexOutOfBoundsException exception) {
            log.error("StringIndexOutOfBoundsException: " + exception.getMessage());
            log.error("Invalid index.");
            throw new IllegalArgumentException("Invalid value for index");
        }
    }
}