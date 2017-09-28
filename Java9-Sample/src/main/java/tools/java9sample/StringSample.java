package tools.java9sample;

import java.util.stream.IntStream;

public class StringSample {
    public static void main(String[] args) {
        StringSample ss = new StringSample();
        ss.stringReplaceSpeedTest();
    }

    private void stringReplaceSpeedTest() {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, 10000).forEach(i -> builder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

        String sample = builder.toString();;
        long start = System.currentTimeMillis();
        String result = sample.replace("ABC", "CCC");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(result.length() + " " + result.substring(0, 30));
    }
}
