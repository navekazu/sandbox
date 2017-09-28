package tools.java9sample;

public class StringSample {
    public static void main(String[] args) {
        StringSample ss = new StringSample();
        ss.stringReplaceSpeedTest();
    }

    private void stringReplaceSpeedTest() {
        String sample = "";
        for (int i = 0; i < 10000; i++) {
            sample += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        long s = System.currentTimeMillis();
        String result = sample.replace("ABC", "CCC");
        long e = System.currentTimeMillis();
        System.out.println(e-s);
        System.out.println(result.substring(0, 30));
    }
}
