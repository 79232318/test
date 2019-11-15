package com.Excel导出;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @version V1.0
 * @Description: Excel导出工具类
 * @date 2018/10/31 19:16
 */
public class ExportExcelUtil {
    /**
     * 
     * @param list 数据集合
     * @param title 内容标题
     * @param sheetName excel名称
     * @param pojoClass 实体类
     * @param fileName 导出的文件名
     * @param isCreateHeader 是否创建excel表头
     * @param response 响应
     * @throws Exception 
     */
    public static void exportExcel(List<?> list,
                                   String title,
                                   String sheetName,
                                   Class<?> pojoClass,
                                   String fileName,
                                   boolean isCreateHeader,
                                   HttpServletResponse response) throws Exception {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);
    }

    /**
     * 导出
     * @param list 数据集合
     * @param title 内容标题
     * @param sheetName excel名称
     * @param pojoClass 实体类
     * @param fileName 导出的文件名
     * @param response 响应
     * @throws Exception 
     */
    public static void exportExcel(List<?> list,
                                   String title,
                                   String sheetName,
                                   Class<?> pojoClass,
                                   String fileName,
                                   HttpServletResponse response) throws Exception{
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
    }

    /**
     * 导出 无内容标题和excel表名
     * @param list
     * @param pojoClass
     * @param fileName
     * @param response
     * @throws Exception 
     */
    public static void exportExcel(List<?> list,
                                   Class<?> pojoClass,
                                   String fileName,
                                   HttpServletResponse response) throws Exception {
        defaultExport(list, pojoClass, fileName, response, new ExportParams());
    }

    /**
     * 导出
     * @param list 数据集合
     * @param fileName 导出的文件名
     * @param response 响应
     * @throws Exception 
     */
    public static void exportExcel(List<Map<String, Object>> list,
                                   String fileName,
                                   HttpServletResponse response) throws Exception{
        defaultExport(list, fileName, response);
    }

    /**
     *
     * @param list 数据集合
     * @param pojoClass  实体类
     * @param fileName  导出的文件名
     * @param response 响应
     * @param exportParams
     * @throws Exception 
     */
    private static void defaultExport(List<?> list,
                                      Class<?> pojoClass,
                                      String fileName,
                                      HttpServletResponse response,
                                      ExportParams exportParams) throws Exception {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,pojoClass,list);
        if (workbook != null) {
            doExport(fileName, response, workbook);
        }
    }

    /**
     *
     * @param list 数据集合
     * @param fileName 导出的文件名
     * @param response 响应
     * @throws Exception 
     */
    private static void defaultExport(List<Map<String, Object>> list,
                                      String fileName,
                                      HttpServletResponse response) throws Exception {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null){
            doExport(fileName, response, workbook);
        }
    }

    /**
     * 导出
     * @param fileName  导出的文件名
     * @param response 响应
     * @param workbook 工作表
     * @throws Exception 
     */
    private static void doExport(String fileName,
                                      HttpServletResponse response,
                                      Workbook workbook) throws Exception {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    /**
     *
     * @param filePath
     * @param titleRows
     * @param headerRows
     * @param pojoClass
     * @param <T>
     * @return
     * @throws Exception 
     */
    public static <T> List<T> importExcel(String filePath,
                                          Integer titleRows,
                                          Integer headerRows,
                                          Class<T> pojoClass) throws Exception {
        if (StringUtils.isBlank(filePath)){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        }catch (NoSuchElementException e){
            throw new Exception("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return list;
    }

    /**
     *
     * @param file
     * @param titleRows
     * @param headerRows
     * @param pojoClass
     * @param <T>
     * @return
     * @throws Exception 
     */
    public static <T> List<T> importExcel(MultipartFile file,
                                          Integer titleRows,
                                          Integer headerRows,
                                          Class<T> pojoClass) throws Exception{
        if (file == null){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        }catch (NoSuchElementException e){
            throw new Exception("excel文件不能为空");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return list;
    }

}