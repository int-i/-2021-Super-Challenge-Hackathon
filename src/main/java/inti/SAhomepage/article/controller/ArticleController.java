package inti.SAhomepage.article.controller;

import inti.SAhomepage.article.model.ArticleModel;
import inti.SAhomepage.article.model.FileModel;
import inti.SAhomepage.article.persistence.ArticleDAO;
import inti.SAhomepage.article.persistence.FileDAO;
import inti.SAhomepage.article.repository.ArticleJpaRepository;
import inti.SAhomepage.article.repository.FileJpaRepository;
import inti.SAhomepage.commons.paging.Criteria;
import inti.SAhomepage.commons.paging.PageMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;


@Controller
public class ArticleController {
    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    // 데이터 왔다 갔다를 위한 애들
    @Autowired
    private ArticleJpaRepository articleJpaRepository;

    @Autowired
    private FileJpaRepository fileJpaRepository;

    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private FileDAO fileDAO;

    // http://localhost:8080/list에 mapping될 View를 return 해줌
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, Criteria criteria) throws Exception{

        logger.info("page list() called ...");

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(criteria);
        pageMaker.setTotalCount(articleDAO.countArticles(criteria));

        model.addAttribute("articles", articleDAO.listCriteria(criteria));
        model.addAttribute("pageMaker", pageMaker);

        return "article/list"; // [ view resolver에서 설정한 prefix + return하는 String + suffix ] 이름의 뷰 파일을 띄워준다
    }

    private String fileUrl = "파일 저장할 경로";

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String writeGET(){
        logger.info("paging writeGET() called...");
        return "article/write";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String writePOST(HttpServletRequest request, MultipartHttpServletRequest multipartHttpServletRequest, RedirectAttributes redirectAttributes){
        ArticleModel articleModel = new ArticleModel();
        logger.info("Write...");

        List<MultipartFile> files = multipartHttpServletRequest.getFiles("files");
        articleModel.setFileCnt(files.size());
        articleModel.setTitle(request.getParameter("title"));
        articleModel.setContent(request.getParameter("content"));
        articleModel.setWriter(request.getParameter("writer"));
        logger.info(articleModel.toString());

        // 게시글 작성
        articleModel = articleJpaRepository.save(articleModel);
        articleJpaRepository.flush();

        for(int i=0;i<files.size();i++){
            logger.info("FILE = " + files.get(i).getOriginalFilename());
            logger.info("ARTICLE_NO = " + articleModel.getArticleNo());
            // 파일 없는 경우
            if(files.get(i).isEmpty()){
                continue;
            }

            // 파일 업로드 한 경우
            else{
                String fileName = files.get(i).getOriginalFilename();
                File destFile;
                String destFileName;

                Integer fileCnt = 0;
                // 올린 파일 이름 변경 및 upload 폴더에 저장
                do{
                    fileCnt++;
                    destFileName = UUID.randomUUID().toString() + fileName;
                    logger.info("orig = " + fileName + " new = " + destFileName);
                    destFile = new File(fileUrl + destFileName);
                }while(destFile.exists());

                destFile.getParentFile().mkdirs();

                try{
                    files.get(i).transferTo(destFile);
                }catch(Exception e){
                }
                FileModel fileModel = new FileModel();
                fileModel.setOrigFileName(fileName);
                fileModel.setArticle(articleModel);
                fileModel.setFileName(destFileName);

                fileJpaRepository.save(fileModel);
                fileJpaRepository.flush();
                logger.info("Fin!");
            }
        }

        // 새글 작성 완료시, list 페이지로 redirection! & 등록 성공 메세지 보내기
        redirectAttributes.addFlashAttribute("msg","regSuccess");
        return "redirect:/list";
    }
}
