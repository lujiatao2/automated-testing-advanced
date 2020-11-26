package com.lujiatao.c09;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    Person getPerson(String idCard);

    boolean addPerson(Person person);

    boolean modifyPerson(Person person);

    boolean delPerson(String idCard);

}
