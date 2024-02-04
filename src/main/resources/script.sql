insert into amanoininhthuan.role (name) values ("ROLE_ADMIN");
select * from amanoininhthuan.user;
select * from amanoininhthuan.role;
drop schema amanoininhthuan;
create schema amanoininhthuan;
select * from amanoininhthuan.user;
select * from amanoininhthuan.booked_room where amanoininhthuan.booked_room.user_email="admin@gmail.com";

CREATE TABLE user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);

CREATE TABLE role (
    role_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE user_roles (
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

CREATE TABLE room (
    room_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_type VARCHAR(255),
    room_price DECIMAL(10, 2),
    is_booked BOOLEAN,
    photo LONGBLOB
);

CREATE TABLE booked_room (
    booking_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    check_in_date DATE,
    check_out_date DATE,
    guest_full_name VARCHAR(255),
    guest_email VARCHAR(255),
    num_of_adults INT,
    num_of_children INT,
    total_num_of_guest INT,
    confirmation_code VARCHAR(255),
    room_id BIGINT,
    user_email VARCHAR(255),
    FOREIGN KEY (room_id) REFERENCES room(room_id),
    FOREIGN KEY (user_email) REFERENCES user(email)
);