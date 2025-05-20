package com.base_spring_boot.com.applications.microservice.contacts.persistence.repository;

import com.base_spring_boot.com.applications.microservice.contacts.persistence.models.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
}
