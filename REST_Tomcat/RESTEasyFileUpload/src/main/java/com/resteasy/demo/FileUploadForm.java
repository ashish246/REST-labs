package com.resteasy.demo;

import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadForm {

	public FileUploadForm() {
	}

	private byte[] data;
	private String fileName;

	public byte[] getData() {
		return data;
	}

	@FormParam("uploadedFile")
	@PartType("application/octet-stream")
	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFileName() {
		return fileName;
	}

	@FormParam("filename")
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}