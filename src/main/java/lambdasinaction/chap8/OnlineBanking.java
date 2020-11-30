package lambdasinaction.chap8;

/**
 * 8.2.2 模板方法
 *
 * @param null
 * @return 
 * @throw 
 *
 * @author wangyh2
 * @since  2020/11/24 13:23 
 */
abstract class OnlineBanking {
    public void processCustomer(int id){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }
    abstract void makeCustomerHappy(Customer c);


    // dummy Customer class
    static private class Customer {}
    // dummy Datbase class
    static private class Database{
        static Customer getCustomerWithId(int id){ return new Customer();}
    }
}
