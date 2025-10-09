package org.example.asynchronousProgramming.completableFuture;

import org.example.asynchronousProgramming.completableFuture.database.EmployeeDatabase;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class EmployeeReminderService {

    /*
    Steps
    1. Fetch all the employees using
        CompletableFuture.supplyAsync(Supplier reference)
    2. get all new joiners from all the employees from Step 1 i.e
        use thenApply(Function reference as input from Step 1)
        note: above thenApply() method will take input as the result from Step1 thread and process new result from that
    3. get all employees who did not complete their pending activities
        use thenApply(Function reference as input from Step 2)
        note : now Step 2 result will be the input for current thenApply(Function)
    4. get email of all new joiner who has not completed training
        use thenApply(Function reference as input from Step 3)
    5. at last we have to send email to all new joiners who has not completed trainings
        use thenAccept(Consumer Reference as input from step 4)
        note :  we know that Consumer will take input only and return nothing thats why we are using thenAccept() to send emails to employees
        note: we can use thenRun(Runnable) as it also does not return anything

    note : inorder to use multithreading to run task simultaneously we can use thenApplyAsync(),
            thenAcceptAsync() or thenRunAsync() so that multiple tasks will run at same time
     */

    // fetch employees data from EmployeeDatabase class
    // (we can use db but for understanding purpose we are hardcoding values)
    public CompletableFuture<Void> sendReminderToEmployee() throws ExecutionException, InterruptedException {
        // create our thread ExecutorService (thread pool of size 5)
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {   // fetch Employees using Completable.supplyAsync(Supplier)
            System.out.println("fetch Employees : " + Thread.currentThread().getName());

            return EmployeeDatabase.fetchEmployees();
        },executor).thenApplyAsync((employees) -> {  // this thenApply(Function) will take above thread output and input and process it to produce another result
            System.out.println("filter new joiner employee : " + Thread.currentThread().getName());

            return employees.stream()
                    .filter(employee -> "true".equals(employee.getNewJoiner())) // filter out employees who are new joiners
                    .collect(Collectors.toList());  // create filtered list of employees and return

        },executor).thenApplyAsync((employees) -> {   // thenApply(Function) takes input from result of above thenApply()
            System.out.println("filter all new joiner employees whose training is not complete : " + Thread.currentThread().getName());

            return employees.stream()
                    .filter(employee -> "true".equals(employee.getLearningPending()))   // filter new joiner employees whose learning is pending
                    .collect(Collectors.toList());
        },executor).thenApplyAsync((employees) -> {
            System.out.println("get email of all new joiners who has not completed training : " + Thread.currentThread().getName());

            return employees.stream()
                    .map(employee -> employee.getEmail())    // get email of all new joiner who has not completed training using map(Function)
                    .collect(Collectors.toList());
        },executor).thenAcceptAsync((emails) -> {
            System.out.println("send email : " + Thread.currentThread().getName());

            emails.forEach(email -> sendEmail(email));  // send email to all new joiner who has not completed training
        },executor);

        return voidCompletableFuture;
    }

    // send email to employees
    public static void sendEmail(String email){
        System.out.println("Sending training reminder email to  : " + email);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        EmployeeReminderService service = new EmployeeReminderService();
        service.sendReminderToEmployee().get();

    }
}
