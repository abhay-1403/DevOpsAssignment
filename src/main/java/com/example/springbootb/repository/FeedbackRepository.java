package com.example.springbootb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootb.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
