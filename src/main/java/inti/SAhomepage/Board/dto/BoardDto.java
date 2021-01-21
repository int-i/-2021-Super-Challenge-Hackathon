package inti.SAhomepage.Board.dto;

import inti.SAhomepage.Board.domain.entity.Board;
import inti.SAhomepage.Board.domain.entity.File;
//import lombok.*;

import java.time.LocalDateTime;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Long fileId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Board toEntity(){
        Board build = new Board
                .Builder(id, author, title, content, fileId)
                .build();
        return build;
    }

//    @Builder
//    public BoardDto(Long id, String author, String title, String content, Long fileId, LocalDateTime createdDate, LocalDateTime modifiedDate){
//        this.id = id;
//        this.author = author;
//        this.title = title;
//        this.content = content;
//        this.fileId = fileId;
//        this.createdDate = createdDate;
//        this.modifiedDate = modifiedDate;
//    }
    public static class Builder{
        private Long id;
        private String author;
        private String title;
        private String content;
        private Long fileId;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

        public Builder(Long id, String author, String title, String content, Long fileId, LocalDateTime createdDate, LocalDateTime modifiedDate){
            this.id = id;
            this.author = author;
            this.title = title;
            this.content = content;
            this.fileId = fileId;
            this.createdDate = createdDate;
            this.modifiedDate = modifiedDate;
        }
        public BoardDto build(){
            return new BoardDto(this);
        }
    }
    private BoardDto(BoardDto.Builder builder){
        id = builder.id;
        author = builder.author;
        title = builder.title;
        content = builder.content;
        fileId = builder.fileId;
        createdDate = builder.createdDate;
        modifiedDate = builder.modifiedDate;
    }
}
