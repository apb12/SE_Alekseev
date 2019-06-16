package sef.module13.activity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

	@SuppressWarnings("unused")
	private Connection conn;

	public AccountDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public List<Account> findAccount(String firstName, String lastName)
			throws AccountDAOException {
		List<Account> list = new ArrayList<>();
		try {
			PreparedStatement pst = conn.prepareStatement("select * from Account where FIRST_NAME=? or LAST_NAME=? order by ID asc ");

			pst.setString(1, firstName);
			pst.setString(2, lastName);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new AccountImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Account findAccount(int id) throws AccountDAOException {
		Account acc = null;

		try {
			PreparedStatement pst = conn.prepareStatement("select * from Account where ID=?");

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				acc = new AccountImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return acc;
	}


	public boolean insertAccount(String firstName, String lastName, String email)
			throws AccountDAOException {
		int i = 0;
		try {
			PreparedStatement pst = conn.prepareStatement("Insert into ACCOUNT  values  (Account_SEQ.nextval,?,?,?)");
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, email);
			i = pst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		return i > 0;
	}
}
