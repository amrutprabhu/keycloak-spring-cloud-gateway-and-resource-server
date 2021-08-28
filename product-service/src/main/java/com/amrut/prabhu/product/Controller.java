package com.amrut.prabhu.product;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class Controller {

    @GetMapping("/page")
    @RolesAllowed({"ROLE_realm_read"})
//    @PreAuthorize("hasAuthority('ROLE_NOTHING')")
    public String getPage(Principal principal){
        return "value";
    }
}
