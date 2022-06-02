package com.shop.repository;

import com.shop.entity.Blog;
import com.shop.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "select b from Blog b " +
            "left join fetch b.blogComment " +
            "left join fetch b.blogDetails " +
            "where  b.id = :id")
    Optional<Blog> findFullBlog(@Param("id") Long id);

    @Query(value = "select b from Blog b where  b.id = :id")
    Optional<Blog> findShortBlog(@Param("id") Long id);

    @Query(nativeQuery = true, value = "select * from blog where  category = :category order by RANDOM() limit :limit")
    List<Blog> findBlogsByCategoryWithLimit(@Param("category") String category, @Param("limit") Integer limit);

    @Query(nativeQuery = true, value = "select * from blog order by RANDOM() limit :limit")
    List<Blog> findBlogsWithLimit(@Param("limit") Integer limit);

    @Query(nativeQuery = true, value = "select * from blog order by blog.date asc limit 4")
    List<Blog> findNewBlogs();

    @Query(nativeQuery = true, value = "select * from blog order by blog.date desc")
    List<Blog> findAllBlogs(Pageable page);
}
