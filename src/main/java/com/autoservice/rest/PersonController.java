package com.autoservice.rest;

import com.autoservice.dto.PersonDto;
import com.autoservice.model.Person;
import com.autoservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping() {
        return "PONG";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public PersonDto get(@PathVariable("id") Long id) {
        return personService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<PersonDto> getAll() {
        return personService.getAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public PersonDto create(@RequestBody PersonDto personDto) {
       // return personService.create(personDto);
        PersonDto dto = new PersonDto();

        dto.setPersonAge(41);
        dto.setPersonName("name1");
        return personService.create(dto);
    }

    @RequestMapping(value = "search/{name}", method = RequestMethod.GET)
    public List<Person> searchByName(@PathVariable("name") String name) {
        return personService.searchByName(name);
    }
    @RequestMapping(value = "search/byage/{age}", method = RequestMethod.GET)
    public List<Person> searchByAge(@PathVariable("age") double age) {
        return personService.searchByAge(age);
    }

}
