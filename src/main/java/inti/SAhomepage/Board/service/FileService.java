package inti.SAhomepage.Board.service;

import inti.SAhomepage.Board.domain.entity.File;
import inti.SAhomepage.Board.domain.repository.FileRepository;
import inti.SAhomepage.Board.dto.FileDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FileService {
    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDto fileDto) {
        return fileRepository.save(fileDto.toEntity()).getFid();
    }

    @Transactional
    public FileDto getFile(Long fid) {
        File file = fileRepository.findById(fid).get();

        FileDto fileDto = FileDto.builder()
                .fid(fid)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}
