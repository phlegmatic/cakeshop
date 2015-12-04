package src.com.vkkm.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import src.com.vkkm.bean.Address;
import src.com.vkkm.bean.Order;
import src.com.vkkm.bean.ProductInfo;
import src.com.vkkm.bean.User;
import src.com.vkkm.model.HibernateFactory;



public class Dao{

	static Session session =null;
	static Logger log = Logger.getLogger(Dao.class.getName());

	public void CreateProduct(ProductInfo p) {

		System.out.println("in create product dao"+p.getProductName());
		SessionFactory factory=HibernateFactory.getSessionFactory();
		session =factory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();
		session.close();

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

	//fetches userdetails
	public List<User> getUserDetails(User userLogin) {

		log.info("in get userdetails dao" + userLogin.getEmail());
		SessionFactory factory=HibernateFactory.getSessionFactory();
		session = factory.openSession();
		//session.beginTransaction();
		Criteria c=session.createCriteria(User.class);
		c.add(Restrictions.eq("email", userLogin.getEmail()));
		List<User> list = c.list();
		session.close();
		return list;

	}

	//authenticates user
	public boolean isValidUser(User userLogin) {

		log.debug("in validuser dao" + userLogin.getEmail());
		SessionFactory factory=HibernateFactory.getSessionFactory();
		session = factory.openSession();
		//session.beginTransaction();
		String SQL_QUERY = " from User u where u.email='" + userLogin.getEmail() + "' and u.password='" + userLogin.getPassword() + "'";
		System.out.println(SQL_QUERY);
		Query query = session.createQuery(SQL_QUERY);
		query.iterate();
		List<User> list = query.list();
		if (list.size() > 0) {
			session.close();
			return true;
		}
		session.close();
		return false;

		//session.save(userLogin);
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

	public ProductInfo loadProducts(int prodId) {

		System.out.println("in select one product dao");
		SessionFactory factory=HibernateFactory.getSessionFactory();
		session =factory.openSession();
		session.beginTransaction();
		ProductInfo product;
		product =  (ProductInfo) session.get(ProductInfo.class, prodId);
		session.close();
		return product;
	}

	public void saveAddress(Address ad) {

		SessionFactory factory=HibernateFactory.getSessionFactory();
		session =factory.openSession();
		session.beginTransaction();
		session.save(ad);
		session.getTransaction().commit();
		session.close();

	}

	public Order saveOrder(Order order) {
		SessionFactory factory=HibernateFactory.getSessionFactory();
		session =factory.openSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		Order receipt;
		receipt = (Order) session.get(Order.class, order.getOrderId());
		session.close();
		return receipt;
		// TODO Auto-generated method stub

	}
}