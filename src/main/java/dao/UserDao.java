package dao;

 
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import dto.User;

public class UserDao 
{
	public Session getSession()
	{
		Configuration configuration=new Configuration().configure("cfgs/hibernate.cfg.xml");
		SessionFactory factory=configuration.buildSessionFactory();
		return factory.openSession();
	}
	public void saveUser(User user)
	{
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		session.save(user);
		transaction.commit();
	}
	public void updateUser(int id,User user)
	{
		Session session=getSession();
		User dbUser=session.find(User.class, id);
		if(dbUser!=null)
		{
			Transaction transaction=session.beginTransaction();
			user.setId(id);
			session.merge(user);
			 transaction.commit();

		}
		else
		{
			System.out.println("Invalid Id");
		}
	}
	public void deleteUser(int id)
	{
		Session session=getSession();
		User user=session.find(User.class,id);
		if(user!=null)
		{
			session.getTransaction().begin();
			session.delete(user);
			session.getTransaction().commit();
		}
		else
		{
			System.out.println("Invalid Id");
		}
	}
	public void displayUser(int id)
	{
		Session session=getSession();
		User user=session.find(User.class, id);
		if(user!=null)
		{
			System.out.println(user);
		}
		else
		{
			System.out.println("User Does Not exist");
		}
	}
	public void displayAll()
	{
		Session session=getSession();
		Query<User>query=session.createQuery("SELECT U FROM User U");
		List<User>users=query.getResultList();
		Iterator<User>iterator=users.iterator();
		while (iterator.hasNext()) 
		{
			iterator.next().display();
			
		}	
	}
}
