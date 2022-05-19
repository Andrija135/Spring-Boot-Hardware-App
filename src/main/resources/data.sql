DELETE
FROM hardware;
DELETE
FROM review;

INSERT INTO hardware (code, name, price, type, stock)
VALUES ('KG23JH4G23K4', 'Intel Pentium', 100.00, 'CPU', 10),
       ('45K6K45HJ6GK', 'RTX 2060', 2500.00, 'GPU', 3),
       ('H6GF4H5GF6JH', 'ASUS ZEPHYRUS', 15000.00, 'OTHER', 5),
       ('45K344567GK',  'PS5', 3500.00, 'OTHER', 5);


INSERT INTO review (title, text, rating, hardware_id)
VALUES ('Slow', 'Slowest thing ever', 1, 1),
       ('Just no. Avoid at all cost.', 'Old and not reliable', 2, 1),
       ('Very Good GPU', 'Good GPU',4, 2),
       ('Runs very smooth. I like it.', 'Everything is great',4, 2),
       ('Best Laptop I Ever had', 'Best laptop I ever had',5, 3),
       ('Best of', 'Top of the top',5, 3);


INSERT INTO user(id, username, password)
VALUES (1, 'user', '$2a$10$XPxWobjZUXcN.39pnS2XL.LUoTrkhpcxvxJOrA8zQai0wlb.GzKgS'),  ----> password = lozinkaUser
       (2, 'admin', '$2a$10$9Qnu74rUoVqxLNTuBNViAuy/4XX.G.2Hv1Rnm1rYEQD4SOc6/17su'); ----> password = lozinkaAdmin

INSERT INTO authority (id, authority_name)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

INSERT INTO user_authority (user_id, authority_id)
VALUES (1, 2),
       (2, 1);