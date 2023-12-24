package com.kot.model.dto;

public class Image {
	
	private int imgId;
	private int loginId;
	private String orgTitle;
	private String newTitle;
	private String path;
	private String contentType;
	
	public Image() {
	}

	public Image(int imgId, int loginId, String orgTitle, String newTitle, String path, String contentType) {
		super();
		this.imgId = imgId;
		this.loginId = loginId;
		this.orgTitle = orgTitle;
		this.newTitle = newTitle;
		this.path = path;
		this.contentType = contentType;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getOrgTitle() {
		return orgTitle;
	}

	public void setOrgTitle(String orgTitle) {
		this.orgTitle = orgTitle;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "Image [imgId=" + imgId + ", loginId=" + loginId + ", orgTitle=" + orgTitle + ", newTitle=" + newTitle
				+ ", path=" + path + ", contentType=" + contentType + "]";
	};
	
}