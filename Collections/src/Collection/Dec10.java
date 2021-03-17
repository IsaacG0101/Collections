package Collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dec10 {

    public static void main(String[] args) {
        // searchDemo1();
        // collectionsDemo1();
        mapsDemo();
    }

    private static void searchDemo1() {
        int numbers[] = {101, 142, 147, 189, 199, 207, 222,
            234, 289, 296, 310, 319, 388, 394,
            417, 429, 447, 521, 536, 600};

        int position = sequentialSearch(numbers, 521);

        if (position != -1) {
            System.out.println("521 was found at position: " + position);
        } else {
            System.out.println("No match found");
        }
    }

    private static int sequentialSearch(int[] numbers, int numberToSearch) {
        int positionFound = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == numberToSearch) {
                positionFound = i;
            }
        }

        return positionFound;
    }

    private static void collectionsDemo1() {

        // array
        int numbers[] = {101, 142, 147, 189, 199, 207, 222,
            234, 289, 296, 310, 319, 388, 394, 417, 429, 447, 521, 536, 600};
        System.out.println("Numbers Array: " + Arrays.toString(numbers));

        // List from JCF
        List<Integer> listNumbers = IntStream.of(numbers) // using Streams
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Numbers List: " + listNumbers);

        setsDemo(listNumbers);
    }

    private static void setsDemo(List<Integer> listNumbers) {
        // HashSet - no sorting and no ordering
        HashSet hashSetNumbers = new HashSet(listNumbers);
        System.out.println("Numbers HashSet: " + hashSetNumbers);

        // Linked Hash Set - keeps the order you specify
        LinkedHashSet linkedHashSetNumbers = new LinkedHashSet(listNumbers);
        System.out.println("Linked HashSet: " + linkedHashSetNumbers);
        linkedHashSetNumbers.add(120);
        System.out.println("After adding 120: " + linkedHashSetNumbers);

        // TreeSet - sorts the data even as you add new data
        TreeSet sortedSetNumbers = new TreeSet(listNumbers);
        System.out.println("Numbers Sorted Set: " + sortedSetNumbers);
        sortedSetNumbers.add(120);
        System.out.println("After adding 120: " + sortedSetNumbers);
    }

    private static void printCollection(Collection numbers, String msg) {
        System.out.print(msg + " [");

        for (Object current : numbers) {
            System.out.print(current + ", ");
        }

        System.out.println("\b\b]");
    }

    private static void mapsDemo() {
        // HashMap - no sorting and no sort order
        HashMap<String, String> campusesMap = new HashMap<>();
        addSampleMapItemsTo(campusesMap);
        System.out.println("HashMap: " + campusesMap);

        // Linked HashMap - ordered (as entered/"put")
        LinkedHashMap<String, String> campusesLinkedMap = new LinkedHashMap<>();
        addSampleMapItemsTo(campusesLinkedMap);
        System.out.println("Linked HashMap: " + campusesLinkedMap);

        // Tree Map - sorted (by key)
        TreeMap<String, String> campusesSortedMap = new TreeMap<>();
        addSampleMapItemsTo(campusesSortedMap);
        System.out.println("Tree (sorted) Map: " + campusesSortedMap);

        // Do some sample Map operations (on the sorted map)
        System.out.println("\nSample Map operations:");
        mapSampleOperations(campusesSortedMap);
    }

    private static void addSampleMapItemsTo(Map<String, String> currentMap) {
        currentMap.put("Manhattan", "230 West 31 Street");
        currentMap.put("Brooklyn-J", "1602 Avenue J");
        currentMap.put("Brooklyn-KH", "1726 Kings Highway");
        currentMap.put("Queens-FH", "113th Street");
    }

    private static void mapSampleOperations(TreeMap<String, String> campusesSortedMap) {
        // some Map operations
        System.out.println("Removing Brooklyn-J");
        campusesSortedMap.remove("Brooklyn-J");
        System.out.println("Tree (sorted) Map: " + campusesSortedMap);

        Set<String> keySet = campusesSortedMap.keySet();
        Collection values = campusesSortedMap.values();

        System.out.println("All Keys: " + keySet);
        System.out.println("All Values: " + values);

        System.out.println("\nKey 'Manhattan''s value: "
                + campusesSortedMap.get("Manhattan"));

        System.out.println("\nLoop through the Map:");

        // loop through a map
        campusesSortedMap.keySet().forEach(currentKey -> {
            System.out.println(currentKey + " is: " + campusesSortedMap.get(currentKey));
        });

        /* // Like doing:
        for (String currentKey : campusesSortedMap.keySet())
        {
        System.out.println(currentKey + " is: " + campusesSortedMap.get(currentKey));
        }
         */
        System.out.println("Number of elements in map: " + campusesSortedMap.size());
    }

}
