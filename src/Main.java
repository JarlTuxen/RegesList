import java.util.*;

public class Main {
    public static void main(String[] args) {

        //find longest word in list
        List<String> myList = new LinkedList<>(List.of(new String[]{"a", "bb", "ccc"}));
        myList.add("dddd");
        System.out.println(longest(myList));

        // Reges 11.3
        //removeInRange
        Integer[] rangeInt = {0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16};
        List<Integer> rangeList = new LinkedList<>(List.of(rangeInt));
        removeInRange(rangeList, 0, 5, 13);
        System.out.println(rangeList);

        // Reges 11.4
        //partition
        Integer[] unsortedInt = {15, 1, 6, 12, -3, 4, 8, 21, 2, 30, -1, 9};
        List<Integer> partionList = new LinkedList<>(List.of(unsortedInt));
        partition(partionList, 5);
        System.out.println(partionList);
        //
    }

    public static String longest(List<String> list){
        Iterator<String> itr = list.iterator();
        String longest = itr.next(); //første element
        while (itr.hasNext()){
            String current = itr.next();
            if (current.length()>longest.length()){
                longest = current;
            }
        }
        return longest;
    }

    // Reges 11.3
    public static void removeInRange(List<Integer> list, int value, int min, int max) {
        Iterator<Integer> itr = list.iterator();
        for (int i = 0; i < min; i++) {
            //skip the elements until starting point reached
            itr.next();
        }
        for (int i = min; i < max; i++) {
            if (itr.next() == value) {
                itr.remove();
            }
        }
    }

    // Reges 11.4
    public static void partition(List<Integer> list, int value) {
        // partition original list into a temporary second list
        List<Integer> temp = new LinkedList<>();
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            int element = itr.next();
            if (element < value) {
                //add element at front of temp list
                temp.add(0, element);
            } else {
                //add element at end of temp list
                temp.add(element);
            }
        }

        // copy temp back to original list
        // can be replaced with Collection.addAll
        list.clear();
        for (Integer i : temp) {
            list.add(i);
        }

    }
}
