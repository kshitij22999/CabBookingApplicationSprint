package com.training.Sprint1;
import com.training.Sprint1.repository.AdminRepository;
import com.training.Sprint1.service.AdminService;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import com.training.Sprint1.entities.*;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class AdminTest {
	@Mock
	AdminRepository adminRepo;
	
	@InjectMocks
	AdminService adminService;
	
	@BeforeAll
	static void setUpBeforeClass()throws Exception {
		
	}
	@AfterAll
	static void tearDownAfterClass()throws Exception{
		
	}
	
	Admin admin1,admin2;
	List<Admin> adminList;
	Address a1,a2;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
	

	a1=new Address("A/P Ashta","Sangli","India","416301");
	a2=new Address("A/P Karad","Satara","India","415124");
	
	admin1=new Admin("PRIYASHI","priya@123","657823012","abc@gmail.com",a1);
	admin2=new Admin("SHENON","seagull@23","6578230882","efg@gmail.com",a2);
	
	adminList.add(admin1);
	adminList.add(admin2);
	

	
}
	@AfterEach
	void tearDown() throws Exception{
	
	}
@Test
public void getAllAdminsTest() {
	when(adminRepo.findAll()).thenReturn(adminList);
	Assertions.assertEquals(2, adminService.getAllAdmin().size());
}
@Test
public void createAdminTest() {
	when(adminRepo.save(admin1)).thenReturn(admin1);
	Assertions.assertEquals(admin1, adminService.createAdmin(admin1));	
	}
@Test
public void updateAdminTest() {
	when(adminRepo.findById(admin1.getId())).thenReturn(Optional.of(admin1));
	when(adminRepo.save(admin1)).thenReturn(admin1);
	Assertions.assertEquals(admin1, adminService.updateAdmin(admin1));
}
@Test
public void getAdminByIdTest() {
	when(adminRepo.findById(admin1.getId())).thenReturn(Optional.of(admin1));
	Assertions.assertEquals(admin1, adminService.getDriverById(admin1.getId()));	
	}
@Test
public void deleteAdminTest() {
	when(adminRepo.findById(admin1.getId())).thenReturn(Optional.of(admin1));
	Assertions.assertEquals(admin1, adminService.deleteAdmin(admin1));	
	}

}
