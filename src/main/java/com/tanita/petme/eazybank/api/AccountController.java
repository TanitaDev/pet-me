package com.tanita.petme.eazybank.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bankme/account")
public class AccountController {

    @GetMapping()
    public String get() {
        return "ACCOUNT PAGE";
    }

}
