package inti.SAhomepage.Board.dto;

import inti.SAhomepage.Board.domain.entity.File;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class FileDto {
    private Long fid;
    private String origFilename;
    private String filename;
    private String filePath;

    public File toEntity() {
        File build = File.builder()
                .fid(fid)
                .origFilename(origFilename)
                .filename(filename)
                .filePath(filePath)
                .build();
        return build;
    }

    @Builder
    public FileDto(Long fid, String origFilename, String filename, String filePath) {
        this.fid = fid;
        this.origFilename = origFilename;
        this.filename = filename;
        this.filePath = filePath;
    }
}
