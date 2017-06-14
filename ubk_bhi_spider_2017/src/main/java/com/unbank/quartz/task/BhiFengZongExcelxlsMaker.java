package com.unbank.quartz.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.unbank.dao.BhiOwnerReader;
import com.unbank.dao.BhiProReader;
import com.unbank.mybatis.vo.BhiOwner;
import com.unbank.mybatis.vo.BhiProWithBLOBs;
import com.unbank.report.WeekReport;
import com.unbank.tools.SimpleTools;
import com.unbank.tools.WordLorder;

/***
 *  每月执行一次 
 *  
 *  改 	String startTime = "2017-02-01";
		String endTime = "2017-02-28";
		
		运行即可，会在 target class temp 下生成 
		
 * @ClassName:  BhiFengZongExcelxlsMaker
 * @Description: TODO
 * @author:  liangyangtao
 * @date:  2017年3月6日 上午10:58:47
 */
public class BhiFengZongExcelxlsMaker extends WordLorder {
	private static Log logger = LogFactory
			.getLog(BhiFengZongExcelxlsMaker.class);
	static {
		// 启动日志
		try {
			PropertyConfigurator.configure(BhiFengZongExcelxlsMaker.class
					.getClassLoader().getResource("").toURI().getPath()
					+ "log4j.properties");
			logger.info("---日志系统启动成功---");
		} catch (Exception e) {
			logger.error("日志系统启动失败:", e);
		}
	}

	public static void main(String[] args) {
		String startTime = "2017-05-01";
		String endTime = "2017-05-19";
		new BhiFengZongExcelxlsMaker().wangjuan(startTime, endTime, "");
		String[] areas = new String[] { "湖南", "江苏", "内蒙古", "河北", "陕西", "山东",
				"安徽", "山西", "江西", "广东", "宁夏", "福建", "四川", "辽宁", "广西", "湖北",
				"吉林", "河南", "贵州", "新疆", "西藏", "黑龙江", "重庆", "甘肃", "浙江", "上海",
				"北京", "云南", "天津", "青海", "海南", "安徽" };
		for (String area : areas) {
			new BhiFengZongExcelxlsMaker().wangjuan(startTime, endTime, area);
		}

	}

	public String wangjuan(String startTime, String endTime, String area) {
		List<BhiProWithBLOBs> excelBhiPro = new BhiProReader()
				.readBhiProReader(startTime, endTime, area);

		HSSFWorkbook xwb = new HSSFWorkbook();
		makeBhiproExcel(xwb, excelBhiPro);
		//
		String result = makeExcelFile(startTime, endTime, area, xwb);
		// String result = "wangle";
		return result;
	}

