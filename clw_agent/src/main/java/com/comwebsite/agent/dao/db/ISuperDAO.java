package com.comwebsite.agent.dao.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.comwebsite.agent.common.BaseParamDTO;
import com.comwebsite.agent.common.Pagination;


public interface ISuperDAO {
	
	public String getId();
	
	public Integer insert(String statementName,Object parameterObject);
	
	public Integer update(String statementName, Object parameterObject);
	
	public Integer delete(String statementName, Object parameterObject);
	
	public <T> List<T> getList(String statementName, Object parameterObject);

    public Pagination queryPagination(String statementName, BaseParamDTO baseParamDTO);

    public Pagination queryPagination(String statementName, HashMap query, BaseParamDTO baseParamDTO);
    
    public <T, V> Map<T, V> getMap(String statementName, Object parameterObject, String key);

    public <T> T getObject(String statementName, Object parameterObject);
}
