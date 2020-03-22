package com.example.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @JsonProperty("first_name")
    @Column(name="first_name", length = 32)
    private String firstName;

    @JsonProperty("last_name")
    @Column(name="last_name", length = 32)
    private String lastName;

    @JsonProperty("city")
    @Column(name="city", length = 32)
    private String city;
}
