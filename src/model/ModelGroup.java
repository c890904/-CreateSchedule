package model;

public class ModelGroup {
	private String Id;
	private String Name;
	private ModelShop[] Shops;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ModelShop[] getShops() {
		return Shops;
	}
	public void setShops(ModelShop[] shops) {
		Shops = shops;
	}
	
	public ModelGroup() {}
	
	public ModelGroup(String id, String name) {
		Id = id;
		Name = name;
	}
	
	public ModelGroup(ModelShop shop) {
		Id = shop.getGroupId();
		Name = shop.getName();
	}
}
