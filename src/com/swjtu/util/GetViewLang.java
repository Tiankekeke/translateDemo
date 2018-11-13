package com.swjtu.util;

public class GetViewLang {
	public String getLang(String srcLang){
		switch(srcLang){
    	case "en":
    		srcLang="英语";
    		break;
    	case "zh-cn":
    		srcLang="中文";
    		break;
		case "ja":
			srcLang = "日文";
			break;
		}
		return srcLang;
	}
}
