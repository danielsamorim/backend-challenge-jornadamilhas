CREATE TABLE testimonial (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    text TEXT NOT NULL,
    photo VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL
);

