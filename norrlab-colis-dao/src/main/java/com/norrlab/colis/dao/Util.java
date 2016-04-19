package com.norrlab.colis.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Util 
{
     public static Class<?> getGenericClass(Class<?> clazz){ 
    	 
    	 Type type = clazz.getGenericSuperclass();
    	 
    	 ParameterizedType pt = (ParameterizedType) type;
    	 
    	 if(pt.getActualTypeArguments()[0] instanceof Class){
    		 return (Class<?>) pt.getActualTypeArguments()[0];
    	 }
    	 else{
    		 return null;
    	 }
    	 
    	 
     }
}
