package wl.ncb.tudf;

import wl.ncb.tudf.dao.EmpDaoImpl;
import wl.ncb.tudf.idao.EmpIDao;
import wl.ncb.tudf.model.Emp;

public class DaoEmpPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		  EmpIDao  empdao = new EmpDaoImpl();
		  //print all emps
		  for(Emp emp : empdao.getAllEmp()){
			  System.out.println("Emp : [Emp id: "+emp.getEmp_id()+",Name: "+emp.getEmp_name()+" ]");
		  }
		  
	}

}
