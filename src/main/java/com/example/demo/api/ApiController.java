package com.example.demo.api;

import com.example.demo.data.User;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class ApiController {

     @Autowired
     DataService dataService;

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

     @QueryMapping
     public Boolean register(
             @Argument PrivateUser user) {
         User registeredUser = dataService.registerUser(
                 user.name(),
                 user.displayName(),
                 user.password());
         return registeredUser != null;
     }

     @QueryMapping
     public Boolean login(
             @Argument String username,
             @Argument String password) {
         return dataService.isValidAuth(username, password);
     }

     @QueryMapping
     public Schedule createSchedule(
             @Argument String title,
             @Argument String description,
             @Argument Long userId,
             @Argument LocalDate start,
             @Argument LocalDate end) {
         var createdSchedule = dataService.createSchedule(
                 title,
                 description,
                 userId,
                 start,
                 end);
         return new Schedule(createdSchedule);
     }

     @QueryMapping
     public Schedule getSchedule(
             @Argument Long scheduleId) {
         var schedule = dataService.getSchedule(scheduleId);
         return new Schedule(schedule);
     }

     @QueryMapping
     public Schedule writeSchedule(
             @Argument Long scheduleId,
             @Argument Availabilities availabilities
         ) {
         availabilities.dates().stream().forEach(aDate -> {
             dataService.writeSchedule(
                 scheduleId,
                 availabilities.createdBy().userId(),
                 aDate.date(),
                 aDate.status()
             );
         });
         return new Schedule(dataService.getSchedule(scheduleId));
     }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

    @SchemaMapping
    public PublicUser publicUser(Availabilities availabilities) {
        return PublicUser.getById(availabilities.createdBy().userId());
    }

}