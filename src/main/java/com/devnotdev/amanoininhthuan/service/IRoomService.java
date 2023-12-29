package com.devnotdev.amanoininhthuan.service;

import com.devnotdev.amanoininhthuan.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
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
}
