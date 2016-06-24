package action.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 实现文件的上传
 * 规则：如果表单中包含了一个name 属性为xxx 的文件域，则action 需要使用三个成员变量来封装该文件域的信息
 * 	   File类型 的xxx 成员变量封装了该文件域对应的文件内容
 * 	   String 类型的名为xxxFileName 成员变量封装了该文件域对应的文件的文件名
 * 	   String 类型的名为xxxContentType 成员变量封装了该文件域对应的文件的文件类型
 * @author Z.J.
 *
 */
public class UploadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;//标题
	
	private File file;//文件域
	
	private String fileContentType;//上传文件的类型
	
	private String fileFileName;//文件的名字
	
	private String savePath;//在struts.xml 中配置的成员变量
	
	//接收 struts.xml中配置的值的方法
	public void setSavePath(String value){
		this.savePath = value;
	}
	//获取上传文件的保存位置
	public String getSavePath() throws Exception{ 
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	
	//setter 和 getter 方法
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileType) {
		this.fileContentType = fileType;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileName) {
		this.fileFileName = fileName;
	}
	
	public String upload() {
		//以服务器的文件保存地址和原文件名建立上传文件输出流
		try (FileOutputStream fos =  new FileOutputStream(getSavePath()+"\\"+getFileFileName());
				FileInputStream fis = new FileInputStream(getFile())
			){
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len=fis.read(buffer))>0) {
				fos.write(buffer,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
