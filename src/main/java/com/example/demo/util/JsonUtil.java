package com.example.demo.util;

import  java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtil {

	
	/**
	 * AJAX请求，相应返回json
	 * @param response
	 * @param json
	 */
	public static void ajaxOutPutJson(HttpServletResponse response, JSONObject json ){
        response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
        try {
			response.getWriter().print(JSON.toJSONString(json, SerializerFeature.WriteDateUseDateFormat));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * AJAX请求，相应返回json数组
	 * @param response
	 * @param arr
	 */
	public static void ajaxOutPutJson(HttpServletResponse response, JSONArray arr ){
        response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
        try {
			response.getWriter().print(arr.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加、修改等操作返回结果：{success:true}{success:false}
	 * @param response
	 * @param result
	 */
	public static void ajaxOutPutJson(HttpServletResponse response, Boolean result ){
		JSONObject jsonObj = new JSONObject(); 
		jsonObj.put("success", result);
        response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
        try {
			response.getWriter().print(jsonObj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
