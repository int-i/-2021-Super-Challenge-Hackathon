package inti.SAhomepage.article.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tbl_article")
public class ArticleModel {
    public Integer getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(Integer articleNo) {
        this.articleNo = articleNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public String[] getFiles() {
        return files;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

    public int getFileCnt() {
        return fileCnt;
    }

    public void setFileCnt(int fileCnt) {
        this.fileCnt = fileCnt;
    }

    @Id
    @Column(name="article_no")
    @GeneratedValue()
    private Integer articleNo;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="writer")
    private String writer;

    @Column(name="regdate", nullable = false)
    private Date regDate = new Date();

    @Column(name="viewcnt")
    private int viewCnt;

    @Transient
    private String[] files;

    @Column(name="file_cnt")
    private int fileCnt;

    public ArticleModel(){
        this.fileCnt=0;
        this.viewCnt=0;
    }

    // getter, setter 생략?

    @Override
    public String toString(){
        return "ArticleModel{" +
                "articleNo=" + articleNo +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", regDate='" + regDate +
                ", viewCnt='" + viewCnt +
                ", fileCnt='" + fileCnt +
                '}';
    }
}
