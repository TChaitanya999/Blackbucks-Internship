package com.business.controllers;

import com.business.entities.Product;
import com.business.services.ProductService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class productController {

    @Autowired
    private ProductService productService;

    // 🟢 Show all products
    @GetMapping("/products")
    public String showProducts(Model model, HttpSession session) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        // For cart
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        return "Products";
    }

    // 🟢 Add to cart
    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") int productId, HttpSession session) {
        Product product = productService.getProductById(productId);

        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(product);
        session.setAttribute("cart", cart);
        return "redirect:/products";
    }

    // 🟢 View Cart
    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        model.addAttribute("cart", cart);
        return "Cart";
    }

    // 🟢 Confirm Order
    @PostMapping("/confirm-order")
    public String confirmOrder(HttpSession session, Model model) {
        session.removeAttribute("cart");
        model.addAttribute("message", "🎉 Order placed successfully!");
        return "Confirmation";
    }
}
