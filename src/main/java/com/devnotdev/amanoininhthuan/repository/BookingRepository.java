package com.devnotdev.amanoininhthuan.repository;

import com.devnotdev.amanoininhthuan.model.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookedRoom, Long> {
    BookedRoom findByConfirmationCode(String confirmationCode);
}
