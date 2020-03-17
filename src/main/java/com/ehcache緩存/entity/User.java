package com.ehcache緩存.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

 
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
 
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author eara
 * @since 2019-03-11
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity
public class User implements Serializable {
  
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String name;

    private String tel;

    private String workPlace;

    private String remark;

    private String mobile;

    private String email;

    private String orgEmail;

    private String active;

    private String orderInDepts;

    private String isAdmin;

    private String isBoss;

    private String isLeaderInDepts;

    private String isHide;

    private String department;

    private String departmentNames;

    private String position;

    private String avatar;

    private Date hiredDate;

    private String jobNumber;

    private String extattr;

    private String isSenior;

    private String roleId;

    private Integer auth;

    private String shopId;

    private String deptIds;
     
    private String shop;
    
    private Integer wechatStatus;
	 
    private String openId;
	 
    
}
