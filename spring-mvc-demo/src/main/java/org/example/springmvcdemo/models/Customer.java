package org.example.springmvcdemo.models;

import javax.validation.constraints.*;

public class Customer {

    @NotNull
    @Size(min = 2, message = "Too short name.")
    @Size(max = 15, message = "Too long name.")
    private String firstName;

    @NotNull(message = "Last name cannot be empty.")
    @Size(min = 1, max = 20, message = "Too short or too long last name.")
    private String lastName;

    @Min(value = 0, message = "Must be greater than or equal to zero.")
    @Max(value = 10, message = "Must be less than or equal to 10")
    private int freePasses;

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
