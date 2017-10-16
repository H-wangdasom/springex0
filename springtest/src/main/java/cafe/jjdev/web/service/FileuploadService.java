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
		System.out.println("fileName"+fileName);
		int pos = fileName.lastIndexOf(".");	//test.txt
		String ext = fileName.substring(pos+1); //확장자
		System.out.println("ext:"+ext);
		
		UUID uuid = UUID.randomUUID();
		String name = uuid.toString();
		System.out.println("name:"+name);
		name = name.replaceAll("-", "");
		System.out.println(name+"."+ext);
		
		File destFile = new File("c:/upload/"+name+"."+ext);//빈파일
		try {
			file.transferTo(destFile);	//file에 있는 파일을 desrFile이라는 빈파일에 카피해주세요
			FileVo fileVo = new FileVo();
			fileVo.setFileTitle(fileRequest.getFileTitle());
			fileVo.setFilePath("c:/upload/"+name+"."+ext);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
		//1. 파일을 폴더 저장
		//2. FileRequest ->FileVo
		//3. FileDao.insertFile() 메서드 호출
		return 0;
	}

}
