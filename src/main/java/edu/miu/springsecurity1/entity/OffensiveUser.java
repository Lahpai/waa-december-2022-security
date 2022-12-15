package edu.miu.springsecurity1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class OffensiveUser {
    @Id
    private int id;

    private int offensiveCount;

    private LocalDateTime bannedUntil;

    private User user;

}