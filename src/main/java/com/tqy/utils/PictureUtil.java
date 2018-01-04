package com.tqy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.multipart.MultipartFile;

public class PictureUtil {
	synchronized public static boolean uploadPicture(MultipartFile file, Integer picType){
		boolean flag = false;
		try {
			OutputStream os = new FileOutputStream(PathUtil.getRealPath()+"/src/main/webapp/img/"+picType+"/"+file.getOriginalFilename());
			InputStream is = file.getInputStream();
			int temp;
			while ((temp=is.read())!=(-1)){
				os.write(temp);
			}
			os.flush();
			os.close();
			is.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("上传文件失败");
		}
		return flag;
	}
	
	synchronized public static boolean deletePictureOnTheDisk(int picType,String picName){
		boolean flag = false;
		String path = PathUtil.getRealPath()+"/src/main/webapp/img/"+picType+"/"+picName;
		File file = new File(path);
		if (file.isFile() && file.exists()){
			file.delete();
			flag = true;
		} 
		return flag;
	}

	synchronized public static boolean transferPicture(int oldType, int newType, String picName){
		boolean flag = false;
		long startTime = System.currentTimeMillis();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		System.out.println("复制开始时间："+format.format(new Date()));
		try {
			InputStream is = new  FileInputStream(PathUtil.getRealPath()+"/src/main/webapp/img/"+oldType+"/"+picName);
			OutputStream os = new FileOutputStream(PathUtil.getRealPath()+"/src/main/webapp/img/"+newType+"/"+picName);
			int temp;
			while ((temp=is.read())!=(-1)){
				os.write(temp);
			}
			os.flush();
			os.close();
			is.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("上传转移失败");
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime-startTime;
		System.out.println("复制结束时间："+format.format(new Date()));
		System.out.println("程序运行时间："+String.valueOf(totalTime)+"ms");
		return flag;
	}
	
	synchronized public static boolean updateHead(MultipartFile file, Integer userId){
		boolean flag = false;
		try {
			OutputStream os = new FileOutputStream(PathUtil.getRealPath()+"/src/main/webapp/img/head/"+file.getOriginalFilename());
			InputStream is = file.getInputStream();
			int temp;
			while ((temp=is.read())!=(-1)){
				os.write(temp);
			}
			os.flush();
			os.close();
			is.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("头像文件失败");
		}
		return flag;
	}
	
	synchronized public static boolean deleteHeadOnTheDisk(String picName){
		boolean flag = false;
		String path = PathUtil.getRealPath()+"/src/main/webapp/img/head/"+picName;
		File file = new File(path);
		if (file.isFile() && file.exists()){
			file.delete();
			flag = true;
		} 
		return flag;
	}
	
	synchronized public static boolean uploadPictureForSSH(File file, Integer picType, String fileName){
		boolean flag = false;
		try {
			String root = ServletActionContext.getServletContext().getRealPath("/img/"+picType);
			System.out.println(root);
			System.out.println("fileName: "+fileName);
			InputStream is = new FileInputStream(file);
	        OutputStream os = new FileOutputStream(new File(root, fileName));
	        byte[] buffer = new byte[500];
	        int length = 0;
	        while(-1 != (length = is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer);
	        }
	        
	        os.close();
	        is.close();
	        flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
}
