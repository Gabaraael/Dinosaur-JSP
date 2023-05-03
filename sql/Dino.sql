CREATE TABLE Dinosauria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    specie VARCHAR(50) NOT NULL,
    diet VARCHAR(20) NOT NULL,
    habitat VARCHAR(50) NOT NULL,
    period VARCHAR(50) NOT NULL,
    length_meters DECIMAL(4,2) NULL,
    weight_kilograms DECIMAL(5,2) NULL,
    top_speed_kph INT,
    description TEXT,
    image_url VARCHAR(200)
);
