package org.example.exceptionHandling;

public class ExceptionHandlingRunner2 {

    public static void main(String[] args) {
        method1();
        System.out.println("Main Ended");
    }

    private static void method1() {
        method2();
        System.out.println("Method1 Ended");
    }

    private static void method2() {
        try {
//            String str = null;
//            str.length();
            int[] i = {1,2};
            int number = i[3];
            System.out.println("Method2 Ended");
        } catch (NullPointerException e) {
            System.out.println("Matched NullPointerException");
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Matched ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }
        catch (Exception ex) {
            System.out.println("Matched Exception");
            ex.printStackTrace();
        }


    }
}
