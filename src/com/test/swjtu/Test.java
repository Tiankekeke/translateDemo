package com.test.swjtu;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.io.GetPath;
import com.swjtu.lang.LANG;
import com.swjtu.querier.Querier;
import com.swjtu.trans.AbstractTranslator;
import com.swjtu.trans.impl.*;
import com.swjtu.util.TransApi;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;

public class Test {
	private static final String APP_ID = "20180702000182001";

    private static final String SECURITY_KEY = "BeR8R_iWsvhjmK03g_Oj";

    public void test() throws IOException{
    	
    	String s1 = "Today is Monday";
    	
    	System.out.println(s1);

        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        System.out.println(api.toString()+"接口引用");

        String transResult1 = api.getTransResult(s1, "auto", "zh");

        
                
        System.out.println(transResult1);
        ObjectMapper mapper = new ObjectMapper();
        mapper.readTree(transResult1).path("trans_result").findPath("dst").toString();
        
        System.out.println(mapper);
    }
		
    public static void main(String[] args) throws IOException{
    	Test t = new Test();
    	t.test();
    }
}
