package ru.gb;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class Student {

    private static long idCounter = 1L;

    private long id;
    private final String name;
    private String groupName;

    public Student(String name, String groupName) {
        this.id = idCounter++;
        this.name = name;
        this.groupName = groupName;
    }

    @JsonCreator
    public Student(Long id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }
}
