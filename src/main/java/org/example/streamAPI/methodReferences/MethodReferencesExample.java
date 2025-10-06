package org.example.streamAPI.methodReferences;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MethodReferencesExample {
    public static void main(String[] args) {

        // approach 1
        // anonymous approach to get all Employees
        EmployeeService service = new EmployeeService();

        service.loadEmployeesFromDB()
                .stream()
                .forEach(new Consumer<Employee>() {
                    @Override
                    public void accept(Employee employee) {
                        System.out.println(employee);
                    }
                });

        System.out.println("============================================");
        // approach 2
        // using lambda expression

        service.loadEmployeesFromDB()
                .forEach(employee -> System.out.println(employee));

        System.out.println("=========================================");

        // approach 3: using Method Reference

        service.loadEmployeesFromDB()
                .forEach(System.out::println);

        System.out.println("******************************************");
        // -------------------------------------------------
        System.out.println("using method references for instance methods");

        EmployeeMapper mapper = new EmployeeMapper();

        List<EmployeeDO> employeeDOS = service.loadEmployeesFromDB()
                .stream()
                .map(mapper::convert) // using method references for instance methods
                .collect(Collectors.toList());// convert stream to list
        System.out.println(employeeDOS);

        System.out.println("******************************************");

        // get the name of each employee from employeeDOS
        /*
        Note: below .map(Employee::getName) here we are calling getName() directly by Employee but getName() is not static
                reason is that any method which does not contain any argument will be considered as static by stream api

                // if getName(T) contains any argument then we need to create object of that class and then call it with method reference
         */
        List<String> nameList = service.loadEmployeesFromDB()
                .stream()
                .map(Employee::getName) // get employees by Name// getName() is considered as static method by stream as it does not contain any argument, if arguement was there then we have to call it by creating object and then method name using method reference
                .collect(Collectors.toList());
        System.out.println(nameList);

        System.out.println("********************************************");

        System.out.println("Constructor Method Reference");

        // using lambda
        EmployeeManager manager = () -> new Employee();
        manager.getEmployee().getEmployeeInfo();;

        // using constructor method reference
        EmployeeManager manager1 = Employee::new;   // calling constructor using method reference
        manager1.getEmployee().getEmployeeInfo();;



    }

    public static void print(Employee employee){
        System.out.println(employee);
    }
}
