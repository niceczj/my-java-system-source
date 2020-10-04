package com.example.mybatis;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cz.jay
 * @creater 2020-09-16 9:49 上午
 */
public class JDBCDemo {
	public static void main(String[] args) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		List<Map<String, String>> resultList = new ArrayList<>();

		try {
			// ① 加载JDBC驱动
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			// ② 获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/spring_cloud_simple?user=root&password=123456" +
					"&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true");

			String sql = "select * from order_item where id = ?";
			// ③ 创建Statement对象
			stmt = connection.prepareStatement(sql);

			// ④ 设置传入参数
			stmt.setLong(1, 1L);

			// ⑤ 执行SQL语句
			rs = stmt.executeQuery();

			// ⑥ 处理查询结果（将查询结果转换成List<Map>格式）
			ResultSetMetaData rsmd = rs.getMetaData();
			int num = rsmd.getColumnCount();

			while (rs.next()) {
				Map map = new HashMap(16);
				for (int i = 0; i < num; i++) {
					String columnName = rsmd.getColumnName(i + 1);
					map.put(columnName, rs.getString(columnName));
				}
				resultList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ⑦ 断开连接
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqlEx) {
				}

				connection = null;
			}
		}
	}
}
