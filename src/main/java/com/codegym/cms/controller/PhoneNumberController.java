package com.codegym.cms.controller;

import com.codegym.cms.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PhoneNumberController {
    @GetMapping("/phone")
    public String showForm(Model model){
        model.addAttribute("phonenumber", new PhoneNumber());
        return "/phone/phone";
    }
    @PostMapping("/valid-phone")
    public String checkValidation (@Valid @ModelAttribute("phonenumber")PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/phone/phone";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber.getNumber());
            return "/phone/result";
        }
    }
}