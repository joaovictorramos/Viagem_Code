package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.DtoPassenger;
import com.example.demo.model.Passenger;
import com.example.demo.service.ServicePassenger;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControllerLogin {

    @Autowired
    private ServicePassenger servicePassenger;

    ModelAndView mv = new ModelAndView();
    Passenger loggedPassenger = new Passenger();

    @GetMapping("/")
    public ModelAndView login(HttpSession session){

        session.invalidate();
        mv.addObject("dtoPassenger", new DtoPassenger());
        mv.setViewName("login");
        
        return mv;
    }

    @PostMapping("/login")
    public String validationLogin(@Valid DtoPassenger dtoPassenger, BindingResult br, HttpSession session, Model model){
        mv.addObject("passenger", new Passenger());

        if(br.hasErrors()){
            return "login";
        }

        var passenger = servicePassenger.findByEmailPassengerAndPasswordPassenger(dtoPassenger.getEmailPassenger(), dtoPassenger.getPasswordPassenger());
        if(passenger == null){
            System.out.println("Null passenger");

            model.addAttribute("error", "Usuário não encontrado!");
            return "login";

        }else{
            session.setAttribute("passenger", passenger);
            loggedPassenger = passenger;

            System.out.println("Has passenger");
            return "home";
        }
    }

    @GetMapping("/cadastro")
    public ModelAndView register(){
        mv.addObject("passenger", new Passenger());
        mv.setViewName("cadastro");

        return mv;
    }

    @PostMapping("/registrationPassenger")
    public String registerPassenger(@Valid Passenger passenger, BindingResult br, Model model){
        mv.addObject("passenger", new Passenger());

        if(br.hasErrors()){
            return "cadastro";
        }

        String message = null;
        try {
            servicePassenger.save(passenger);

            message = "User register sucessfully!";
            model.addAttribute("message", message);
            
        } catch (Exception e) {
            message = "Error when registering!";

            model.addAttribute("message", message);
            e.printStackTrace();
        }

        return "cadastro";
    }

    @GetMapping("/perfil")
    public ModelAndView perfil(){
        mv.addObject("passenger", new Passenger());
        mv.setViewName("perfil");

        return mv;
    }
}
