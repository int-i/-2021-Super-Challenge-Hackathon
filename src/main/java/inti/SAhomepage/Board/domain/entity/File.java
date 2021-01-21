package inti.SAhomepage.Board.domain.entity;

//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Getter
@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File {

    public Long getId() {
        return id;
    }

    public String getOrigFilename() {
        return origFilename;
    }

    public String getFilename() {
        return filename;
    }

    public String getFilePath() {
        return filePath;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String origFilename;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private String filePath;

//    @Builder
//    public File(Long id, String origFilename, String filename, String filePath){
//        this.id = id;
//        this.origFilename = origFilename;
//        this.filename = filename;
//        this.filePath = filePath;
//    }
    public static class Builder{
        private Long id;
        private String origFilename;
        private String filename;
        private String filePath;

        public Builder(Long id, String origFilename, String filename, String filePath){
            this.id = id;
            this.origFilename = origFilename;
            this.filename = filename;
            this.filePath = filePath;
        }
        public File build(){
            return new File(this);
        }
    }
    private File(Builder builder){
        id = builder.id;
        origFilename = builder.origFilename;
        filename = builder.filename;
        filePath = builder.filePath;
    }
}
