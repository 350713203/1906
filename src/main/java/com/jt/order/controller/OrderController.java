

//@Controller
//@RequestMapping("/order")
//public class OrderController {
	
//	@Autowired
//	private OrderService orderService;
//	private static ObjectMapper objectMapper = new ObjectMapper();
//	
//	
//	//http://order.jt.com/order/create
//	@RequestMapping("/create")
//	@ResponseBody
//	public SysResult saveOrder(String orderJSON){
//		try {
//			Order order = objectMapper.readValue(orderJSON, Order.class);
//			String orderId = orderService.saveOrder(order);
//			if(StringUtils.isEmpty(orderId)){
//				throw new RuntimeException();
//			}
//			return SysResult.oK(orderId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return SysResult.build(201, "新增订单失败");
//	}
//	
//	//http://order.jt.com/order/query/"+id;
//	@RequestMapping("/query/{orderId}")
//	@ResponseBody
//	public Order findOrderById(@PathVariable String orderId){
//		
//		return orderService.findOrderById(orderId);
//	}
	
	
	
	
	
//}