package org.example.exceptionHandling;

public class CheckedExceptionRunner {
    public static void main(String[] args) {
        /*
        // handling checked exception by try-cath ( either we can throws the exception in method signature)
        try {
            someOtherMethod();
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        */

        // someOtherMethod2() is unchecked exception which extends RuntimeException
        // we don't need to handle the exception beforehand not by throwing exception or by using try-catch
        someOtherMethod2();


    }

    private static void someOtherMethod2() throws RuntimeException{

    }

    private static void someOtherMethod() throws InterruptedException {
        // this sleep() method will have to handle exception because it is checked exception and
        // it has to be handled by either throwing the exception in method signature or
        // by using try-catch block
        Thread.sleep(2000);
    }
}
