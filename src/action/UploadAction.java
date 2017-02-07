package action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.framework.core.utils.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.bind.v2.runtime.Name;
import com.thoughtworks.xstream.io.path.Path;


public class UploadAction extends ActionSupport {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//上传文件存放路径   
    private String uploade = "/upload";   
    //上传文件集合   
    private List<File> file;
    private String name;
    private String result;
    private String type;
    private String fileName;
    //上传文件名集合   
    private List<String> fileFileName;   
    //上传文件内容类型集合   
    private List<String> fileContentType;   
    public List<File> getFile() {   
        return file;   
    }   

    public void setFile(List<File> file) {   
        this.file = file;   
    }   

   public List<String> getFileFileName() {   
       return fileFileName;   
   }   

    public void setFileFileName(List<String> fileFileName) {   
        this.fileFileName = fileFileName;   
    }   

    public List<String> getFileContentType() {   
        return fileContentType;   
    }   

    public void setFileContentType(List<String> fileContentType) {   
        this.fileContentType = fileContentType;   
    }   

    public String uploadeFile() throws Exception {   
        System.err.println(this.getFileFileName());
        System.err.println(name);
        if("banner".equals(type)){
        	uploade += "/headImg";
        	name = getTimeNow();
        	result = "/upload/headImg/"+uploadFile(0,name);
        }else if("diseases".equals(type)){
        	uploade += "/diseases";
        	name = getTimeNow();
        	result = "/upload/diseases/"+uploadFile(0,name);
        }else if("pest".equals(type)){
        	uploade += "/pest";
        	name = getTimeNow();
        	result = "/upload/pest/"+uploadFile(0,name);
        }else if("exper".equals(type)){
        	uploade += "/exper";
        	name = getTimeNow();
    		result = "/upload/exper/"+uploadFile(0,name);
        }else if("question".equals(type)){
        	uploade += "/question";
        	name = getTimeNow();
    		result = "/upload/question/"+uploadFile(0,name);
        }
        return "ajaxSuccess";
    }   

    public String toUpload(){
    	return "index";
    }
    
    /*
     * 获取当前时间作为文件名
     */
    public String getTimeNow(){
		Date d = new Date(); 
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");  
		String dateNow = date.format(d);
		return dateNow;
	}
    //执行上传功能   
    private String uploadFile(int i ,String filename) throws FileNotFoundException, IOException {       	
    	try {   
            InputStream in = new FileInputStream(file.get(i));   
            String dir = ServletActionContext.getRequest().getRealPath(uploade);  
            File fileLocation = new File(dir);  
            //此处也可以在应用根目录手动建立目标上传目录  
            if(!fileLocation.exists()){  
                boolean isCreated  = fileLocation.mkdir();  
                if(!isCreated) {  
                    //目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。  
                    return null;  
                } 
            }  
            String fileName=this.getFileFileName().get(i);
            //取得文件扩展名
            int point= fileName.lastIndexOf(".");
            String ext=fileName.substring(point);
            //命名规则
            String  newname =filename+ext;
            File uploadFile = new File(dir, newname);
            OutputStream out= new FileOutputStream(uploadFile);
            byte[] buffer = new byte[1024 * 1024];   
            int length;   
            while ((length = in.read(buffer)) > 0) {   
                out.write(buffer, 0, length);   
            }   
            in.close();   
            out.close();
            return newname;
        } catch (FileNotFoundException ex) {   
            System.out.println("上传失败!");  
            ex.printStackTrace();   
        } catch (IOException ex) {   
            System.out.println("上传失败!");  
            ex.printStackTrace();   
        }
		return null;
    }

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUploade() {
		return uploade;
	}

	public void setUploade(String uploade) {
		this.uploade = uploade;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
