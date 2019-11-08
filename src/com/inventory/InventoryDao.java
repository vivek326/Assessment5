package com.inventory;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class InventoryDao {
private static EntityManagerFactory entityManagerFactory;
	
	public void add() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Name of Product");
		String name=s.next();
		System.out.println("Description of Product");
		String description=s.next();
		System.out.println("Price of Product");
		int price=s.nextInt();
		System.out.println("Quantity of Product");
		int quantity=s.nextInt();
		
		Inventory i=new Inventory(name,description,price,quantity);
		
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
	}
	
	public void update(String name) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		Inventory invent=em.createQuery("select s from Inventory s where name= :name",Inventory.class).setParameter("name",name).getResultList().get(0);
		Scanner s=new Scanner(System.in);
		System.out.println("Enter name - ");
		String name1=s.next();
		System.out.println("Enter Description -");
		String description=s.next();
		System.out.println("Enter Price");
		int price=s.nextInt();
		System.out.println("Enter Quantity -");
		int quantity=s.nextInt();
		invent.setName(name1);
		invent.setDescription(description);
		invent.setPrice(price);
		invent.setQuantity(quantity);
		em.getTransaction().begin();
		em.merge(invent);
		em.getTransaction().commit();
	}
	
	public List<Inventory> printList(){
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("select s from Inventory s",Inventory.class).getResultList();
	
	}
	
	public void delete(String name)
	{
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		Inventory invent=em.createQuery("select s from Inventory s where name= :name",Inventory.class).setParameter("name",name).getResultList().get(0);
	
		em.getTransaction().begin();
		em.remove(invent);
		em.getTransaction().commit();
		
	
	}
}
