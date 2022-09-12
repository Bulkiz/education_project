package com.example.demo.mappers;

import java.util.List;

public interface ModelMapper<Dto, Entity> {
	
	public Dto toDto(Entity entity);
	
	public Entity toEntity(Dto dto);
	
	public List<Dto> allToDtos(List<Entity> entities);
	
	public List<Entity> allToEntities(List<Dto> dtos);
	
}
