/**  
* @Title: ExcelController.java  
* @Package com.Excel导出  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年9月19日  
* @version V1.0  
*/  
package com.Excel导出;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
* <p>Description: </p>
* @ClassName: ExcelController  
* @author wangtz  
* @date 2019年9月19日    
*/
@Controller
public class ExcelController {

	 @RequestMapping(value = "/")
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



//	      response.setHeader("content-Type", "application/vnd.ms-excel");
//	      response.setHeader("Content-Disposition", "attachment;filename=" + System.currentTimeMillis() + ".xls");
//	      response.setCharacterEncoding("UTF-8");

//	      Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("","学生"),
//	              StudentEntity.class, list);

//	      ExportExcelUtil.exportExcel(list,"学生信息", "学生",StudentEntity.class,
//	              "学生报表", true, response);

//	      if (workbook != null) {
//	          try {
//	              workbook.write(response.getOutputStream());
//	          } catch (IOException e) {
//	              e.printStackTrace();
//	          }
//	      }
	        //return "Hello Spring Boot";
	    }
}
