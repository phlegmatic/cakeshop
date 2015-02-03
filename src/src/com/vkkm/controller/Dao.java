package src.com.vkkm.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


import src.com.vkkm.bean.ProductInfo;
import src.com.vkkm.bean.User;
import src.com.vkkm.model.DBConnection;
import src.com.vkkm.model.HibernateFactory;



public class Dao{
	
	static Session session =null;
	static Logger log = Logger.getLogger(Dao.class.getName());
	
	//authenticates user
	public boolean isValidUser(User userLogin) {
		
		log.info("in validuser dao"+userLogin.getEmail());
		
		SessionFactory factory=HibernateFactory.getSessionFactory();
		session =factory.openSession();
		
		//session.beginTransaction();
        String SQL_QUERY = " from User u where u.email='" + userLogin.getEmail() + "' and u.password='" + userLogin.getPassword() + "'";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Iterator<User> it = query.iterate(); 
        List<User> list = query.list();
        if (list.size() > 0) {
            session.close();
            return true;
        }
        session.close();
        return false;
		
		//session.save(userLogin);
	}
	
	//fetches userdetails
	public List<User> getUserDetails(User userLogin) {
		
		log.info("in get userdetails dao"+userLogin.getEmail());
		
		SessionFactory factory=HibernateFactory.getSessionFactory();
		session =factory.openSession();
		
		//session.beginTransaction();
		Criteria c=session.createCriteria(User.class);
		c.add(Restrictions.eq("email", userLogin.getEmail()));
		List<User> list=c.list();
        
        session.close();
		return list;
		
		
	}
	
	public void CreateUser(User userLogin) {
		
		System.out.println("in create user dao"+userLogin.getEmail());
		SessionFactory factory=HibernateFactory.getSessionFactory();
		session =factory.openSession();
		session.beginTransaction();
		
		
		session.save(userLogin);
		
		session.getTransaction().commit();
        session.close();
		
	}
	
    public void CreateProduct(ProductInfo p) {
		
		System.out.println("in create product dao"+p.getProductName());
		SessionFactory factory=HibernateFactory.getSessionFactory();
		session =factory.openSession();
		session.beginTransaction();
		
		
		session.save(p);
		
		session.getTransaction().commit();
        session.close();
		
	}
    
    @SuppressWarnings("unchecked")
    public List<ProductInfo> loadProducts() {
		
		System.out.println("in select all product dao");
		SessionFactory factory=HibernateFactory.getSessionFactory();
		session =factory.openSession();
		session.beginTransaction();
		List<ProductInfo> prodList = session.createCriteria(ProductInfo.class).list();
		session.close();
		return prodList;
	}
}   



/*public int insert(Login objLogin){
	  Connection conn=null;
	  PreparedStatement pst=null;
	  conn=DBConnection.getDBconnection();
	  ResultSet rs=null;
	  int count=0;
	  try{
		  if(conn!=null){
		  String sql="select count(*) from library_pavani where username=? and password=? and category=?";
		  pst=conn.prepareStatement(sql);
		  pst.setString(1, objLogin.getUsername());
		  pst.setString(2, objLogin.getPassword());
		  pst.setString(3, objLogin.getCategory());
		  rs=pst.executeQuery();
		  while(rs.next()){
			  count=rs.getInt(1);
		  }
		  }
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
	  finally{
		  DBConnection.closeConnection(conn);
	  }
	return count;
	  
  }
  public Book binsert(Book b){
	  Connection conn=null;
	  PreparedStatement pst=null;
	  conn=DBConnection.getDBconnection();
	  try{
		  String sql="insert into book_pavani(bid,bname,author,pages)values(?,?,?,?)";
		  if(conn!=null){
			  pst=conn.prepareStatement(sql);
			  pst.setInt(1, b.getBid());
			  pst.setString(2, b.getBname());
			  pst.setString(3, b.getAuthor());
			  pst.setInt(4, b.getPages());
			  pst.execute();
			  System.out.println("inserted successfully");
			  
		  }
		  else{
			  System.out.println("not inserted into table");
		  }
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
	  finally{
		  DBConnection.closeConnection(conn);
	  }
	return b;
	  
  }
  public ArrayList<Book> viewall(){
	  Connection conn=null;
	  PreparedStatement pst=null;
	  ResultSet rs=null;
	  conn=DBConnection.getDBconnection();
	  ArrayList<Book> blist=new ArrayList<Book>();
	  try{
		  String sql="select * from book_pavani order by bid";
		  if(conn!=null){
			  pst=conn.prepareStatement(sql);
			  rs=pst.executeQuery();
			  while(rs.next()){
				  Book b=new Book();
				  b.setBid(rs.getInt("bid"));
				  b.setBname(rs.getString("bname"));
				  b.setAuthor(rs.getString("author"));
				  b.setPages(rs.getInt("pages"));
				  blist.add(b);
				  
			  }
		  }
		  
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  finally{
		  DBConnection.closeConnection(conn);
	  }
	return blist;
	  
  }
  public Person insert(Person p){
	  Connection conn=null;
	  PreparedStatement pst=null;
	  conn=DBConnection.getDBconnection();
	  try{
		  String sql="insert into person_pavani1(pid,pname,bid)values(?,?,?)";
		  if(conn!=null){
			  pst=conn.prepareStatement(sql);
			  pst.setInt(1, p.getPid());
			  pst.setString(2, p.getPname());
			  pst.setInt(3, p.getBid());
			  pst.execute();
			  System.out.println("inserted successfully");
		  }
		  else{
			  System.out.println("not inserted into table");
		  }
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  finally{
		  DBConnection.closeConnection(conn);
	  }
	return p;
	  
  }
  public ArrayList<Person> viewall1(){
	  Connection conn=null;
	  PreparedStatement pst=null;
	  ResultSet rs=null;
	  conn=DBConnection.getDBconnection();
	  ArrayList<Person> plist=new ArrayList<Person>();
	  try{
		  String sql="select * from person_pavani1 order by pid";
		  if(conn!=null){
			  pst=conn.prepareStatement(sql);
			  rs=pst.executeQuery();
			  while(rs.next()){
				  Person p=new Person();
				  p.setPid(rs.getInt("pid"));
				  p.setPname(rs.getString("pname"));
				  p.setBid(rs.getInt("bid"));
				  plist.add(p);
				  
			  }
		  }
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
	  finally{
		  DBConnection.closeConnection(conn);
	  }
	return plist;
	  
  }
}
*/