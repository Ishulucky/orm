package com.jstl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class JstlTagDrop extends TagSupport {
	String tableName;
	String columnName;
	String url;
	String user;
	String password;
	String valueColumn;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValueColumn() {
		return valueColumn;
	}

	public void setValueColumn(String valueColumn) {
		this.valueColumn = valueColumn;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(url + "?user=" + user + "&password=" + password);
			Statement st = con.createStatement();

			if (valueColumn == null) {

				ResultSet rs = st.executeQuery("SELECT " + columnName + " FROM " + tableName);
				out.println("<select>");
				while (rs.next()) {
					String columnValue = rs.getString(columnName);
					out.println("<option value='" + columnValue + "'>" + columnValue + "</option>");
				}
				out.println("</select>");
				rs.close();
			} else {
				ResultSet rs = st.executeQuery("SELECT " + columnName + "," + valueColumn + " FROM " + tableName);
				out.println("<select>");
				while (rs.next()) {
					String columnValue = rs.getString(columnName);
					String columnValue2 = rs.getString(valueColumn);
					out.println(
							"<option value='" + columnValue + "'>" + columnValue + " " + columnValue2 + "</option>");
				}
				out.println("</select>");
				rs.close();
			}

			st.close();
			con.close();
		} catch (

		Exception e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}

}