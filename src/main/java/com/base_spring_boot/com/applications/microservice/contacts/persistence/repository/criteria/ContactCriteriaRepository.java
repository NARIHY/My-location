package com.base_spring_boot.com.applications.microservice.contacts.persistence.repository.criteria;

import com.base_spring_boot.com.applications.base.repository.criteria.CriteriaRepository;
import com.base_spring_boot.com.applications.microservice.contacts.persistence.models.ContactEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ContactCriteriaRepository extends CriteriaRepository<ContactEntity> {
    public ContactCriteriaRepository(EntityManager em) {
        super(ContactEntity.class, em);
    }
}
