            package com.pak.practice.algorithm.datastructure;

import java.util.*;

@SuppressWarnings("serial")
public class ArrayListShift<E> extends ArrayList<E> {
    public ArrayListShift() {
    }

    public ArrayListShift(int size) {
        super(size);
    }

    public ArrayListShift(final List<E> list) {
        super(list);
    }

    public void shiftLeft(int shiftSize) {
        /* bad performance
        while (shiftSize > 0) {
            E temp = this.get(0);
            int x = 1;
            for (; x < this.size(); x++) {
                this.set(x - 1, this.get(x));
            }
            this.set(x - 1, temp);
            shiftSize--;
        }

         */

        int size = this.size();
        List<E> temp = new ArrayList<>();

        int i = 0;
        while (i < size) {
            int k = (i + shiftSize) % size;
            /*
            k = 0, 1, 2, 3, 4
            i = 4, 0, 1, 2, 3
            d = 4, 4, 4, 4, 4
            si= 5, 5, 5, 5, 5
            */

            temp.add(this.get(k));
            i++;
        }

        this.clear();
        this.addAll(temp);
    }

    public void shiftRight(int shiftSize) {
        /*
        while (shiftSize > 0) {
            E temp = this.get(this.size() - 1);
            for (int i = this.size() - 1; i > 0; i--) {
                this.set(i, this.get(i - 1));
            }
            //Set the first element to the last element
            this.set(0, temp);
            shiftSize--;
        }

         */

        int size = this.size();

        Map<Integer, E> temp = new HashMap<>();

        int i = 0;
        while (i < size) {
            int k = (i + shiftSize) % size;

            temp.put(k, this.get(i));
            i++;
        }

        this.clear();
        this.addAll(temp.values());
    }

    public static void main(String[] args) {
        int shiftSize = 3;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        @SuppressWarnings({"unchecked", "rawtypes"})
        ArrayListShift arrayListShift = new ArrayListShift(list);
        arrayListShift.shiftLeft(shiftSize);
        System.out.println("Original: " + list);
        System.out.println("After left shifted " + shiftSize + " times");
        System.out.println(arrayListShift);
        System.out.println("After right shifted 2 times:");
        arrayListShift.shiftRight(2);
        System.out.println(arrayListShift);
    }
}
