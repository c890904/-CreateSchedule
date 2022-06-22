package model;

import java.util.UUID;

public class ModelShop {
	private String Id;
	private String Name;
	private String GroupId;
	
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
	public String getGroupId() {
		return GroupId;
	}
	public void setGroupId(String groupId) {
		GroupId = groupId;
	}
	
	public ModelShop() {}
	
	public ModelShop(String name, String... groupId) {
		Id = UUID.randomUUID().toString();
		Name = name;
		if (groupId.length > 0) {
			GroupId = groupId[0];
		}
	}
}
