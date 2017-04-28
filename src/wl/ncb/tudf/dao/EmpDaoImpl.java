package wl.ncb.tudf.dao;

import java.util.ArrayList;
import java.util.List;

import wl.ncb.tudf.idao.EmpIDao;
import wl.ncb.tudf.model.Emp;

public class EmpDaoImpl implements EmpIDao {

	
	//list is working as database
	
	List<Emp> emps;
	public EmpDaoImpl(){
	  emps = new ArrayList<Emp>();
	  Emp emp1 = new Emp("B96","Phasin");
	  Emp emp2 = new Emp("K39","Tep");
	  Emp emp3 = new Emp("K40","Yuki");
	  emps.add(emp3);
	  emps.add(emp2);
	  emps.add(emp1);
	}
	
	@Override
	public List<Emp> getAllEmp() {
		// TODO Auto-generated method stub
		return emps;
	}

	@Override
	public Emp getEmp(String emp_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmp(Emp emp) {
		// TODO Auto-generated method stub
      System.out.println("Emp: Emp id"+emp.getEmp_id()+",Updated in the database");   
	}

	@Override
	public void deleteEmp(Emp emp) {
		// TODO Auto-generated method stub
       
		emps.remove(emp.getEmp_id());
		System.out.println("Emp: Emp Id "+emp.getEmp_id()+", deleted from database");
	}

}
