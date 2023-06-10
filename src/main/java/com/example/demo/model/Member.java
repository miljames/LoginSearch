package com.example.demo.model;

public class Member {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Member() {
    }

    public Member(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (o == null || getClass() != o.getClass()) {
        return false;
    }
    Member member = (Member) o;
    return (firstName != null && firstName.length() > 0 && member.firstName != null && member.firstName.length() > 0 &&
            Character.toLowerCase(firstName.charAt(0)) == Character.toLowerCase(member.firstName.charAt(0))) ||
            (lastName != null && lastName.length() > 0 && member.lastName != null && member.lastName.length() > 0 &&
                    Character.toLowerCase(lastName.charAt(0)) == Character.toLowerCase(member.lastName.charAt(0)));
}
}

