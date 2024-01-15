package com.devnotdev.amanoininhthuan.repository;

import com.devnotdev.amanoininhthuan.model.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookedRoom, Long> {
    Optional<BookedRoom> findByConfirmationCode(String confirmationCode);
}
