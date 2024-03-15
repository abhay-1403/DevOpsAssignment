package com.example.springbootb.controller;
import com.example.springbootb.entity.Feedback;
import com.example.springbootb.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository; // Assuming you have a FeedbackRepository for database operations

    @GetMapping("/feedback")
    public String showFeedbackForm(Model model) {
        model.addAttribute("message", null); // Initialize message attribute
        return "feedback"; // Assuming feedback.html is placed in the appropriate directory
    }

    @PostMapping("/submitFeedback")
    public String submitFeedback(@RequestParam String name, @RequestParam String email, @RequestParam String message, Model model) {
        Feedback feedback = new Feedback(name, email, message);
        feedbackRepository.save(feedback); // Assuming Feedback is the entity class representing feedback
        model.addAttribute("message", "Feedback has been received. Thank you for your feedback"); // Set success message
        return "feedback"; // Assuming feedback.html is placed in the appropriate directory
    }
}

