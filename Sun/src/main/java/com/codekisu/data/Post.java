package com.codekisu.data;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "title")
	private String title;
	@Column(name = "subtitle")
	private String subTitle;
	@Column(name = "content")
	private String content;
	@Column(name = "category")
	private String category;
	@Column(name = "date_post")
	private Date date;
	@Column(name = "arthur")
	private String arthur;
	@Column(name="img")
	private String img;
}
