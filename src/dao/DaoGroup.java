package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ModelGroup;

public class DaoGroup extends BaseDao{
	public static ModelGroup[] getList() throws Exception {
		ArrayList<ModelGroup> groupArr = new ArrayList<ModelGroup>();
		
		Connection con = getConnection();
		
		String sql = "select * from shop_group";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ModelGroup group = new ModelGroup(rs.getString("id"), rs.getString("name"));
			groupArr.add(group);
		}
		
		return groupArr.toArray(new ModelGroup[0]);
	}
	
	public static void add(ModelGroup group) throws Exception {
		Connection con = getConnection();
		
		String sql = "INSERT INTO shop_group(id, name) VALUES (?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, group.getId());
		ps.setString(2, group.getName());
		ps.execute();
		
		ps.close();
		con.close();
	}
}
