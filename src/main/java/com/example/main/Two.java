package com.example.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Two {
    public static void main(String[] args) {
        String buffer = "B2[a3[c]b]b4[z]";

        String result = decompress(buffer);
        System.out.println(result);
    }


    private static String decompress(String buffer) {
        Matcher matcher = compile(buffer);
        while (matcher.find()) {
            String searchText = matcher.group();
            String[] splitText = searchText.split("\\[");
            int numberCycle = Integer.parseInt(splitText[0]);
            String text = splitText[1].replace("]", "");
            String rawResult = doCycle(numberCycle, text);
            buffer = buffer.replace(searchText, rawResult);
            return decompress(buffer);
        }

        return buffer;
    }

    private static Matcher compile(String buffer) {
        return Pattern.compile("(\\d+\\[\\w+\\])").matcher(buffer);
    }


    private static String doCycle(int numberCycle, String text) {
        String rawResult = "";
        for (int i = 0; i < numberCycle; i++) {
            rawResult += text;
        }
        return rawResult;
    }

}
