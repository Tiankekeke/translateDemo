package com.fy.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class TransClient {
	
	
	
	public static String translate_sent(String srcLang,String tgtLang, String srcSent,String ip, Integer port){
			Socket socket = null;
		try {
            //创建一个Socket，跟服务器的8080端口链接
            //Socket socket = new Socket("172.18.31.35",4444);
			socket = new Socket(ip,port);
            //使用PrintWriter和BufferedReader进行读写数据
            //PrintWriter pw = new PrintWriter(socket.getOutputStream());
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            //发送数据
            String head = "L" + String.format("%05d", srcSent.trim().getBytes().length) + "*" +"S" + srcLang + "*T" + tgtLang + "*D****T";
            String sentence = head + srcSent.trim();
           // String sendSent = "L" + String.format("%05d", srcSent.trim().getBytes().length) + "*" + sentence;
            pw.println(sentence);
            System.out.println(head);
            pw.flush();
            //接收数据
            String line = is.readLine();
            System.out.println("received from server" + line);
            //关闭资源
            pw.close();
            is.close();
            socket.close();
            return line;
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;
		
		
    }
}