package inti.SAhomepage.article.persistence;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;


@Repository
@Transactional
public class FileDAO {
    private static final String NAMESPACE= "inti.SAhomepage.article.repository.FileMapper";
    private final SqlSession sqlSession;
    //private static final Logger logger = LoggerFactory.getLogger((FileDAO.class));

    @Inject
    public FileDAO(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public List<String> getArticleFileNames(Integer articleNo) throws Exception{
        return sqlSession.selectList(NAMESPACE+".getArticleFileNames", articleNo);
    }

    public List<Integer> getArticleFileId(Integer articleNo) throws Exception{
        return sqlSession.selectList(NAMESPACE+".getArticleFileId", articleNo);
    }

}
