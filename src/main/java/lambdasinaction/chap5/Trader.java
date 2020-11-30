package lambdasinaction.chap5;
/**
 * 5.5.1 交易员
 *
 * @param null
 * @return 
 * @throw 
 *
 * @author wangyh2
 * @since  2020/11/17 16:14 
 */
public  class Trader{
	
	private String name;
	private String city;

	public Trader(String n, String c){
		this.name = n;
		this.city = c;
	}

	public String getName(){
		return this.name;
	}

	public String getCity(){
		return this.city;
	}

	public void setCity(String newCity){
		this.city = newCity;
	}

	@Override
	public String toString(){
		return "Trader:"+this.name + " in " + this.city;
	}
}