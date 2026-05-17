package org.example.cafe_kiosk_sales.models.category;

public interface ICategory {
    Integer getId();
    void setId(Integer id);

    String getName();
    void setName(String name);

    default ICategory copyMembers(ICategory src) {
        if ( src != null ) {
            if ( src.getId() != null ) {
                this.setId(src.getId());
            }
            if ( src.getName() != null ) {
                this.setName(src.getName());
            }
        }
        return this;
    }
}