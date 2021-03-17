package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Dec17 {

    public static void main(String[] args) {
        iteratorDemo1();
    }

    private static void iteratorDemo1() {
        ArrayList<String> campuses = new ArrayList<>(3);
        campuses.add("Manhattan-W. 31st");
        campuses.add("Brooklyn-Kings Highway");
        campuses.add("Queens-113th Street");
        Collections.sort(campuses);

        // listOperations(campuses);
        // iteratorOperations(campuses);
        // listIteratorOperations(campuses);
        // listIteratorOperations2(campuses);
        // listIteratorOperations3(campuses);
        listIteratorOperations4(campuses);
    }

    private static void listOperations(ArrayList<String> campuses) {
        // output the entire list
        System.out.println("Campuses: " + campuses);

        System.out.println("Item #1 (second item): " + campuses.get(1));
        System.out.println("The index of 'Queens-113th Street' is: "
                + campuses.indexOf("Queens-113th Street"));

        System.out.println("\nUsing an iterator:");
    }

    private static void iteratorOperations(ArrayList<String> campuses) {

        // clone the list so that our remove(s) don't affect the original
        campuses = (ArrayList<String>) campuses.clone();

        // get a reference to a new iterator object
        Iterator<String> campusesIterator = campuses.iterator();

        while (campusesIterator.hasNext()) {
            System.out.println(campusesIterator.next());
        }

        // Will crash - Attempting to do next() - after iterating through list
        // System.out.println(campusesIterator.next());
        // at this point, we've iterated through the entire list
        System.out.println("\nRemoving the most recently 'nexted' item");
        campusesIterator.remove();

        // output the entire list
        System.out.println("Campuses: " + campuses);
    }

    private static void listIteratorOperations(ArrayList<String> campuses) {
        // output the entire list
        System.out.println("\nList Iterator Demo:");
        System.out.println("Campuses: " + campuses);

        System.out.println("\nUsing the List Iterator:");
        ListIterator<String> campusesListIterator = campuses.listIterator();
        System.out.println("-- Iterating forwards through the ListIterator/list");
        while (campusesListIterator.hasNext()) {
            System.out.println(campusesListIterator.next());
        }

        System.out.println("-- Iterating backwards through the ListIterator/list");
        while (campusesListIterator.hasPrevious()) {
            System.out.println(campusesListIterator.previous());
        }
    }

    private static void listIteratorOperations2(ArrayList<String> campuses) {
        // output the entire list
        System.out.println("\nList Iterator Demo2:");
        System.out.println("Campuses: " + campuses);

        System.out.println("\nUsing the List Iterator:");
        ListIterator<String> campusesListIterator = campuses.listIterator();

        // go forward through the entire list iterator
        for (; campusesListIterator.hasNext(); campusesListIterator.next());

        System.out.println("-- Iterating backwards through the ListIterator/list");
        while (campusesListIterator.hasPrevious()) {
            System.out.println(campusesListIterator.previous());
        }
    }

    private static void listIteratorOperations3(ArrayList<String> campuses) {
        // output the entire list
        System.out.println("\nList Iterator Demo2:");
        System.out.println("Campuses: " + campuses);

        System.out.println("\nUsing the List Iterator to start at the end:");
        ListIterator<String> campusesListIterator
                = campuses.listIterator(campuses.size());

        System.out.println("-- Iterating backwards through the ListIterator/list");
        while (campusesListIterator.hasPrevious()) {
            System.out.println(campusesListIterator.previous());
        }
    }

    private static void listIteratorOperations4(ArrayList<String> campuses) {
        // clone the incoming ArrayList to prevent changing the source data
        campuses = (ArrayList<String>) campuses.clone();
        
        // output the entire list
        System.out.println("\nList Iterator Demo:");
        System.out.println("Campuses: " + campuses);

        System.out.println("\nUsing the List Iterator:");
        ListIterator<String> campusesListIterator = campuses.listIterator();
        
        System.out.println("-- Iterating forwards through the ListIterator/list");
        while (campusesListIterator.hasNext()) {
            String originalValue = campusesListIterator.next();
            System.out.print(originalValue + " --> ");
            String newValue = "Campus: " + originalValue;
            campusesListIterator.set(newValue);
            System.out.println(newValue);
        }
        
        System.out.println("\nAfter changing the items using the ListIterator:");
        System.out.println("Campuses: " + campuses);

        System.out.println("\nAdd to end of the list using the ListIterator:");
        campusesListIterator.add("Campus: Touro University Nevada");
        
        System.out.println("Campuses: " + campuses);
        
    }
}
