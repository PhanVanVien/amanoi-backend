package com.devnotdev.amanoininhthuan.repository;

import com.devnotdev.amanoininhthuan.model.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookedRoom, Long> {
    Optional<BookedRoom> findByConfirmationCode(String confirmationCode);

//    @Query("SELECT b FROM BookedRoom b WHERE b.roomId = :userId")
//    List<BookedRoom> findByUserId(Long userId);

    //    List<BookedRoom> findByUser_Id(Long userId);
//    @Query("SELECT br FROM BookedRoom br WHERE br.user_id = :userId")
    @Query("SELECT br FROM BookedRoom br WHERE br.user.userId = :userId")
    List<BookedRoom> findByUserId(Long userId);
}