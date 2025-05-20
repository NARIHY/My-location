package com.base_spring_boot.com.applications.microservice.contacts.controller;

import com.base_spring_boot.com.applications.base.controller.ControllerBase;
import com.base_spring_boot.com.applications.base.service.Service;
import com.base_spring_boot.com.applications.base.utils.filter.JsonModelFilter;
import com.base_spring_boot.com.applications.microservice.contacts.persistence.models.ContactEntity;
import com.base_spring_boot.com.applications.microservice.contacts.service.ContactService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController extends ControllerBase<ContactEntity> {
    public ContactController(ContactService serviceBase, JsonModelFilter jsonModelFilter) {
        super(serviceBase, jsonModelFilter);
    }

    @Override
    protected Service<ContactEntity> getService() {
        return serviceBase;
    }

    @Override
    protected Set<String> getDefaultFilter() {
        return Set.of(
                "id",
                "firstname",
                "lastname",
                "phone",
                "email",
                "subject",
                "message",
                "status.id",
                "status.statusName",
                "creationDate",
                "modificationDate"
        );
    }
}
