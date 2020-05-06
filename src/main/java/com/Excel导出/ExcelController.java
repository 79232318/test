/**  
* @Title: ExcelController.java  
* @Package com.Excel导出  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年9月19日  
* @version V1.0  
*/  
package com.Excel导出;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

/**  
* <p>Description: </p>
* @ClassName: ExcelController  
* @author wangtz  
* @date 2019年9月19日    
*/
@Controller
public class ExcelController {

	 @RequestMapping(value = "/excel")
	    public void getname(HttpServletResponse response) throws Exception {
	        List<StudentEntity> list = new ArrayList<>();
	        StudentEntity studentEntity = new StudentEntity("a","路飞",1,new Date(),new Date());
	        StudentEntity studentEntity1 = new StudentEntity("a","路飞",1,new Date(),new Date());
	        StudentEntity studentEntity2 = new StudentEntity("a","路飞",1,new Date(),new Date());
	        StudentEntity studentEntity3 = new StudentEntity("a","路飞",1,new Date(),new Date());
	        StudentEntity studentEntity4 = new StudentEntity("a","路飞",1,new Date(),new Date());
	        list.add(studentEntity);
	        list.add(studentEntity1);
	        list.add(studentEntity2);
	        list.add(studentEntity3);
	        list.add(studentEntity4);
	        ExportExcelUtil.exportExcel(list, StudentEntity.class, "学生报表", response);

	                

 
	    }
	 @RequestMapping(value = "/excel_class")
	    public void getClass(HttpServletResponse response) throws Exception {
	        List<ClassEntity> list = new ArrayList<>();
	        list.add(new ClassEntity("第一节\n08:00-08:40"));
	        list.add(new ClassEntity("第一节\n08:00-08:40"));
	        list.add(new ClassEntity("第一节\n08:00-08:40"));
	        list.add(new ClassEntity("第一节\n08:00-08:40"));
	        list.add(new ClassEntity("第一节\n08:00-08:40"));
	        list.add(new ClassEntity("第一节\n08:00-08:40"));
	        list.add(new ClassEntity("第一节\n08:00-08:40"));
	        
String title = "注意事项\n1、每周的课程，课程与老师之间必须用“Alt+回车”换行，否则系统无法区分课程和老师\n2、单双周课程默认第一行为单周课程第二行为双周课程，课程与老师之间用“空格”隔断\n";
		
	        
	        
	        Workbook workbook =  ExcelExportUtil.exportExcel(new ExportParams(title, "学生"), ClassEntity.class, list);

	        response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("一年级一班", "UTF-8") + ".xls");
            workbook.write(response.getOutputStream());


	    }
	 @PostMapping(value = "/excel/input")
	    public void input(@RequestParam MultipartFile file) throws Exception {
	        
		 System.out.println(file.getOriginalFilename());
		 List<StudentEntity> list = ExportExcelUtil.importExcel(file, 0, 1, StudentEntity.class);

		 System.out.println(list.toString());


	    }
	 @PostMapping(value = "/excel_class/input")
	    public void inputClass(@RequestParam MultipartFile file) throws Exception {
	        
		 System.out.println(file.getOriginalFilename());
		 List<ClassEntity> list = ExportExcelUtil.importExcel(file, 1, 1, ClassEntity.class);

		 System.out.println(list.toString());


	    }
}
