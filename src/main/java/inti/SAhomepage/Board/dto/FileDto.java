package inti.SAhomepage.Board.dto;

import inti.SAhomepage.Board.domain.entity.File;
//import lombok.*;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
public class FileDto {
    private Long id;
    private String origFilename;
    private String filename;
    private String filePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigFilename() {
        return origFilename;
    }

    public void setOrigFilename(String origFilename) {
        this.origFilename = origFilename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public File toEntity(){
        File build = new File
                .Builder(id, origFilename,filename,filePath)
                .build();
        return build;
    }

//    @Builder
//    public FileDto(Long id, String origFilename, String filename, String filePath) {
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
        public FileDto build(){
            return new FileDto(this);
        }
    }
    private FileDto(FileDto.Builder builder){
        id = builder.id;
        origFilename = builder.origFilename;
        filename = builder.filename;
        filePath = builder.filePath;
    }
}
