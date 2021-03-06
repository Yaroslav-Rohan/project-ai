package com.project.Band_Search.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "genres", "hibernateLazyInitializer", "handler", "primarySkills"})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String postHeader;
    @NotNull
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private User user;

    private Long user_top_id;
    // Тупо єбані чекбокси

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_genres",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    Set<Genre> genres = new HashSet<>(); // ManyToMany

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_primary_skills",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "primary_skill_id"))
    Set<PrimarySkill> primarySkills = new HashSet<>(); // ManyToMany (Amateur, Beginner, Advanced...)

    private String location;

    private String mainPhoto;
    //private Set<String> photos;

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public Post(@NotNull String postHeader, @NotNull String description, String location) {
        this.postHeader = postHeader;
        this.description = description;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Доробити upload files зі збереженням в шляхів у бд (самі файли зберігати у внутрішньо проектній папці)

    public Post() {
    }

    public Post(@NotNull String postHeader, @NotNull String description) {
        this.postHeader = postHeader;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getPostHeader() {
        return postHeader;
    }

    public void setPostHeader(String postHeader) {
        this.postHeader = postHeader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<PrimarySkill> getPrimarySkills() {
        return primarySkills;
    }

    public void setPrimarySkills(Set<PrimarySkill> primarySkills) {
        this.primarySkills = primarySkills;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.user_top_id = user.getId();
    }

    public Long getUser_top_id() {
        return user_top_id;
    }

    public void setUser_top_id(Long user_id) {
        this.user_top_id = user_id;
    }
}