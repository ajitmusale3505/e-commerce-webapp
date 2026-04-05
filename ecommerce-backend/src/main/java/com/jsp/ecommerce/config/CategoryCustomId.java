package com.jsp.ecommerce.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CategoryCustomId implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object owner) {
		 String prefix = "CTEGORY";
		 int suffix = 0;
		 
		 JdbcConnectionAccess access = session.getJdbcConnectionAccess();
		 
		 try {
			 Connection conn = access.obtainConnection();
			 Statement st = conn.createStatement();
			 ResultSet rs = st.executeQuery("SELECT nextval('category')");
			 
			 if (rs.next()) {
				suffix = rs.getInt(1);
			}
			 rs.close();
			 st.close();
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		}
		return  prefix+suffix;
	}

}
