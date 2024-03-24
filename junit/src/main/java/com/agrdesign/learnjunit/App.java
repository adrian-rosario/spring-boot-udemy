package com.agrdesign.learnjunit;

/**
 * Hello world!
 */
public final class App {

    public int calculateNumbers(int[] numbersToCalculate) {
        int theSum = 0;

        for (int eachNumber : numbersToCalculate) {
            theSum += eachNumber;
        }

        return theSum;
    }

    // private App() {
    // }

    // /**
    // * Says hello to the world.
    // * @param args The arguments of the program.
    // */
    // public static void main(String[] args) {
    // System.out.println("Hello Worlds!");
    // }
}
