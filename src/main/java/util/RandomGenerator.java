package util;

public class RandomGenerator {
    public String getRandomNumber(int count) {
        final String ALPHA_NUMERIC_STRING = "0123456789";

        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public String getRandomSymbols(int count) {
        final String SYMBOLS_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * SYMBOLS_STRING.length());
            builder.append(SYMBOLS_STRING.charAt(character));
        }
        return builder.toString();
    }

    public String generateEmail() {
        return getRandomSymbols(10) + "@gmail.com";
    }

    public String generatePassword() {
        return "+7911" + getRandomSymbols(10);
    }

    public String generateName() {
        return "Test_name_" + getRandomNumber(10);
    }
}
