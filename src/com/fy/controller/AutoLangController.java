package com.fy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fy.autolang.LangDetectorUtil;
//已废除
@Controller
public class AutoLangController {
	@RequestMapping(value = "LangView",method = {RequestMethod.POST},produces="application/json;charset=UTF-8")
	 public @ResponseBody JSONObject autoSrcLang(HttpServletRequest req, HttpServletResponse resp,String srcSent){
		String originalStr = srcSent;
		LangDetectorUtil ldtu = new LangDetectorUtil();
		String Lang = ldtu.getLangUsed(originalStr);
		JSONObject object = new JSONObject();
		object.put("autoLang", Lang);
    	return object;
	}
}

