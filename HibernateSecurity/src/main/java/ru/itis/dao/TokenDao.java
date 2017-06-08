package ru.itis.dao;

import ru.itis.models.Token;

/**
 * 13.05.2017
 * BaseTokenDao
 * @author Aivar Yusupov
 * @version v0.1 /
 */

public interface TokenDao extends BaseDao<Token> {
	
	Token findByToken(String token);
	
}