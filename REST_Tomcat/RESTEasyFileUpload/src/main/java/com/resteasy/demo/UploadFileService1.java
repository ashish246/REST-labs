package com.resteasy.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

/**
 * will map the uploaded file to a POJO class, you dun need to handle the
 * inputPart. The problem is, you can’t get the uploaded filename!
 * 
 * @author Administrator
 *
 */
@Path("/file/pojo")
public class UploadFileService1 {

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadFile(@MultipartForm FileUploadForm form) {

		String fileName = "d://uploaded/"+form.getFileName();

		try {
			writeFile(form.getData(), fileName);
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Done");

		return Response
				.status(200)
				.entity("UploadFileService1 is called, Uploaded file name : "
						+ fileName).build();

	}

	// save to somewhere
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();

	}
}
