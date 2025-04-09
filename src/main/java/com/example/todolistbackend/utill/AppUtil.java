package com.example.todolistbackend.utill;

import java.util.UUID;

public class AppUtil {
    public static String generateTaskId(){
        return "T-"+ UUID.randomUUID();
    }
}
