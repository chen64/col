package com.tallgeese;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallgeese.model.Collectable;
import com.tallgeese.model.User;
import com.tallgeese.repository.CollectableDao;
import com.tallgeese.repository.UserDao;

public class MainDriver {
	public static ApplicationContext appContext =
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static CollectableDao collectableDao = appContext.getBean("collectableDao", CollectableDao.class);
	
	public static UserDao userDao = appContext.getBean("userDao", UserDao.class);
	
	public static void main(String[] args) {
//		insertInitialValues();
//		System.out.println("\nAll our Users: \n" + userDao.selectAll());
//		System.out.println(userDao.selectByUsername("collector").getCollectable());
//		User user = userDao.selectByUsername("collector");
//		List<Collectable> tmpList = user.getCollectable();
//		System.out.println(tmpList);
//		Random rng = new Random();
//		ArrayList<Collectable> collList = (ArrayList<Collectable>) collectableDao.selectAll();
//		Collectable newColl = collList.get(rng.nextInt(collList.size()));
//		if (!(tmpList.contains(newColl))) {
//			System.out.println("does not contain");
//			tmpList.add(newColl);
//			user.setCollectable(tmpList);
//			userDao.update(user);
//		}
//		List<Collectable> rollList = new ArrayList<>();
//		for (int i=0; i<10; i++) {
//			Collectable newColl = collList.get(rng.nextInt(collList.size()));
//			rollList.add(newColl);
//			if (!(tmpList.contains(newColl))) {
//				tmpList.add(newColl);
//				user.setCollectable(tmpList);
//			}
//		}
//		userDao.update(user);
//		System.out.println(rollList);
	}
	
