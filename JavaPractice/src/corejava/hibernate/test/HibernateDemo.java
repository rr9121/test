package corejava.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import corejava.hibernate.domain.Product;
import corejava.hibernate.domain.Uom;

public class HibernateDemo {
	SessionFactory factory;
	public HibernateDemo(SessionFactory factory){
		this.factory = factory;
	}
	public void close(){
		if(factory != null) {
			factory.close();
		}
	}
	public Uom testReadUom(int id) {
		Uom uomObj = null;
		Session session = factory.openSession();
		uomObj = (Uom)session.load(Uom.class, new Integer(id));
		session.close();
		return uomObj;
	}
	public Product testReadProduct(int id){
		Product prodObj = null;
		Session session = factory.openSession();
		prodObj = (Product)session.load(Product.class, new Integer(id));
		session.close();
		return prodObj;
	}
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		HibernateDemo demo = new HibernateDemo(cfg.buildSessionFactory());
		//Uom uomObj = demo.testReadUom(1);
		Product prodObj = demo.testReadProduct(1);
		System.out.println(prodObj);
		demo.close();
	}

}
