package com.business.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/home")
    public String homePage() {
        return "Home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "About";
    }

    @GetMapping("/location")
    public String locationPage() {
        return "Locate_us";
    }

    // ❌ REMOVED this method to avoid conflict with productController
    // @GetMapping("/products")
    // public String productsPage() {
    //     return "Products";
    // }

    @GetMapping("/products/selected")
    public String productSelectedPage() {
        return "Product_Selected";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "Login";
    }

    @GetMapping("/exception")
    public String exceptionPage() {
        return "Exception";
    }
    @GetMapping("/services")
public String servicesPage() {
    return "Services";
}

}
