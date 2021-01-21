package inti.SAhomepage.article.repository;


import inti.SAhomepage.article.model.ArticleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleJpaRepository extends JpaRepository<ArticleModel, Integer>{
    ArticleModel findByArticleNo(Integer no);

    // 리턴타입 findBy필드명(필드타입에 해당하는 parameter);  이런식으로 명명하면 된다!
    // ArticleModel 객체의 viewCnt라는 필드를 기준으로 ArticleModel 데이터를 가져오고 싶으면
    // ArticleModel findByViewCnt(Integer cnt); 이런 식으로

    List<ArticleModel> findAllBy();
}
