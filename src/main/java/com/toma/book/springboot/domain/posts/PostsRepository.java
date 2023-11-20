package com.toma.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //@Repository 를 추가할 필요도 없음
    //Entity 클래스와 기본 Entity Repository는 함께 위치해야 함(도메인 패키지에서 함께 관리)
}
