package com.udemy.microservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * The Class UserDaoService.
 */
@Component
public class UserDaoService {

	/** The users. */
	private static List<User> users = new ArrayList<>();

	/**
	 * The users count.
	 *
	 * @return the user
	 */
	private static int usersCount = 3;

	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<User> findAll() {
		return users;
	}

	/**
	 * Save.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User save(User user) {

		if (user.getId() == null) {
			user.setId(++usersCount);
		}

		users.add(user);

		return user;
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the user
	 */
	public User findById(int id) {

		for (User user : users) {
			if (user.getId() == id)
				return user;
		}

		throw new UserNotFoundException("id-" + id);

	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the int
	 */
	public int deleteById(int id) {

		Iterator<User> it = users.iterator();

		while(it.hasNext()) {
			User user = it.next();

			if(user.getId() == id) {
				it.remove();
				return id;
			}
		}

		// this also works
//		for (User user : users) {
//			if (user.getId() == id) {
//				users.remove(user);
//				return id;
//			}
//		}

		throw new UserNotFoundException("id-" + id);

	}

}
