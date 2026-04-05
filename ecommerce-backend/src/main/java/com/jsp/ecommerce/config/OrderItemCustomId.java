package com.jsp.ecommerce.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderItemCustomId implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object owner) {

	    String prefix = "ORDERITEM";

	    try {
	        JdbcConnectionAccess access = session.getJdbcConnectionAccess();
	        Connection conn = access.obtainConnection();

	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery("SELECT nextval('\"orderItemseq\"')"); // lowercase

	        if (rs.next()) {
	            int suffix = rs.getInt(1);

	            rs.close();
	            st.close();

	            return prefix + suffix; // ✅ RETURN HERE
	        }

	    } catch (Exception e) {
	        throw new RuntimeException("Error generating OrderItem ID", e);
	    }

	    throw new RuntimeException("Failed to generate OrderItem ID");
	}

}
