package com.example.chat.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ChatRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private Long id;
    private String roomName;
    private int totalNum;
    private LocalDateTime lastMessageTime;
    @JsonIgnore
    @OneToMany(mappedBy = "chatRoom")
    private final List<Chat> chatList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "chatRoom")
    private final List<ChatParticipant> chatParticipants = new ArrayList<>();


    public static ChatRoom save(ChatRoomRequest chatRoomRequest, Bucketlist bucketlist) {
        return ChatRoom.builder()
                .roomName(chatRoomRequest.getRoomName())
                .bucketlist(bucketlist)
                .totalNum(chatRoomRequest.getTotalNum())
                .lastMessageTime(LocalDateTime.now())
                .build();
    }

    public static ChatRoom messageTimeUpdate(ChatRoom chatRoom) {
        return chatRoom.builder()
                .lastMessageTime(LocalDateTime.now())
                .build();
    }
}

