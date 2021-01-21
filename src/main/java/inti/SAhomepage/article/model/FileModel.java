package inti.SAhomepage.article.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tbl_article_file")
public class FileModel {

    public ArticleModel getArticle() {
        return article;
    }

    public void setArticle(ArticleModel article) {
        this.article = article;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getOrigFileName() {
        return origFileName;
    }

    public void setOrigFileName(String origFileName) {
        this.origFileName = origFileName;
    }

    @ManyToOne
    @JoinColumn(name = "article_no")
    private ArticleModel article;

    @Id
    @Column(name ="id")
    @GeneratedValue()
    private Integer fileId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "reg_date")
    private Date regDate = new Date();

    @Column(name = "original_file_name")
    private String origFileName; // uuid 제외한 파일 이름: view에서 보여주는 용도

    //getter, setter 생략

    public String toString(){
        return "FileModel{" +
                ", fileName='" + fileName + '\'' +
                ", origName = " + origFileName + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
