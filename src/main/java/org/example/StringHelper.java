package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringHelper {
    public static String toUpperCase(String inputString) {
        char[] string = toArrayOfChar(inputString);
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < string.length; i++) {
            int asciiNum = string[i];
            if (asciiNum > 96 && asciiNum < 123) {
                asciiNum -= 32;
                string[i] = (char) asciiNum;
            }
            temp.append(string[i]);
        }
        return temp.toString();
    }

    public static String toLowerCase(String inputString) {
        char[] string = toArrayOfChar(inputString);
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < string.length; i++) {
            int asciiNum = string[i];
            if (asciiNum > 64 && asciiNum < 91) {
                asciiNum += 32;
                string[i] = (char) asciiNum;
            }
            temp.append(string[i]);
        }
        return temp.toString();
    }

    public static String replace(String inputString, char a, char b) {
        char[] string = toArrayOfChar(inputString);
        StringBuilder temp = new StringBuilder();
        for (char c : string) {
            if (c == a) {
                temp.append(b);
            } else {
                temp.append(c);
            }
        }
        return temp.toString();
    }

    public static List<String> split(String inputString, char pattern) {
        char[] string = toArrayOfChar(inputString);
        StringBuilder temp = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < string.length; i++) {
            if (string[i] == pattern) {
                if (!temp.toString().equals("")) {
                    stringList.add(temp.toString());
                }
                temp.setLength(0);
            } else {
                temp.append(string[i]);
            }
        }
        if (!temp.toString().equals("")) {
            stringList.add(temp.toString());
        }
        return stringList;
    }

    public static String join(String s1, String s2) {
//        StringBuilder temp = new StringBuilder();
//        temp.append(s1);
//        temp.append(s2);
//        return temp.toString();

        char[] string = new char[s1.length() + s2.length()];
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            string[i] = s1.charAt(i);
        }
        for (int i = s1.length(); i < s1.length() + s2.length(); i++) {
            string[i] = s2.charAt(i - s1.length());
        }
        for (int i = 0; i < string.length; i++) {
            temp.append(string[i]);
        }
        return temp.toString();

//        return s1 + s2;
    }

    public static boolean equalsIgnoreCase(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        s1 = toUpperCase(s1);
        s2 = toUpperCase(s2);

        char[] string1 = toArrayOfChar(s1);
        char[] string2 = toArrayOfChar(s2);

        for (int i = 0; i < string1.length; i++) {
            if (string1[i] != string2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String format(String s, int d) {
        boolean isFind = false;
        int counter = 0;
        char[] string = toArrayOfChar(s);
        for (int i = 0; i < string.length; i++) {
            if (string[i] == '%') {
                if ((i + 1) != string.length) {
                    if (string[i + 1] == 'd') {
                        string[i] = (char) (d + '0');
                        isFind = true;
                        counter = i;
                        break;
                    }
                }
            }
        }
        if (isFind) {
            for (int i = counter + 1; i < string.length - 1; i++) {
                string[i] = string[i + 1];
            }
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < string.length - 1; i++)
                temp.append(string[i]);
            return temp.toString();
        } else {
            return s;
        }
    }

    public static int indexOf(String inputString, char ch) {
        char[] string = toArrayOfChar(inputString);
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public static char[] toArrayOfChar(String s) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
        }
        return result;
    }
}
