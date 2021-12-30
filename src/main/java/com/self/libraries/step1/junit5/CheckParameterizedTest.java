package com.self.libraries.step1.junit5;

/*
Junit 4 does not has support for java8 features.
Junit 4 has a single fat jar file.(no separation of concerns)
Runners are used to support extra functionality

1. Junit Jupiter(to write junit 5 testcases) , Junit Vintage(junit 3 and 4 support), Junit platform are components of Junit5
 */
public class CheckParameterizedTest {

    public boolean isEven(int number){
        return number%2==0;
    }

    public String reverse(String input){
        if(input==null || "".equals(input)){
            return input;
        }
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
}
