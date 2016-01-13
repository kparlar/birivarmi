package com.birivarmi.birivarmiapp.repository;

import org.springframework.data.repository.CrudRepository;



import com.birivarmi.birivarmiapp.model.CategoryStats;
import com.birivarmi.birivarmiapp.model.CategoryStatsPK;



public interface CategoryStatsRepository extends CrudRepository<CategoryStats, CategoryStatsPK>{

}