	private String makeExcelFile(String startTime, String endTime, String area,
			HSSFWorkbook xwb) {
		StringBuffer fileName = new StringBuffer();
		fileName.append(area.isEmpty() ? "全国" : area);
		endTime = endTime.replace("-", "");
		fileName.append(endTime);
		fileName.append(".xls");
		String path = null;
		try {
			path = WeekReport.class.getClassLoader().getResource("").toURI()
					.getPath();
			path = path.substring(1, path.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String filePath = path + "temp/";

		System.out.println(filePath);
		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println("执行");
			file.mkdirs();
		}
		filePath = filePath + fileName.toString();
		try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			xwb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;

	}

	private void makeBhiproExcel(HSSFWorkbook xwb, List<BhiProWithBLOBs> bhiPros) {
		Set<String> zong = new HashSet<String>();

		Map<String, String> zongMap = new HashMap<String, String>();
		List<String> zonglist = loadWords(BhiFengZongExcelxlsMaker.class
				.getResourceAsStream("zong2.txt"));
		for (String string : zonglist) {
			String temp[] = string.split("@@@");
			zong.add(temp[1].trim());
			zongMap.put(temp[1].trim(), temp[0].trim());
		}

		Set<String> feng = new HashSet<String>();
		Map<String, String> fengMap = new HashMap<String, String>();

		List<String> fenglist = loadWords(BhiFengZongExcelxlsMaker.class
				.getResourceAsStream("feng2.txt"));
		for (String string : fenglist) {
			// feng.add(string.trim());
			String temp[] = string.split("@@@");
			feng.add(temp[1].trim());
			fengMap.put(temp[1].trim(), temp[0].trim());
		}

		// 读取第一章表格内容
		HSSFSheet sheet = xwb.createSheet("bhi_pro");
		// 定义 row、cell
		HSSFRow row;
		row = sheet.createRow(0);
		// String[] rows = new String[] { "id", "pro_name", "pro_area",
		// "pro_time", "pro_nature", "firm_nature", "pro_trade",
		// "pro_assets", "pro_stage", "pro_way", "pro_office",
		// "pro_cycle", "pro_fund", "equipment_source", "governing_unit",
		// "address", "pro_facility", "pro_content", "pro_intro",
		// "weburl", "type", "feng", "zong" };
		String[] rows = new String[] { "编号", "项目名称", "地区", "发布时间", "项目性质",
				"企业性质", "行业", "投资总额(万元)", "进展阶段", "申报方式", "审批机关", "建设周期",
				"资金到位", "设备来源", /* "主管单位", */"所在地", /* "主要设备", */"建设内容",
				"项目简介", /*
						 * "网页URL",
						 */
				/* "是否为VIP项目", */"业主单位名称", "业主人员", "人员职务", "人员电话", "人员传真",
				"业主邮编", "业主详细地址", /* "业主网址", */"所涉总行级战略客户集团名称", "所涉分行级战略客户集团名称" };

		for (int i = 0; i < rows.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(rows[i]);
		}

		for (int i = 0; i < bhiPros.size(); i++) {
			row = sheet.createRow(i + 1);

			// 序号

			Cell cell = row.createCell(0);
			cell.setCellValue(i + 1);
			// 项目名称：交叉滚道滚珠万向联轴器项目
			cell = row.createCell(1);
			String proName = bhiPros.get(i).getProName();
			proName = proName.replace("项目名称：", "");
			proName = proName.replace("【VIP】", "");
			cell.setCellValue(proName);
			// "地区"
			cell = row.createCell(2);
			cell.setCellValue(bhiPros.get(i).getProArea());
			// "发布时间",
			cell = row.createCell(3);
			cell.setCellValue(SimpleTools.dateToString(bhiPros.get(i)
					.getProTime(), "yyyy-MM-dd"));
			// "项目性质",
			cell = row.createCell(4);
			cell.setCellValue(bhiPros.get(i).getProNature());
			// "企业性质"
			cell = row.createCell(5);
			cell.setCellValue(bhiPros.get(i).getFirmNature());
			// "行业"
			cell = row.createCell(6);
			String trade = bhiPros.get(i).getProTrade();
			trade = trade.split(",")[0];
			cell.setCellValue(trade);
			// "投资总额
			cell = row.createCell(7);
			String proAssets = bhiPros.get(i).getProAssets();
			proAssets = proAssets.replace("万元", "");
			cell.setCellValue(proAssets);
			// 进展阶段"
			cell = row.createCell(8);
			cell.setCellValue(bhiPros.get(i).getProStage());
			// "申报方式"
			cell = row.createCell(9);
			cell.setCellValue(bhiPros.get(i).getProWay());
			// "审批机关"
			cell = row.createCell(10);
			cell.setCellValue(bhiPros.get(i).getProOffice());
			// "建设周期"
			cell = row.createCell(11);
			cell.setCellValue(bhiPros.get(i).getProCycle());
			// "资金到位",
			cell = row.createCell(12);
			cell.setCellValue(bhiPros.get(i).getProFund());
			// "设备来源
			cell = row.createCell(13);
			cell.setCellValue(bhiPros.get(i).getEquipmentSource());
			//
			// cell = row.createCell(14);
			// cell.setCellValue(bhiPros.get(i).getGoverningUnit());
			// "所在地"
			cell = row.createCell(14);
			cell.setCellValue(bhiPros.get(i).getAddress());
			// "建设内容"
			// cell = row.createCell(16);
			// cell.setCellValue(bhiPros.get(i).getProFacility());
			// "建设内容"
			cell = row.createCell(15);
			cell.setCellValue(bhiPros.get(i).getProContent().trim());
			// 项目简介
			cell = row.createCell(16);
			cell.setCellValue(bhiPros.get(i).getProIntro());

			// cell = row.createCell(19);
			// cell.setCellValue(bhiPros.get(i).getWeburl());
			// cell = row.createCell(20);
			// cell.setCellValue(bhiPros.get(i).getType());
			List<Integer> values = new ArrayList<Integer>();
			values.add(bhiPros.get(i).getId());
			List<BhiOwner> bhiowners = new BhiOwnerReader()
					.readBhiOwner(values);
			if (bhiowners.size() > 0) {
				BhiOwner owners = bhiowners.get(0);
				cell = row.createCell(17);
				cell.setCellValue(owners.getOwnerDepartment());
				cell = row.createCell(18);
				cell.setCellValue(owners.getOwnerPeople());
				cell = row.createCell(19);
				cell.setCellValue(owners.getOwnerPeopleJob());
				cell = row.createCell(20);
				cell.setCellValue(owners.getOwnerTel());
				cell = row.createCell(21);
				cell.setCellValue(owners.getOwnerFax());
				cell = row.createCell(22);
				cell.setCellValue(owners.getOwnerPostcode());
				cell = row.createCell(23);
				cell.setCellValue(owners.getOwnerDetailAddress());
			} else {
				System.out.println(bhiPros.get(i).getId() + "meiyou  ");
				cell = row.createCell(17);
				cell.setCellValue("");
				cell = row.createCell(18);
				cell.setCellValue("");
				cell = row.createCell(19);
				cell.setCellValue("");
				cell = row.createCell(20);
				cell.setCellValue("");
				cell = row.createCell(21);
				cell.setCellValue("");
				cell = row.createCell(22);
				cell.setCellValue("");
				cell = row.createCell(23);
				cell.setCellValue("");
			}
			String gover = bhiPros.get(i).getGoverningUnit();
			boolean isZong = false;
			if (zong.contains(gover.trim())) {
				isZong = true;
			}
			boolean isFeng = false;
			if (feng.contains(gover.trim())) {
				isFeng = true;
			}
			cell = row.createCell(24);
			cell.setCellValue(isZong == false ? "" : zongMap.get(gover.trim()));
			cell = row.createCell(25);
			cell.setCellValue(isFeng == false ? "" : fengMap.get(gover.trim()));

		}
	}
}
