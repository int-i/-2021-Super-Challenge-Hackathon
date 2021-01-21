package inti.SAhomepage.Board.domain.entity;

//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Getter
@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) // JPA에게 해당 Entity는 Audit
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length=10, nullable = false)
    private String author;

    @Column(length=100,nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private Long fileId;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getFileId() {
        return fileId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
//    @Builder
//    public Board(Long id, String author, String title, String content){
//        this.id = id;
//        this.author = author;
//        this.title = title;
//        this.content = content;
//        this.fileId = fileId;
//    }

    public static class Builder{
        private Long id;
        private String author;
        private String title;
        private String content;
        private Long fileId;

        public Builder(Long id, String author, String title, String content, Long fileId){
            this.id = id;
            this.author = author;
            this.title = title;
            this.content = content;
            this.fileId = fileId;
        }
        public Board build(){
            return new Board(this);
        }
    }
    private Board(Builder builder){
        id = builder.id;
        author = builder.author;
        title = builder.title;
        content = builder.content;
        fileId = builder.fileId;
    }
}
