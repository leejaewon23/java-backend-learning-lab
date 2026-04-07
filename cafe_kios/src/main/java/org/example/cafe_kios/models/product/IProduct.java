package org.example.cafe_kios.models.product;

import org.example.cafe_kios.models.category.IdName;

public interface IProduct extends IdName {
	Integer getPrice();
	void setPrice(Integer price);

	Integer getCategoryId();
	void setCategoryId(Integer categoryId);

	String getPicture();
	void setPicture(String picture);

	default void copyMembers(IProduct src) {

	}
}
