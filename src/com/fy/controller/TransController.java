package com.fy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.ResponseBody;

import com.fy.autolang.LangDetectorUtil;
import com.fy.webservice.TransClient;
import com.swjtu.lang.LANG;
import com.swjtu.querier.Querier;
import com.swjtu.trans.AbstractTranslator;
import com.swjtu.trans.impl.BaiduTranslator;
import com.swjtu.trans.impl.GoogleTranslator;
import com.swjtu.trans.impl.YoudaoTranslator;
import com.swjtu.util.GetAutoLang;
import com.swjtu.util.GetViewLang;
  
@Controller  
public class TransController {  
      
    @RequestMapping(value="translateview", method = {RequestMethod.POST},produces="application/json;charset=UTF-8")
    public @ResponseBody JSONObject successModel(HttpServletRequest req, HttpServletResponse resp,String srcLang,String tgtLang,String srcSent) {
    	long start = System.currentTimeMillis();//时间差起点
    	LANG L_src = null;//源语言
    	LANG L_tgt = null;//目标语言
    	String ip = null;
    	Integer port = null;
    	GetAutoLang gal = new GetAutoLang(); //检测语言的判断方法实例化
    	srcLang = gal.getLang(srcLang);
    	switch(srcLang){		//源语言和目标语言对于不同代码块的整合
    	case "oye":
    		L_src=LANG.EN;
    		ip = "172.18.31.35";
    		port = 3333;
    		break;
    	case "oyc":
    		L_src=LANG.ZH;
    		ip = "172.18.31.35";
    		port = 4444;
    		break;
    	}
    	
    	switch(tgtLang){
    	case "oye":
    		L_tgt=LANG.EN;
    		break;
    	case "oyc":
    		L_tgt=LANG.ZH;
    		break;
    	}
    	 //String tgtSent = TransClient.translate_sent(srcLang,tgtLang,srcSent,ip,port);//CASIA翻译方法调用
    	 Querier<AbstractTranslator> querierTrans = new Querier<>();
         querierTrans.setParams(L_src, L_tgt,srcSent);
         
         querierTrans.attach(new BaiduTranslator());
         querierTrans.attach(new GoogleTranslator());
        

         List<String> resultTrans = querierTrans.execute();
         //resultTrans.add(tgtSent);
         for (String str : resultTrans) {
             System.out.println(str);
         }
    	Map<String,Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("list", resultTrans);
		JSONObject jsonObject = JSONObject.fromObject(resultMap);
    	System.out.println(jsonObject);
    	long end = System.currentTimeMillis();//时间差终点
    	System.out.println(end-start);
    	return jsonObject;
     }
    @RequestMapping(value="ourtranslate", method = {RequestMethod.POST},produces="application/text;charset=UTF-8")
    public @ResponseBody String ourModel(HttpServletRequest req, HttpServletResponse resp,String srcLang,String tgtLang,String srcSent) {
    	//long start = System.currentTimeMillis();//时间差起点
    	String ip = null;
    	Integer port = null;
    	GetAutoLang gal = new GetAutoLang(); //检测语言的判断方法实例化
    	srcLang = gal.getLang(srcLang);
    	switch(srcLang){		//源语言和目标语言对于不同代码块的整合
    	case "oye":
    		ip = "172.18.31.35";
    		port = 3333;
    		break;
    	case "oyc":
    		ip = "172.18.31.35";
    		port = 4444;
    		break;
    	}
    	 String tgtSent = TransClient.translate_sent(srcLang,tgtLang,srcSent,ip,port);//CASIA翻译方法调用
        /* List<String> resultTrans = null;
         resultTrans.add(tgtSent);
         for (String str : resultTrans) {
             System.out.println(str);
         }
    	Map<String,Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("list", resultTrans);
		JSONObject jsonObject = JSONObject.fromObject(resultMap);
    	System.out.println(jsonObject);
    	long end = System.currentTimeMillis();//时间差终点
    	System.out.println(end-start);
    	return jsonObject;*/
    	return tgtSent;
     }
    
   @RequestMapping(value="ListenMessage", method = {RequestMethod.POST},produces="application/json;charset=UTF-8")
    public @ResponseBody String getListenMessage(HttpServletRequest req, HttpServletResponse resp,String message) {
	   LangDetectorUtil ldtu = new LangDetectorUtil();
	   String lang = null;
	   if(!message.equals("")) {
	 	  lang = ldtu.getLangUsed(message);
	   }
	   
	   return lang;
     }
  }

      
      

    

