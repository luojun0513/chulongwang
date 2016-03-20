package com.clw.core.code;

import java.util.HashMap;
import java.util.Map;

public enum ProductInfoStateCode {
	
	未发布("01","未发布"),已发布("02","已发布"),已下架("03","已下架");
    
    private String code;

    private String msg;

    private ProductInfoStateCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public static Map<String, ProductInfoStateCode> codeMap;
	private static Map<String, ProductInfoStateCode> nameMap;
	static {
		codeMap = new HashMap<String, ProductInfoStateCode>();
		nameMap = new HashMap<String, ProductInfoStateCode>();
		for (ProductInfoStateCode status : ProductInfoStateCode.values()) {
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
