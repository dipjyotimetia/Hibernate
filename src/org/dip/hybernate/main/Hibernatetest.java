package org.dip.hybernate.main;


import java.util.Date;

import org.dip.hybernate.Address;
import org.dip.hybernate.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernatetest {

	
	public static void main(String[] args)
	{
		try {
			UserDetails user=new UserDetails();
			user.setUserId(101);
			user.setUsername(" Second User");
			user.setJoinedDate(new Date());
			user.setDescription("User description comes here");
			
			Address addr=new Address();
			addr.setCity("Mysore");
			addr.setPin("570017");
			addr.setState("Karnataka");
			addr.setStreet("Mayuracicrle 6th cross");
			user.setAddress(addr);
			
		    SessionFactory sessionFactory=	new Configuration().configure().buildSessionFactory();
		    Session session =sessionFactory.openSession();
		    session.beginTransaction();									//convert to SQl query
		    session.save(user);											// Insert table
		    session.getTransaction().commit();							//Run the query
		    session.close();
		    
		    
		    user=null;
		    addr=null;
		    session =sessionFactory.openSession();
		    session.beginTransaction();
		    user=(UserDetails) session.get(UserDetails.class, 101);
		    addr=(Address) session.get(Address.class, 101);
		    System.out.println("Description is"+user.getDescription());
		    System.out.println("User id is"+user.getUserId());
		    System.out.println("user name is"+user.getUsername());
		    System.out.println("adress is"+user.getAddress());
		    System.out.println("joining date is"+user.getJoinedDate());
		    System.out.println("Description is"+addr.getCity());
		    System.out.println("Description is"+addr.getPin());
		    System.out.println("Description is"+addr.getState());
		    System.out.println("Description is"+addr.getStreet());
		    
		    
		} catch (Exception e) {
			
			System.out.println("Error is"+e);
		}
		
	    
	    
	    
	}
}
