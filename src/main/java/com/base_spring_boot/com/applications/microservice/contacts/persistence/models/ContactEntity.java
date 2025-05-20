package com.base_spring_boot.com.applications.microservice.contacts.persistence.models;

import com.base_spring_boot.com.applications.microservice.test.persistence.model.status.StatusEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="firstname", nullable = false)
    @NotBlank(message = "Le nom ne peut pas être vide.")
    private String firstname;

    @Column(name="lastname", nullable = false)
    @NotBlank(message = "Le prénom ne peut pas être vide.")
    private String lastName;

    @Column(name= "email")
    private String email;

    @Column(name="numero_telephone")
    private String phone;

    @Column(name = "subject", nullable = false)
    @NotBlank(message = "Le sujet est obligatoire.")
    private String subject;

    @Column(name = "message", nullable = false)
    @NotBlank(message = "Le message ne peut pas être vide.")
    private String message;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private StatusEntity status;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name="modification_date")
    private LocalDateTime modificationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "Le nom ne peut pas être vide.") String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NotBlank(message = "Le nom ne peut pas être vide.") String firstname) {
        this.firstname = firstname;
    }

    public @NotBlank(message = "Le prénom ne peut pas être vide.") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Le prénom ne peut pas être vide.") String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Le sujet est obligatoire.") String getSubject() {
        return subject;
    }

    public void setSubject(@NotBlank(message = "Le sujet est obligatoire.") String subject) {
        this.subject = subject;
    }

    public @NotBlank(message = "Le message ne peut pas être vide.") String getMessage() {
        return message;
    }

    public void setMessage(@NotBlank(message = "Le message ne peut pas être vide.") String message) {
        this.message = message;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }
}
