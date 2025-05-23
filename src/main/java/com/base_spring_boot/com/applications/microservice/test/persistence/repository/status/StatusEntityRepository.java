package com.base_spring_boot.com.applications.microservice.test.persistence.repository.status;

import com.base_spring_boot.com.applications.microservice.test.persistence.model.status.StatusEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusEntityRepository extends org.springframework.data.jpa.repository.JpaRepository<StatusEntity, Integer> {
}
