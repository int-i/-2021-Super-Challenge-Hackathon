package inti.SAhomepage.Board.service;

import inti.SAhomepage.Board.domain.entity.File;
import inti.SAhomepage.Board.domain.repository.FileRepository;
import inti.SAhomepage.Board.dto.FileDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FileService {
    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDto fileDto){
        return fileRepository.save(fileDto.toEntity()).getId();
    }

    @Transactional
    public FileDto getFile(Long id) {
        File file = fileRepository.findById(id).get();

        FileDto fileDto = new FileDto
                .Builder(id, file.getOrigFilename(), file.getFilename(), file.getFilePath())
//                .id(id)
//                .origFilename(file.getOrigFilename())
//                .filename(file.getFilename())
//                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}
