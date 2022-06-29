package com.IntiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntiFormation.dao.IroleDao;
import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Role;

@Service
public class RoleService implements IroleService{
	
	@Autowired
	IroleDao rDao;
	
	public List<Role> cherchertt()
	{
		return rDao.findAll();
	}

	
	public Role chercherUn(int id)
	{
		return rDao.findById(id).get();
	}
	
}
