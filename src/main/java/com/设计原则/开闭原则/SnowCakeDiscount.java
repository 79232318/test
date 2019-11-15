/**  
* @Title: SnowCakeDiscount.java  
* @Package com.设计模式.开闭原则  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年9月29日  
* @version V1.0  
*/  
package com.设计原则.开闭原则;

/**  
* <p>Description: </p>
* @ClassName: SnowCakeDiscount  
* @author wangtz  
* @date 2019年9月29日    
*/
public class SnowCakeDiscount extends SnowCake {

	public SnowCakeDiscount(Integer id, String taste, Double price) {
        super(id, taste, price);
    }

    @Override
    public Integer getID() {
        return super.getID();
    }

    @Override
    public String getTaste() {
        return super.getTaste();
    }

    @Override
    public Double getPrice() {
        return super.getPrice()*0.8;
    }

    @Override
    public String toString() {
        return "SnowCake{" +
                "id=" + super.getID() +
                ", taste='" + super.getTaste()+ '\'' +
                ", price=" + super.getPrice()*0.8 +
                '}';
    }

}
