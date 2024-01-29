package com.devnotdev.amanoininhthuan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked = false;
    @Lob
    private Blob photo;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;

    public Room(String roomType, BigDecimal roomPrice, Blob photo) {
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.photo = photo;
    }

    public BookedRoom addBooking(BookedRoom booking) {
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        String bookingCode = RandomStringUtils.randomNumeric(10);
        booking.setRoom(this);
        booking.setConfirmationCode(bookingCode);
        isBooked = true;
        bookings.add(booking);
        return booking;
    }
}
