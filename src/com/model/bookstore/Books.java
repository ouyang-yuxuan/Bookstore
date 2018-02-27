package com.model.bookstore;

import java.util.Date;

/**
 * @author KINGTONG
 *
 */
public class Books {
	private int Id;
	private String Title;
	private String Author;
	private int PublisherId;
	private Date PublishDate;
	private String ISBN;
	private int WordsCount;
	private float UnitPrice;
	private String ContentDescription;
	private String AurhorDescription;
	private String EditorComment;
	private String TOC;
	private int CategoryId;
	private int Clicks;
	private int Repertory;

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int id, String title, String author, int publisherId, Date publishDate, String iSBN, int wordsCount,
			float unitPrice, String contentDescription, String aurhorDescription, String editorComment, String tOC,
			int categoryId, int clicks, int repertory) {
		super();
		Id = id;
		Title = title;
		Author = author;
		PublisherId = publisherId;
		PublishDate = publishDate;
		ISBN = iSBN;
		WordsCount = wordsCount;
		UnitPrice = unitPrice;
		ContentDescription = contentDescription;
		AurhorDescription = aurhorDescription;
		EditorComment = editorComment;
		TOC = tOC;
		CategoryId = categoryId;
		Clicks = clicks;
		Repertory = repertory;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getPublisherId() {
		return PublisherId;
	}
	public void setPublisherId(int publisherId) {
		PublisherId = publisherId;
	}
	public Date getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getWordsCount() {
		return WordsCount;
	}
	public void setWordsCount(int wordsCount) {
		WordsCount = wordsCount;
	}
	public float getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}
	public String getContentDescription() {
		return ContentDescription;
	}
	public void setContentDescription(String contentDescription) {
		ContentDescription = contentDescription;
	}
	public String getAurhorDescription() {
		return AurhorDescription;
	}
	public void setAurhorDescription(String aurhorDescription) {
		AurhorDescription = aurhorDescription;
	}
	public String getEditorComment() {
		return EditorComment;
	}
	public void setEditorComment(String editorComment) {
		EditorComment = editorComment;
	}
	public String getTOC() {
		return TOC;
	}
	public void setTOC(String tOC) {
		TOC = tOC;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public int getClicks() {
		return Clicks;
	}
	public void setClicks(int clicks) {
		Clicks = clicks;
	}
	public int getRepertory() {
		return Repertory;
	}
	public void setRepertory(int repertory) {
		Repertory = repertory;
	}

	
}
