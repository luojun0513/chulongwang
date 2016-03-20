package com.clw.core.code;

import java.util.HashMap;
import java.util.Map;

public enum NewsInfoStateCode {
	
	未发布("01","未发布"),已发布("02","已发布"),已关闭("03","已关闭");
    
    private String code;

    private String msg;

    private NewsInfoStateCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public static Map<String, NewsInfoStateCode> codeMap;
	private static Map<String, NewsInfoStateCode> nameMap;
	static {
		codeMap = new HashMap<String, NewsInfoStateCode>();
		nameMap = new HashMap<String, NewsInfoStateCode>();
		for (NewsInfoStateCode status : NewsInfoStateCode.values()) {
			codeMap.put(status.getCode(), status);
			nameMap.put(status.getMsg(), status);
		}
	}
	
    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
