package com.pak.practice.algorithm.map;

import com.google.common.collect.TreeMultimap;

import java.util.*;

public class MileageAvgByDate {

    static class DateItem {
        final String date;

        public DateItem(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }
    }

    static class sortByDate implements Comparator<DateItem> {
        @Override
        public int compare(DateItem a, DateItem b) {
            return a.date.compareTo(b.date);
        }
    }

    static void printList(List<Integer> list) {
        System.out.println(list);
    }

    public static void main(String[] args) {
        String searchDate = "2020-03-26";

        // Either ArrayListMultimap or TreeMultimap will work in this case

        // ArrayListMultimap<Integer, DateItem> hashMap = ArrayListMultimap.create();

        TreeMultimap<Integer, DateItem> treemap = TreeMultimap.create(Comparator.naturalOrder(),
                Comparator.comparing(DateItem::getDate));

        treemap.put(10099, new DateItem("2020-03-27"));
        treemap.put(10099, new DateItem("2020-03-27"));
        treemap.put(10000, new DateItem("2020-03-25"));
        treemap.put(10005, new DateItem("2020-03-25"));
        treemap.put(10005, new DateItem("2020-03-25"));
        treemap.put(10035, new DateItem("2020-03-25"));
        treemap.put(10035, new DateItem("2020-03-25"));
        treemap.put(10081, new DateItem("2020-03-25"));
        treemap.put(10081, new DateItem("2020-03-26"));
        treemap.put(10090, new DateItem("2020-03-26"));

        /*
        // sort function testing
        List<DateItem> dateList = new ArrayList<>();
        dateList.add(new DateItem("2020-03-27"));
        dateList.add(new DateItem("2020-03-27"));
        dateList.add(new DateItem("2020-03-25"));
        dateList.add(new DateItem("2020-03-25"));
        dateList.add(new DateItem("2020-03-25"));
        dateList.add(new DateItem("2020-03-25"));
        dateList.add(new DateItem("2020-03-25"));
        dateList.add(new DateItem("2020-03-25"));
        dateList.add(new DateItem("2020-03-26"));
        dateList.add(new DateItem("2020-03-26"));
        Collections.sort(dateList, new sortByDate());
        for (DateItem dateItem : dateList) {
            System.out.println(dateItem.getDate());
        }

         */



        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, DateItem> entry : treemap.entries()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getDate());
            if (entry.getValue().getDate().equals(searchDate))
                list.add(entry.getKey());
        }
        printList(list);
        int totalMiles = Collections.max(list) - Collections.min(list);
        System.out.println("Total mileages traveled on " + searchDate + " is " + totalMiles);
    }
}
