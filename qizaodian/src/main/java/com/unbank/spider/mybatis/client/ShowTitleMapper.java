package com.unbank.spider.mybatis.client;

import com.unbank.spider.mybatis.vo.ShowTitle;
import com.unbank.spider.mybatis.vo.ShowTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShowTitleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	int countByExample(ShowTitleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	int deleteByExample(ShowTitleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	int insert(ShowTitle record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	int insertSelective(ShowTitle record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	List<ShowTitle> selectByExample(ShowTitleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	ShowTitle selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	int updateByExampleSelective(@Param("record") ShowTitle record, @Param("example") ShowTitleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	int updateByExample(@Param("record") ShowTitle record, @Param("example") ShowTitleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	int updateByPrimaryKeySelective(ShowTitle record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table show_title
	 * @mbggenerated  Tue Jun 06 17:07:54 CST 2017
	 */
	int updateByPrimaryKey(ShowTitle record);
}