package cafe.jjdev.web.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cafe.jjdev.web.FileRequest;
@Service
public class FileuploadService {
	public int fileupload(FileRequest fileRequest) {
		MultipartFile file = fileRequest.getFile();
		String fileName = file.getOriginalFilename();
		int pos = fileName.lastIndexOf("."); // 마지막 점의 위치
		String ext = fileName.substring(pos+1); //확장자
		System.out.println("ext:" +ext);
		
		UUID uuid = UUID.randomUUID();
		String name = uuid.toString();
		name = name.replaceAll("-", "");
		System.out.println(name+"."+ext);
		
		File destFile = new File("c:/upload/"+name+"."+ext);
		try {
			file.transferTo(destFile);
			FileVo fileVo = new FileVo();
			fileVo.setFileTitle(fileRequest.getFileTitle());
			fileVo.setFilePath("c:/upload/"+name+"."+ext);
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
		}
				
		//1. 파일을 폴더 저장
		//2. FileRequest -> FileVo
		//3. FileDao.insertFile() 메서드 호출
		return 0;
	}
}
