package com.lujiatao.c09;

import java.util.List;

public class PersonController {

    private static int instanceCount;
    private PersonService personService;

    public PersonController(PersonService personService) {
        if (personService == null) {
            throw new IllegalArgumentException("PersonService为空！");
        }
        this.personService = personService;
        instanceCount++;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public List<Person> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        if (persons == null) {
            throw new RuntimeException("无Person！");
        }
        return persons;
    }

    public Person getPerson(String idCard) {
        Person person = personService.getPerson(idCard);
        if (person == null) {
            throw new RuntimeException("无Person！");
        }
        return person;
    }

    public boolean addPerson(Person person) {
        return personService.addPerson(person);
    }

    public boolean modifyPerson(Person person) {
        return personService.modifyPerson(person);
    }

    public boolean delPerson(String idCard) {
        return personService.delPerson(idCard);
    }

}
