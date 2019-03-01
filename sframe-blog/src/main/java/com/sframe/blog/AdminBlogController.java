package com.sframe.blog;

import com.sframe.common.util.PropertiesUtil;
import com.sframe.common.util.ZipUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: cxy@acmtc.com
 * \* Date: 2019/2/25
 * \* Time: 17:33
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
@RequestMapping("/admin/blog")
public class AdminBlogController {

	@RequestMapping(value = "uploadBlogFile", method = RequestMethod.POST)
	@ResponseBody
	public String uploadBlogFile (HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
		try{
			String prefix = UUID.randomUUID().toString();
			String localPrefix = PropertiesUtil.getProperty("localDirPrefix");
			prefix = prefix.replace("-","");
			String realPath = PropertiesUtil.getProperty("blog.localImageUrl")+prefix;//得到文件上传目的位置的真实路径
			System.out.println("realPath :"+realPath);
			File file1 = new File(realPath);
			if(!file1.exists()){
				file1.mkdir();   //如果该目录不存在，就创建此抽象路径名指定的目录。
			}
			String fileName = prefix+"_"+file.getOriginalFilename();//使用UUID加前缀命名文件，防止名字重复被覆盖
			try(InputStream in= file.getInputStream();//声明输入输出流
			     OutputStream out=new FileOutputStream(new File(realPath+localPrefix+fileName));//指定输出流的位置;
			){
				byte []buffer =new byte[1024];
				int len=0;
				while((len=in.read(buffer))!=-1){
					out.write(buffer, 0, len);
					out.flush();                //类似于文件复制，将文件存储到输入流，再通过输出流写入到上传位置
				}                               //这段代码也可以用IOUtils.copy(in, out)工具类的copy方法完成

			}catch (Exception e){
				throw e;
			}
			if(ZipUtil.unzip(realPath+localPrefix+fileName,realPath)){

			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return "success";
	}
}