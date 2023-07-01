package com.my.gym.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "The 'name' cannot be empty")
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "training_time")
    private int trainingTime;
    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(name = "price")
    @Min(0)
    private int price;
    @Column(name = "month")
    @Enumerated(EnumType.STRING)
    private Month month;
    @Column(name = "date")
    @Min(0)
    @Max(31)
    private int date;
    @Column(name = "time")
    @Min(0)
    @Max(24)
    private int time;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "workout")
    private List<Registration> registrations;

    public Workout() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public int getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public Month getMonth() {
        return month;
    }
    public static String getUkrainianLevel(String englishLevel) {
        switch (englishLevel.toUpperCase()) {
            case "BEGINNER":
                return "Початківець";
            case "INTERMEDIATE":
                return "Середній";
            case "ADVANCED":
                return "Просунутий";
            default:
                return "";
        }
    }

    public static String getUkrainianMonth(String englishMonth) {
        switch (englishMonth.toUpperCase()) {
            case "JANUARY":
                return "Січень";
            case "FEBRUARY":
                return "Лютий";
            case "MARCH":
                return "Березень";
            case "APRIL":
                return "Квітень";
            case "MAY":
                return "Травень";
            case "JUNE":
                return "Червень";
            case "JULY":
                return "Липень";
            case "AUGUST":
                return "Серпень";
            case "SEPTEMBER":
                return "Вересень";
            case "OCTOBER":
                return "Жовтень";
            case "NOVEMBER":
                return "Листопад";
            case "DECEMBER":
                return "Грудень";
            default:
                return "";
        }
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public Level getLevel() {
        return level;
    }

    public User getUser() {
        return user;
    }

    public void setTrainingTime(int trainingTime) {
        this.trainingTime = trainingTime;
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
