package com.example.mybatis;

import com.example.mybatis.entity.OrderItem;
import com.example.mybatis.repository.OrderItemMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cz.jay
 * @creater 2020-10-04 4:48 下午
 */
@SpringBootApplication
@RestController
@MapperScan("com.example.mybatis.repository")
@PropertySource("classpath:datasource.properties")
public class MybatisApplication {

	@Autowired
	private OrderItemMapper orderItemMapper;

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}

	@RequestMapping("/order-item/query")
	public OrderItem queryOrderItem() {
		OrderItem orderItem = orderItemMapper.selectByPrimaryKey(1L);
		return orderItem;
	}
}
