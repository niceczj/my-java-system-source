package com.example.mybatis;

import com.example.mybatis.entity.OrderItem;
import com.example.mybatis.repository.OrderItemMapper;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author cz.jay
 * @creater 2020-09-16 9:49 上午
 */
public class MybatisDemo {
	public static void main(String[] args) throws IOException {
		selectWithPage();
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


	private static void selectWithPage() throws IOException {
		String resource = "mybatis-api-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			OrderItemMapper mapper = session.getMapper(OrderItemMapper.class);
			PageHelper.startPage(0, 1);
			List<OrderItem> orderItems = mapper.selectAll();
			System.out.println(orderItems.size());
		}
	}
}
