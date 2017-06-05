package com.unbank.spider.mybatis.client;

import com.unbank.spider.mybatis.vo.ShowPoetryText;
import com.unbank.spider.mybatis.vo.ShowPoetryTextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShowPoetryTextMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	int countByExample(ShowPoetryTextExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	int deleteByExample(ShowPoetryTextExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	int insert(ShowPoetryText record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	int insertSelective(ShowPoetryText record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	List<ShowPoetryText> selectByExampleWithBLOBs(ShowPoetryTextExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	List<ShowPoetryText> selectByExample(ShowPoetryTextExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	ShowPoetryText selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	int updateByExampleSelective(@Param("record") ShowPoetryText record,
			@Param("example") ShowPoetryTextExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	int updateByExampleWithBLOBs(@Param("record") ShowPoetryText record,
			@Param("example") ShowPoetryTextExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	int updateByExample(@Param("record") ShowPoetryText record, @Param("example") ShowPoetryTextExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	int updateByPrimaryKeySelective(ShowPoetryText record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_poetry_text
	 * @mbggenerated  Wed May 31 17:14:13 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(ShowPoetryText record);
}