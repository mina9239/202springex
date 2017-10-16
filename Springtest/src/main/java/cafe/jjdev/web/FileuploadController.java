package cafe.jjdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cafe.jjdev.web.service.FileuploadService;

@Controller
public class FileuploadController {
	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping(value="/fileAdd", method = RequestMethod.GET)
	public String fileAdd() {
		return "fileAdd";
	}
	//file upload 액션
	/*@RequestMapping(value="/fileAdd", method = RequestMethod.POST)
	public String fileAdd(@RequestParam(value="fileTitle")String fileTitle
			,MultipartFile file) {
		//파일을 폴더에 저장하는 로직
		return "";*/
	@RequestMapping(value="/fileAdd", method = RequestMethod.POST)
	public String fileAdd(FileRequest fileRequest) {
		System.out.println(fileRequest);
		fileuploadService.fileupload(fileRequest);
		return "";
	}
}