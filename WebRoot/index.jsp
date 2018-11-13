<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>在线翻译</title>
<meta http=equiv = "content-type" content = "text/html;charset = utf-8"/>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<style>
		.fra{
		min-height:150px;
		*min-height:150px;
		height:auto;
		*height:400px;
		}
		 /* SELECT W/IMAGE */
            select#selectTravelCity
            {
               width                    : 14em;
               height                   : 3.2em;
               padding                  : 0.2em 0.4em 0.2em 0.4em;
               vertical-align           : middle;
               border                   : 1px solid #94c1e7;
               -moz-border-radius       : 0.2em;
               -webkit-border-radius    : 0.2em;
               border-radius            : 0.2em;
               -webkit-appearance       : none;
               -moz-appearance          : none;
               appearance               : none;
               background               : #ffffff;
               font-family              : SimHei;
               font-size                : 1.1em;
               color                    : RGBA(102,102,102,0.7);
               cursor                   : pointer;
            }

            /*SELECT W/DOWN-ARROW*/
            select#srcLang
            {
               width                    : 120pt;
               height                   : 25pt;
               line-height              : 20pt;
               padding-right            : 20pt;
               text-indent              : 4pt;
               text-align               : left;
               vertical-align           : middle;
               border                   : 1px solid #94c1e7;
               -moz-border-radius       : 6px;
               -webkit-border-radius    : 6px;
               border-radius            : 6px;
               -webkit-appearance       : none;
               -moz-appearance          : none;
               appearance               : none;
               font-size                : 13pt;
               font-weight              : 500;
               color                    : #000;
               cursor                   : pointer;
               outline                  : none;
                background              : #ddd;
            }
			  select#tgtLang
            {
               width                    : 120pt;
               height                   : 25pt;
               line-height              : 20pt;
               padding-right            : 20pt;
               text-indent              : 4pt;
               text-align               : left;
               vertical-align           : middle;
               border                   : 1px solid #94c1e7;
               -moz-border-radius       : 6px;
               -webkit-border-radius    : 6px;
               border-radius            : 6px;
               -webkit-appearance       : none;
               -moz-appearance          : none;
               appearance               : none;
               font-size                : 13pt;
               font-weight              : 500;
               color                    : #000;
               cursor                   : pointer;
               outline                  : none;
               vertical-align			: middle;
               background               : #ddd;
            }
            /*LABEL FOR SELECT*/
            label#lblSelect{ position: relative; display: inline-block;}
            /*DOWNWARD ARROW (25bc)*/
            label#lblSelect::after
            {
                content                 : "\25bc";
                position                : absolute;
                top                     : 0;
                right                   : 0;
                bottom                  : 0;
                width                   : 20pt;
                line-height             : 25pt;
                vertical-align          : middle;
                text-align              : center;
                background              : #bbb;
                color                   : #000;
               -moz-border-radius       : 0 6px 6px 0;
               -webkit-border-radius    : 0 6px 6px 0;
                border-radius           : 0 6px 6px 0;
                pointer-events          : none;
            }
            select::-ms-expand { display: none; }
			.btn {
				display: inline-block;
				padding: .3em .5em;
				background-image: linear-gradient(#ddd, #ddd);
				border: 1px solid rgba(0,0,0,.2);
				border-radius: .3em;
				box-shadow: 0 1px white inset;
				text-align: center;
				color:black;
				font-weight: bold;
			}
			.btn:active{
				box-shadow: .05em .1em .2em rgba(0,0,0,.6) inset;
				border-color: rgba(0,0,0,.3);
				background:	#bbb;
			}
		/* *{
            margin:1px;
            padding:0;
        } */
        .headauto{
            width:100%;
            background:url(banner.jpg) no-repeat;
            -webkit-background-size: 100% 100%;
            background-size: 100% 100%;
        }
html,body{height: 100%;width: 100%;margin:0;padding:0;}
body{
	background:url(./jpg/background2.jpg)no-repeat;
    width:100%;
    height:100%;
    background-size:100% 150%;
    position:absolute;
    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='./jpg/background2.jpg',sizingMethod='scale');
  	opacity:0.9
}
</style>
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script>
var srcAuto = "";
var flag = 0;
var result = "";
function get(){
			if(flag ==0){
				srcAuto=$("#srcLang").val();
			}else{
				srcAuto = result;
			} 
			$.ajax({
				type:"post",
				url:"/translateDemo/translateview",
				datatype:"json",
				//contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				data:{
					srcLang: srcAuto,
					tgtLang: $("#tgtLang").val(),
					srcSent: $("#srcSent").val()
					},
				success:function(jsonObject){
					//document.getElementById("ourtranslate").innerHTML=jsonObject.list[2];
					document.getElementById("baidutranslate").innerHTML=jsonObject.list[0].replace(/\"/g, "");
					document.getElementById("googletranslate").innerHTML=jsonObject.list[1].replace(/\"/g, "");
					
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){     
						alert(XMLHttpRequest.status);  
                    	alert(XMLHttpRequest.readyState);  
                    	alert(textStatus);
				}
			});
}
function ourget(){
			if(flag ==0){
				srcAuto=$("#srcLang").val();
			}else{
				srcAuto = result;
			} 
			$.ajax({
				type:"post",
				url:"/translateDemo/ourtranslate",
				datatype:"text",
				//contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				data:{
					srcLang: srcAuto,
					tgtLang: $("#tgtLang").val(),
					srcSent: $("#srcSent").val()
					},
				success:function(jsonObject){
					document.getElementById("ourtranslate").innerHTML=jsonObject;
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){     
						alert(XMLHttpRequest.status);  
                    	alert(XMLHttpRequest.readyState);  
                    	alert(textStatus);
				}
			});
}
function auto(msg){
		switch(msg){
    	case "en":
    		msg="英语";
    		break;
    	case "zh-cn":
    		msg="中文";
    		break;
    	case "ar":
    		msg="阿拉伯语";
    		break;
    	case "bg":
    		msg="保加利亚语";
    		break;
    	case "ca":
    		msg="加泰隆语";
    		break;
    	case "cs":
    		msg="捷克语";
    		break;
    	case "da":
    		msg="丹麦语";
    		break;
    	case "de":
    		msg="德语";
    		break;
    	case "el":
    		msg="希腊语";
    		break;
    	case "es":
    		msg="西班牙语";
    		break;
    	case "et":
    		msg="爱沙尼亚语";
    		break;
    	case "fa":
    		msg="法斯语";
    		break;
    	case "fi":
    		msg="芬兰语";
    		break;
    	case "fr":
    		msg="法语";
    		break;
    	case "gu":
    		msg="古吉拉特语";
    		break;
    	case "he":
    		msg="希伯来语";
    		break;
    	case "hi":
    		msg="印地语";
    		break;
    	case "hr":
    		msg="克罗地亚语";
    		break;
    	case "hu":
    		msg="匈牙利语";
    		break;
    	case "id":
    		msg="印度尼西亚语";
    		break;
    	case "it":
    		msg="意大利语";
    		break;
    	case "ja":
    		msg="日语";
    		break;
    	case "ko":
    		msg="朝鲜语";
    		break;
    	case "lt":
    		msg="立陶宛语";
    		break;
    	case "lv":
    		msg="拉脱维亚语";
    		break;
    	case "mk":
    		msg="马其顿语";
    		break;
    	case "nl":
    		msg="荷兰语";
    		break;
    	case "pa":
    		msg="旁遮普语";
    		break;
    	case "pl":
    		msg="波兰语";
    		break;
    	case "pt":
    		msg="葡萄牙语";
    		break;
    	case "ro":
    		msg="罗马尼亚语";
    		break;
    	case "ru":
    		msg="俄语";
    		break;
    	case "sq":
    		msg="阿尔巴尼亚语";
    		break;
    	case "sv":
    		msg="瑞典语";
    		break;
    	case "ta":
    		msg="泰米尔语";
    		break;
    	case "te":
    		msg="泰卢固语";
    		break;
    	case "th":
    		msg="泰语";
    		break;
    	case "tl":
    		msg="塔加路语";
    		break;
    	case "tr":
    		msg="土耳其语";
    		break;
    	case "uk":
    		msg="乌克兰语";
    		break;
    	case "ur":
    		msg="乌都语";
    		break;
    	case "vi":
    		msg="越南语";
    		break;
    	case "zh-tw":
    		msg="中文繁体";
    		break;
    	case "sl":
    		msg="斯洛文尼亚语";
    		break;
    	case "no":
    		msg="挪威语";
    		break;	
    	}
   			if(msg == null){
   				document.getElementById("autoLang").value="检测中";
   			}else{
   				document.getElementById("autoLang").value="检测到"+msg;
   			}
			flag = 1;
}
function request() {
        	var message=document.getElementById("srcSent").value;
        	//alert(message);
        	$.ajax({
                type: "POST", //提交数据的类型 分为POST和GET
                async: false,
                url: "/translateDemo/ListenMessage",  //提交url 注意url必须小写
                //contentType: "application/json;charset=UTF-8",
                data: {"message": message}, 
                dataType:"text",
                success: function (msg) {
                	auto(msg);
                	result = msg;
                },
                error:function(data){  
                    alert("失败");  
                }  
            });
}
   		function onInput(){
   			if(flag == 1){
   				request();
   			}
   		}
   		function changeflag(){
   			document.getElementById("autoLang").value="检测源语言";
   			flag = 0;
   		}
   		/* 图片的自动缩放 */
   		window.onload= function () {
        var screenW=document.body.clientWidth;
        var ratio=screenW/1766;
        var img=document.getElementById("topImg");
        img.style.height=ratio*635+"px";
        window.onresize= function () {
            screenW=document.body.clientWidth;
            ratio=screenW/1766;
            img.style.height=ratio*635+"px";
        }
    }
