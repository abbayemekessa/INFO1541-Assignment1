package EmployeeObjects;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestingAnnoations {
    public static void main(String[] args) {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);

        SalaryEmployee salaryEmployee = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);

        int employeeTypeCount = 0;

        Object[] employees = {hourlyEmployee, salaryEmployee, commissionEmployee};

        for (Object employee : employees) {
            Class<?> clazz = employee.getClass();

            // Check if the class is annotated with @EmployeeType
            if(clazz.isAnnotationPresent(EmployeeType.class)){
                employeeTypeCount++;
            }

            // Loop through fields to find @PayRate
            for(Field field : clazz.getDeclaredFields()){
                if(field.isAnnotationPresent(PayRate.class)){
                    field.setAccessible(true);
                    try {
                        Object value = field.get(employee);
                        System.out.println("Employee pay rate: $" + value);
                    } catch (IllegalAccessException e) {
                        System.out.println("Error accessing pay rate field: " + e.getMessage());
                    }
                }
            }

            // Loop thorugh methods to find @WeeklyPaycalculator
            for(Method method : clazz.getDeclaredMethods()){
                if(method.isAnnotationPresent(WeeklyPayCalculator.class)){
                    try {
                        Object result = method.invoke(employee);
                        System.out.println("Weekly Pay: $" + result);
                    } catch (Exception e) {
                        System.out.println("Error invoking weekly pay method: " + e.getMessage());
                    }
                }
            }
            System.out.println("------------------------------");
        }

        System.out.println("You have " + employeeTypeCount + " employee type(s) added to the salary employee");


    }
}
