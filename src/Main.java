import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Entry> entries = Entry.populate();
        printEntries(entries);
        printTuesdays(entries);
        countTueWedThur(entries);
        weekendList(entries);
        weekdaySet(entries);
        printDurationGreaterThan10(entries);
        findMaxDuration(entries);
        listGreaterThan50(entries);
    }


    public static void printEntries(List<Entry> entries) {
        System.out.println("For Loop:");
        for (Entry entry : entries) {
            System.out.println(entry + ", ");
        }
        System.out.println("\nStream, forEach:");
        entries.stream().forEach(entry -> System.out.println(entry + ", "));
        System.out.println();
    }

    public static void printTuesdays(List<Entry> entries) {
        System.out.println("For Loop:");
        for (Entry entry : entries)
            if (entry.getDay().equals(Day.TUESDAY))
                System.out.println(entry + ", ");
        System.out.println("\nStream, filter, forEach:");
        entries.stream()
                .filter(entry -> entry.getDay().equals(Day.TUESDAY))
                .forEach(entry -> System.out.println(entry + ", "));
        System.out.println();
    }

    public static void countTueWedThur(List<Entry> entries) {
        System.out.println("For Loop:");
        int count = 0;
        for (Entry entry : entries) {
            if (entry.getDay().equals(Day.TUESDAY) ||
                    entry.getDay().equals(Day.WEDNESDAY) ||
                    entry.getDay().equals(Day.THURSDAY))
                count++;
        }
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count);
        System.out.println("Stream, filter, count: ");
        long count1 = 0;
        count1 = entries.stream()
                .filter(entry -> entry.getDay().equals(Day.TUESDAY) ||
                        entry.getDay().equals(Day.WEDNESDAY) ||
                        entry.getDay().equals(Day.THURSDAY))
                .count();
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count1);
        System.out.println();
    }

    public static void weekendList(List<Entry> entries) {
        System.out.println("For Loop:");
        List<Entry> weekends = new ArrayList<>();

        for (Entry entry : entries) {
            if (entry.getDay() == Day.SATURDAY || (entry.getDay() == Day.SUNDAY)) {
                weekends.add(entry);
            }
        }

        System.out.println(weekends);
        System.out.println("Stream, filter, collect:");
        weekends = entries.stream().filter(date -> date.getDay() == Day.SATURDAY ||
                date.getDay() == Day.SUNDAY).collect(Collectors.toList());
        System.out.println(weekends);
    }

    public static void weekdaySet(List<Entry> entries) {
        System.out.println("For Loop:");
        Set<String> weekdays = new HashSet<>();
        for (Entry entry : entries) {
            if (entry.getDay() != Day.SATURDAY && entry.getDay() != Day.SUNDAY) {
                weekdays.add(entry.getNote().toString());
            }
        }

        System.out.println(weekdays);
        System.out.println("Stream, filter, map, collect:");
        weekdays = entries.stream().filter(date -> date.getDay() != Day.SATURDAY && date.getDay()
                != Day.SUNDAY).map(Entry::getNote).collect(Collectors.toSet());
        System.out.println(weekdays);
        System.out.println();
    }

    public static void printDurationGreaterThan10(List<Entry> entries) {
        System.out.println("Duration > 10 For Loop:");
        for (Entry entry : entries) {
            if (entry.getDuration() > 10)
                System.out.println(entry);
        }
        System.out.println("\n Stream, filter, forEach:");
        entries.stream()
                .filter(entry -> entry.getDuration() > 10)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void findMaxDuration(List<Entry> entries) {
        System.out.println("For Loop:");
        int temp = 0;
        for (Entry entry : entries) {
            if (entry.getDuration() > temp)
                temp = entry.getDuration();
        }
        System.out.println("The Max Duration is: " + temp);
        System.out.println("Stream, mapToInt, max, getAsInt:");
        temp = entries.stream() // write stream use mapToInt then max the getAsInt
                .mapToInt(Entry::getDuration)
                .max()
                .getAsInt();
        System.out.println("The Max Duration is: " + temp);
        System.out.println();
    }

    public static void listGreaterThan50(List<Entry> entries) {
        System.out.println("For Loop:");
        List<Entry> greaterThan50 = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.getDuration() > 50)
                greaterThan50.add(entry);
        }
        System.out.println(greaterThan50);
        System.out.println("Stream, filter, collect:");
        greaterThan50 = entries.stream()
                .filter(entry -> entry.getDuration() > 50)
                .collect(Collectors.toList());
        System.out.println(greaterThan50);
        System.out.println();
    }
}

