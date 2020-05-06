package com.Excel导出;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Description:
 * @date 2018/10/31 15:31
 */
@Data
public class StudentEntity implements Serializable {

    /**
     * id
     */
    private String id;
    /**
     * 学生姓名
     */
    @Excel(name = "姓名", isImportField = "true_st")
    private String name;
    /**
     * 学生性别
     */
    @Excel(name = "性别", replace = { "男_1", "女_2" }, isImportField = "true_st")
    private int sex;

    @Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", isImportField = "true_st")
    private Date birthday;

    @Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd")
    private Date registrationDate;

    public StudentEntity(String id, String name, int sex, Date birthday, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.registrationDate = registrationDate;
    }

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}