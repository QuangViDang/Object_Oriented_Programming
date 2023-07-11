CREATE TABLE products (
    product_code VARCHAR(10) NOT NULL PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    location VARCHAR(50) NOT NULL,
    quantity INT NOT NULL
);