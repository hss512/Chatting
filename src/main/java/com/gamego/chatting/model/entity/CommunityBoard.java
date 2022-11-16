package com.gamego.chatting.model.entity;

import com.gamego.chatting.model.dto.board.ResponseBoardDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CommunityBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_board_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    @Column(name = "imgUrl")
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardType_id")
    private BoardType boardType;

    @Builder.Default
    @OneToMany(mappedBy = "communityBoard",cascade = CascadeType.ALL)
    private List<Likes> likes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "communityBoard",cascade = CascadeType.ALL)
    private List<Unlike> unlike = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "communityBoard",cascade = CascadeType.ALL)
    private List<Reply> replyList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "communityBoard",cascade = CascadeType.ALL)
    private List<Images> imageList = new ArrayList<>();

    public ResponseBoardDTO toDTO(){
        return ResponseBoardDTO.builder()
                .boardId(this.id)
                .title(this.title)
                .contents(this.contents)
                .category(this.category.getTitle())
                .type(this.boardType.getTitle())
                .likes(this.likes.stream().map(Likes::toDTO).collect(Collectors.toList()))
                .unlike(this.unlike.stream().map(Unlike::toDTO).collect(Collectors.toList()))
                .replyList(this.replyList.stream().map(Reply::toDTO).collect(Collectors.toList()))
                .imageList(this.imageList.stream().map(Images::toDTO).collect(Collectors.toList()))
                .memberDTO(this.member.toDTO())
                .createdDate(this.createdDate)
                .lastModifiedDate(this.lastModifiedDate)
                .build();
    }

    public CommunityBoard update(String title, String contents, Category category, BoardType type){
        this.title = title;
        this.contents = contents;
        this.category = category;
        this.boardType = type;

        return this;
    }

    public void insertImage(Images img){
        this.imageList.add(img);
    }

    public ResponseBoardDTO toResponseDTO(Member member) {
        return ResponseBoardDTO.builder()
                .boardId(this.id)
                .title(this.title)
                .contents(this.contents)
                .category(this.category.getTitle())
                .type(this.boardType.getTitle())
                .likes(this.likes.stream().map(Likes::toDTO).collect(Collectors.toList()))
                .unlike(this.unlike.stream().map(Unlike::toDTO).collect(Collectors.toList()))
                .replyList(this.replyList.stream().map(Reply::toDTO).collect(Collectors.toList()))
                .imageList(this.imageList.stream().map(Images::toDTO).collect(Collectors.toList()))
                .memberDTO(member.toDTO())
                .createdDate(this.createdDate)
                .lastModifiedDate(this.lastModifiedDate)
                .build();
    }
}
