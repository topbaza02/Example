package com.example.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class One {
    public static void main(String[] args) {
        Integer[] arrayInt = {10, 48, 416, 65, 654, 321, 654, 32, 8, 1111, 3, 64, 65, 64, 555, 684, 615, 684};
        Integer data = 64;

        Integer indexOfData = findIndex(arrayInt, data);

        System.out.println("Index of " + data + " is : " + indexOfData);

    }

    private static Integer findIndex(Integer[] arrayInt, Integer data) {
        List listData = new ArrayList();

        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] == data) {
                listData.add(i);
            }
        }

        return listData.isEmpty() ? null : getRandomElement(listData);
    }


    private static int getRandomElement(List<Integer> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

}