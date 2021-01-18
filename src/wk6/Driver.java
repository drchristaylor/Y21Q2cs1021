package wk6;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("How many cars did you see on your way to class?");

        try(Scanner in = new Scanner("8 8")) {
            int numberOfCars = in.nextInt();
            if(true) {
                throw new ArrayIndexOutOfBoundsException("Just kidding");
            }
            System.out.println("How many trucks did you see on your way to class?");
            int numberOfTrucks = in.nextInt();
            if (numberOfCars == numberOfTrucks) {
                System.out.println("You saw the same number of cars and trucks.");
            } else if (numberOfCars < numberOfTrucks) {
                System.out.println("You saw more trucks than cars.");
            } else {
                System.out.println("You saw more cars than trucks.");
            }
        } catch(InputMismatchException exception) {
            System.err.println("You must enter an integer.\n" + exception.getMessage());
        } catch (NoSuchElementException exception) {
            System.err.println("You ran out of energy too early, need to type more numbers\n" + exception.getMessage());
        } catch(IllegalStateException exception) {
            System.err.println("Scanner was closed prematurely\n" + exception.getMessage());
        }
    }
}
