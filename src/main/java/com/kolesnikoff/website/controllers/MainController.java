package com.kolesnikoff.website.controllers;

import com.kolesnikoff.website.models.Message;
import com.kolesnikoff.website.repos.MessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    // private final String server_address = "192.168.4.46";
    // private final String server_address = "http://192.168.7.208";
    // private final String server_address = "http://192.168.0.52";
    private final String server_address = "http://176.125.128.180";

    @Autowired
    MessagesRepo messagesRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("server_address", server_address);
        return "index";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("server_address", server_address);
        return "contact";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("server_address", server_address);
        return "about";
    }

    @GetMapping("/details_start")
    public String detailsStart(Model model) {
        model.addAttribute("server_address", server_address);
        return "details_start";
    }

    @GetMapping("/details_optimal")
    public String detailsOptimal(Model model) {
        model.addAttribute("server_address", server_address);
        return "details_optimal";
    }

    @GetMapping("/details_max")
    public String detailsMax(Model model) {
        model.addAttribute("server_address", server_address);
        return "details_max";
    }


    @GetMapping("/admin")
    public String admin(Model model) {

        System.out.println("IN ADMIN");

        return "admin";
    }


    @PostMapping("/send")
    public String contactSend(@RequestParam String title,
                              @RequestParam String contacts,
                              @RequestParam String full_text, Model model) {

        System.out.println("IN SEND");

        model.addAttribute("server_address", server_address);

        Message message = null;

        if (!title.isEmpty() || !contacts.isEmpty() || !full_text.isEmpty()) {
            message = new Message(title, contacts, full_text);
        }

        if (message != null)
            messagesRepo.save(message);


        return "msg_sended";
    }

}



























