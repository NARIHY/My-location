package com.base_spring_boot.com.applications.microservice.contacts.service;

import com.base_spring_boot.com.applications.base.repository.criteria.CriteriaRepository;
import com.base_spring_boot.com.applications.base.service.ServiceBase;
import com.base_spring_boot.com.applications.microservice.contacts.persistence.models.ContactEntity;
import com.base_spring_boot.com.applications.microservice.contacts.persistence.repository.ContactRepository;
import com.base_spring_boot.com.applications.microservice.contacts.persistence.repository.criteria.ContactCriteriaRepository;
import com.base_spring_boot.com.applications.microservice.test.persistence.repository.status.StatusEntityRepository;
import com.base_spring_boot.com.security.service.OpenIdService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService extends ServiceBase<ContactEntity> {
    private final ContactRepository contactRepository;
    private final ContactCriteriaRepository contactCriteriaRepository;
    public ContactService(OpenIdService openIdService,
                          StatusEntityRepository statusEntityRepository,
                          ContactCriteriaRepository contactCriteriaRepository,
                          ContactRepository contactRepository) {
        super(openIdService, statusEntityRepository);
        this.contactRepository = contactRepository;
        this.contactCriteriaRepository = contactCriteriaRepository;
    }

    @Override
    protected ContactRepository getRepository() {
        return this.contactRepository;
    }

    @Override
    protected ContactCriteriaRepository getCriteriaRepository() {
        return this.contactCriteriaRepository;
    }

    @Override
    protected ContactEntity processCreate(ContactEntity contactPosting) {
        ContactEntity newContact = new ContactEntity();
        newContact.setFirstname(contactPosting.getFirstname());
        newContact.setLastName(contactPosting.getLastName());
        newContact.setEmail(contactPosting.getEmail());
        newContact.setPhone(contactPosting.getPhone());
        newContact.setSubject(contactPosting.getSubject());
        newContact.setMessage(contactPosting.getMessage());
        newContact.setCreationDate(generateDate());
        newContact.setModificationDate(generateDate());
        return newContact;
    }

    @Override
    protected ContactEntity processUpdate(ContactEntity entity, Integer id) {
        return null;
    }

    @Override
    protected void processRemove(ContactEntity entity) {

    }

    @Override
    public boolean canCreate() {
        return true;
    }

    @Override
    public boolean canUpdate(Integer id) {
        return openIdService.isAdmin();
    }

    @Override
    public boolean canQuery() {
        return openIdService.isAdmin();
    }

    @Override
    public boolean canQueryOne(Integer id) {
        return openIdService.isAdmin();
    }

    @Override
    public boolean canRemove(Integer id) {
        return super.canRemove(id);
    }
}
