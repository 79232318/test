package com.Excel导出;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Description:
 * @date 2018/10/31 15:31
 */
@Data
public class ClassEntity implements Serializable {

     
    /**
     * 学生姓名
     */
    @Excel(name = "节次/时间", type = 1, width = 13.29 )
    private String segment;
    
    @Excel(name = "星期一", width = 13.29 )
    private String monday;

     
    @Excel(name = "星期二", width = 13.29 )
    private String tuesday;
    @Excel(name = "星期三", width = 13.29 )
    private String wednesday;
    @Excel(name = "星期四", width = 13.29 )
    private String thursday;
    @Excel(name = "星期五", width = 13.29 )
    private String friday;
    @Excel(name = "星期六", width = 13.29 )
    private String saturday;
    @Excel(name = "星期日", width = 13.29 )
    private String sunday;
    
    
    
    
	public ClassEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public ClassEntity(String segment) {
		super();
		this.segment = segment;
	}
    
}