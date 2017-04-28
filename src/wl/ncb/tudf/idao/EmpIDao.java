package wl.ncb.tudf.idao;

import java.util.List;

import wl.ncb.tudf.model.Emp;

public interface EmpIDao {
	
	public List<Emp> getAllEmp();
	public Emp getEmp(String emp_id);
	public void updateEmp(Emp emp);
	public void deleteEmp(Emp emp);

}
