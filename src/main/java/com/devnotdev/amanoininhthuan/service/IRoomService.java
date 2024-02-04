package com.devnotdev.amanoininhthuan.service;

import com.devnotdev.amanoininhthuan.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IRoomService {
    Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws IOException, SQLException;

    List<String> getAllRoomTypes();

    List<Room> getAllRooms();

    void deleteRoomById(Long roomId);

    byte[] getRoomPhotoById(Long id) throws SQLException;

    Room updateRoom(Long roomId, String roomType, BigDecimal roomPrice, Blob photoBlob);

    Optional<Room> getRoomById(Long id);

    List<Room> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, String roomType);

    Page<Room> getRooms(int page, int size);

    Page<Room> getRoomsByRoomType(int page, int size, String roomType);
}