</script>
</head>
<body>
<img src = "./jpg/head2.png" class = "headauto"/>
<form name = "form">
<div style = "margin-left:30px">
<div style = "width:1100px;">
<div style="float:left;width:500px;">
	<label id="lblSelect">
            <select id="srcLang" title="--请选择"  onchange = "changeflag()">
				<option>源端语言</option>
                <option value = "oye">英语</option>
				<option value = "oyc">汉语</option>
            </select>
	</label>
	<input type = "button" value = "检测源语言" id="autoLang" class = "btn" style = "width:140px;height:35px;" onclick="auto()">
	<input type = "reset" class = "btn" value = "重置" style = "width:110px;height:35px;">
	</div>
<div style="float:right;width:400px;">
	<label id="lblSelect">
            <select id="tgtLang" title="--请选择">
				<option>目标端语言</option>
                <option value = "oye">英语</option>
				<option value = "oyc">汉语</option>
            </select>
	</label>
<input type = "button" class = "btn" value = "Our翻译" style = "width:110px;height:35px;" onclick="ourget()">
</div>
</div>
<div style = "clear:both;">
<div style = "width:1100px;">
<div style="float:left;width:200px;">
<h4>请输入翻译内容：</h4>
<textarea id="srcSent"  placeholder="要翻译的单词/句子" style = " width:600px;height: 140px;padding: 5px;
border: 1px solid #ccc;background-repeat: no-repeat;background-position: bottom right;" oninput="onInput()"></textarea>
</div>
</form>
<div style="float:right;width:400px;">
<h4>Our翻译：</h4>
<div class="fra" id = "ourtranslate" style = "width:600px;;border-radius:3px;border:1px solid #ffffff;background:#ffffff;">
</div>
</div>
</div>
<div style = "clear:both">
<div style = "width:1100px">
<div style="float:right;width:400px;">
<pre>&#9&#9&#9&nbsp<input type = "button" class = "btn" value = "G/B翻译" style = "width:110px;height:35px;" onclick="get()"></pre>
<h4>Google翻译：</h4>
<div class="fra" id = "googletranslate" style = "width:600px;border-radius:3px;border:1px solid #ffffff;background:#ffffff;">
</div>
</div>
</div>
</div>
<div style = "clear:both">
<div style = "width:1100px">
<div style="float:right;width:400px;">
<h4>Baidu翻译：</h4>
<div class="fra" id = "baidutranslate" style = "width:600px;border-radius:3px;border:1px solid #ffffff;background:#ffffff;">
</div>
</div>
</div>
</div>
</div>
</body>
</html>