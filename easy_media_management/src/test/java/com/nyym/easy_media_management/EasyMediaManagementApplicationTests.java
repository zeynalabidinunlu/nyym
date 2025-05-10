package com.nyym.easy_media_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nyym.entites.Category;
import com.nyym.entites.Content;
import com.nyym.entites.Media;
import com.nyym.entites.User;
import com.nyym.repository.UserRepository;
import com.nyym.services.ICategoryService;
import com.nyym.services.IContentService;
import com.nyym.services.IMediaService;
import com.nyym.services.IUserService;
import com.nyym.starter.EasyMediaManagementApplication;

@SpringBootTest(classes = EasyMediaManagementApplication.class)
class EasyMediaManagementApplicationTests {

	@Autowired
	private IContentService contentService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IMediaService mediaService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testSaveCategory() {
	    // Veri hazırlama
	    Category category = new Category();
	    category.setCategoryUuid(UUID.randomUUID());
	    category.setName("Test Kategori");
	    category.setDescription("Test Kategori Açıklaması");
	    
	    // Metot çağrısı
	    Category savedCategory = categoryService.saveCategory(category);
	    assertNotNull(category);
	  
	}
	
	
	
	@Test
	public void testSaveContent() {
	    // Veri hazırlama
	    Content content = new Content();
	    content.setContentUuid(UUID.randomUUID());
	    System.out.println();
	    content.setDescription("Test Content");
	    content.setEventDate(LocalDateTime.now());
	    content.setNumberOfPeople(120);
	    content.setShareText("Test Paylaşım Metini");
	    content.setImprovements("İlgili Yorumlar");
	    
	    // Metot çağrısı
	    Content savedContent = contentService.saveContent(content);
	    
	    // Doğrulama (assertion)
	    assertNotNull(savedContent.getContentUuid());
	    assertEquals("Test Content", savedContent.getDescription());
	    // Diğer alanlar için benzer assertionlar...
	      // veya contentUuid ile
	}
	

	@Test
	public void getAllCategories_shouldReturnSavedCategories() {
	    // Veri hazırlama
	    Category category1 = new Category();
	    category1.setCategoryUuid(UUID.randomUUID());
	    category1.setName("Kategori 1");
	    category1.setDescription("Açıklama 1");

	    Category category2 = new Category();
	    category2.setCategoryUuid(UUID.randomUUID());
	    category2.setName("Kategori 2");
	    category2.setDescription("Açıklama 2");

	    categoryService.saveCategory(category1);
	    categoryService.saveCategory(category2);

	    // Metot çağrısı
	    List<Category> allCategories = categoryService.getAllCategories();

	    // Doğrulama (assertion)
	    assertNotNull(allCategories);
	    assertTrue(allCategories.size() >= 2); // veya tam sayı da kontrol edilebilir
	    assertTrue(allCategories.stream().anyMatch(c -> c.getName().equals("Kategori 1")));
	    assertTrue(allCategories.stream().anyMatch(c -> c.getName().equals("Kategori 2")));
	}


    @Test
    public void testSaveUser() {
        // Veri hazırlama
        User user = new User();
        user.setName("Test");
        user.setSurname("User");
        user.setEmail("te@example.com");
        user.setPassword("password123");
        user.setPhone("5551234567");
        user.setGender("Male");
        user.setRole("admin");

        User savedUser = new User();
        savedUser.setName("Test");
        savedUser.setSurname("User");
        savedUser.setEmail("test.user@example.com");
        savedUser.setPassword("password123");
        savedUser.setPhone("5551234567");
        savedUser.setGender("Male");
        savedUser.setRole("ADMIN");
        // Normally the AdminUserFactory would set additional properties

     //   when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Metot çağrısı
        User result = userService.saveUser(user);

        // Doğrulama
        assertNotNull(result);
        assertEquals("Test", result.getName());
        assertEquals("User", result.getSurname());
        assertEquals("te@example.com", result.getEmail());
        assertEquals("ADMIN", result.getRole());
        
        // UserRepository'nin save metodu çağrıldı mı?
      //  verify(userRepository).save(any(User.class));
    }

}
