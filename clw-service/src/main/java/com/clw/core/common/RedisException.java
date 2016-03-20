package com.clw.core.common;

public class RedisException extends Exception{
	public RedisException(){
		super();
	}
	
	public RedisException(String message,Throwable e){
		super(message, e);
	}
}
