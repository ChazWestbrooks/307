package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model){
        Person person = new Person();
        person.setName("Chaz Westbrooks");
        person.setSsn("123-45-6789");

        Passport passport = new Passport();
        passport.setDate("06/26/13");

        person.setPassport(passport);

        personRepository.save(person);

        model.addAttribute("persons", personRepository.findAll());
        return "index";
    }
}
