package ua.com.shop.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.service.FileWriter;
import ua.com.shop.util.Engine;

@Service
public class FileWriterImpl implements FileWriter {

	@Override
	public boolean write(Folder folder, MultipartFile file, int i) {
		if (file != null && !file.isEmpty()) {
			File pathToHome = new File(System.getProperty("catalina.home"));
			File pathToFolder = new File(pathToHome, "images" + File.separator
					+ folder.name().toLowerCase());
			if (!pathToFolder.exists()) {
				pathToFolder.mkdirs();
			}
			try {
				InputStream inputStream = new ByteArrayInputStream(
						file.getBytes());
				BufferedImage old = ImageIO.read(inputStream);
				Engine engine = new Engine(old);
				BufferedImage present = engine.crop();
				File pathToFile = new File(pathToFolder, String.valueOf(i)
						+ ".jpg");
				ImageIO.write(present, "jpg", pathToFile);
			} catch (IOException e) {

			}
		}
		return false;
	}

}
