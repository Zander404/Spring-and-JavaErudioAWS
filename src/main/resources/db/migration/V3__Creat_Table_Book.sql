CREATE TABLE book
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    title       VARCHAR(180) NOT NULL,
    author      VARCHAR(180) NOT NULL,
    launch_date date         NOT NULL,
    price DOUBLE NOT NULL,
    CONSTRAINT pk_book PRIMARY KEY (id)
);