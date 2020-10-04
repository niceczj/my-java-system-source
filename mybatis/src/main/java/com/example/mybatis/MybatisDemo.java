package com.example.mybatis;

import com.example.mybatis.entity.OrderItem;
import com.example.mybatis.repository.OrderItemMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author cz.jay
 * @creater 2020-09-16 9:49 上午
 */
public class MybatisDemo {
	public static void main(String[] args) throws IOException {
		select();
	}

	private static void select() throws IOException {
		String resource = "mybatis-api-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			OrderItemMapper mapper = session.getMapper(OrderItemMapper.class);
			OrderItem orderItem = mapper.selectByPrimaryKey(1L);
			System.out.println(orderItem);
		}
	}
}
