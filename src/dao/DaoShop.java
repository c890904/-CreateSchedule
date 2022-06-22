package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.ModelShop;

public class DaoShop extends BaseDao{
	public static void add(ModelShop shop) throws Exception{
		Connection con = getConnection();
		
		String sql = "INSERT INTO shop(id, name, groupid) VALUES (?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, shop.getId());
		ps.setString(2, shop.getName());
		ps.setString(3, shop.getGroupId());
		ps.execute();
		
		ps.close();
		con.close();
	}
}