	public static void insertInitialValues() {
		Collectable coll1 = new Collectable("CONCEPT-X 6-1-2 Turn X", "https://phototallgeese.s3.us-east-2.amazonaws.com/CONCEPT-X_6-1-2_Turn_X_-_Front.png", 100, 5);
		Collectable coll2 = new Collectable("FA-010S Full Armor ZZ Gundam", "https://phototallgeese.s3.us-east-2.amazonaws.com/Fa-010s.jpg", 100, 5);
		Collectable coll3 = new Collectable("FA-78 Full Armor Gundam (Thunderbolt Ver.)", "https://phototallgeese.s3.us-east-2.amazonaws.com/Full_Armor_Gundam_Thunderbolt-ova.png", 80, 4);
		Collectable coll4 = new Collectable("XXXG-01H2 Gundam Heavyarms Custom", "https://phototallgeese.s3.us-east-2.amazonaws.com/Gundam_Heavyarms_KaiW0.jpg", 60, 3);
		Collectable coll5 = new Collectable("XXXG-01SR2 Gundam Sandrock Custom", "https://phototallgeese.s3.us-east-2.amazonaws.com/Gundam_Sandrock_KaiW0.jpg", 60, 3);
		Collectable coll6 = new Collectable("RX-75-4 Guntank", "https://phototallgeese.s3.us-east-2.amazonaws.com/GuntankRX-75-4.JPG", 30, 2);
		Collectable coll7 = new Collectable("MS-06J Zaku II Ground Type", "https://phototallgeese.s3.us-east-2.amazonaws.com/MS-06J_Zaku_II_Ground_Type_%2528Missile_Pod%2529.jpg", 35, 2);
		Collectable coll8 = new Collectable("MS-06S Zaku II Commander Type (Gabby Hazard Custom)", "https://phototallgeese.s3.us-east-2.amazonaws.com/MS-06S_-_Gabby_Hazard_Colors.png", 40, 2);
		Collectable coll9 = new Collectable("MS-06S Zaku II Commander Type (Robert Gilliam Custom)", "https://phototallgeese.s3.us-east-2.amazonaws.com/MS-06S_-_Robert_Gilliam_Colors.png", 40, 2);
		Collectable coll10 = new Collectable("MS-06S Zaku II Commander Type (Char Custom)", "https://phototallgeese.s3.us-east-2.amazonaws.com/Ms-06s-char.jpg", 50, 2);
		Collectable coll11 = new Collectable("MSZ-006 Zeta Gundam", "https://phototallgeese.s3.us-east-2.amazonaws.com/MSZ-006_-_Zeta_Gundam_-_Front_View.jpg", 95, 5);
		Collectable coll12 = new Collectable("MS-06J Zaku II Ground Type (Camo)", "https://phototallgeese.s3.us-east-2.amazonaws.com/Ms-06j-camo.jpg", 35, 2);
		Collectable coll13 = new Collectable("MS-07B Gouf", "https://phototallgeese.s3.us-east-2.amazonaws.com/Ms-07b_1.jpg", 50, 3);
		Collectable coll14 = new Collectable("MSN-00100 Hyaku-Shiki", "https://phototallgeese.s3.us-east-2.amazonaws.com/Msn-00100.jpg", 80, 4);
		Collectable coll15 = new Collectable("RX-178 Gundam Mk-II (Titans)", "https://phototallgeese.s3.us-east-2.amazonaws.com/RX-178_-_Gundam_Mk-II_%2528Titans_Colors%2529_-_Front_View.jpg", 60, 3);
		Collectable coll16 = new Collectable("RGM-79N GM Custom", "https://phototallgeese.s3.us-east-2.amazonaws.com/Rgm-79n.jpg", 40, 2);
		Collectable coll17 = new Collectable("RMS-099 Rick Dias", "https://phototallgeese.s3.us-east-2.amazonaws.com/Rms-099-red.jpg", 30, 2);
		Collectable coll18 = new Collectable("RX-93-ƒË2 Hi-Nu Gundam", "https://phototallgeese.s3.us-east-2.amazonaws.com/Rx-93-v-2.jpg", 100, 5);
		Collectable coll19 = new Collectable("GNW-001 Gundam Throne Eins", "https://phototallgeese.s3.us-east-2.amazonaws.com/Throne_Eins_Color.png", 70, 3);
		Collectable coll20 = new Collectable("SYSTEM Í-99 Í Gundam", "https://phototallgeese.s3.us-east-2.amazonaws.com/Turn_A.png", 100, 5);
		Collectable coll21 = new Collectable("XXXG-00W0 Wing Gundam Zero", "https://phototallgeese.s3.us-east-2.amazonaws.com/XXXG-00W0_Wing_Gundam_Zero_-_Front.png", 95, 5);
		Collectable coll22 = new Collectable("XXXG-01D2 Gundam Deathscythe H", "https://phototallgeese.s3.us-east-2.amazonaws.com/Xxxg-01d2.jpg", 75, 3);
		Collectable coll23 = new Collectable("ZGMF-X10A Freedom Gundam", "https://phototallgeese.s3.us-east-2.amazonaws.com/Zgmf-x10a.jpg", 80, 4);
		Collectable coll24 = new Collectable("ZMT-S33S Gottrlatan", "https://phototallgeese.s3.us-east-2.amazonaws.com/Zmt-s33s.jpg", 75, 4);
		Collectable coll25 = new Collectable("OZ-00MS Tallgeese", "https://phototallgeese.s3.us-east-2.amazonaws.com/tallgeese.gif", 75, 3);
		
		collectableDao.insert(coll1);
		collectableDao.insert(coll2);
		collectableDao.insert(coll3);
		collectableDao.insert(coll4);
		collectableDao.insert(coll5);
		collectableDao.insert(coll6);
		collectableDao.insert(coll7);
		collectableDao.insert(coll8);
		collectableDao.insert(coll9);
		collectableDao.insert(coll10);
		collectableDao.insert(coll11);
		collectableDao.insert(coll12);
		collectableDao.insert(coll13);
		collectableDao.insert(coll14);
		collectableDao.insert(coll15);
		collectableDao.insert(coll16);
		collectableDao.insert(coll17);
		collectableDao.insert(coll18);
		collectableDao.insert(coll19);
		collectableDao.insert(coll20);
		collectableDao.insert(coll21);
		collectableDao.insert(coll22);
		collectableDao.insert(coll23);
		collectableDao.insert(coll24);
		collectableDao.insert(coll25);
		
		List<Collectable> collList = new ArrayList<>();
		collList.add(coll1);
		collList.add(coll2);
		collList.add(coll3);
		
		List<Collectable> collList2 = new ArrayList<>();
		collList2.add(coll3);
		
		User user1 = new User("temp@temp.com", "temp", "temp", null);
		User user2 = new User("new@temp.com", "newguy", "safepass", collList2);
		User user3 = new User("collector@temp.com", "collector", "masterpass", collList);
		
		userDao.insert(user1);
		userDao.insert(user2);
		userDao.insert(user3);
	}
}
