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