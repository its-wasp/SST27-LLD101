public class Demo09 {
    public static void main(String[] args) {
        OrderController sqlController = new OrderController(new SqlOrderRepository());
        OrderController noSqlController = new OrderController(new NoSqlOrderRepository());
        sqlController.create("ORD-1");
        noSqlController.create("ORD-2");
    }
}
