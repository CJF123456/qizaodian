package com.test;

import java.util.HashSet;
import java.util.Set;

public class Shujuyuan {

	public static void main(String[] args) {
		String small[] = new String[] { "1981", "1982", "3990", "3991", "535",
				"4181", "4182", "4183", "4184", "4186", "164", "213", "49",
				"1435", "4074", "4075", "143", "880", "998", "3006", "351",
				"313", "147", "148", "568", "707", "4115", "4116", "4117",
				"4118", "4120", "4121", "4122", "4123", "431", "4004", "4162",
				"4163", "4164", "4165", "4166", "4161", "549", "4105", "4106",
				"4108", "4109", "4110", "4111", "4112", "4114", "394", "395",
				"582", "585", "779", "781", "3988", "9", "425", "1331", "1351",
				"1352", "1436", "1437", "15", "32", "295", "299", "300", "658",
				"796", "991", "4080", "4081", "4082", "4083", "4084", "4085",
				"4086", "4238", "4241", "4242", "4243", "4244", "358", "359",
				"360", "36", "47", "246", "247", "248", "249", "258", "261",
				"262", "263", "856", "857", "858", "864", "865", "867", "4005",
				"4172", "4173", "4175", "4176", "4177", "593", "468", "4251",
				"37", "789", "790", "4168", "4169", "4171", "4011", "4234",
				"4187", "4247", "4252", "2228", "2229", "2230", "2231", "2233",
				"4010", "2", "4236", "4179", "4180", "2315", "2318", "2319",
				"4193", "4194", "4195", "4196", "4197", "4198", "4200", "4201",
				"4202", "4203", "4204", "4205", "4206", "4207", "4209", "4210",
				"4211", "4212", "4213", "4214", "4215", "4216", "4217", "4218",
				"4219", "4220", "4221", "4223", "4224", "4225", "4228", "4229",
				"4230", "4231", "1975", "1976", "1977", "1978", "1778", "1779",
				"1780", "1782", "1783", "1784", "1785", "116", "6", "704",
				"705", "706", "5", "24", "25", "126", "135", "411", "466",
				"467", "564", "566", "916", "1120", "1535", "1635", "1636",
				"4024", "580", "2017", "2971", "2973", "677", "678", "679",
				"870", "67", "371", "4073", "927", "928", "929", "930", "78",
				"276", "4076", "2136", "2067", "41", "243", "664", "1762",
				"1811", "1952", "2187", "2351", "481", "33", "4013", "716",
				"717", "46", "848", "1161", "847", "4248", "500", "23", "51",
				"54", "56", "57", "145", "150", "155", "157", "158", "348",
				"349", "469", "604", "714", "792", "849", "1651", "1653",
				"3142", "4133", "4134", "4135", "4136", "4137", "4138", "4139",
				"4140", "4141", "4142", "4143", "4144", "4145", "4146", "4147",
				"4148", "899", "4053", "323", "2205", "4246", "336", "482",
				"11", "28", "592", "708", "710", "39", "48", "729", "730",
				"272", "273", "555", "559", "4126", "4127", "27", "50", "672",
				"58", "365", "366" };
		Set<String> a = new HashSet<String>();
		for (int i = 0; i < small.length; i++) {
			a.add(small[i]);
		}

		String b[] = new String[] { "4043", "4012", "4011", "4234", "4187",
				"4247", "4261", "4232", "4252", "2228", "2229", "4005", "2230",
				"2231", "2232", "2233", "4010", "4262", "2", "4236", "2240",
				"2105", "4022", "4023", "4179", "4180", "2315", "2316", "2318",
				"2319", "1899", "1520", "352", "1293", "1384", "1385", "1386",
				"1387", "1388", "1389", "208", "278", "83", "85", "165", "329",
				"4044", "4191", "4192", "4193", "4194", "4195", "4196", "4197",
				"4198", "4199", "4200", "4201", "4202", "4203", "4204", "4205",
				"4206", "4207", "4208", "4209", "4210", "4211", "4212", "4213",
				"4214", "4215", "4216", "4217", "4218", "4219", "4220", "4221",
				"4222", "4223", "4224", "4225", "4226", "4227", "4228", "4229",
				"4230", "4231", "894", "17", "1975", "1976", "1977", "1978",
				"1778", "1779", "1780", "1781", "1782", "1783", "1784", "1785",
				"2375", "116", "6", "4237", "120", "4128", "704", "705", "706",
				"4245", "118", "122", "5", "24", "25", "126", "132", "134",
				"135", "141", "269", "411", "466", "467", "564", "566", "676",
				"719", "916", "1120", "1535", "1635", "1636", "4024", "4025",
				"315", "580", "2017", "2968", "2969", "2970", "2971", "2972",
				"2973", "677", "678", "679", "870", "4002", "166", "1935",
				"1936", "1937", "1940", "1942", "1944", "1945", "1946", "1934",
				"1939", "1941", "1943", "119", "1933", "67", "68", "371",
				"1081", "4073", "927", "928", "929", "930", "4020", "4021",
				"4078", "4079", "575", "1822", "7", "641", "78", "276", "669",
				"4076", "4077", "2136", "140", "2067", "40", "41", "123",
				"128", "131", "133", "243", "664", "1762", "1811", "1951",
				"1952", "1955", "2057", "2085", "2086", "2180", "2186", "2187",
				"2213", "2351", "2353", "2355", "2357", "2359", "481", "33",
				"4007", "4013", "497", "545", "546", "716", "717", "12", "31",
				"46", "848", "472", "907", "1161", "1162", "117", "847",
				"4248", "500", "23", "51", "54", "55", "56", "57", "144",
				"145", "150", "154", "155", "156", "157", "158", "271", "348",
				"349", "469", "498", "604", "714", "792", "849", "1450",
				"1651", "1652", "1653", "2134", "2135", "3050", "3142", "4133",
				"4134", "4135", "4136", "4137", "4138", "4139", "4140", "4141",
				"4142", "4143", "4144", "4145", "4146", "4147", "4148", "4149",
				"4150", "4151", "4152", "4153", "4154", "4155", "4156", "4157",
				"4158", "4159", "4160", "899", "4014", "4017", "4018", "4019",
				"1980", "1981", "1982", "4131", "3990", "3991", "4053", "16",
				"535", "4181", "4182", "4183", "4184", "4185", "4186", "164",
				"731", "213", "49", "1435", "3997", "2998", "2999", "4074",
				"4075", "143", "10", "4249", "314", "623", "905", "906",
				"3003", "880", "998", "333", "368", "1159", "1160", "302",
				"303", "316", "331", "538", "3006", "4253", "4254", "4255",
				"4256", "14", "924", "925", "926", "1337", "1338", "1339",
				"351", "2994", "465", "1786", "2156", "2157", "3996", "3998",
				"3999", "4000", "4001", "43", "87", "88", "1295", "1296",
				"1297", "1356", "1390", "1391", "1392", "4", "270", "3993",
				"4028", "4029", "4030", "313", "507", "510", "855", "543",
				"415", "1150", "1151", "1152", "1153", "1154", "1155", "8",
				"18", "202", "256", "3989", "901", "236", "323", "324", "325",
				"1446", "569", "587", "4132", "589", "52", "4008", "4009",
				"4006", "960", "4130", "1947", "2205", "4026", "4246", "146",
				"147", "148", "152", "1958", "2123", "21", "22", "238", "268",
				"310", "311", "3994", "4129", "38", "124", "129", "130", "138",
				"312", "321", "322", "330", "403", "404", "470", "471", "474",
				"475", "508", "674", "1047", "1250", "336", "1326", "482",
				"673", "675", "872", "627", "317", "1989", "3011", "3012",
				"3013", "3014", "3015", "3016", "3017", "3018", "3019", "3020",
				"3022", "3023", "3024", "3021", "3025", "121", "326", "327",
				"328", "11", "908", "622", "850", "988", "989", "990", "568",
				"707", "4115", "4116", "4117", "4118", "4120", "4121", "4122",
				"4123", "431", "579", "4004", "4233", "581", "28", "4124",
				"433", "592", "708", "710", "4162", "4163", "4164", "4165",
				"4166", "4161", "588", "", "542", "544", "4027", "153", "549",
				"4031", "4032", "4033", "4034", "4035", "4036", "4037", "1641",
				"39", "48", "655", "1823", "1824", "726", "729", "730", "139",
				"4105", "4106", "4108", "4109", "4110", "4111", "4112", "4113",
				"4114", "394", "395", "582", "585", "779", "781", "3988",
				"746", "1043", "1719", "1722", "272", "273", "555", "559",
				"4188", "4189", "4190", "9", "425", "1331", "1351", "1352",
				"1436", "1437", "15", "32", "295", "299", "300", "301", "658",
				"796", "991", "4125", "4126", "4127", "4080", "4081", "4082",
				"4083", "4084", "4085", "4086", "4087", "4088", "862", "27",
				"50", "4250", "254", "502", "672", "871", "1101", "58", "4238",
				"4240", "4241", "4242", "4243", "4244", "357", "358", "359",
				"360", "36", "47", "246", "247", "248", "249", "2996", "258",
				"259", "261", "262", "263", "264", "856", "857", "858", "863",
				"864", "865", "867", "4005", "4172", "4173", "4174", "4175",
				"4176", "4177", "4178", "53", "252", "274", "350", "593",
				"468", "4251", "30", "45", "37", "1616", "1617", "1618",
				"1619", "1960", "1961", "1962", "1963", "1964", "2100", "2101",
				"2102", "2103", "2188", "2196", "2266", "2345", "2376", "257",
				"363", "364", "365", "366", "367", "789", "790", "4167",
				"4168", "4169", "4170", "4171", "4235", "496" };
		for (int i = 0; i < b.length; i++) {
			if (a.contains(b[i])) {

			} else {
				System.out.print(b[i] + ",");
			}
		}

	}
}