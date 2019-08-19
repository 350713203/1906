package com.jt.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.order.mapper.OrderItemMapper;
import com.jt.order.mapper.OrderMapper;
import com.jt.order.mapper.OrderShippingMapper;
import com.jt.order.pojo.Order;
import com.jt.order.pojo.OrderItem;
import com.jt.order.pojo.OrderShipping;

//@Service
public class OrderMsgConsumer {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@Autowired
	private OrderShippingMapper orderShippingMapper;

	

	public void saveOrder(Order order) {
//		//拼接orderId号
//		String orderId = order.getUserId() + "" + System.currentTimeMillis();
		Date date = new Date();
		String orderId = order.getOrderId();
		//入库订单
//		order.setOrderId(orderId);
		order.setStatus(1); 
		order.setCreated(date);
		order.setUpdated(date);
		orderMapper.insert(order);
		System.out.println("订单入库成功!!!!!");
		
		//获取订单物流信息
		OrderShipping orderShipping = order.getOrderShipping();
		orderShipping.setOrderId(orderId);
		orderShipping.setCreated(date);
		orderShipping.setUpdated(date);
		orderShippingMapper.insert(orderShipping);
		System.out.println("订单物流信息入库成功!!");
		
		//实现订单商品入库
		List<OrderItem> orderItemList = order.getOrderItems();
		for (OrderItem orderItem : orderItemList) {
			orderItem.setOrderId(orderId);
			orderItem.setCreated(date);
			orderItem.setUpdated(date);
			orderItemMapper.insert(orderItem);
		}
		System.out.println("订单入库成功!!!");
	}
	
	
}
