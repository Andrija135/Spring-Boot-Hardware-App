CREATE TABLE IF NOT EXISTS hardware
(
    id       IDENTITY,
    name     VARCHAR(255)                                          NOT NULL,
    code     VARCHAR(100)                                          NOT NULL UNIQUE,
    price    DECIMAL(8, 2)                                         NOT NULL,
    type     ENUM ('CPU', 'GPU', 'MBO', 'RAM', 'STORAGE', 'OTHER') NOT NULL,
    stock    INT                                                   NOT NULL
);


CREATE TABLE IF NOT EXISTS review
(
    id          IDENTITY,
    title       VARCHAR(255) NOT NULL,
    text        TEXT         NOT NULL,
    rating      INT          NOT NULL,
    hardware_id INT          NOT NULL,
    FOREIGN KEY (hardware_id) REFERENCES hardware (id)
);