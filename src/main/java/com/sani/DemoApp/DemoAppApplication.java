package com.sani.DemoApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import javax.management.Query;
import java.beans.BeanProperty;
import java.beans.JavaBean;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class DemoAppApplication {
        public static void main(String[] args) {
            SpringApplication.run(DemoAppApplication.class, args);
        }

    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
        return args -> {

            Address address;
            address = new Address(

                    "England",
                    "London",
                    "NE9"

            );
            Student student;
            student = new Student(
                    "Jamila",
                    "Ahmed",
                    "jahmed@gmail.com",
                    Gender.FEMMALE,
                    address,
                    List.of("Computer Science", "Maths"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

			org.springframework.data.mongodb.core.query.Query query = new org.springframework.data.mongodb.core.query.Query();

			query.addCriteria(Criteria.where("email").is("jahmed@gmail.com"));





			List<Student> students = mongoTemplate.find(query, Student.class);

			if(students.size() > 1) {
				throw new IllegalAccessException("found many students with email " +"jahmed@gmail.com");
			}
			if(students.isEmpty()) {
				System.out.println("Inserting new student"+ student);
				repository.insert(student);
			}
			else {
				System.out.println( student + "Student already exists");
			}




        };
    }

}


