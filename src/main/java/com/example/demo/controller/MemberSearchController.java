package com.example.demo.controller;

import com.example.demo.query.MemberSearchQuery;
import com.example.demo.model.Member;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.Serializable;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "*")

public class MemberSearchController implements Serializable {

    private List<Member> members;

    public MemberSearchController() {
        members = new ArrayList<>();
        members.add(new Member("Preethi", "Balasubramaniam", "preethi@gmail.com", "123-456-7890"));
        members.add(new Member("Steven", "Hollander", "stevie@gmail.com", "234-567-8901"));
        members.add(new Member("John", "Maclellan", "john@gmail.com", "345-678-9012"));
        members.add(new Member("Kyle", "Oleksak", "kyle@gmail.com", "456-789-0123"));
        members.add(new Member("Jenny", "Hill", "jenny@gmail.com", "567-890-1234"));
        members.add(new Member("Sam", "Olsen", "sam@gmail.com", "678-901-2345"));
        members.add(new Member("Kim", "Malone", "kim@gmail.com", "789-012-3456"));
        members.add(new Member("Ken", "Bensen", "ken@gmail.com", "890-123-4567"));
        members.add(new Member("Hardik", "Dhanuka", "hardik@gmail.com", "901-234-5678"));
        members.add(new Member("Milan", "Chitariya", "milan@gmail.com", "012-345-6789"));
        members.add(new Member("Henry", "Carling", "henry@gmail.com", "123-456-8901"));
        members.add(new Member("Michelle", "Donovan", "michelle@gmail.com", "234-567-8901"));
    }

    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> searchMembers(@RequestBody MemberSearchQuery query) {
        String firstNameQuery = query.getFirstNameQuery();
        String lastNameQuery = query.getLastNameQuery();

        List<Member> filterMembers = members.stream()
                .filter(member -> isMatch(member, query, true))
                .filter(member -> isMatch(member, query, false))
                .collect(Collectors.toList());

        return filterMembers;
    }

    private boolean isMatch(Member member, MemberSearchQuery query, boolean isFirstNameSearch) {
        String firstName = member.getFirstName().toLowerCase();
        String lastName = member.getLastName().toLowerCase();
        String searchQuery = isFirstNameSearch ? query.getFirstNameQuery() : query.getLastNameQuery();

        if (searchQuery == null || searchQuery.isEmpty()) {
            return true;
        }
        searchQuery = searchQuery.toLowerCase();

        if (isFirstNameSearch) {
            if (searchQuery.length() == 1) {
                return firstName.startsWith(searchQuery);
            } else {
                return firstName.equals(searchQuery);
            }
        } else {
            if (searchQuery.length() == 1) {
                return lastName.startsWith(searchQuery);
            } else {
                return lastName.equals(searchQuery);
            }
        }
    }

}




















