package com.lujiatao.c09;

import java.util.List;

import static com.lujiatao.c09.PersonTable.PERSON_TABLE;

public class PersonDAOImpl implements PersonDAO {

    @Override
    public List<Person> selectAllPersons() {
        return PERSON_TABLE.selectAllPersons();
    }

    @Override
    public Person selectPerson(String idCard) {
        return PERSON_TABLE.selectPerson(idCard);
    }

    @Override
    public boolean insertPerson(Person person) {
        return PERSON_TABLE.insertPerson(person);
    }

    @Override
    public boolean updatePerson(Person person) {
        return PERSON_TABLE.updatePerson(person);
    }

    @Override
    public boolean deletePerson(String idCard) {
        return PERSON_TABLE.deletePerson(idCard);
    }

}
