package com.swjtu.util;

public class GetAutoLang {

	public String getLang(String srcLang){
		switch(srcLang){
    	case "en":
    		srcLang="oye";
    		break;
    	case "zh-cn":
    		srcLang="oyc";
    		break;
    	}
		return srcLang;
	}
}
