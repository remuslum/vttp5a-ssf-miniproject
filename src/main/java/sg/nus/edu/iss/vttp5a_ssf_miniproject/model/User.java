package sg.nus.edu.iss.vttp5a_ssf_miniproject.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message = "First Name cannot be blank")
    @Size(min = 2, message = "First Name must be at least 2 characters in length")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @Size(min = 2, message = "Last Name must be at least 2 characters in length")
    private String lastName;

    @NotNull(message = "Date of birth cannot be blank")
    @Past(message = "Date of birth cannot be more current than today")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be a vaild email address")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters in length")
    private String password;
    
    public User() {
    }

    public User(String firstName, String lastName, LocalDate dateOfBirth, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
