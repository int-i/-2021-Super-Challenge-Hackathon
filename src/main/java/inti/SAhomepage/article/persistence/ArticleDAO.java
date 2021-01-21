package inti.SAhomepage.article.persistence;

import inti.SAhomepage.article.model.ArticleModel;
import inti.SAhomepage.commons.paging.Criteria;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


@Repository
public class ArticleDAO {

    private static final String NAMESPACE = "inti.SAhomepage.article.repository.ArticleMapper"; // 수정
    private final SqlSession sqlSession;
    //private static final Logger logger = LoggerFactory.getLogger((ArticleDAO.class));

    @Inject
    public ArticleDAO(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    // NAMESPACE.id 형태로 mapper에 정의해둔 sql문 접근

    public ArticleModel read(Integer articleNo) throws Exception{
        return sqlSession.selectOne(NAMESPACE + ".read", articleNo);
    }

    public List<ArticleModel> listCriteria(Criteria criteria) throws Exception{
        return sqlSession.selectList(NAMESPACE + ".listCriteria", criteria);
    }

    public int countArticles(Criteria criteria) throws Exception{
        return sqlSession.selectOne(NAMESPACE+".countArticles", criteria);
    }

    public void updateViewCnt(Integer articleNo) throws Exception{
        sqlSession.update(NAMESPACE+".updateViewCnt", articleNo);
    }
}
