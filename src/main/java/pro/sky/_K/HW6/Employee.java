package pro.sky._K.HW6;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String LastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(LastName, employee.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, LastName);
    }


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.LastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName;
    }

}
