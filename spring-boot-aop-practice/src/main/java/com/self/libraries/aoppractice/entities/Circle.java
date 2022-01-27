package com.self.libraries.aoppractice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Circle {

    private String name;

    public void setAbc(){
        try {
            System.out.println("set abc");
            throw new RuntimeException("exc");
        }catch (Exception ex){
            System.out.println("catch");
            throw ex;
        } finally {
            System.out.println("finally");
        }
    }
}
