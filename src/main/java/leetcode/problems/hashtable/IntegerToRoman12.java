package leetcode.problems.hashtable;

public class IntegerToRoman12 {

    public static void main(String[] args) {
        IntegerToRoman12 obj = new IntegerToRoman12();
        int num = 3949;
        System.out.println(obj.intToRoman(num));
    }

    public String intToRoman(int num) {
        int number = num;
        int[] arr = new int[4];
        int count = 0;
        for (int i = 3; i >= 0; i--) {
            arr[count] = number / (int) Math.pow(10, i);
            number = number % (int) Math.pow(10, i);
            count++;
        }
        StringBuilder sb = new StringBuilder();

        int num1000 = arr[0];
        for (int i = 0; i < num1000; i++) {
            sb.append("M");
        }

        int num100 = arr[1];
        if (num100 >= 5) {
            if (num100 == 9) {
                sb.append("CM");
            } else {
                sb.append("D");
                for (int i = 5; i < num100; i++) {
                    sb.append("C");
                }
            }
        } else {
            if (num100 == 4) {
                sb.append("CD");
            } else {
                for (int i = 0; i < num100; i++) {
                    sb.append("C");
                }
            }
        }

        int num10 = arr[2];
        if (num10 >= 5) {
            if (num10 == 9) {
                sb.append("XC");
            } else {
                sb.append("L");
                for (int i = 5; i < num10; i++) {
                    sb.append("X");
                }
            }
        } else {
            if (num10 == 4) {
                sb.append("XL");
            } else {
                for (int i = 0; i < num10; i++) {
                    sb.append("X");
                }
            }
        }

        int num1 = arr[3];
        if (num1 >= 5) {
            if (num1 == 9) {
                sb.append("IX");
            } else {
                sb.append("V");
                for (int i = 5; i < num1; i++) {
                    sb.append("I");
                }
            }
        } else {
            if (num1 == 4) {
                sb.append("IV");
            } else {
                for (int i = 0; i < num1; i++) {
                    sb.append("I");
                }
            }
        }
        return sb.toString();
    }
}
