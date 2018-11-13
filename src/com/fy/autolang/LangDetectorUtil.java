package com.fy.autolang;
 
import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
 

public class LangDetectorUtil {
	/**
	 * Load the profile in a static way
	 */
	static{
		try {
			DetectorFactory.loadProfile(Thread.currentThread().getContextClassLoader().getResource("lang").getPath().replace("%20"," "));
		} catch (LangDetectException e) {
			e.printStackTrace();
		}
	}
 
	/**
	 * Get the language used in the original string.
	 * @param originalStr the original string
	 * @return
	 */
	public String getLangUsed(String originalStr){
		String langUsed="";
		Detector detector;
		try {
			detector = DetectorFactory.create();
			detector.append(originalStr);
			langUsed= detector.detect();
		} catch (LangDetectException e) {
			e.printStackTrace();
		}
		return langUsed;
	}
	
	/**
	 * Does the original string contain Chinese?
	 * @param originalStr
	 * @return
	 */
	public static boolean containsChinese(String originalStr) {
		boolean containsChinese = false;
		LangDetectorUtil ldtu = new LangDetectorUtil();
		if("zh-cn".equals(ldtu.getLangUsed(originalStr))){
			containsChinese=true;
		}
		return containsChinese;
		
	}
	
	/**
	 * Does the original string contain English?
	 * @param originalStr
	 * @return
	 */
	public static boolean containsEnglish(String originalStr) {
		boolean containsEnglish = false;
		LangDetectorUtil ldtu = new LangDetectorUtil();
		if("en".equals(ldtu.getLangUsed(originalStr))){
			containsEnglish=true;
		}
		return containsEnglish;		
	}
	
	/**
	 * Does the original string contain Japanese?
	 * @param originalStr
	 * @return
	 */
	public static boolean containsJapanese(String originalStr) {
		boolean containsJapanese = false;
		LangDetectorUtil ldtu = new LangDetectorUtil();
		if("ja".equals(ldtu.getLangUsed(originalStr))){
			containsJapanese=true;
		}
		return containsJapanese;		
	}
	
	/**
	 * Does the original string contain Arabic?
	 * @param originalStr
	 * @return
	 */
	public static boolean containsArabic(String originalStr) {
		boolean containsArabic = false;
		LangDetectorUtil ldtu = new LangDetectorUtil();
		if("ar".equals(ldtu.getLangUsed(originalStr))){
			containsArabic=true;
		}
		return containsArabic;		
	}	
 
	/**
	 * Does the original string contain Russian?
	 * @param originalStr
	 * @return
	 */
	public static boolean containsRussian(String originalStr) {
		boolean containsRussian = false;
		LangDetectorUtil ldtu = new LangDetectorUtil();
		if("ru".equals(ldtu.getLangUsed(originalStr))){
			containsRussian=true;
		}
		return containsRussian;		
	}
	
	/**
	 * Does the original string contain France?
	 * @param originalStr
	 * @return
	 */
	public static boolean containsFrench(String originalStr) {
		boolean containsFrench = false;
		LangDetectorUtil ldtu = new LangDetectorUtil();
		if("fr".equals(ldtu.getLangUsed(originalStr))){
			containsFrench=true;
		}
		return containsFrench;		
	}
	
	/**
	 * Does the original string contain Spanish?
	 * @param originalStr
	 * @return
	 */
	public static boolean containsSpanish(String originalStr) {
		boolean containsSpanish = false;
		LangDetectorUtil ldtu = new LangDetectorUtil();
		if("es".equals(ldtu.getLangUsed(originalStr))){
			containsSpanish=true;
		}
		return containsSpanish;		
	}
	
	/**
	 * Does the original string contain Portuguese?
	 * @param originalStr
	 * @return
	 */
	public static boolean containsPortuguese(String originalStr) {
		boolean containsPortuguese = false;
		LangDetectorUtil ldtu = new LangDetectorUtil();
		if("pt".equals(ldtu.getLangUsed(originalStr))){
			containsPortuguese=true;
		}
		return containsPortuguese;		
	}
 
	/**
	 * Does the original string contain German?
	 * @param originalStr
	 * @return
	 */
	public static boolean containsGerman(String originalStr) {
		boolean containsGerman = false;
		LangDetectorUtil ldtu = new LangDetectorUtil();
		if("de".equals(ldtu.getLangUsed(originalStr))){
			containsGerman=true;
		}
		return containsGerman;
	}
	

}
