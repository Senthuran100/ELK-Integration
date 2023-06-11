package com.elk.elkstackintegration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ELKController {

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id) {
        log.info("Request getUser with the id : {}",id);

        if (id == 1 || id == 2) {
            log.info("Admin User has invoked");
            return "Admin";
        }
        log.info("Normal User has invoked");
        return "User";
    }


}
