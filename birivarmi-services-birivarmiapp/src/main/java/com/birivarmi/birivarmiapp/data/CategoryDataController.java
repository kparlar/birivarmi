package com.birivarmi.birivarmiapp.data;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.birivarmi.birivarmiapp.model.Admin;
import com.birivarmi.birivarmiapp.model.Category;
import com.birivarmi.birivarmiapp.model.CategoryDescription;
import com.birivarmi.birivarmiapp.model.CategoryDescriptionPK;
import com.birivarmi.birivarmiapp.model.CategoryStats;
import com.birivarmi.birivarmiapp.model.CategoryStatsPK;
import com.birivarmi.birivarmiapp.repository.AdminRepository;
import com.birivarmi.birivarmiapp.repository.CategoryDescriptionRepository;
import com.birivarmi.birivarmiapp.repository.CategoryRepository;
import com.birivarmi.birivarmiapp.repository.CategoryStatsRepository;
import com.birivarmi.birivarmiapp.util.BirivarmiConstantsUtil;

@Controller
@RequestMapping("/birivarmi/birivarmiapp/data/v1/category")
public class CategoryDataController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	CategoryDescriptionRepository categoryDescriptionRepository;
	
	@Autowired
	CategoryStatsRepository categoryStatsRepository;
	
	
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity<Category> createOrUpdateCategory(
			@RequestParam(value="id", required = false) Long id,
			@RequestParam(value="enabled", required = false) String enabled, 
			@RequestParam(value="expirationDays", required = false) Integer expirationDays,
			@RequestParam(value="iconPath", required = false ) String iconPath,
			@RequestParam(value="position", required = false) Integer position,
			@RequestParam(value="priceEnabled", required = false) String priceEnabled,
			@RequestParam(value="updaterId", required = true) Long updaterId,
			@RequestParam(value="parentId", required = false) Long parentId,
			@RequestParam(value="name", required = false) String name,
			@RequestParam(value="description", required = false) String description,
			@RequestParam(value="localCode", required = false) String localCode
			){
		
		Category category = null;
		Date today = new Date();
		//create new
		if(id==null){
			category = new Category();
			category.setEnabled(BirivarmiConstantsUtil.CHAR_FALSE);
			category.setExpirationDays(0);
			category.setIconPath("");
			if(parentId !=null){
				Category parentCategory = categoryRepository.findOne(parentId);
				category.setParentId(parentCategory);
			}else{
				category.setParentId(null);
			}
			
			category.setPosition(0);
			category.setPriceEnabled(BirivarmiConstantsUtil.CHAR_FALSE);
			category.setUpdateDate(today);
			Admin admin = adminRepository.findOne(updaterId);
			category.setUpdaterId(admin);
			category.setUpdateStatus(BirivarmiConstantsUtil.UPDATE_STATUS_INSERT);
			categoryRepository.save(category);
			
			CategoryDescription categoryDescription = new CategoryDescription();
			categoryDescription.setDescription(description);
			categoryDescription.setName(name);
			String slug = name.replaceAll(" ", "_").toLowerCase();
			categoryDescription.setSlug(slug);
			categoryDescription.setUpdateDate(today);
			categoryDescription.setUpdaterId(admin);
			categoryDescription.setUpdateStatus(BirivarmiConstantsUtil.UPDATE_STATUS_INSERT);
			
			CategoryDescriptionPK categoryDescriptionPK = new CategoryDescriptionPK();
			categoryDescriptionPK.setCategory(category);
			categoryDescriptionPK.setLocalCode(localCode);
			
			categoryDescription.setId(categoryDescriptionPK);
			categoryDescriptionRepository.save(categoryDescription);
			
			CategoryStats categoryStats = new CategoryStats();
			
			CategoryStatsPK categoryStatsPK = new CategoryStatsPK();
			categoryStatsPK.setCategory(category);
			
			categoryStats.setId(categoryStatsPK);
			categoryStats.setNumItems(new Long(0));
			categoryStats.setUpdateDate(today);
			categoryStats.setUpdaterId(admin);
			categoryStats.setUpdateStatus(BirivarmiConstantsUtil.UPDATE_STATUS_INSERT);
			
			categoryStatsRepository.save(categoryStats);
			
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		}else{
			//update
			category = categoryRepository.findOne(id);
			if(category!=null){
				if(enabled!=null){
					category.setEnabled(enabled.equalsIgnoreCase(String.valueOf(BirivarmiConstantsUtil.CHAR_TRUE))? BirivarmiConstantsUtil.CHAR_TRUE: BirivarmiConstantsUtil.CHAR_FALSE);
				}else{
					//do nothing.
				}
				if(expirationDays!=null){
					category.setExpirationDays(expirationDays);
				}else{
					//do nothing.
				}
				
				if(iconPath!=null){
					category.setIconPath(iconPath);
				}else{
					//do nothing.
				}
				if(position!=null){
					category.setPosition(position);
				}else{
					//do nothing.
				}
				
				
				if(priceEnabled!=null){
					category.setPriceEnabled(priceEnabled.equalsIgnoreCase(String.valueOf(BirivarmiConstantsUtil.CHAR_TRUE))? BirivarmiConstantsUtil.CHAR_TRUE: BirivarmiConstantsUtil.CHAR_FALSE);
				}else{
					//do nothing.
				}
				
				Admin admin = adminRepository.findOne(updaterId);
				category.setUpdaterId(admin);
				
				if(parentId !=null){
					Category parentCategory = categoryRepository.findOne(parentId);
					category.setParentId(parentCategory);
				}else{
					//do nothing.
				}
				category.setUpdateDate(today);
				category.setUpdateStatus(BirivarmiConstantsUtil.UPDATE_STATUS_UPDATE);
				
				categoryRepository.save(category);
				if(localCode!=null && name!=null){
					CategoryDescriptionPK categoryDescriptionPK = new CategoryDescriptionPK();
					categoryDescriptionPK.setCategory(category);
					categoryDescriptionPK.setLocalCode(localCode);
					
					CategoryDescription categoryDescription =  categoryDescriptionRepository.findOne(categoryDescriptionPK);
					if(categoryDescription!=null){
						categoryDescription.setName(name);
						categoryDescription.setUpdateDate(today);
						categoryDescription.setUpdaterId(admin);
						categoryDescription.setUpdateStatus(BirivarmiConstantsUtil.UPDATE_STATUS_UPDATE);
						
						categoryDescriptionRepository.save(categoryDescription);
					}else{
						//do nothing.
					}
				}else{
					//do nothing.
				}
				
				
				
				return new ResponseEntity<Category>(category, HttpStatus.OK);
			}else{
				return new ResponseEntity<Category>(category, HttpStatus.BAD_REQUEST);	
			}
			
		}
	}



	

}
