package com.unbank.mybatis.mapper;

import com.unbank.mybatis.entity.ArticleContent;
import com.unbank.mybatis.entity.ArticleContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleContentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    int countByExample(ArticleContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    int deleteByExample(ArticleContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    int deleteByPrimaryKey(Integer crawlId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    int insert(ArticleContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    int insertSelective(ArticleContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    List<ArticleContent> selectByExampleWithBLOBs(ArticleContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    List<ArticleContent> selectByExample(ArticleContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    ArticleContent selectByPrimaryKey(Integer crawlId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    int updateByExampleSelective(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    int updateByExample(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    int updateByPrimaryKeySelective(ArticleContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ptf_crawl_text
     *
     * @mbggenerated Wed Aug 19 09:37:11 GMT+08:00 2015
     */
    int updateByPrimaryKeyWithBLOBs(ArticleContent record);
}