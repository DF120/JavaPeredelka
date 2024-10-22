package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Setter;
import lombok.Getter;


@Setter
@Getter
@Entity
public class Theater {
    private Long id;
    private String performanceName;
    private String actorCollective;
    private LocalDateTime performanceDateTime;
    private String totalTickets;
    private String availableTickets;

    protected Theater() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "theater [id=" + id + ", performanceName=" + performanceName + ", actorCollective=" + actorCollective + ", performanceDateTime=" + performanceDateTime + ", totalTickets=" + totalTickets + ", availableTickets=" + availableTickets +"]";
    }
}
