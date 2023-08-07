package com.productoappdistri2.productoappdistri2.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {
    @Value("TEST-90769cee-e01e-4067-93b4-ea9edb9c77d6")
    private String mercadoPagoSamplePublicKey;

    @GetMapping("/pagoweb")
    public String renderMainPage(Model model) {
        model.addAttribute("publicKey", mercadoPagoSamplePublicKey);
        return "pago/pagoWeb";
    }
}