package com.business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.business.entities.Admin;
import com.business.entities.Product;
import com.business.entities.User;
import com.business.loginCredentials.AdminLogin;
import com.business.services.AdminService;
import com.business.services.ProductService;
import com.business.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    // Admin Login
    @PostMapping("/login")
    public String login(@ModelAttribute("adminLogin") AdminLogin login, Model model) {
        if (adminService.validateAdminCredentials(login.getEmail(), login.getPassword())) {
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "Login";
        }
    }

    // Admin Dashboard with all data
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("admins", adminService.getAll());
        model.addAttribute("users", userService.getAllUser());
        model.addAttribute("products", productService.getAllProducts());
        return "Admin_Page";
    }

    // ----------------- Admin CRUD -----------------

    @GetMapping("/add-admin")
    public String showAddAdminForm() {
        return "Add_Admin";
    }

    @PostMapping("/add-admin")
    public String addAdmin(@ModelAttribute Admin admin) {
        adminService.addAdmin(admin);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/update-admin/{adminId}")
    public String showUpdateAdminForm(@PathVariable int adminId, Model model) {
        model.addAttribute("admin", adminService.getAdmin(adminId));
        return "Update_Admin";
    }

    @PostMapping("/update-admin/{adminId}")
    public String updateAdmin(@ModelAttribute Admin admin, @PathVariable int adminId) {
        adminService.updateAdmin(admin, adminId);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/delete-admin/{adminId}")
    public String deleteAdmin(@PathVariable int adminId) {
        adminService.delete(adminId);
        return "redirect:/admin/dashboard";
    }

    // ----------------- User CRUD -----------------

    @GetMapping("/add-user")
    public String showAddUserForm() {
        return "Add_User";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/update-user/{userId}")
    public String showUpdateUserForm(@PathVariable int userId, Model model) {
        model.addAttribute("user", userService.getUser(userId));
        return "Update_User";
    }

    @PostMapping("/update-user/{userId}")
    public String updateUser(@ModelAttribute User user, @PathVariable int userId) {
        userService.updateUser(user, userId);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/delete-user/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return "redirect:/admin/dashboard";
    }

    // ----------------- Product CRUD -----------------

    @GetMapping("/add-product")
    public String showAddProductForm() {
        return "Add_Product";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute int product) {
        productService.addProduct(product);
        return "redirect:/admin/dashboard";
    }

    /**
     * @param productId
     * @param model
     * @return
     */
    @GetMapping("/update-product/{productId}")
    public String showUpdateProductForm(@PathVariable Product productId, Model model) {
        model.addAttribute("product");
        return "Update_Product";
    }

    @PostMapping("/update-product/{productId}")
    public String updateProduct(@ModelAttribute Product product, @PathVariable int productId) {
        productService.updateProduct(product, productId);
        return "redirect:/admin/dashboard";
    }

    /**
     * @param productId
     * @return
     */
    @GetMapping("/delete-product/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        productService.addProduct(productId);
        return "redirect:/admin/dashboard";
    }
}
