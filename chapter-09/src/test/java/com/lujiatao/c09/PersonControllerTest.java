package com.lujiatao.c09;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.lujiatao.c09.PersonController.getInstanceCount;
//import static com.lujiatao.c09.PersonServiceImpl.getCount;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;

public class PersonControllerTest {

    @Test
    public void testCase_001() {
        assertEquals(getInstanceCount(), 0);
        new PersonController(new PersonServiceImpl());
        assertEquals(getInstanceCount(), 1);
    }

    @Test
    public void testCase_002() {
        PersonController personController = new PersonController(new PersonServiceImpl());
        assertEquals(personController.getAllPersons().size(), 0);
    }

    @Test
    public void testCase_003() {
        PersonController personController = new PersonController(new PersonServiceImpl());
//        assertEquals(getCount(), 0);
        assertEquals(personController.getAllPersons().size(), 0);
//        assertEquals(getCount(), 1);
    }

    @InjectMocks
    private PersonController personController;
    @Mock
    private PersonService personService;

    @Test
    public void testCase_004() {
        assertEquals(getInstanceCount(), 0);
        initMocks(this);
        assertEquals(getInstanceCount(), 1);
        new PersonController(personService);
        assertEquals(getInstanceCount(), 2);
    }

    @Test
    public void testCase_005() {
        initMocks(this);
        when(personService.getAllPersons()).thenReturn(new ArrayList<>());
        assertEquals(personController.getAllPersons().size(), 0);
    }

    @Test
    public void testCase_006() {
        initMocks(this);
        when(personService.getAllPersons()).thenReturn(new ArrayList<>());
        verify(personService, times(0)).getAllPersons();
        assertEquals(personController.getAllPersons().size(), 0);
        verify(personService).getAllPersons();
    }

    @Test
    public void testCase_007() {
        PersonService personService = mock(PersonService.class);
        assertEquals(getInstanceCount(), 0);
        new PersonController(personService);
        assertEquals(getInstanceCount(), 1);
        new PersonController(personService);
        assertEquals(getInstanceCount(), 2);
    }

    @Test
    public void testCase_008() {
        PersonService personService = new PersonServiceImpl();
        assertEquals(personService.getAllPersons().size(), 0);
        personService.addPerson(new Person("123456", "张三"));
        assertEquals(personService.getAllPersons().size(), 1);
    }

}
