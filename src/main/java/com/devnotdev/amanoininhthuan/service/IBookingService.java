package com.devnotdev.amanoininhthuan.service;

import com.devnotdev.amanoininhthuan.model.BookedRoom;

import java.util.List;

public interface IBookingService {
    List<BookedRoom> getAllBookings();

    BookedRoom findByBookingConfirmationCode(String confirmationCode);

    void cancelBooking(Long bookingId);

    String saveBooking(Long roomId, String email, BookedRoom bookingRequest);

//    List<BookedRoom> getBookingsByUserId(Long userId);
}
