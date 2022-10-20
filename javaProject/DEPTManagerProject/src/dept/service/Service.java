package dept.service;

import dept.dao.Dao;

abstract class Service {
	Dao dao;
	public Service(Dao dao) {
		this.dao = dao;
	}
}
