package com.tanita.petme.eazybank.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bankme/contact")
public class ContactController {

    @GetMapping()
    public String get() {
        return "CONTACT PAGE";
    }

}
