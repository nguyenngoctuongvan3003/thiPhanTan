package services_ca46;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dao.EmployeeDAO;
import entities.Department;
import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeServices implements EmployeeDAO {
	private EntityManager entityManager;

	public EmployeeServices(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	/**
	 * Liệt kê danh sách nhân viên (employees) theo phòng ban (department) khi biết
	 * tên phòng ban (department_name – tìm tương đối) mà có ngày được thuê trong
	 * khoảng thời gian từ ngày đến ngày (dựa vào cột ngày được thuê hire_date)
	 */
	@Override
	public List<Employee> listEmployees(String departmentName, String fromHireDate, String toHireDate) {
		// TODO Auto-generated method stub
		LocalDate fromHireDateLD = LocalDate.parse(fromHireDate);
		LocalDate toHireDateLD = LocalDate.parse(toHireDate);
		return entityManager.createQuery(
				"select e from Employee e where e.department.departmentName like :departmentName and e.hireDate between :fromHireDate and :toHireDate ",
				Employee.class).setParameter("departmentName", "%" + departmentName + "%")
				.setParameter("fromHireDate", fromHireDateLD).setParameter("toHireDate", toHireDateLD).getResultList();
	}

	/**
	 * Thống kê tổng số nhân viên (Employee) theo phòng ban khi biết danh sách các
	 * job_id của nhân viên (dựa theo cột job_id của nhân viên), sắp xếp theo tổng
	 * số sách giảm dần.// Key: Tên phòng ban; Value: Số lượng nhân viên
	 */
	@Override
	public Map<String, Long> getNoOfEmployeeFollowDepartmentByJobIds(List<String> jobIds) {
		Map<String, Long> map = new LinkedHashMap<String, Long>();
		List<?> results = entityManager.createQuery(
				"select d.departmentName, count(e.id) as soNV from Department d inner join d.employees e where e.job.id in :jobIds group by d.id order by soNV desc")
				.setParameter("jobIds", jobIds).getResultList();

		results.stream().map(t -> (Object[]) t).forEach(t -> {
			String string = (String) t[0];
			Long long1 = ((Number) t[1]).longValue();
			map.put(string, long1);
		});
		return map;
	}

	@Override
	public List<Department> getListNoOfEmployeeFollowDepartmentByJobIds(List<String> jobIds) {
		List<Department> list = entityManager
				.createQuery("select d from Department d inner join d.employees e where e.job.id in :jobIds",
						Department.class)
				.setParameter("jobIds", jobIds).getResultList();
		return list;
	}

	/**
	 * Cập nhật lại lương (salary) của nhân viên (employee) khi biết mã số
	 * (employee_id) của nhân viên. + updateSalary(employeeId: int, newSalary:
	 * Double): boolean
	 */
	@Override
	public boolean updateSalary(int employeeId, Double newSalary) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee employee=entityManager.find(Employee.class, employeeId);
		if(employee==null) {
			System.out.println("Không có nhân viên này");
			return false;
		}else {
			employee.setSalary(newSalary);
			try {
				entityTransaction.begin();
				entityManager.merge(employee);
				entityTransaction.commit();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				if (entityTransaction.isActive()) {
					entityTransaction.rollback();
				}
				e.printStackTrace();
			}
		}
				
		return false;
	}
}
