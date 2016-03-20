package com.clw.core.dao.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO{
	
	public static final Logger logger = LoggerFactory.getLogger(BaseDAO.class);
    public ISuperDAO superDAO;

    public ISuperDAO getSuperDAO() {
        return superDAO;
    }
    
    @Autowired
    public void setSuperDAO(ISuperDAO superDAO) {
        this.superDAO = superDAO;
    }
}
