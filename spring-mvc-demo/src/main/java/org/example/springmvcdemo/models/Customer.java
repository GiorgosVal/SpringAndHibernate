package org.example.springmvcdemo.models;

import org.example.springmvcdemo.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    @NotNull
    @Size(min = 2, message = "Too short name.")
    @Size(max = 15, message = "Too long name.")
    private String firstName;

    @NotNull(message = "Last name cannot be empty.")
    @Size(min = 1, max = 20, message = "Too short or too long last name.")
    private String lastName;

    @NotNull(message = "Free passes cannot be empty.")
    @Min(value = 0, message = "Must be greater than or equal to zero.")
    @Max(value = 10, message = "Must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Postal Code must be 5 characters or digits.")
    private String postalCode;

    @CourseCode(value = {"VALAM", "GIO"}, message = "Course code must start with VALAM or GIO.")
    private String courseCode;

    public Customer() {
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
