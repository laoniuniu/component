package com.deppon.demo.commons.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 将java对象树装换成xml格式工具类
 * @author 陈帅
 * @createDate 2012-10-22
 * */
public class JavaObjectToXmlUtil {
	
	/**
	 * 字符编码
	 * */
	private static  String charset = "UTF-8";
	
	/**
	 * 将指定的java对象转换成xml格式的字符串
	 * @param classPath
	 * */
	public static String javaObjectToXmlStr(String classPath,Object obj){
		String xmlStr = null;
		
		if(classPath == null ||
				"".equals(classPath)){
			return xmlStr;
		}
		
		if(obj == null ||
				"".equals(obj)){
			return xmlStr;
		}
		Class<?> classes = null;
		JAXBContext context = null;
		OutputStream os =  null;
		try {
			classes = Class.forName(classPath);
			context = JAXBContext.newInstance(classes);
			os = new ByteArrayOutputStream()  ;
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING,charset);//编码格式   
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//是否格式化生成的xml串   
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);//是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）   
//            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION,"sdfsdf");
//            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "dsfsdfsdf");
            marshaller.marshal(obj, os);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(os != null){
				try {
					os.flush();
					xmlStr = os.toString() == null ? "" : new String(os.toString().getBytes(),charset);
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return xmlStr == null ? "" : xmlStr;
	}
	
	/**
	 * 将xml格式字符串转换成java对象
	 * */
	public static Object xmlToJavaObject(String xmlStr,String classPath){
		
		Object obj = null;
		
		if(classPath == null ||
				"".equals(classPath)){
			return obj;
		}
		
		if(xmlStr == null ||
				"".equals(xmlStr)){
			return obj;
		}
		
		JAXBContext context = null;
		Class<?> classes = null;
		Reader reader = null;
		
		try {
			classes = Class.forName(classPath);
			reader = new StringReader(xmlStr);
			context = JAXBContext.newInstance(classes);
			Unmarshaller unmar = context.createUnmarshaller();
			obj = unmar.unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) {

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar gc = null;
        try {
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {

             e.printStackTrace();
        }
        return gc;
    }
}
