package com.swaggerconfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.反射获取接口.InitApi;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ApiOperation：用来描述该接口的作用。可以通过该注解说明接口的职责、返回头信息、
 * 方法的请求方式（"GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS" and "PATCH"）、协议（ http, https, ws, wss）、http状态码。
   @ApiImplicitParam：用来给参数增加说明。可以设置参数的名称、是否是必填项、参数的描述信息、是否只读等。
  paramType：表示参数放在哪个地方
    header-->请求参数的获取：@RequestHeader(代码中接收注解)
    query-->请求参数的获取：@RequestParam(代码中接收注解)
    path（用于restful接口）-->请求参数的获取：@PathVariable(代码中接收注解)
    body-->请求参数的获取：@RequestBody(代码中接收注解)
    form（不常用）
 */

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
	
	static {
		
		User user = new User();
		
		user.setAge(18);
		
		user.setId(1L);
		
		user.setName("aa");
		
		users.put(1L, user);
		
	}
	
	@ApiOperation(value="获取所有用户列表", notes="")
	@GetMapping
	public List<User> getUserList() {
		List<User> r = new ArrayList<User>(users.values());
		
		return r;
		
	}
	
	@ApiOperation(value="创建新的用户", notes="根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@PostMapping
	public String postUser(@RequestBody User user) {
		
		users.put(user.getId(), user);
		
		return "success";
		
	}
	
	@ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",  paramType = "path")
	@GetMapping("{id}")
	public User getUser(@PathVariable Long id) {
		
		return users.get(id);
		
	}
	
	@ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
		@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
		
	})
	@PutMapping(value="/{id}")
	public String putUser(@PathVariable Long id, @RequestBody User user) {
		
		User u = users.get(id);
		
		u.setName(user.getName());
		
		u.setAge(user.getAge());
		
		users.put(id, u);
		
		return "success";
		
	}
	
	
	@ApiOperation(value="删除已存在的用户", notes="根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
	@DeleteMapping(value="{id}")
	public String deleteUser(@PathVariable Long id) {
		
		users.remove(id);
		
		return "success";
		
	}
	@ApiOperation(value="上传文件", notes="")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "文件名", required = true, dataType = "String", paramType = "form"),
	})
	@PostMapping(value = "upload", headers = "content-type=multipart/form-data")
	public String upload(String name, @ApiParam(value="短视频",required=true) MultipartFile file) throws IllegalStateException, IOException {
		
		System.out.println(name);
		file.transferTo(new File("e:\\" + name + ".jpg"));
		return "success";
		
	}
	@Autowired
	InitApi initApi;
	@ApiOperation(value="测试", notes="")
	@GetMapping(value = "test")
	public String test() {
		System.out.println("测试开始");
		initApi.getController();
		
		return "";
	}
	
}
 