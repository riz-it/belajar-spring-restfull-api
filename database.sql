USE belajar_spring

CREATE TABLE users (
    username         VARCHAR(100) not null,
    password         VARCHAR(100) not null,
    name             VARCHAR(100) not null,
    token            VARCHAR(100),
    token_expired_at BIGINT,
    primary key (username),
    unique (token)
) ENGINE InnoDB;

SELECT * FROM users;

DESC users;

CREATE TABLE contacts
(
    id         VARCHAR(100) NOT NULL,
    username   VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100),
    phone      VARCHAR(100),
    email      VARCHAR(100),
    PRIMARY KEY (id),
    FOREIGN KEY fk_users_contacts (username) REFERENCES users (username)
) ENGINE InnoDB;

SELECT * FROM contacts;

DESC contacts;

CREATE TABLE addresses
(
    id          VARCHAR(100) NOT NULL,
    contact_id  VARCHAR(100) NOT NULL,
    street      VARCHAR(200),
    city        VARCHAR(100),
    province    VARCHAR(100),
    country     VARCHAR(100) NOT NULL,
    postal_code VARCHAR(10),
    PRIMARY KEY (id),
    FOREIGN KEY fk_contacts_addresses (contact_id) REFERENCES contacts (id)
) ENGINE InnoDB;

SELECT * FROM addresses;

DESC addresses;