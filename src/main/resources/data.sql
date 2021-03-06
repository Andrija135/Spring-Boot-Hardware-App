DELETE FROM review;
DELETE FROM hardware;

DELETE FROM user_authority;
DELETE FROM user;
DELETE FROM authority;

INSERT INTO hardware (code, name, price, type, stock)
VALUES ('KG23JH4G23K4', 'Intel Pentium', 100.00, 'CPU', 10),
       ('45K6K45HJ6GK', 'RTX 2060', 2500.00, 'GPU', 3),
       ('H6GF4H5GF6JH', 'ASUS ZEPHYRUS', 15000.00, 'OTHER', 5),
       ('45K344567GKT', 'PS5', 3500.00, 'OTHER', 5),
       ('3KL4J5LJHJKJ', 'Razer Mamba', 500.00, 'OTHER', 2),
       ('ZUITZ4MBVBM5', 'INTEL Core i9', 5600.00, 'CPU', 8),
       ('JKG54KJH3G5K', 'RTX 3080Ti', 19000.00, 'GPU', 3);


INSERT INTO review (title, text, rating, hardware_id)
VALUES ('Slow', 'Slowest thing ever', 1, 1),
       ('Just no. Avoid at all cost.', 'Old and not reliable', 2, 1),
       ('Very Good GPU', 'Good GPU', 4, 2),
       ('Runs very smooth. I like it.', 'Everything is great', 4, 2),
       ('Best Laptop I Ever had', 'Best laptop I ever had', 5, 3),
       ('Best of', 'Top of the top', 5, 3);


INSERT INTO user(id, username, password)
VALUES (1, 'user', '$2a$10$Hfyjzwb4.se.xi4ZN4LGNuDBnXUUrebC3isqULmmiM.MEDsphfqRa'), ----> password = user
       (2, 'admin', '$2a$10$n6WS00rlkoRB/w.rBlgg5egIXp17lcb4BqvXHIy8r0HKrd9WI6FZy'); ----> password = admin

INSERT INTO authority (id, authority_name)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

INSERT INTO user_authority (user_id, authority_id)
VALUES (1, 2),
       (2, 1);