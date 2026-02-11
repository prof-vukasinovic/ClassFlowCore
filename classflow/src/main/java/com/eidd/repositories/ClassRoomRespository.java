package com.eidd.repositories;
import java.util.ArrayList;
import java.util.List;

import com.eidd.model.ClassRoom;

public class ClassRoomRespository {
    private List<ClassRoom> classRooms;
    private static long idCounter = 0;
    public ClassRoomRespository() {
        this.classRooms = new ArrayList<>();
    }

    public void addClassRoom(ClassRoom classRoom) {
        classRooms.add(classRoom);
    }

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }
    public ClassRoom getClassRoomById(long id) {
        for (ClassRoom classRoom : classRooms) {
            if (classRoom.getId() == id) {
                return classRoom;
            }
        }
        return null;
    }
    public static long getCounter() {
        return idCounter;
    }
    public static void incrementCounter() {
        idCounter++;
    }
    public static void resetCounter() {
        idCounter = 0;
    }
}
