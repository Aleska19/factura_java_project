DROP DATABASE IF EXISTS invoice_coder;
CREATE DATABASE invoice_coder;
USE invoice_coder;

CREATE TABLE clients(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(75) NOT NULL,
    lastname VARCHAR(75) NOT NULL,
    docnumber VARCHAR(11) UNIQUE NOT NULL
);

CREATE TABLE products(
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(150) NOT NULL,
    code VARCHAR(50) UNIQUE NOT NULL,
    stock INT NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE invoice(
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id BIGINT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE
);

CREATE TABLE invoice_details(
    id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_id INT,
    product_id INT,
    amount INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoice(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);