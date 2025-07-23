package com.skillsync.controller;

import com.skillsync.model.User;
import com.skillsync.repository.UserRepository;
import com.skillsync.service.UserService;

import jakarta.servlet.http.HttpSession;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    // Redirect root to dashboard
    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }

    // Show registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Register user and encode password
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Email already registered!");
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/login";
    }

    // Show login form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    @GetMapping("/career-suggestions")
    public String showCareerSuggestions(Model model) {
        return "career-suggestions";  // Make sure the template exists
    }
    @GetMapping("/career-detail/{role}")
    public String showCareerDetails(@PathVariable String role, Model model) {
        model.addAttribute("role", role);  // You can customize details based on role
        return "career-detail";
    }
    @GetMapping("/career-fullstack")
    public String fullstackCareerPage() {
        return "career-fullstack";
    }
    @GetMapping("/career-frontend")
    public String showFrontendDetails() {
        return "career-frontend";
    }
    @GetMapping("/career-backend")
    public String showBackendDetails() {
        return "career-backend";
    }
    @GetMapping("/career-software")
    public String showSoftwareDetails() {
        return "career-software";
    }
    @GetMapping("/career-data-analyst")
    public String dataAnalystRole() {
        return "career-data-analyst";
    }
    @GetMapping("/career-uiux")
    public String uiuxRole() {
        return "career-uiux";
    }
    @GetMapping("/career-cybersecurity")
    public String cybersecurityRole() {
        return "career-cybersecurity";
    }
    @GetMapping("/career-cloud-engineer")
    public String cloudEngineer() {
        return "career-cloud-engineer";
    }
    @GetMapping("/career-software-tester")
    public String softwareTester() {
        return "career-software-tester";
    }
    @GetMapping("/career-digital-marketer")
    public String digitalMarketer() {
        return "career-digital-marketer";
    }
    @GetMapping("/career-mobile-developer")
    public String mobileDeveloper() {
        return "career-mobile-developer";
    }
    @GetMapping("/career-ai-ml")
    public String aiMlEngineer() {
        return "career-ai-ml";
    }
    @GetMapping("/career-tech-support")
    public String techSupport() {
        return "career-tech-support";
    }
    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal) {
        String email = principal.getName(); // logged-in user's email
        User user = userRepository.findByEmail(email);

        model.addAttribute("user", user);
        return "profile"; // this must match profile.html
    }
    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute("user") User updatedUser, Model model) {
        User existingUser = userRepository.findByEmail(updatedUser.getEmail());

        if (existingUser != null) {
            // Update interest
            existingUser.setInterests(updatedUser.getInterests());
            userRepository.save(existingUser);

            // Redirect based on selected interest
            String interest = updatedUser.getInterests();

            switch (interest) {
                case "Full Stack Web Developer":
                    return "redirect:/role-fullstack";
                case "Frontend Developer":
                    return "redirect:/role-frontend";
                case "Backend Developer":
                    return "redirect:/role-backend";
                case "Software Developer":
                    return "redirect:/role-software";
                case "Data Analyst":
                    return "redirect:/role-data-analyst";
                case "UI/UX Designer":
                    return "redirect:/role-uiux";
                case "Cybersecurity Analyst":
                    return "redirect:/role-cybersecurity";
                case "Cloud Engineer":
                    return "redirect:/role-cloud";
                case "Software Tester / QA":
                    return "redirect:/role-tester";
                case "Digital Marketer":
                    return "redirect:/role-marketer";
                case "Mobile App Developer":
                    return "redirect:/role-mobile";
                case "AI/ML Engineer":
                    return "redirect:/role-ai";
                case "Technical Support":
                    return "redirect:/role-support";
                default:
                    return "redirect:/profile";  // fallback
            }
        }

        return "redirect:/profile";  // fallback in case user not found
    }
    @GetMapping("/role-fullstack")
    public String showFullStackPage() {
        return "role-fullstack";
    }

    @GetMapping("/role-frontend")
    public String showFrontendPage() {
        return "role-frontend";
    }

    @GetMapping("/role-backend")
    public String showBackendPage() {
        return "role-backend";
    }

    @GetMapping("/role-software")
    public String showSoftwarePage() {
        return "role-software";
    }

    @GetMapping("/role-data-analyst")
    public String showDataAnalystPage() {
        return "role-data-analyst";
    }

    @GetMapping("/role-uiux")
    public String showUIUXPage() {
        return "role-uiux";
    }

    @GetMapping("/role-cybersecurity")
    public String showCyberPage() {
        return "role-cybersecurity";
    }

    @GetMapping("/role-cloud")
    public String showCloudPage() {
        return "role-cloud";
    }

    @GetMapping("/role-tester")
    public String showTesterPage() {
        return "role-tester";
    }

    @GetMapping("/role-marketer")
    public String showMarketerPage() {
        return "role-marketer";
    }

    @GetMapping("/role-mobile")
    public String showMobilePage() {
        return "role-mobile";
    }

    @GetMapping("/role-ai")
    public String showAIPage() {
        return "role-ai";
    }

    @GetMapping("/role-support")
    public String showSupportPage() {
        return "role-support";
    }


}
