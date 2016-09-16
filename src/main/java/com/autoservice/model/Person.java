package com.autoservice.model;

import com.autoservice.dto.PersonDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String personName;

    @Column
    private Double personAge;

    public static Person fromPersonDto(PersonDto dto) {
        Person person = new Person();
        person.setId(dto.getId());
        person.setPersonAge(dto.getPersonAge());
        person.setPersonName(dto.getPersonName());
        return person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public double getPersonAge() {
        return personAge;
    }

    public void setPersonAge(double personAge) {
        this.personAge = personAge;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", personName=" + personName + ", personAge=" + personAge + "]";
    }
}

