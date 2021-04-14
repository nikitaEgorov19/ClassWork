package com.example.core;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class reper {
    static Map<String, Person> person = new Hashtable<>();

    static {
        person.put("Григорий", new Person("Григорий", "Иванов", "Сергеевич", 12021999, "ГИС", 0001));
        person.put("Константин", new Person("Григорий", "Меркунов", "Сергеевич", 12021999, "ГИС", 0001));
        person.put("Илья", new Person("Григорий", "Коноплев", "Сергеевич", 12021999, "ГИС", 0001));
        person.put("Никита", new Person("Григорий", "Гришин", "Сергеевич", 12021999, "ГИС", 0001));
        person.put("Василий", new Person("Григорий", "Егоров", "Сергеевич", 12021999, "ГИС", 0001));
    }
}
