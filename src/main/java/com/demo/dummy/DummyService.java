package com.demo.dummy;

import java.util.ArrayList;
import java.util.List;

public class DummyService {

    static List<String> listOfNames = new ArrayList<>();

    public List<String> getListOfNames() {
        return listOfNames;
    }

    public void deleteName(final String name) {
        listOfNames.remove(name);
    }

}
