package com.tqy.actions.back;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tqy.bean.Code;
import com.tqy.bean.Msg;
import com.tqy.bean.Picture;
import com.tqy.bean.page.PageInfo;
import com.tqy.service.TqyPictureService;
import com.tqy.utils.PictureUtil;

public class BackPictureAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String getPictureByType() {
		try {
			PageInfo pageInfo = tqyPictureService.getPictureByTypeWithPage(pn, picture.getPicType());
			result = Msg.success();
			result = Msg.add(result, "pageInfo", pageInfo);
			return SUCCESS;
		} catch (Exception e) {
			result = Msg.fail();
			return SUCCESS;
		}
	}

	public String getPictureByDateAndType() {
		try {
			System.out.println("get the picture by date and type");
			PageInfo pageInfo = tqyPictureService.getPictureByDateAndType(picture);
			if (pageInfo == null) {
				result = Msg.fail();
			} else {
				result = Msg.success();
				result = Msg.add(result, "pageInfo", pageInfo);
			}
			return SUCCESS;
		} catch (Exception e) {
			result = Msg.fail();
			return SUCCESS;
		}
	}

	public String getPictureByDate(){
		try {
			System.out.println("get the picture by date");
			PageInfo pageInfo = tqyPictureService.getPictureByDate(picture);
			if (pageInfo == null){
				result = Msg.fail();
			} else {
				result = Msg.success();
				result = Msg.add(result, "pageInfo", pageInfo);
			}
			return SUCCESS;
		} catch (Exception e) {
			result = Msg.fail();
			return SUCCESS;
		}
	}

	public String addOnlyPicture() throws IOException {
		try {
			long startTime = System.currentTimeMillis();
			boolean flag = PictureUtil.uploadPictureForSSH(file2, picture.getPicType(), fileFileName);
			if (flag){
				Integer picId = tqyPictureService.addOnlyPicture(picture,fileFileName);
				if (picId != null) {
					result = Msg.success();
					result = Msg.add(result, "picId", picId);
					long endTime = System.currentTimeMillis();
					result = Msg.add(result, "totalTime", (endTime-startTime)+"ms");
				} else {
					result = Msg.fail();
				}
				
			} else {
				result = Msg.fail();
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result = Msg.fail();
			return SUCCESS;
		}

	}

	public String addPicture() {
		try {
			tqyPictureService.addPicture(picture);
			result = Msg.success();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result = Msg.fail();
			return SUCCESS;
		}
	}
	
	public String deletePicture() {
		try {
			Picture temp = tqyPictureService.getPictureById(picture.getPicId());
			picture.setPicType(temp.getPicType());
			picture.setPicName(temp.getPicName());
			tqyPictureService.deletePicture(picture);
			result = Msg.success();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result = Msg.fail();
			return SUCCESS;
		}
	}
	
	public void updatePicture() {

	}



	@Autowired
	TqyPictureService tqyPictureService;

	private Map<String, Object> result = null;
	private Integer pn;
	private Picture picture;
	private Code code;
	private File file2;   //file并不是前端页面上传来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private String fileContentType;
	private String fileFileName;

	public File getFile() {
		return file2;
	}

	public void setFile(File file2) {
		this.file2 = file2;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public Integer getPn() {
		return pn;
	}

	public void setPn(Integer pn) {
		this.pn = pn;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}
}
