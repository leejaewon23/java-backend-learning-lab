package org.example.cookies.models.ingredient;

import org.example.cookies.models.common.IdName;

public interface IngredientInterface extends IdName {
	Long getCategoryId();
	void setCategoryId(Long categoryId);

	IdName getCategory();
	void setCategory(IdName category);
}
