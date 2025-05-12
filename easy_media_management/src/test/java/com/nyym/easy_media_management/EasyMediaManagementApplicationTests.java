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
import com.nyym.observer.CalendarObserver;
import com.nyym.repository.CalendarDayRepository;
import com.nyym.repository.UserRepository;
import com.nyym.services.ICategoryService;
import com.nyym.services.IContentService;
import com.nyym.services.IMediaService;
import com.nyym.services.IUserService;
import com.nyym.services.impl.ContentService;
import com.nyym.starter.EasyMediaManagementApplication;
import com.nyym.subject.ContentPublisher;

@SpringBootTest(classes = EasyMediaManagementApplication.class)
class EasyMediaManagementApplicationTests {

	@Autowired
	private ContentService contentService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IMediaService mediaService;

	@Autowired
	private IUserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CalendarDayRepository calendarDayRepository;

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
		content.setDescription("SELAMM");
		content.setEventDate(LocalDateTime.now());
		content.setNumberOfPeople(120);
		content.setShareText("Test SELAMMMM Metini");
		content.setImprovements("İlgili Yorumlar");

		// Metot çağrısı
		Content savedContent = contentService.saveContent(content);

		assertNotNull(savedContent);

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
		user.setUserUuid(UUID.randomUUID());
		user.setName("Test");
		user.setSurname("User");
		user.setEmail("l@example.com");
		user.setPassword("password123");
		user.setPhone("5551234567");
		user.setGender("Male");
		user.setRole("admin");

		// Metot çağrısı
		User result = userService.saveUser(user);

		// Doğrulama
		assertNotNull(result);
	

		// UserRepository'nin save metodu çağrıldı mı?
		// verify(userRepository).save(any(User.class));
	}

	@Test
	public void testSaveObserverContent() {
		// Veri hazırlama
		Content content = new Content();
		content.setContentUuid(UUID.randomUUID());
		System.out.println();
		content.setDescription("SELAMM");
		content.setEventDate(LocalDateTime.now());
		content.setNumberOfPeople(120);
		content.setShareText("Test SELAMMMM Metini");
		content.setImprovements("İlgili Yorumlar");

		// Metot çağrısı - önce ContentService ile içeriği kaydet
		Content savedContent = contentService.saveContent(content);

		// Yeni bir UUID ile içeriği tekrar oluştur - bu veritabanı çakışmasını
		// önleyecek
		Content duplicateContent = new Content();
		duplicateContent.setContentUuid(UUID.randomUUID()); // Farklı bir UUID kullan
		duplicateContent.setDescription(content.getDescription());
		duplicateContent.setEventDate(content.getEventDate());
		duplicateContent.setNumberOfPeople(content.getNumberOfPeople());
		duplicateContent.setShareText(content.getShareText());
		duplicateContent.setImprovements(content.getImprovements());

		// Observer pattern'i test et
		ContentPublisher publisher = new ContentPublisher();
		CalendarObserver observer = new CalendarObserver(calendarDayRepository);
		publisher.addObserver(observer);
		publisher.notifyContentCreated(duplicateContent); // Farklı UUID'li içeriği kullan

		// Doğrulama (assertion)
		assertNotNull(savedContent);
	}
}
