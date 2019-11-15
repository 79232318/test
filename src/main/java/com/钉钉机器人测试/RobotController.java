/**  
* @Title: RobotController.java  
* @Package com.钉钉机器人测试  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年8月30日  
* @version V1.0  
*/  
package com.钉钉机器人测试;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;

/**  
* <p>Description: </p>
* @ClassName: RobotController  
* @author wangtz  
* @date 2019年8月30日    
*/
@RestController
public class RobotController {

	
	@RequestMapping("test")
	public void test(HttpServletRequest req,HttpServletResponse resp,@RequestBody JSONObject param) {
		String token = req.getHeader("token");
		System.out.println("token="+token);
		System.out.println(JSON.toJSONString(req.getAttributeNames()));
		System.out.println("消息格式："+param.getString("msgtype"));
		System.out.println("消息发送时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(param.getLong("createAt"))));
		System.out.println("1-单聊，2-群聊 ："+param.getString("conversationType"));
		System.out.println("会话Id："+param.getString("conversationId"));
		System.out.println("群名称："+param.getString("conversationTitle"));
		System.out.println("发送者id："+param.getString("senderId"));
		System.out.println("发送者名称："+param.getString("senderNick"));
		System.out.println("senderStaffId："+param.getString("senderStaffId"));
		System.out.println("isAdmin："+param.getBoolean("isAdmin"));
		System.out.println("context："+param.getString("context"));
		System.out.println("企业机器人对应的企业id："+param.getString("chatbotCorpId"));
		System.out.println("机器人实例对应的id："+param.getString("chatbotUserId"));
		String text1 = param.getString("text");
		System.out.println("text："+text1);
//		JSONObject param1 = JSON.parseObject(text1);
//		String content = param1.getString("content");
//		System.out.println("消息内容="+content);
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=c44c4d98db8cd3e8640afb3cacac074f463ce0316a77527d51af57e14fa127c2");
		OapiRobotSendRequest request = new OapiRobotSendRequest();
		request.setMsgtype("text");
		OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
		text.setContent("测试文本消息@15659177657");
		request.setText(text);
		OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
		at.setAtMobiles(Arrays.asList("15659177657"));
		request.setAt(at);

		 

		request.setMsgtype("markdown");
		OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
		markdown.setTitle("杭州天气");
		markdown.setText("#### 杭州天气 @dasd\n" +
		        "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
		        "> ![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png)\n"  +
		        "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
		request.setMarkdown(markdown);
		try {
			OapiRobotSendResponse response = client.execute(request);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
