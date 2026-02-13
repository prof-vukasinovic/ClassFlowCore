package com.eidd.DTO;

import java.util.List;
import java.util.ArrayList;

public class ClassRoomExport{
	private GroupeExport eleves;
	private List<TableExport> tables = new ArrayList<>();
	private long id;
	private String nom;

	public ClassRoomExport() {}

	public ClassRoomExport(com.eidd.model.ClassRoom cr) {
		if (cr != null) {
			this.id = cr.getId();
			this.nom = cr.getNom();
			if (cr.getEleves() != null) this.eleves = new GroupeExport(cr.getEleves());
			if (cr.getTables() != null) {
				for (com.eidd.model.Table t : cr.getTables()) {
					this.tables.add(new TableExport(t));
				}
			}
		}
	}

	public GroupeExport getEleves() {
		return eleves;
	}

	public void setEleves(GroupeExport eleves) {
		this.eleves = eleves;
	}

	public List<TableExport> getTables() {
		return tables;
	}

	public void setTables(List<TableExport> tables) {
		this.tables = tables;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}