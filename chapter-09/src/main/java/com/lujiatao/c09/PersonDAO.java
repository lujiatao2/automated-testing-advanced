package com.lujiatao.c09;

import java.util.List;

public interface PersonDAO {

    List<Person> selectAllPersons();

    Person selectPerson(String idCard);

    boolean insertPerson(Person person);

    boolean updatePerson(Person person);

    boolean deletePerson(String idCard);

}
