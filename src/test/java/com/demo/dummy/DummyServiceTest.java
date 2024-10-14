package com.demo.dummy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DummyServiceTest {

    private static final String STUDENT_NAME_1 = "bob";

    private static final String STUDENT_NAME_2 = "jon";

    private static final String STUDENT_NAME_3 = "steve";

    private DummyService cut;

    @BeforeEach
    void setUp() {
        cut = new DummyService();
//        DummyService.listOfNames.add(STUDENT_NAME_1);
//        DummyService.listOfNames.add(STUDENT_NAME_2);
//        DummyService.listOfNames.add(STUDENT_NAME_3);
    }

    @AfterEach
    void tearDown() {
        DummyService.listOfNames.clear();
    }

    @Test
    void givenListWith3Names_whenGetListOfNames_thenReturn3Names() {
        // setup
        DummyService.listOfNames.add(STUDENT_NAME_1);
        DummyService.listOfNames.add(STUDENT_NAME_2);
        DummyService.listOfNames.add(STUDENT_NAME_3);

        // execute
        final List<String> actualListOfNames = cut.getListOfNames();

        // verify
        assertThat(actualListOfNames).hasSize(3)
            .contains(STUDENT_NAME_1, STUDENT_NAME_2, STUDENT_NAME_3);
    }

    @Test
    void givenListWith3Names_whenDeleteName_thenNameIsDeleted() {
        // setup
        DummyService.listOfNames.add(STUDENT_NAME_1);
        DummyService.listOfNames.add(STUDENT_NAME_2);
        DummyService.listOfNames.add(STUDENT_NAME_3);

        // execute
        cut.deleteName(STUDENT_NAME_1);

        // verify
        final List<String> actualListOfNames = DummyService.listOfNames;

        assertThat(actualListOfNames).hasSize(2)
            .contains(STUDENT_NAME_2, STUDENT_NAME_3)
            .doesNotContain(STUDENT_NAME_1);
    }
    
}
