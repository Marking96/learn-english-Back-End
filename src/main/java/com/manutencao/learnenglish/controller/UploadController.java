package com.manutencao.learnenglish.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.manutencao.learnenglish.models.FileUpload;
import com.manutencao.learnenglish.repository.FileRepository;
import com.manutencao.learnenglish.util.SaveUpload;

@RestController
@RequestMapping(value = "upload")
public class UploadController {

	@Autowired
	FileRepository fileRepository;
	
	@Autowired
	private SaveUpload saveUpload;

	@PostMapping
	public FileUpload uploadFile(@RequestParam MultipartFile file) {
		
		try {
		String uri = (String) saveUpload.SaveinDirectory(file);
		
			FileUpload upload = new FileUpload(file.getOriginalFilename(), uri, file.getContentType(), file.getBytes());
			return fileRepository.save(upload);
		} catch (IOException e) {
			
			throw new RuntimeException("Upload faled", e);
		}
		
	}

	@GetMapping("/{filename}")
	public ResponseEntity<Resource> getFile(@PathVariable String filename, HttpServletRequest request){
		/**	 
		FileUpload file = fileRepository.findByNameFile(filename);
		
		
		 * return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(file.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + file.getNameFile() + "\"")
				.body(new ByteArrayResource(file.getData()) );
		 */
		Resource resource = saveUpload.loadFileAsResource(filename);
		String contetType = null;
		try {
			contetType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
			
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		
		if(contetType == null) {
			contetType="application/octet-stream";
		}
		
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contetType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
	}
}
