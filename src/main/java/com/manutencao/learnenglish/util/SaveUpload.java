package com.manutencao.learnenglish.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ch.qos.logback.core.net.SyslogOutputStream;

@Component
public class SaveUpload {
	
	@Value("${file.upload.raiz}")
	private String raiz;

	@Value("${file.upload.dir}")
	private String directory;
	
	public String SaveinDirectory(MultipartFile arquivo) {
		Path path = Paths.get(this.raiz,directory);
		
		Path filepath = path.resolve(arquivo.getOriginalFilename());

		try {
			Files.createDirectories(path);
			/**File diretoryFile = new File(directory);
			diretoryFile.setReadable(true, true);
			diretoryFile.setWritable(true, true);
			
			System.out.println("Esse é o diretorio "+diretoryFile.toString());
			 
			if(!diretoryFile.exists()) {
				diretoryFile.mkdir();
				file.transferTo(diretoryFile);
			}else {
				System.out.println("não há diretorio");
			}
			**/
			//arquivo.transferTo(filepath.toFile());
			Files.copy(arquivo.getInputStream(), filepath, StandardCopyOption.REPLACE_EXISTING);
			String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path(directory)
					.path(arquivo.getOriginalFilename()).toUriString();
			
			return uri;
		} catch (IOException e) {
			throw new RuntimeException("Upload faled aki", e);
		}		
	}
	
	public Resource loadFileAsResource(String filename) {
		try {
			Path path = Paths.get(this.raiz,this.directory);
			Path filePath = path.resolve(filename).normalize();
			System.out.println(filePath.toUri().toString());
			Resource resource = new UrlResource(filePath.toUri());
			if(resource.exists()) {
				return resource;
			}else {
				throw new RuntimeException("Upload faled lllll");
			}
		}catch (Exception e) {
			throw new RuntimeException("Upload faled", e);
		}
	}
	
}
