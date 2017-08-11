package com.wsy;


import java.sql.*;
import java.util.*;
import java.text.*;

public class selectsql {
	public static ResultSet rs;
	public static stringTrans s;
	public static connsqlserver connsqlserver=new connsqlserver();
	/*
	 * 闁稿繐鍘栫花鐟僢_usertable閻炴稏鍔庡▓鎴﹀箼瀹ュ嫮绋�
	 */
	
	public static Collection getRet(){
		Collection ret=new ArrayList();

		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_usertable";
			rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				String names=rs.getString("name");
				String passwords=rs.getString("password");
				user user=new user();
				user.setName(names);
				user.setPassword(passwords);
				ret.add(user);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
	}
	public static int check(String name,String password){
		int i=0;
		String names="";
		String passwords="";
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_usertable where name='"+name+"'and password='"+password+"'";
			System.out.println(sql);
			rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				names=rs.getString("name");
				passwords=rs.getString("password");
				if(names!=null){
					i=1;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return i;
	}
	/*
	 * 闁稿繐鍘栫花鐟僢_news閻炴稏鍔庡▓鎴﹀箼瀹ュ嫮绋�
	 */
	public int Insert(String title,String author,String news){
		int i=0;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="insert into tb_news(title,author,content) values('"+title+"','"+author+"','"+news+"')";
			i=connsqlserver.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return i;
	}
	public void Insert1(String title,String author,String news){
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="insert into tb_business(title,author,content) values('"+title+"','"+author+"','"+news+"')";
			connsqlserver.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public	Collection selectNewsAll(){
		Collection ret=new ArrayList();
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_news order by id desc";
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				news news1=new news();
				news1.setId(rs.getString("id"));
				news1.setTitle(rs.getString("title"));
				news1.setContent(rs.getString("content"));
				news1.setAuthor(rs.getString("author"));
				news1.setSubmittime(rs.getString("submittime"));
				ret.add(news1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public	Collection selectNews(String id){
		String sql="select * from tb_news where id=?";
		Collection ret=new ArrayList();
		connsqlserver connsqlserver=new connsqlserver();
		Connection connection = connsqlserver.getConnection();
		try{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, (Integer.valueOf(id)).intValue());
			ResultSet rs = statement.executeQuery();
			//ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				String ids=rs.getString("id");
				String title=rs.getString("title");
				String author=rs.getString("author");
				String news=rs.getString("content");
				news news1=new news();
				news1.setId(ids);
				news1.setTitle(title);
				news1.setContent(news);
				news1.setAuthor(author);
				ret.add(news1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public	Collection selectNews(){
		Collection ret=new ArrayList();
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_news order by id desc limit 5";
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				String id=rs.getString(1);
				String title=rs.getString(2);
				String author=rs.getString(3);
				String news=rs.getString(4);
				news news1=new news();
				news1.setId(id);
				news1.setTitle(title);
				news1.setContent(news);
				news1.setAuthor(author);
				ret.add(news1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public	Collection selectMoreNewsFy(int page){
		Collection ret=new ArrayList();
		MoreNewsPage down=new MoreNewsPage();
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_news where id not in(select top "+down.getPageSize()*page+" id from tb_news  order by id)order by id limit 20";
			//String sql="select * from (select top 20 * from (select top "+10*page+" * from tb_business order by id ASC)as aSysTable order by id desc) as bsystable order by id ASC";
			//System.out.println(sql);
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				news n=new news();
				n.setId(rs.getString(1));
				n.setTitle(rs.getString(2));
				n.setContent(rs.getString(3));
				n.setAuthor(rs.getString(4));
				n.setSubmittime(rs.getString(4));
				ret.add(n);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public	Collection selectNewsFy(int page){
		Collection ret=new ArrayList();
		NewsPage down=new NewsPage();
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select top 10 * from tb_news where id not in(select top "+down.getPageSize()*page+" id from tb_news  order by id)order by id";
			//String sql="select * from (select top 20 * from (select top "+10*page+" * from tb_business order by id ASC)as aSysTable order by id desc) as bsystable order by id ASC";
			//System.out.println(sql);
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				news n=new news();
				n.setId(rs.getString(1));
				n.setTitle(rs.getString(2));
				n.setContent(rs.getString(3));
				n.setAuthor(rs.getString(4));
				n.setSubmittime(rs.getString(4));
				ret.add(n);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public	Collection selectNewsforqyxw(){
		Collection ret=new ArrayList();
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_news limit 20";
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				String id=rs.getString(1);
				String title=rs.getString(2);
				String author=rs.getString(3);
				String news=rs.getString(4);
				news news1=new news();
				news1.setId(id);
				news1.setTitle(title);
				news1.setContent(news);
				news1.setAuthor(author);
				ret.add(news1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public  int updateNews(String title,String content,String author,String id){
		int i=0;
		try{

			connsqlserver connsqlserver=new connsqlserver();
			String sql="UPDATE tb_news SET title = '"+title+"', content = '"+content+"', author = '"+author+"' WHERE (id = '"+id+"')";
			i=connsqlserver.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return i;
	}
	public int delNews(String id){
		int i=0;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="delete from tb_news where id='"+id+"'";
			i=connsqlserver.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return i;
	}
	/*
	 * 闁稿繐鍘栫花鐟僢_business閻炴稏鍔庡▓鎴﹀箼瀹ュ嫮绋�
	 */
	public	Collection selectBusinessAll(){
		Collection ret=new ArrayList();
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_business";
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				product product=new product();
				product.setId(rs.getString("id"));
				product.setImg(rs.getString("img"));
				product.setMsg(rs.getString("ms"));
				product.setName(rs.getString("name"));
				product.setSubmittime(rs.getString("submittime"));
				product.setCategory(rs.getString("category"));
				ret.add(product);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public	ResultSet selectbusiness(){
		ResultSet rs=null;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_business";
			rs=connsqlserver.executeQuery(sql);
			rs.last();
		}catch(Exception e){
			e.printStackTrace();
		}
		//connsqlserver.close();
		return rs;
		
	}
	public	Collection selectBusinessForId(String id){
		Collection ret=new ArrayList();
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_business where id='"+id+"'";
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				product product=new product();
				product.setId(rs.getString("id"));
				product.setImg(rs.getString("img"));
				product.setMsg(rs.getString("ms"));
				product.setName(rs.getString("name"));
				product.setSubmittime(rs.getString("submittime"));
				product.setCategory(rs.getString("category"));
				ret.add(product);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public	Collection selectBusinessFy(int page){
		Collection ret=new ArrayList();
		DownTable down=new DownTable();
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select top 10 * from tb_business where id not in(select top "+down.getPageSize()*page+" id from tb_business  order by id)order by id";
			//String sql="select * from (select top 20 * from (select top "+10*page+" * from tb_business order by id ASC)as aSysTable order by id desc) as bsystable order by id ASC";
			//System.out.println(sql);
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				product product=new product();
				product.setId(rs.getString("id"));
				product.setImg(rs.getString("img"));
				product.setMsg(rs.getString("ms"));
				product.setName(rs.getString("name"));
				product.setSubmittime(rs.getString("submittime"));
				product.setCategory(rs.getString("category"));
				ret.add(product);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public int InsertBusiness(String category,String name,String ms,String img){
		int i=0;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="insert into tb_business(category,name,ms,img) values('"+category+"','"+name+"','"+ms+"','"+img+"')";
		//閻忓繐妫欓崸濠囧礉閻樺弶鍊甸柣銊ュ缁劑寮稿鍫濇闁哄倻澧楃敮鎾存償韫囨梹鏉归柛蹇ｆb_temp閻炴稏鍔嬮懙鎴﹀Υ閿燂拷
			//String sql2="DROP TABLE tb_temp; SELECT IDENTITY (smallint, 1, 1) AS id, name, img, ms, category, submittime INTO tb_temp FROM tb_business ORDER BY id";
			i=connsqlserver.executeUpdate(sql);
			//System.out.println("test1"+connsqlserver.executeUpdate(sql2));
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return i;
	}
	public int DelBusiness(String id){
		int i=0;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="delete from tb_business where id='"+id+"'";
			//閻忓繐妫楅崹褰掓⒔閵堝懏鍊甸柣銊ュ缁劑寮稿鍫濇闁哄倻澧楃敮鎾存償韫囨梹鏉归柛蹇ｆb_temp閻炴稏鍔嬮懙鎴﹀Υ閿燂拷
			//String sql2="DROP TABLE tb_temp; SELECT IDENTITY (smallint, 1, 1) AS id, name, img, ms, category, submittime INTO tb_temp FROM tb_business ORDER BY id";
			//System.out.println("test2"+connsqlserver.executeUpdate(sql2));
			i=connsqlserver.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return i;
	}
	public	Collection selectTempForId(String id){
		Collection ret=new ArrayList();
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_temp where id='"+id+"'";
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				product product=new product();
				product.setId(rs.getString("id"));
				product.setImg(rs.getString("img"));
				product.setMsg(rs.getString("ms"));
				product.setName(rs.getString("name"));
				product.setSubmittime(rs.getString("submittime"));
				product.setCategory(rs.getString("category"));
				ret.add(product);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public int selectCountBusiness(){
		int i=0;
		ResultSet rs=null;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select count(*) from tb_news";
			rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				i=rs.getInt(1);
			}
			rs.last();
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	/*
	 * 闁稿繐鍘栫花鐟僢_category閻炴稏鍔庡▓鎴﹀箼瀹ュ嫮绋�
	 */
	public	Collection selectCategoryAll(){
		Collection ret=new ArrayList();
		//ResultSet rs=null;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_category";
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				category category=new category();
				category.setId(rs.getString("id"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setSubmittime(rs.getString("submittime"));
				ret.add(category);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public	Collection selectCategoryAll(String id){
		Collection ret=new ArrayList();
		//ResultSet rs=null;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="select * from tb_category where id='"+id+"'";
			ResultSet rs=connsqlserver.executeQuery(sql);
			while(rs.next()){
				category category=new category();
				category.setId(rs.getString("id"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setSubmittime(rs.getString("submittime"));
				ret.add(category);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return ret;
		
	}
	public int UpdateCategory(String edititem,String id){
		int i=0;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="update tb_category set categoryname='"+edititem+"' where id='"+id+"'";
			connsqlserver.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return i;
	}
	public int DelCategory(String id){
		int i=0;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="delete from tb_category where id='"+id+"'";
			i=connsqlserver.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return i;
	}
	public int InsertCategory(String categoryname){
		int i=0;
		try{
			connsqlserver connsqlserver=new connsqlserver();
			String sql="insert into tb_category(categoryname) values('"+categoryname+"')";
			i=connsqlserver.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		connsqlserver.close();
		return i;
	}
}
	
	

