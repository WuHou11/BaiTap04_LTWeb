package iot.vnstar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private int cateId;

    @Column(name = "cate_name", nullable = false)
    private String cateName;

    // Quan hệ nhiều Category -> 1 User
    @ManyToOne
    @JoinColumn(name = "user_id")  // Khóa ngoại trong bảng Category
    private User user;

    // ===== Getter, Setter =====
    public int getCateId() { return cateId; }
    public void setCateId(int cateId) { this.cateId = cateId; }

    public String getCateName() { return cateName; }
    public void setCateName(String cateName) { this.cateName = cateName; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
