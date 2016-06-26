/**
 * 
 */
package me.hub.loja;

/**
 * @author adriancf
 *
 */
public enum ShopType {

	Coins("Coins","§e"),
	Planets("Planets","§6"),
	Cash("Cash","§5");
	
	  public String Name = "";
	  public String Cor = "";
	  
	  private ShopType(String name, String cor)
	  {
	    this.Cor = cor;
	    this.Name = name;
	  }
	  public String GetTag()
	  {
	    String name = this.Name;
	    return this.Cor + name;
	  }
}
