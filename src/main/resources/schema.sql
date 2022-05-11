CREATE TABLE IF NOT EXISTS hardware
(
    id             LONG PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(255)  NOT NULL,
    code           VARCHAR(100)  NOT NULL,
    price          DECIMAL(8, 2) NOT NULL,
    type           varchar(255)  NOT NULL,
    nrAvailable    INT           NOT NULL
);