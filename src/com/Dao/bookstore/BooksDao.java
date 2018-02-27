package com.Dao.bookstore;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connect.bookstore.jdbcutil;
import com.model.bookstore.Books;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.tools.bookstore.PageUtil;

public class BooksDao {
	public static ArrayList<Books> randomBook() throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "SELECT * FROM books order by rand() limit 6;";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		ArrayList<Books> books = new ArrayList<>();
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Books book = new Books();
			book.setId(resultSet.getInt("Id"));
			book.setTitle(resultSet.getString("Title"));
			book.setAuthor(resultSet.getString("Author"));
			book.setPublisherId(resultSet.getInt("PublisherId"));
			book.setPublishDate(resultSet.getDate("PublishDate"));
			book.setISBN(resultSet.getString("ISBN"));
			book.setWordsCount(resultSet.getInt("WordsCount"));
			book.setUnitPrice(resultSet.getFloat("UnitPrice"));
			book.setContentDescription(resultSet.getString("ContentDescription"));
			book.setAurhorDescription(resultSet.getString("AurhorDescription"));
			book.setEditorComment(resultSet.getString("EditorComment"));
			book.setTOC(resultSet.getString("TOC"));
			book.setCategoryId(resultSet.getInt("CategoryId"));
			book.setClicks(resultSet.getInt("Clicks"));
			book.setRepertory(resultSet.getInt("Repertory"));
			books.add(book);
		}
		jdbcutil.close(connection);
		return books;
	}
	public static PageUtil queryBooks(int pageNo,int pageSize,String type) throws SQLException {
		Connection connection = jdbcutil.getConection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Books> books = new ArrayList<>();
		PageUtil page = null;
		try {
            //获取总数据条数
            int totalCount = 0; 
            preparedStatement = (PreparedStatement) connection.prepareStatement("select count(*) from books where isbn like ? or title like ? or Author like ?");
    		preparedStatement.setString(1, "%"+type+"%");
    		preparedStatement.setString(2, "%"+type+"%");
    		preparedStatement.setString(3, "%"+type+"%");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                totalCount = resultSet.getInt(1);
            }
            preparedStatement = (PreparedStatement) connection.prepareStatement("select * from books where isbn like ? or title like ? or Author like ? limit " + (pageNo-1)*pageSize+","+pageSize);
    		preparedStatement.setString(1, "%"+type+"%");
    		preparedStatement.setString(2, "%"+type+"%");
    		preparedStatement.setString(3, "%"+type+"%");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
            	Books book = new Books();
    			book.setId(resultSet.getInt("Id"));
    			book.setTitle(resultSet.getString("Title"));
    			book.setAuthor(resultSet.getString("Author"));
    			book.setPublisherId(resultSet.getInt("PublisherId"));
    			book.setPublishDate(resultSet.getDate("PublishDate"));
    			book.setISBN(resultSet.getString("ISBN"));
    			book.setWordsCount(resultSet.getInt("WordsCount"));
    			book.setUnitPrice(resultSet.getFloat("UnitPrice"));
    			book.setContentDescription(resultSet.getString("ContentDescription"));
    			book.setAurhorDescription(resultSet.getString("AurhorDescription"));
    			book.setEditorComment(resultSet.getString("EditorComment"));
    			book.setTOC(resultSet.getString("TOC"));
    			book.setCategoryId(resultSet.getInt("CategoryId"));
    			book.setClicks(resultSet.getInt("Clicks"));
    			book.setRepertory(resultSet.getInt("Repertory"));
    			books.add(book);
            }
            page = new PageUtil(pageSize, totalCount);
            page.setData(books);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbcutil.close(connection);
        }
		return page;
	}
	public static ArrayList<Books> phoneQueryBooks(String type) throws SQLException {
		Connection connection = jdbcutil.getConection();
		ArrayList<Books> books = new ArrayList<>();
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("select * from books where isbn like ? or title like ? or Author like ? ");
    		preparedStatement.setString(1, "%"+type+"%");
    		preparedStatement.setString(2, "%"+type+"%");
    		preparedStatement.setString(3, "%"+type+"%");
    		System.out.println(preparedStatement);
           ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
            	Books book = new Books();
    			book.setId(resultSet.getInt("Id"));
    			book.setTitle(resultSet.getString("Title"));
    			book.setAuthor(resultSet.getString("Author"));
    			book.setPublisherId(resultSet.getInt("PublisherId"));
    			book.setPublishDate(resultSet.getDate("PublishDate"));
    			book.setISBN(resultSet.getString("ISBN"));
    			book.setWordsCount(resultSet.getInt("WordsCount"));
    			book.setUnitPrice(resultSet.getFloat("UnitPrice"));
    			book.setContentDescription(resultSet.getString("ContentDescription"));
    			book.setAurhorDescription(resultSet.getString("AurhorDescription"));
    			book.setEditorComment(resultSet.getString("EditorComment"));
    			book.setTOC(resultSet.getString("TOC"));
    			book.setCategoryId(resultSet.getInt("CategoryId"));
    			book.setClicks(resultSet.getInt("Clicks"));
    			book.setRepertory(resultSet.getInt("Repertory"));
    			books.add(book);
            }
            jdbcutil.close(connection);
		return books;
	}
	public static PageUtil getBooks(int pageNo,int pageSize) throws SQLException {
		Connection connection = jdbcutil.getConection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Books> books = new ArrayList<>();
		PageUtil page = null;
		try {
            //获取总数据条数
            int totalCount = 0; 
            preparedStatement = (PreparedStatement) connection.prepareStatement("select count(id) from books");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                totalCount = resultSet.getInt(1);
            }
            preparedStatement = (PreparedStatement) connection.prepareStatement("select * from books limit " + (pageNo-1)*pageSize+","+pageSize);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
            	Books book = new Books();
    			book.setId(resultSet.getInt("Id"));
    			book.setTitle(resultSet.getString("Title"));
    			book.setAuthor(resultSet.getString("Author"));
    			book.setPublisherId(resultSet.getInt("PublisherId"));
    			book.setPublishDate(resultSet.getDate("PublishDate"));
    			book.setISBN(resultSet.getString("ISBN"));
    			book.setWordsCount(resultSet.getInt("WordsCount"));
    			book.setUnitPrice(resultSet.getFloat("UnitPrice"));
    			book.setContentDescription(resultSet.getString("ContentDescription"));
    			book.setAurhorDescription(resultSet.getString("AurhorDescription"));
    			book.setEditorComment(resultSet.getString("EditorComment"));
    			book.setTOC(resultSet.getString("TOC"));
    			book.setCategoryId(resultSet.getInt("CategoryId"));
    			book.setClicks(resultSet.getInt("Clicks"));
    			book.setRepertory(resultSet.getInt("Repertory"));
    			books.add(book);
            }
            page = new PageUtil(pageSize, totalCount);
            page.setData(books);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbcutil.close(connection);
        }
		return page;
	}
	public static Books getBook(int id) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from books where id = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		Books book = new Books();
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			book.setId(resultSet.getInt("Id"));
			book.setTitle(resultSet.getString("Title"));
			book.setAuthor(resultSet.getString("Author"));
			book.setPublisherId(resultSet.getInt("PublisherId"));
			book.setPublishDate(resultSet.getDate("PublishDate"));
			book.setISBN(resultSet.getString("ISBN"));
			book.setWordsCount(resultSet.getInt("WordsCount"));
			book.setUnitPrice(resultSet.getFloat("UnitPrice"));
			book.setContentDescription(resultSet.getString("ContentDescription"));
			book.setAurhorDescription(resultSet.getString("AurhorDescription"));
			book.setEditorComment(resultSet.getString("EditorComment"));
			book.setTOC(resultSet.getString("TOC"));
			book.setCategoryId(resultSet.getInt("CategoryId"));
			book.setClicks(resultSet.getInt("Clicks"));
			book.setRepertory(resultSet.getInt("Repertory"));

		}
		jdbcutil.close(connection);
		return book;
	}
	public static ArrayList<Books> queryBooks(String type) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from books where isbn like ? or title like ? or Author like ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

		ArrayList<Books> books = new ArrayList<>();
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Books book = new Books();
			book.setId(resultSet.getInt("Id"));
			book.setTitle(resultSet.getString("Title"));
			book.setAuthor(resultSet.getString("Author"));
			book.setPublisherId(resultSet.getInt("PublisherId"));
			book.setPublishDate(resultSet.getDate("PublishDate"));
			book.setISBN(resultSet.getString("ISBN"));
			book.setWordsCount(resultSet.getInt("WordsCount"));
			book.setUnitPrice(resultSet.getFloat("UnitPrice"));
			book.setContentDescription(resultSet.getString("ContentDescription"));
			book.setAurhorDescription(resultSet.getString("AurhorDescription"));
			book.setEditorComment(resultSet.getString("EditorComment"));
			book.setTOC(resultSet.getString("TOC"));
			book.setCategoryId(resultSet.getInt("CategoryId"));
			book.setClicks(resultSet.getInt("Clicks"));
			book.setRepertory(resultSet.getInt("Repertory"));
			books.add(book);
		}
		jdbcutil.close(connection);
		return books;
	}
	public static boolean addBook(String title, String author, int publisherId, Date publishDate, String iSBN,
			int wordsCount, float unitPrice, String contentDescription, String aurhorDescription, String editorComment,
			String tOC, int categoryId, int clicks, int repertory) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "insert books(title,author,publisherId,publishDate,iSBN,wordsCount,unitPrice,contentDescription,aurhorDescription,editorComment,tOC,categoryId,clicks,repertory) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setString(1, title);
		preparedStatement.setString(2, author);
		preparedStatement.setInt(3, publisherId);
		preparedStatement.setDate(4, publishDate);
		preparedStatement.setString(5, iSBN);
		preparedStatement.setInt(6, wordsCount);
		preparedStatement.setFloat(7, unitPrice);
		preparedStatement.setString(8, contentDescription);
		preparedStatement.setString(9, aurhorDescription);
		preparedStatement.setString(10, editorComment);
		preparedStatement.setString(11, tOC);
		preparedStatement.setInt(12, categoryId);
		preparedStatement.setInt(13, clicks);
		preparedStatement.setInt(14, repertory);
		int flag = preparedStatement.executeUpdate();
		jdbcutil.close(connection);
		return flag==1?true:false;
	}
	public static boolean updateBook(int id, String title, String author, int publisherId, Date publishDate, String iSBN,
			int wordsCount, float unitPrice, String contentDescription, String aurhorDescription, String editorComment,
			String tOC, int categoryId, int clicks, int repertory) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "update books set title=?,author=?,publisherId=?,publishDate=?,iSBN=?,wordsCount=?,unitPrice=?,contentDescription=?,aurhorDescription=?,editorComment=?,tOC=?,categoryId=?,clicks=?,repertory=? where id = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setString(1, title);
		preparedStatement.setString(2, author);
		preparedStatement.setInt(3, publisherId);
		preparedStatement.setDate(4, publishDate);
		preparedStatement.setString(5, iSBN);
		preparedStatement.setInt(6, wordsCount);
		preparedStatement.setFloat(7, unitPrice);
		preparedStatement.setString(8, contentDescription);
		preparedStatement.setString(9, aurhorDescription);
		preparedStatement.setString(10, editorComment);
		preparedStatement.setString(11, tOC);
		preparedStatement.setInt(12, categoryId);
		preparedStatement.setInt(13, clicks);
		preparedStatement.setInt(14, repertory);
		preparedStatement.setInt(15, id);
		int flag = preparedStatement.executeUpdate();
		jdbcutil.close(connection);
		return flag==1?true:false;
	}
	public static boolean deleteBook(int id) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "delete from books where id=?";		
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		boolean flag = preparedStatement.execute();
		jdbcutil.close(connection);
		return flag;
	}
}
