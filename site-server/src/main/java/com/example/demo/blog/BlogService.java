package com.example.demo.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
	@Autowired
	private BlogRepository repository;

	// 一覧取得
	public List<? extends BlogDataInterface> getAll() {
		System.out.println("BlogService:getAll");
		return repository.findAll();
	}

	// 個別取得
	public BlogDataInterface getById(int id) {
		System.out.println("BlogService:getById");
		return repository.findById(id).orElse(null);
	}

	// 追加・更新
	public int add(BlogDataInterface item) {
		System.out.println("BlogService:add [" + item + "]");
		if (item instanceof Blog) {
			Blog savedItem = repository.saveAndFlush((Blog)item);
			return savedItem.getId();
		}
		return 0;
	}

	// 削除
	public void delete(BlogDataInterface item) {
		System.out.println("BlogService:delete [" + item + "]");
		if (item instanceof Blog) {
			repository.delete((Blog)item);
		}
	}
}
