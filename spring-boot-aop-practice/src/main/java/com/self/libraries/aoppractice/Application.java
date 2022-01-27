package com.self.libraries.aoppractice;

import com.self.libraries.aoppractice.entities.Circle;
import com.self.libraries.aoppractice.entities.Triangle;
import com.self.libraries.aoppractice.services.ShapeService;
import com.self.libraries.aoppractice.services.TestService;
import com.self.libraries.aoppractice.services.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sound.midi.Track;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private ShapeService shapeService;

    @Autowired
    private Circle circle;

    @Autowired
    private Triangle triangle;

    @Autowired
    private TestService testService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
//        circle.setName("circle");
//        triangle.setName("triangle");
        System.out.println(shapeService.getCircle());
//        shapeService.getCircle().setAbc();
//        TestServiceImpl testService = new TestServiceImpl();
//        testService.test();
    }
}
