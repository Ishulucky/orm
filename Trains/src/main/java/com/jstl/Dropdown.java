package com.jstl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Dropdown extends TagSupport {
	String tableName;
	String columnName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			Class.forName("org.postgresql.Driver");

			
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Srirama@");

			
			String sqlQuery = "SELECT " + columnName + " FROM " + tableName;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);

			
			out.println("<select>");
			while (rs.next()) {
				String columnValue = rs.getString(5);
				out.println("<option value='" + columnValue + "'>" + columnValue + "</option>");
			}
			out.println("</select>");

			
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
}
