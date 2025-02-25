CREATE TABLE person
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(80)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    address    VARCHAR(100) NOT NULL,
    gender     VARCHAR(6)   NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);