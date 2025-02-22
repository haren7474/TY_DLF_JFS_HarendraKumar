package com.tyss.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tyss.springrest.dao.EmployeeDAO;
import com.tyss.springrest.dto.EmployeeAddressBean;
import com.tyss.springrest.dto.EmployeeBean;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	@Override
	public boolean register(EmployeeBean bean) {
		String encodedPassword = encoder.encode(bean.getPassword());
		bean.setPassword(encodedPassword);
		List<EmployeeAddressBean> addressBean = bean.getAddressBeans();
		for (EmployeeAddressBean employeeAddressBean : addressBean) {
			employeeAddressBean.setBean(bean);
		}
		return dao.register(bean);
	}

	@Override
	public List<EmployeeBean> getEmployees(String key) {
		return dao.getEmployees(key);
	}

	@Override
	public boolean changePassword(int id, String password) {
		return dao.changePassword(id, encoder.encode(password));
	}

	@Override
	public boolean deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}

}
