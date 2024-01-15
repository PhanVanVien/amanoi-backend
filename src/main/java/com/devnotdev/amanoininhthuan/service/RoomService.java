package com.devnotdev.amanoininhthuan.service;

import com.devnotdev.amanoininhthuan.exception.ResourceNotFoundException;
import com.devnotdev.amanoininhthuan.model.Room;
import com.devnotdev.amanoininhthuan.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {
    private final RoomRepository roomRepository;

    @Override
    public Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws IOException, SQLException {
        Room room = new Room();
        if (!photo.isEmpty()) {
            byte[] photoBytes = photo.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes);
            room.setPhoto(photoBlob);
        }
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);

        return roomRepository.save(room);
    }

    @Override
    public List<String> getAllRoomTypes() {
        return roomRepository.findDistinctRoomTypes();
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void deleteRoomById(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            roomRepository.deleteById(roomId);
        }
    }

    @Override
    public byte[] getRoomPhotoById(Long id) throws ResourceNotFoundException, SQLException {
        Optional<Room> theRoom = roomRepository.findById(id);
        if (theRoom.isEmpty()) {
            throw new ResourceNotFoundException("Sorry, Room not found");
        }
        Blob photoBlob = theRoom.get().getPhoto();
        if (photoBlob != null) {
            return photoBlob.getBytes(1, (int) photoBlob.length());
        }
        return null;
    }

    @Override
    public Room updateRoom(Long roomId, String roomType, BigDecimal roomPrice, Blob photoBlob) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        if (roomType != null) room.setRoomType(roomType);
        if (roomPrice != null) room.setRoomPrice(roomPrice);
        if (photoBlob != null) room.setPhoto(photoBlob);
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> getRoomById(Long id) {
        return Optional.of(roomRepository.findById(id).get());
    }

    @Override
    public List<Room> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
        return roomRepository.findAvailableRoomsByDateAndType(checkInDate, checkOutDate, roomType);
    }


}
