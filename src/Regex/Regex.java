package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String nameRegex = "^\\D+$";
    public static final String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*(@gmail.com)$";
    public static final String idRegex = "[0-9]+$";
    private static Pattern pattern;
    private static Matcher matcher;
    static Scanner scanner = new Scanner(System.in);
    public static boolean validateName(String nameRegexX) {
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(nameRegexX);
        return matcher.matches();
    }

    public static boolean validateEmail(String emailRegexX) {
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(emailRegexX);
        return matcher.matches();
    }

    public static boolean validateId(int idRegexX) {
        //phair laf so
        // khong dc trng
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (id > 0) {
            }
        } catch (Exception e) {

        }
        return true;
    }
}
