CREATE TABLE testimonial (
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    testimonial TEXT NOT NULL,
    photoPath VARCHAR(255),
    active BOOLEAN NOT NULL
);
