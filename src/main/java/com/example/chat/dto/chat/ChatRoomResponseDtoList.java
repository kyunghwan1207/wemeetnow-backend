package com.example.chat.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomResponseDtoList {
    List<ChatRoomResponseDto> chatRoomDtoList;
}
