package com.devnotdev.amanoininhthuan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomListResponse {
    private long total;
    private List<RoomResponse> rooms;
}
