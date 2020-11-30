package com.project.Band_Search;

import com.project.Band_Search.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Execute implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Execute.class, args);
    }

    @Autowired
    private UserRepository userRep;

    @Override
    public void run(String... args) throws Exception {
       // this.userRep.deleteAllInBatch();
      //  this.userRep.save(new User( "Andriy", "01010", "mmm", "email@.com"));
     //   this.userRep.save(new User( "Asd", "FFF", "6456", "aad@.com"));
    }
}

