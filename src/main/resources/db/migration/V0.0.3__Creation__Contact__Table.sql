CREATE TABLE contact_entity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    numero_telephone VARCHAR(255),
    subject VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    status_id BIGINT,
    creation_date DATETIME DEFAULT NULL,
    modification_date DATETIME DEFAULT NULL,
    FOREIGN KEY (status_id) REFERENCES status_entity(id)
);
