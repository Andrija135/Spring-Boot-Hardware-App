DELETE
FROM hardware;

INSERT INTO hardware (code, name, price, type, nrAvailable)
VALUES ('KG23JH4G23K4', 'Intel Pentium', 100.00, 'CPU', 10),
       ('45K6K45HJ6GK', 'RTX 2060', 2500.00, 'GPU', 3),
       ('H6GF4H5GF6JH', 'ASUS ZEPHYRUS', 15000.00, 'OTHER', 5)
