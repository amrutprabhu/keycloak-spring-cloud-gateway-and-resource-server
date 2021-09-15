package com.amrut.prabhu.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class Controller {

    @GetMapping("/product")
    @RolesAllowed({"product_read"})
    public String getProduct(Principal principal) {
        return "Response from Product Service, User Id:" + principal.getName();
    }
}
